package FormaterIMplementation;


import CoreInterfaces.Schedule;
import FormaterEngineInterfaces.IoutputFormatter;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * This class outputs to the user
 */
public class outPutFormatter implements IoutputFormatter {

    /**
     * Selects appropriate output depending on user's input
     *
     * @param methodAndList A TreeMap
     * @return A string to be printed to the user
     */
    @Override
    public String selector(TreeMap<String, List<Schedule>> methodAndList) {

        switch (methodAndList.firstKey()) {

            case ConstVar.help:
                return ConstVar.userhelp;

            case ConstVar.InvalidDate:
            case ConstVar.InvalidRoom:
            case ConstVar.InvalidDayOfWeek:
            case ConstVar.InvalidProfName:
            case ConstVar.InvalidCommand:
            case ConstVar.RoomIsEmpty:
            case ConstVar.NotInClass:
            case ConstVar.NoCoursesGiven:
            case ConstVar.NoClassesThisDate:
            case ConstVar.NoClassesThisDay:
            case ConstVar.SomethingWentWrong:
                return methodAndList.firstKey();

            case ConstVar.WhereIsProf:
            case ConstVar.WhoIsThereNow:
            case ConstVar.WhoWasThereLast:
                return scheduleToString(methodAndList.get(methodAndList.firstKey()).get(0));
            default:
                return scheduleToString(
                        methodAndList.values().stream().flatMap(List::stream).collect(Collectors.toList()));

        }
    }

    /**
     * Prints a List of Schedules
     *
     * @param schedules A list of Schedules
     * @return A string
     */
    @Override
    public String scheduleToString(List<Schedule> schedules) {
        String message = "";
        for (Schedule s : schedules) {
            message += "\n" + s.getInstructor() + " " + s.getCourse() + " " + s.getFromTime() + " " + s.getToTime()
                    + " " + s.getRoom() + " " + s.getDay() + " \n";
        }
        return message;
    }

    /**
     * Prints a Schedule
     *
     * @param LS A schedule
     * @return A string
     */
    @Override
    public String scheduleToString(Schedule LS) {
        return LS.getInstructor() + " " + LS.getCourse();
    }
}