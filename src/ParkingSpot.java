package src;

public class ParkingSpot {
    private Vehicle parkedVehicle;
    public int spotnumber;
    public vehicletype pstype;

    ParkingSpot(int spotnumber, vehicletype pstype) {
        this.spotnumber = spotnumber;
        this.pstype = pstype;
        this.parkedVehicle = null;
    }

    public synchronized boolean isAvailable() {
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle v) {
        if (isAvailable() && v.getType() == this.pstype) {
            parkedVehicle = v;
        } else {
            throw new IllegalArgumentException("WRONG PARKING VEHICLE OR SPACE OCCUPIED");
        }
    }

    public synchronized void unparkVehicle() {
        parkedVehicle = null;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public vehicletype getPstype() {
        return pstype;
    }

    public int getSpotnumber() {
        return spotnumber;
    }
}
