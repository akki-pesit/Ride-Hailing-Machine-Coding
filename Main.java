import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import exceptions.NoDriversAvailableException;
import exceptions.RideAlreadyInProgressException;
import models.Driver;
import models.RideSystem;
import models.Rider;

class Main {
    public static void main(String[] args) {
        Rider rider1 = new Rider("Mark", 1);
        Rider rider2 = new Rider("Twain", 2);

        try {
            rider1.createRide(1, 1, 5, 1);
        } catch (RideAlreadyInProgressException e) {
            e.printStackTrace();
        }
        try {
            rider2.createRide(1, 2, 10, 4);
        } catch (RideAlreadyInProgressException e) {
            e.printStackTrace();
        }
        
        Driver driver1 = new Driver("Adam");
        Driver driver2 = new Driver("Eve");

        Deque<Driver> driversQueue = new LinkedList<Driver>();
        driversQueue.addLast(driver1);
        driversQueue.addLast(driver2);

        ArrayList<Rider> ridersArr = new ArrayList<>();
        ridersArr.add(rider1);
        ridersArr.add(rider2);

        RideSystem rideSystem = new RideSystem(driversQueue, ridersArr);
        
        // First ride
        Driver assignedDriver1;
        try {
            assignedDriver1 = rideSystem.assignDriverToRider(1);
            rideSystem.closeRide(assignedDriver1);
        } catch (NoDriversAvailableException e) {
            e.printStackTrace();
        }

        // Second ride
        Driver assignedDriver2;
        try {
            assignedDriver2 = rideSystem.assignDriverToRider(2);
            rideSystem.closeRide(assignedDriver2);
        } catch (NoDriversAvailableException e) {
            e.printStackTrace();
        }
    }
}