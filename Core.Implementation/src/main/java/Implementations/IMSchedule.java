package Implementations;

import CoreInterfaces.Instructor;
import CoreInterfaces.Room;
import CoreInterfaces.Schedule;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import CoreInterfaces.Course;


public class IMSchedule implements Schedule {
    private Room Room;
    private LocalTime FromTime;
    private LocalTime ToTime;
    private Instructor Instructor;
    private Course Course;
    private List<DayOfWeek> day;

    IMSchedule(Room room, LocalTime fromTime, LocalTime toTime, Instructor instructor, IMCourse course) {
        this.Room = room;
        this.FromTime = fromTime;
        this.ToTime = toTime;
        this.Instructor = instructor;
        this.Course = course;
        GetDaysOfCourse(course);
    }

    public String getRoom() {
        return this.Room.getBuilding() + " " + this.Room.getRoomNumber();
    }

    public LocalTime getFromTime() {
        return this.FromTime;
    }

    public LocalTime getToTime() {
        return this.ToTime;
    }

    public String getInstructor() {
        return this.Instructor.getFirstName() + " " + this.Instructor.getLastName();
    }

    public String getCourse() {
        return this.Course.getSubject() + " " + this.Course.getCourse_num() + " " + " Section " + this.Course.getSection() + " " + this.Course.getTitle();
    }

    @Override
    public List<DayOfWeek> getDay() {
        return this.day;
    }

    /*
     * @param course -> course
     *
     * returns a list of days of a course
     * */
    private void GetDaysOfCourse(IMCourse course) {
        day = new ArrayList<>();
        if (course.getMonday()) day.add(DayOfWeek.MONDAY);
        if (course.getTuesday()) day.add(DayOfWeek.TUESDAY);
        if (course.getWednesday()) day.add(DayOfWeek.WEDNESDAY);
        if (course.getThursday()) day.add(DayOfWeek.THURSDAY);
        if (course.getFriday()) day.add(DayOfWeek.FRIDAY);
        if (course.getSaturday()) day.add(DayOfWeek.SATURDAY);
    }
}
