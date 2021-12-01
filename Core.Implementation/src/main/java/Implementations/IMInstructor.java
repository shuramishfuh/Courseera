package Implementations;

import CoreInterfaces.Instructor;

public class IMInstructor implements Instructor {
    String lName;
    private
    String fName;

    public IMInstructor(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    @Override
    public String getFirstName() {
        return this.fName;
    }

    @Override
    public String getLastName() {
        return this.lName;
    }
}
