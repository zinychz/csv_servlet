package zin.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVTable {

    private String[] header;
    private List<Row> body;
    private int columnCount;
    private String name;

    public CSVTable() {
        body = new ArrayList<>();
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public long getRowCount() {
        return body.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
        this.columnCount = this.header.length;

    }

    public List<Row> getBody() {
        return body;
    }

    public void setBody(List<Row> body) {
        this.body = body;
    }

    public void addRow(Row row){
        body.add(row);
    }

    public void addRow(String[] row){
        addRow(new Row(row));
    }

    public void print(PrintWriter printWriter) throws IOException {
        printWriter.print(HtmlUtils.getTableHead("center", 1));
        printWriter.print(
                HtmlUtils.getTableCaption(getName() + "; columns: " + getColumnCount() + "; rows:" + getRowCount()));
        for (String headValue: header) {
            printWriter.print(HtmlUtils.getTH("center", headValue));
        }
        printWriter.print(HtmlUtils.getTableContents("center", body));
    }

    public static class Row{
        private String[] row;

        public Row(String[] row) {
            this.row = row;
        }

        public String[] getRow() {
            return row;
        }

        public void setRow(String[] row) {
            this.row = row;
        }

        public String get(int column){
            return row[column];
        }
    }
}
