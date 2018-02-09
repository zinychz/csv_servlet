package zin.test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CSVServlet extends HttpServlet {

    private static final long serialVersionUID = -4751096228274971485L;
    private String folder;
    private String delim;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        String absolutePath = getServletContext().getRealPath(folder);
        File dir = new File(absolutePath);
        List<File> csvs = CSVReader.listFilesForFolder(dir);
        List<CSVTable> tables = new ArrayList<>();
        for (File file: csvs){
            tables.add(CSVReader.getTable(file, delim));
        }
        printWriter.println(HtmlUtils.createHtmlHeader("Zinchenko Test"));
        for (CSVTable table: tables){
            table.print(printWriter);
            printWriter.println("</br>");
        }
        printWriter.println(HtmlUtils.getHtmlFooter());
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        Properties properties = new Properties();
        try {
            properties.load(getServletContext().getResourceAsStream(config.getInitParameter("config")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        folder = properties.getProperty("folder", "CSV");
        delim = properties.getProperty("delim", ",");
    }
}
