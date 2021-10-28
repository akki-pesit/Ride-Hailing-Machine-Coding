package models;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

import exceptions.NoDriversAvailableException;

public class RideSystem {
    Deque<Driver> drivers;
    ArrayList<Rider> riders;
    HashMap<Driver, Rider> driverToRiderMapping;

    public RideSystem() {
    }

    public RideSystem(Deque<Driver> drivers, ArrayList<Rider> riders) {
        this.drivers = drivers;
        this.riders = riders;
        this.driverToRiderMapping = new HashMap<Driver,Rider>();
    }

    public Deque<Driver> getDrivers() {
        return this.drivers;
    }

    public void setDrivers(Deque<Driver> drivers) {
        this.drivers = drivers;
    }

    public ArrayList<Rider> getRiders() {
        return this.riders;
    }

    public void setRiders(ArrayList<Rider> riders) {
        this.riders = riders;
    }

    public HashMap<Driver,Rider> getDriverToRiderMapping() {
        return this.driverToRiderMapping;
    }

    public void setDriverToRiderMapping(HashMap<Driver,Rider> driverToRiderMapping) {
        this.driverToRiderMapping = driverToRiderMapping;
    }

    public RideSystem drivers(Deque<Driver> drivers) {
        setDrivers(drivers);
        return this;
    }

    public RideSystem riders(ArrayList<Rider> riders) {
        setRiders(riders);
        return this;
    }

    public RideSystem driverToRiderMapping(HashMap<Driver,Rider> driverToRiderMapping) {
        setDriverToRiderMapping(driverToRiderMapping);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " drivers='" + getDrivers() + "'" +
            ", riders='" + getRiders() + "'" +
            ", driverToRiderMapping='" + getDriverToRiderMapping() + "'" +
            "}";
    }

    public Driver assignDriverToRider(int riderId) throws NoDriversAvailableException {
        if(this.drivers.size() == 0) {
            throw new NoDriversAvailableException();
        } else {
            Driver driver = this.drivers.getFirst();
            Rider rider = null;
            for(Rider r : this.riders) {
                if(r.getId() == riderId) {
                    rider = r;
                }
            }

            if(rider == null) {
                System.out.println("Rider not found");
                return null;
            }

            this.driverToRiderMapping.put(driver, rider);
            System.out.println(rider.toString() + ", is completing ride: " + rider.getCurrentRide().toString() + ", with cost: " + rider.getCurrentRide().calculateFare());
            return driver;
        }
    }

    public void closeRide(Driver driver) {
        if(!this.driverToRiderMapping.containsKey(driver)) {
            System.out.println("Driver does'nt have any rides");
        } else {
            Rider rider = this.driverToRiderMapping.get(driver);
            System.out.println(rider.toString() + ", completed ride.");
            System.out.println("Releasing driver: " + driver.toString());
            rider.closeRide();
            this.drivers.addLast(driver);
        } 
    }
}
