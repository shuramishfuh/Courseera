package FormaterIMplementation;

import CoreInterfaces.CourSeera;
import CoreInterfaces.CourSeeraFactory;
import CoreInterfaces.Course;
import CoreInterfaces.Schedule;
import FormaterEngineInterfaces.ILinker;
import Implementations.IMCourSeeraFactory;
import Implementations.IMInstructor;
import Implementations.IMRoom;
import Implementations.Initializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * This class calls the appropriate method
 */
public class Linker implements ILinker {

    /**
     * Calls the appropriate Courseera method
     *
     * @param Ls A List os strings
     * @return A TreeMap
     */
    @Override
    public TreeMap<String, List<Schedule>> callCoursera(List<String> Ls) {
        Initializer initializer = new Initializer("\\Core.Implementation\\src\\Data\\", "https://www-banner.aub.edu.lb/catalog/schd_");
        List<Course> courses = new ArrayList<>();
        initializer.listGenerator(courses);
        CourSeeraFactory csf = new IMCourSeeraFactory();
        CourSeera CS = csf.createInstance(courses);

        TreeMap<String, List<Schedule>> methodAndList = new TreeMap<>();

        String method = Ls.get(ConstantVariables.Method).toLowerCase();//the method the user inputted

        try {
            switch (method) {
                case ConstantVariables.help: {
                    methodAndList.put(ConstantVariables.help, null);
                    return methodAndList;
                }

                case ConstantVariables.RoomSchedule: {
                    if (Ls.size() == 3) {                           //roomSchedule with one parameter
                        try {
                            List<Schedule> sh = CS
                                    .roomSchedule(new IMRoom(Ls.get(ConstantVariables.RoomBuilding).toUpperCase(),
                                            Ls.get(ConstantVariables.RoomNumber).toUpperCase()));

                            if (sh.isEmpty())
                                throw new IllegalArgumentException();

                            methodAndList.put(method, sh);
                            return methodAndList;
                        } catch (Exception e) {
                            String error = ConstantVariables.InvalidRoom;
                            methodAndList.put(error, null);
                            return methodAndList;
                        }

                    }

                    if (Character.isDigit(Ls.get(ConstantVariables.Date).charAt(0))) { //roomSchedule with room and date
                        LocalDate date = null;

                        try {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y");
                            date = LocalDate.parse(Ls.get(ConstantVariables.Date), formatter);
                        } catch (Exception e) {
                            String error = ConstantVariables.InvalidDate;
                            methodAndList.put(error, null);
                            return methodAndList;
                        }

                        try {
                            List<Schedule> sh = CS
                                    .roomSchedule(new IMRoom(Ls.get(ConstantVariables.RoomBuilding).toUpperCase(),
                                            Ls.get(ConstantVariables.RoomNumber).toUpperCase()), date);

                            methodAndList.put(method, sh);
                            return methodAndList;
                        } catch (IllegalStateException e) {
                            String error = ConstantVariables.NoClassesThisDate;
                            methodAndList.put(error, null);
                            return methodAndList;
                        } catch (Exception e) {
                            String error = ConstantVariables.InvalidRoom;
                            methodAndList.put(error, null);
                            return methodAndList;
                        }
                    }

                    if ((Character.isLetter(Ls.get(ConstantVariables.DayofWeek).charAt(0)))) { //roomSchedule with room and day
                        java.time.DayOfWeek day = null;
                        try {
                            day = java.time.DayOfWeek.valueOf(Ls.get(ConstantVariables.DayofWeek).toUpperCase());
                        } catch (Exception e) {
                            String error = ConstantVariables.InvalidDayOfWeek;
                            methodAndList.put(error, null);
                            return methodAndList;
                        }
                        try {
                            List<Schedule> sh = CS
                                    .roomSchedule(new IMRoom(Ls.get(ConstantVariables.RoomBuilding).toUpperCase(),
                                            Ls.get(ConstantVariables.RoomNumber).toUpperCase()), day);

                            methodAndList.put(method, sh);
                            return methodAndList;
                        } catch (IllegalStateException e) {
                            String error = ConstantVariables.NoClassesThisDay;
                            methodAndList.put(error, null);
                            return methodAndList;
                        } catch (Exception e) {
                            String error = ConstantVariables.InvalidRoom;
                            methodAndList.put(error, null);
                            return methodAndList;
                        }
                    }
                }

                case ConstantVariables.WhoWasThereLast: {
                    try {
                        Schedule s = CS.whoWasThereLast(new IMRoom(Ls.get(ConstantVariables.RoomBuilding).toUpperCase(),
                                Ls.get(ConstantVariables.RoomNumber).toUpperCase()));
                        List<Schedule> sh = new ArrayList<>(Arrays.asList(s));
                        methodAndList.put(method, sh);
                        return methodAndList;
                    } catch (Exception e) {
                        String error = ConstantVariables.InvalidRoom;
                        methodAndList.put(error, null);
                        return methodAndList;
                    }
                }

                case ConstantVariables.WhoIsThereNow: {
                    try {
                        Schedule s = CS.whoIsThereNow(new IMRoom(Ls.get(ConstantVariables.RoomBuilding).toUpperCase(),
                                Ls.get(ConstantVariables.RoomNumber).toUpperCase()));
                        List<Schedule> sh = new ArrayList<>(Arrays.asList(s));
                        methodAndList.put(method, sh);
                        return methodAndList;

                    } catch (IllegalStateException e) {
                        String error = ConstantVariables.RoomIsEmpty;
                        methodAndList.put(error, null);
                        return methodAndList;
                    } catch (Exception e) {
                        String error = ConstantVariables.InvalidRoom;
                        methodAndList.put(error, null);
                        return methodAndList;
                    }
                }

                case ConstantVariables.ProfSchedule: {
                    try {
                        List<Schedule> sh = CS
                                .profSchedule(
                                        new IMInstructor(Ls.get(ConstantVariables.InstructorFirstName),
                                                Ls.get(ConstantVariables.InstructorLastname)));

                        if (sh.isEmpty())
                            throw new IllegalArgumentException();

                        methodAndList.put(method, sh);
                        return methodAndList;
                    } catch (Exception e) {
                        String error = ConstantVariables.InvalidProfName;
                        methodAndList.put(error, null);
                        return methodAndList;
                    }
                }

                case ConstantVariables.WhereIsProf: {
                    try {
                        Schedule s = CS.whereIsProf(
                                new IMInstructor(Ls.get(ConstantVariables.InstructorFirstName),
                                        Ls.get(ConstantVariables.InstructorLastname)));
                        List<Schedule> sh = new ArrayList<>(Arrays.asList(s));

                        methodAndList.put(method, sh);
                        return methodAndList;
                    } catch (IllegalStateException e) {
                        String error = ConstantVariables.NotInClass;
                        methodAndList.put(error, null);
                        return methodAndList;
                    } catch (Exception e) {
                        String error = ConstantVariables.InvalidProfName;
                        methodAndList.put(error, null);
                        return methodAndList;
                    }
                }

                case ConstantVariables.WhereWillProfBe: {
                    try {
                        List<Schedule> sh = CS
                                .whereWillProfBe(
                                        new IMInstructor(Ls.get(ConstantVariables.InstructorFirstName),
                                                Ls.get(ConstantVariables.InstructorLastname)));

                        methodAndList.put(method, sh);
                        return methodAndList;
                    } catch (IllegalStateException e) {
                        String error = ConstantVariables.NoCoursesGiven;
                        methodAndList.put(error, null);
                        return methodAndList;
                    } catch (Exception e) {
                        String error = ConstantVariables.InvalidProfName;
                        methodAndList.put(error, null);
                        return methodAndList;
                    }
                }

                default:
                    String error = ConstantVariables.InvalidCommand;
                    methodAndList.put(error, null);
                    return methodAndList;
            }

        } catch (Exception e) {
            String error = ConstantVariables.SomethingWentWrong;
            methodAndList.put(error, null);
            return methodAndList;
        }
    }
}