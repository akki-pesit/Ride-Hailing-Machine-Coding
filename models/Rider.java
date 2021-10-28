package models;

import java.util.ArrayList;

import exceptions.RideAlreadyInProgressException;

public class Rider extends Person {
    private int id;
    private ArrayList<Ride> completedRides;
    private Ride currentRide;

    public Rider(String name, int id) {
        this.id = id;
        this.name = name;
        this.completedRides = new ArrayList<>();
        this.currentRide = null;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Ride> getCompletedRides() {
        return this.completedRides;
    }

    public void setCompletedRides(ArrayList<Ride> completedRides) {
        this.completedRides = completedRides;
    }

    public Ride getCurrentRide() {
        return this.currentRide;
    }

    public void setCurrentRide(Ride currentRide) {
        this.currentRide = currentRide;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", completedRides='" + getCompletedRides() + "'" +
            ", currentRide='" + getCurrentRide() + "'" +
            "}";
    }

    public void createRide(int id, int origin, int destination, int seats) throws RideAlreadyInProgressException {
        if(this.currentRide == null) {
            Ride currentRide = new Ride(id, origin, destination, seats, true);
            this.currentRide = currentRide;
        } else {
            throw new RideAlreadyInProgressException("Rider Already is in a ride");
        }
    }

    public void closeRide() {
        this.currentRide.setRideStatus(false);
        this.completedRides.add(this.currentRide);
        this.currentRide = null;
    }
}
