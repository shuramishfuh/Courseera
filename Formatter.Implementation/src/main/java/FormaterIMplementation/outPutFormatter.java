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

            case ConstantVariables.help:
                return ConstantVariables.userhelp;

            case ConstantVariables.InvalidDate:
            case ConstantVariables.InvalidRoom:
            case ConstantVariables.InvalidDayOfWeek:
            case ConstantVariables.InvalidProfName:
            case ConstantVariables.InvalidCommand:
            case ConstantVariables.RoomIsEmpty:
            case ConstantVariables.NotInClass:
            case ConstantVariables.NoCoursesGiven:
            case ConstantVariables.NoClassesThisDate:
            case ConstantVariables.NoClassesThisDay:
            case ConstantVariables.SomethingWentWrong:
                return methodAndList.firstKey();

            case ConstantVariables.WhereIsProf:
            case ConstantVariables.WhoIsThereNow:
            case ConstantVariables.WhoWasThereLast:
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