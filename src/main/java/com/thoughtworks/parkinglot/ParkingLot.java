package com.thoughtworks.parkinglot;

import com.thoughtworks.parkinglot.exceptions.AlreadyParkedException;
import com.thoughtworks.parkinglot.exceptions.ParkableNotInTheParkingLotException;
import com.thoughtworks.parkinglot.exceptions.ParkingLotFullException;

import java.util.HashSet;

public class ParkingLot {
    private final int capacity;
    private final HashSet<Parkable> parkedVehicles;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        parkedVehicles = new HashSet<>(capacity);
    }

    public void park(Parkable parkable) throws ParkingLotFullException, AlreadyParkedException {
        if (isFull())
            throw new ParkingLotFullException();
        if (isParked(parkable))
            throw new AlreadyParkedException();
        parkedVehicles.add(parkable);
    }

    public void unpark(Parkable parkable) throws ParkableNotInTheParkingLotException {
        if(!isParked(parkable))
            throw new ParkableNotInTheParkingLotException();
        parkedVehicles.remove(parkable);
    }

    public boolean isParked(Parkable parkable) {
        return parkedVehicles.contains(parkable);
    }

    private boolean isFull() {
        return parkedVehicles.size() >= capacity;
    }
}
