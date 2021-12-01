package Implementations;

import CoreInterfaces.HtmlToCsv;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IMHtmlToCsv implements HtmlToCsv {
    @Override
    public void htmlToCsv(String htmlFile, String csvFile) {

        try {
            FileWriter myWriter = new FileWriter(csvFile, true);
            String line = "";
            String html = Files.readString(Path.of(htmlFile));
            if (html.contains("Fall 2021-2022(202210)")) {
                String fall = html.substring(html.indexOf("Fall 2021-2022(202210)"));
                fall = fall.substring(0, fall.indexOf("<TD>Spring 2021-2022(202220)</TD>")).trim();
//				fall = fall.substring(0, fall.indexOf("</TABLE>")).trim();
                String[] rows = fall.split("</TR>");
                for (String row : rows) {
                    String[] tds = row.split("</TD>");
                    line = tds[ConstantVariables.CRN].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.SUBJECT].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.COURSE_NUM].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.SECTION].replace("<TD>", "").trim() + "," + "\"" +
                            tds[ConstantVariables.TITLE].replace("<TD>", "").trim() + "\"," +
                            tds[ConstantVariables.CREDIT_HOURS].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.COLLEGE].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.ACTUAL_ENROL].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.SEATS_AVAILABLE].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.BEGIN_TIME].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.END_TIME].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.BUILDING].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.ROOM].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.MONDAY].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.TUESDAY].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.WEDNESDAY].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.THURSDAY].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.FRIDAY].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.SATURDAY].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.INSTRUCTOR_FIRST_NAME].replace("<TD>", "").trim() + "," +
                            tds[ConstantVariables.INSTRUCTOR_LAST_NAME].replace("<TD>", "").trim() + "\n";
                    myWriter.append(line);
                }

            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error Parsing to csv");
        }
    }
}
