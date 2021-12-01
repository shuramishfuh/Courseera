package FormaterEngineInterfaces;

import CoreInterfaces.Schedule;

import java.util.List;
import java.util.TreeMap;

public interface IoutputFormatter {
    String selector(TreeMap<String, List<Schedule>> methodAndList);

    String scheduleToString(List<Schedule> schedules);

    String scheduleToString(Schedule LS);
}
