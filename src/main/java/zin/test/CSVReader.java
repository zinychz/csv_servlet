package zin.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static CSVTable getTable(File csv, String delim) throws IOException {
        BufferedReader br = null;
        String line = "";
        String splitBy = delim == null? "," : delim;
        CSVTable table = new CSVTable();
        table.setName(csv.getName());
        try {
            br = new BufferedReader(new FileReader(csv));
            long lineNumber = 0;
            while ((line = br.readLine()) != null) {
                if (lineNumber == 0){
                    String[] columns =line.split(splitBy);
                    for (String c: columns){
                    }
                    table.setHeader(line.split(splitBy));
                } else {
                    table.addRow(line.split(splitBy));
                }
                lineNumber++;
            }
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return table;
    }

    public static List<File> listFilesForFolder(final File folder) {
        List<File> scvs = new ArrayList<>();
        for (final File file : folder.listFiles()) {
            if (file.isDirectory()) {
                listFilesForFolder(file);
            } else {
                if ("csv".equalsIgnoreCase(getFileExtension(file))){
                    scvs.add(file);
                }
            }
        }
        return scvs;
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
