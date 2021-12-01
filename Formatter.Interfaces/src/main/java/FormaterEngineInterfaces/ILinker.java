package FormaterEngineInterfaces;

import CoreInterfaces.Schedule;

import java.util.List;
import java.util.TreeMap;

public interface ILinker {
    TreeMap<String, List<Schedule>> callCoursera(List<String> Ls);
}
