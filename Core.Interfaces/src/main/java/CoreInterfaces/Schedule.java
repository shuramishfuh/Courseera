package CoreInterfaces;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public interface Schedule {
    String getRoom();

    LocalTime getFromTime();

    LocalTime getToTime();

    String getInstructor();

    String getCourse();

    List<DayOfWeek> getDay();
}
