package Implementations;

import CoreInterfaces.CourSeera;
import CoreInterfaces.CourSeeraFactory;
import CoreInterfaces.Course;

import java.util.List;

public class IMCourSeeraFactory implements CourSeeraFactory {

    @Override
    public CourSeera createInstance(List<Course> courses) {
        return new IMCourSeera(courses);
    }
}
