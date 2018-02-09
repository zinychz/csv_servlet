package zin.test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Vector;

class HtmlUtils {

    public static String createHtmlHeader(String title) {

        String htmlHeader = null;
        htmlHeader = "<HTML><HEAD><TITLE> " + title + " </TITLE></HEAD><BODY>";
        return htmlHeader;
    }

    public static String getHtmlFooter() {

        String htmlFooter = "</BODY></HTML>";
        return htmlFooter;
    }

    public static String getHead(int level, String heading) {
        return "<H" + level + "> " + heading + "</H" + level + ">";
    }

    public static String getTableCaption(String caption){
        return "<caption>" + caption +"</caption>";
    }

    public static String getTableHead(String align, int border) {

        String tableHeader = null;
        tableHeader = "<TABLE align=" + align + " border=" + border + ">";
        return tableHeader;

    }

    public static String getTR(String align) {
        String TRCell = null;
        TRCell = "<TR align=" + align + ">";
        return TRCell;
    }

    public static String getTR() {
        String TRCell = null;
        TRCell = "<TR>";
        return TRCell;
    }

    public static String getTD(String align, String value) {
        String TDCell = null;
        TDCell = "<TD align=" + align + "> " + value + " </TD>";
        return TDCell;
    }

    public static String getTD() {
        String TDCell = null;
        TDCell = "<TD>";
        return TDCell;
    }

    public static String getTD(int width) {
        String TDCell = null;
        TDCell = "<TD WIDTH=" + width + ">";
        return TDCell;
    }

    public static String getTH(String align, String value) {
        String THCell = null;
        THCell = "<TH align=" + align + "> " + value + " </TH>";
        return THCell;
    }

    public static String getTableContents(String align, List<CSVTable.Row> rows) throws IOException {

        StringWriter Cells = new StringWriter();
        String contents = new String();

        long rowNumber = 0;
        for (CSVTable.Row row: rows){
            Cells.write("<TR>");
            for (String cell: row.getRow()){
                Cells.write("<TD align=" + align + "> " + cell + " </TD> \n");
            }
            Cells.write("</TR>\n\n");
            rowNumber++;
        }

        contents = Cells.toString();
        Cells.flush();
        Cells.close();

        return contents;
    }

    public static String getClosedTR() {
        String TRCell = null;
        TRCell = "</TR>";
        return TRCell;
    }

    public static String getClosedTD() {
        String TDCell = null;
        TDCell = "</TD>";
        return TDCell;
    }

    public static String getBR(int lines) {

        StringWriter lineBR = new StringWriter();
        String lineBRs = new String();

        for (int i = 0; i <= lines; i++) {
            lineBR.write("<BR>\n");
        }
        lineBRs = lineBR.toString();

        return lineBRs;
    }

    public static String getLI(String item) {

        String li = new String("<LI>");
        li += item;
        return li;

    }
}