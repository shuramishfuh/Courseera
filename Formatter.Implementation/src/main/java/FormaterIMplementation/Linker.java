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

        String method = Ls.get(ConstVar.Method).toLowerCase();//the method the user inputted

        try {
            switch (method) {
                case ConstVar.help: {
                    methodAndList.put(ConstVar.help, null);
                    return methodAndList;
                }

                case ConstVar.RoomSchedule: {
                    if (Ls.size() == 3) {                           //roomSchedule with one parameter
                        try {
                            List<Schedule> sh = CS
                                    .roomSchedule(new IMRoom(Ls.get(ConstVar.RoomBuilding).toUpperCase(),
                                            Ls.get(ConstVar.RoomNumber).toUpperCase()));

                            if (sh.isEmpty())
                                throw new IllegalArgumentException();

                            methodAndList.put(method, sh);
                            return methodAndList;
                        } catch (Exception e) {
                            String error = ConstVar.InvalidRoom;
                            methodAndList.put(error, null);
                            return methodAndList;
                        }

                    }

                    if ((Character.isLetter(Ls.get(ConstVar.DayofWeek).charAt(0)))) { //roomSchedule with room and day
                        java.time.DayOfWeek day = null;
                        try {
                            day = java.time.DayOfWeek.valueOf(Ls.get(ConstVar.DayofWeek).toUpperCase());
                        } catch (Exception e) {
                            String error = ConstVar.InvalidDayOfWeek;
                            methodAndList.put(error, null);
                            return methodAndList;
                        }
                        try {
                            List<Schedule> sh = CS
                                    .roomSchedule(new IMRoom(Ls.get(ConstVar.RoomBuilding).toUpperCase(),
                                            Ls.get(ConstVar.RoomNumber).toUpperCase()), day);

                            methodAndList.put(method, sh);
                            return methodAndList;
                        } catch (IllegalStateException e) {
                            String error = ConstVar.NoClassesThisDay;
                            methodAndList.put(error, null);
                            return methodAndList;
                        } catch (Exception e) {
                            String error = ConstVar.InvalidRoom;
                            methodAndList.put(error, null);
                            return methodAndList;
                        }
                    }

                    if (Character.isDigit(Ls.get(ConstVar.Date).charAt(0))) { //roomSchedule with room and date
                        LocalDate date = null;

                        try {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y");
                            date = LocalDate.parse(Ls.get(ConstVar.Date), formatter);
                        } catch (Exception e) {
                            String error = ConstVar.InvalidDate;
                            methodAndList.put(error, null);
                            return methodAndList;
                        }

                        try {
                            List<Schedule> sh = CS
                                    .roomSchedule(new IMRoom(Ls.get(ConstVar.RoomBuilding).toUpperCase(),
                                            Ls.get(ConstVar.RoomNumber).toUpperCase()), date);

                            methodAndList.put(method, sh);
                            return methodAndList;
                        } catch (IllegalStateException e) {
                            String error = ConstVar.NoClassesThisDate;
                            methodAndList.put(error, null);
                            return methodAndList;
                        } catch (Exception e) {
                            String error = ConstVar.InvalidRoom;
                            methodAndList.put(error, null);
                            return methodAndList;
                        }
                    }

                    
                }

                case ConstVar.WhoWasThereLast: {
                    try {
                        Schedule s = CS.whoWasThereLast(new IMRoom(Ls.get(ConstVar.RoomBuilding).toUpperCase(),
                                Ls.get(ConstVar.RoomNumber).toUpperCase()));
                        List<Schedule> sh = new ArrayList<>(Arrays.asList(s));
                        methodAndList.put(method, sh);
                        return methodAndList;
                    } catch (Exception e) {
                        String error = ConstVar.InvalidRoom;
                        methodAndList.put(error, null);
                        return methodAndList;
                    }
                }

                case ConstVar.WhoIsThereNow: {
                    try {
                        Schedule s = CS.whoIsThereNow(new IMRoom(Ls.get(ConstVar.RoomBuilding).toUpperCase(),
                                Ls.get(ConstVar.RoomNumber).toUpperCase()));
                        List<Schedule> sh = new ArrayList<>(Arrays.asList(s));
                        methodAndList.put(method, sh);
                        return methodAndList;

                    } catch (IllegalStateException e) {
                        String error = ConstVar.RoomIsEmpty;
                        methodAndList.put(error, null);
                        return methodAndList;
                    } catch (Exception e) {
                        String error = ConstVar.InvalidRoom;
                        methodAndList.put(error, null);
                        return methodAndList;
                    }
                }

                case ConstVar.ProfSchedule: {
                    try {
                        List<Schedule> sh = CS
                                .profSchedule(
                                        new IMInstructor(Ls.get(ConstVar.InstructorFirstName),
                                                Ls.get(ConstVar.InstructorLastname)));

                        if (sh.isEmpty())
                            throw new IllegalArgumentException();

                        methodAndList.put(method, sh);
                        return methodAndList;
                    } catch (Exception e) {
                        String error = ConstVar.InvalidProfName;
                        methodAndList.put(error, null);
                        return methodAndList;
                    }
                }

                case ConstVar.WhereIsProf: {
                    try {
                        Schedule s = CS.whereIsProf(
                                new IMInstructor(Ls.get(ConstVar.InstructorFirstName),
                                        Ls.get(ConstVar.InstructorLastname)));
                        List<Schedule> sh = new ArrayList<>(Arrays.asList(s));

                        methodAndList.put(method, sh);
                        return methodAndList;
                    } catch (IllegalStateException e) {
                        String error = ConstVar.NotInClass;
                        methodAndList.put(error, null);
                        return methodAndList;
                    } catch (Exception e) {
                        String error = ConstVar.InvalidProfName;
                        methodAndList.put(error, null);
                        return methodAndList;
                    }
                }

                case ConstVar.WhereWillProfBe: {
                    try {
                        List<Schedule> sh = CS
                                .whereWillProfBe(
                                        new IMInstructor(Ls.get(ConstVar.InstructorFirstName),
                                                Ls.get(ConstVar.InstructorLastname)));

                        methodAndList.put(method, sh);
                        return methodAndList;
                    } catch (IllegalStateException e) {
                        String error = ConstVar.NoCoursesGiven;
                        methodAndList.put(error, null);
                        return methodAndList;
                    } catch (Exception e) {
                        String error = ConstVar.InvalidProfName;
                        methodAndList.put(error, null);
                        return methodAndList;
                    }
                }

                default:
                    String error = ConstVar.InvalidCommand;
                    methodAndList.put(error, null);
                    return methodAndList;
            }

        } catch (Exception e) {
            String error = ConstVar.SomethingWentWrong;
            methodAndList.put(error, null);
            return methodAndList;
        }
    }
}