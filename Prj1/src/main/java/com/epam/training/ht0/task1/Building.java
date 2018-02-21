package com.epam.training.ht0.task1;

import com.epam.training.ht0.task1.exceptions.NoSuchRoomException;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private String name;
    private List<Room> rooms;

    public Building(String name) {
        this.name = name;
        this.rooms = new ArrayList<Room>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public Room getRoom(String roomName) throws NoSuchRoomException {
        for (Room room : this.rooms) {
            if (roomName.equals(room.getName())) {
                return room;
            }
        }
        throw new NoSuchRoomException("There is no room '" + roomName + "' in building '" + this.name + "'");
    }

    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append("\n");
        for (Room room : this.rooms) {
            sb.append(room.toString()).append("\n");
        }
        return sb.toString();
    }
}
