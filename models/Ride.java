package models;

public class Ride {
    static public int AMOUNT_PER_KM = 15;

    private int id;
    private int origin;
    private int destination;
    private int seats;
    private boolean rideStatus;

    public boolean getRideStatus() {
        return this.rideStatus;
    }

    public void setRideStatus(boolean rideStatus) {
        this.rideStatus = rideStatus;
    }

    public Ride() {
        this.id = 0;
        this.origin = 0;
        this.destination = 0;
        this.seats = 0;
        this.rideStatus = false;
    }

    public Ride(int id, int origin, int destination, int seats, boolean rideStatus) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.seats = seats;
        this.rideStatus = rideStatus;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrigin() {
        return this.origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public int getDestination() {
        return this.destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getSeats() {
        return this.seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", origin='" + getOrigin() + "'" +
            ", destination='" + getDestination() + "'" +
            ", seats='" + getSeats() + "'" +
            ", rideStatus='" + getRideStatus() + "'" +
            "}";
    }
    
    public int calculateFare() {
        int dist = destination - origin;
        if(seats >= 2) {
            return (int)(Math.ceil(dist * seats * 0.75 * AMOUNT_PER_KM));
        } else if(seats == 1) {
            return (int)(Math.ceil(dist * AMOUNT_PER_KM));
        }
        return 0;
    }
}
