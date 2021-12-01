package Implementations;

import CoreInterfaces.Schedule;

import java.util.Comparator;

public class ScheduleComparator implements Comparator<Schedule> {

    @Override
    public int compare(Schedule o1, Schedule o2) {
        return o1.getToTime().compareTo(o2.getToTime());
    }
}
