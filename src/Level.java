package src;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int floorid;
    public final List<ParkingSpot> bikeParkingSpots;
    public final List<ParkingSpot> carParkingSpots;
    public final List<ParkingSpot> truckParkingSpots;

    public Level(int floorid, int numspot) {
        this.floorid = floorid;
        int mt = (numspot * 50) / 100;
        int cr = (numspot * 30) / 100;
        int tr = numspot - mt - cr;
        bikeParkingSpots = new ArrayList<>(mt);
        carParkingSpots = new ArrayList<>(cr);
        truckParkingSpots = new ArrayList<>(tr);

        for (int i = 0; i < mt; i++) {
            bikeParkingSpots.add(new ParkingSpot(i, vehicletype.MOTORCYCLE));
        }
        for (int i = 0; i < cr; i++) {
            carParkingSpots.add(new ParkingSpot(i, vehicletype.CAR));
        }
        for (int i = 0; i < tr; i++) {
            truckParkingSpots.add(new ParkingSpot(i, vehicletype.TRUCK));
        }
    }

    public synchronized boolean parkVehicle(Vehicle v) {
        if (v.getType() == vehicletype.MOTORCYCLE) {
            for (ParkingSpot spot : bikeParkingSpots) {
                if (spot.isAvailable()) {
                    spot.parkVehicle(v);
                    return true;
                }
            }
            return false;
        } else if (v.getType() == vehicletype.CAR) {
            for (ParkingSpot spot : carParkingSpots) {
                if (spot.isAvailable()) {
                    spot.parkVehicle(v);
                    return true;
                }
            }
            return false;
        } else {
            for (ParkingSpot spot : truckParkingSpots) {
                if (spot.isAvailable()) {
                    spot.parkVehicle(v);
                    return true;
                }
            }
            return false;
        }
    }

    public synchronized boolean unparkVehicle(Vehicle v) {
        if (v.getType() == vehicletype.MOTORCYCLE) {
            for (ParkingSpot spot : bikeParkingSpots) {
                if (spot.getParkedVehicle() == v) {
                    spot.unparkVehicle();
                    return true;
                }
            }
            return false;
        } else if (v.getType() == vehicletype.CAR) {
            for (ParkingSpot spot : carParkingSpots) {
                if (spot.getParkedVehicle() == v) {
                    spot.unparkVehicle();
                    return true;
                }
            }
            return false;
        } else {
            for (ParkingSpot spot : truckParkingSpots) {
                if (spot.getParkedVehicle() == v) {
                    spot.unparkVehicle();
                    return true;
                }
            }
            return false;
        }
    }

    public void displayAvailability() {
        System.out.println("Level " + this.floorid + " Availability:");
        for (ParkingSpot spot : bikeParkingSpots) {
            System.out.println("Spot " + spot.getSpotnumber() + ": " + (spot.isAvailable() ? "Available For" : "Occupied By ") + " " + spot.getPstype());
        }
        for (ParkingSpot spot : carParkingSpots) {
            System.out.println("Spot " + spot.getSpotnumber() + ": " + (spot.isAvailable() ? "Available For" : "Occupied By ") + " " + spot.getPstype());
        }
        for (ParkingSpot spot : truckParkingSpots) {
            System.out.println("Spot " + spot.getSpotnumber() + ": " + (spot.isAvailable() ? "Available For" : "Occupied By ") + " " + spot.getPstype());
        }
    }
}
