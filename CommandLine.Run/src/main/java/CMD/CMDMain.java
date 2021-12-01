package CMD;

import CoreInterfaces.Schedule;

import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class CMDMain {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        CmdRun cli = new CmdRun();

        List<String> list = cli.inputParser(userInput);
        TreeMap<String, List<Schedule>> sch = cli.callCoursera(list);
        String output = cli.selector(sch);
        System.out.println(output);
        input.close();
    }
}
