package Implementations;

import CoreInterfaces.Room;

public class IMRoom implements Room, Comparable<Room> {
    String roomNumber;
    private String building;

    public IMRoom(String building, String roomNumber) {
        this.building = building;
        this.roomNumber = roomNumber;
    }

    @Override
    public String getBuilding() {
        return this.building;
    }

    @Override
    public String getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public int compareTo(Room obj) {
        if (this.getBuilding().equals(obj.getBuilding()) && this.getRoomNumber().equals(obj.getRoomNumber()))
            return 0;
        if (this.getBuilding().equals(obj.getBuilding()))
            return this.getRoomNumber().compareTo(obj.getRoomNumber());
        return this.getBuilding().compareTo(obj.getBuilding());
    }
}
