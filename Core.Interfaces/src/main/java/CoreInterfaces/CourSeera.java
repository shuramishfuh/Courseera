package CoreInterfaces;

import java.time.DayOfWeek;
import java.util.List;
import java.util.TreeMap;

public interface CourSeera {
    TreeMap<Room, List<Schedule>> roomSchedule();//lists the schedule for every room in alphabetical room number order

    List<Schedule> roomSchedule(Room room);//lists the schedule for a specific room

    List<Schedule> roomSchedule(Room room, java.time.LocalDate date);//lists the schedule for a specific room for a specific date

    List<Schedule> roomSchedule(Room room, DayOfWeek day);//lists the schedule for a specific room for a specific day of week

    Schedule whoWasThereLast(Room room);//lists the course and instructor name for the last time this room was occupied

    Schedule whoIsThereNow(Room room);//lists the course and instructor name currently occupying a specific room

    List<Schedule> profSchedule(Instructor instructor); //lists the instructor�s weekly schedule (day, time, room)

    Schedule whereIsProf(Instructor instructor); //lists the room where a prof is currently teaching (if any)

    List<Schedule> whereWillProfBe(Instructor instructor); //lists the instructor�s schedule for today
}
