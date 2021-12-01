package Implementations;

import CoreInterfaces.Course;
import CoreInterfaces.CsvToDb;
import CoreInterfaces.Downloader;
import CoreInterfaces.HtmlToCsv;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class Initializer {
    private static String FilePath;
    private static String Url;

    public Initializer(String filePath, String url) {
        FilePath = filePath;
        Url = url;
    }


    public static void listGenerator(List<Course> courses) {
        String WorkingDirectory = Paths.get(".").toAbsolutePath().normalize().toString();
        FilePath = WorkingDirectory + FilePath;
        File folder = new File(FilePath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File Htmlfolder = new File(FilePath + "HTML\\");
        if (!Htmlfolder.exists()) {
            Htmlfolder.mkdirs();
        }
        File CSVfolder = new File(FilePath + "CSV");
        if (!CSVfolder.exists()) {
            CSVfolder.mkdirs();
        }

        File myObj = new File(CSVfolder + "\\courses.csv");
        if (myObj.exists()) {
            myObj.delete();
        }


        Downloader downloader = new IMDownloader();
        HtmlToCsv csvMaker = new IMHtmlToCsv();
        CsvToDb listMaker = new IMCsvToDb();
        String htmlLink = "";
        String csvFileName = myObj.toString();
        String pre = Url;

        if (Htmlfolder.listFiles().length == 0 || Htmlfolder.listFiles().length != 26) {
            System.out.println(" Clearing Obsolete files");
            Arrays.stream(Htmlfolder.listFiles()).forEach(File::delete);
            System.out.println(" All Clear");
            System.out.println("Starting!");

            for (char i = 'A'; i <= 'Z'; i++) {
                htmlLink = FilePath + "HTML/" + String.valueOf(i).concat(".html");
                downloader.downloadHtmlToFile(pre.concat(String.valueOf(i)).concat(".htm"), htmlLink);
                System.out.println("Page for letter " + String.valueOf(i) + " has been downloaded");
                csvMaker.htmlToCsv(htmlLink, csvFileName);
                System.out.println("Page for letter " + String.valueOf(i) + " has been parsed into csv");
            }
        } else {
            File csvFile = new File(CSVfolder + "\\courses.csv");
            try {

                if (csvFile.createNewFile())
                    System.out.println("File created");

            } catch (Exception e) {
                System.err.println(e);
                return;
            }


            for (char i = 'A'; i <= 'Z'; i++) {
                htmlLink = FilePath + "HTML\\" + String.valueOf(i).concat(".html");
                csvMaker.htmlToCsv(htmlLink, csvFileName);
                System.out.println("Page for letter " + String.valueOf(i) + " has been parsed into csv");
            }
        }

        listMaker.csvToDb(courses, csvFileName);
        System.out.println("Finished!");
    }


}
