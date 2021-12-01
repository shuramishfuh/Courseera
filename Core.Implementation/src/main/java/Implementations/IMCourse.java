package Implementations;

import CoreInterfaces.Course;

import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class IMCourse implements Course {
    private String crn, subject, course_num, section, title, bldg, room, first_name, last_name, college, begin_time, end_time;
    private float credit_hrs;
    private int enrol, available;
    private boolean monday, tuesday, wednesday, thursday, friday, saturday;

    IMCourse(String crn, String subject, String course_num, String section, String title, float credit_hrs, String college, int enrol,
             int available, String begin_time, String end_time, String bldg, String room, boolean monday, boolean tuesday, boolean weds, boolean thurs, boolean fri,
             boolean sat, String first_name, String last_name) {
        this.crn = crn;
        this.subject = subject;
        this.course_num = course_num;
        this.section = section;
        this.title = title;
        this.credit_hrs = credit_hrs;
        this.college = college;
        this.enrol = enrol;
        this.available = available;
        this.begin_time = begin_time;
        this.end_time = end_time;
        this.bldg = bldg;
        this.room = room;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = weds;
        this.thursday = thurs;
        this.friday = fri;
        this.saturday = sat;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getCrn() {
        return this.crn;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getCourse_num() {
        return this.course_num;
    }

    public String getSection() {
        return this.section;
    }

    public String getTitle() {
        return this.title;
    }

    public float getCredithrs() {
        return this.credit_hrs;
    }

    public String getCollege() {
        return this.college;
    }

    public int getActual_enrol() {
        return this.enrol;
    }

    public int getSeats_available() {
        return this.available;
    }

    public java.time.LocalTime getBegin_time() {
        this.begin_time = this.begin_time.substring(0, 2) + ":" + this.begin_time.substring(2);
        // check for time of format 00 :: 00
        int numOccurrences = 0;
        Matcher m = Pattern.compile(":", Pattern.LITERAL).matcher(this.begin_time);
        while (m.find()) numOccurrences++;

        if (numOccurrences > 1) this.begin_time = this.begin_time.substring(0, 2) + this.begin_time.substring(3);

        return LocalTime.parse(this.begin_time);
    }

    public java.time.LocalTime getEnd_time() {
        this.end_time = this.end_time.substring(0, 2) + ":" + this.end_time.substring(2);

        int numOccurrences = 0;
        Matcher m = Pattern.compile(":", Pattern.LITERAL).matcher(this.end_time);
        while (m.find()) numOccurrences++;

        if (numOccurrences > 1) this.end_time = this.end_time.substring(0, 2) + this.end_time.substring(3);


        return LocalTime.parse(this.end_time);
    }

    public String getBldg() {
        return this.bldg;
    }

    public String getRoom() {
        return this.room;
    }

    public boolean getMonday() {
        return this.monday;
    }

    public boolean getTuesday() {
        return this.tuesday;
    }

    public boolean getWednesday() {
        return this.wednesday;
    }

    public boolean getThursday() {
        return this.thursday;
    }

    public boolean getFriday() {
        return this.friday;
    }

    public boolean getSaturday() {
        return this.saturday;
    }

    public String getInstructor_first() {
        return this.first_name;
    }

    public String getInstructor_last() {
        return this.last_name;
    }
}
