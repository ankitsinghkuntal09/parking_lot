package src;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static volatile ParkingLot instance;
    private final List<Level> levels;

    private ParkingLot() {
        levels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (ParkingLot.instance == null) {
            synchronized (ParkingLot.class) {
                if (ParkingLot.instance == null) {
                    instance = new ParkingLot();
                }
            }
        }
        return ParkingLot.instance;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public boolean parkVehicle(Vehicle v) {
        for (Level level : levels) {
            if (level.parkVehicle(v)) {
                System.out.println("Vehicle parked successfully.");
                return true;
            }
        }
        System.out.println("Could not park vehicle.");
        return false;
    }

    public boolean unparkVehicle(Vehicle v) {
        for (Level level : levels) {
            if (level.unparkVehicle(v)) {
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        for (Level level : levels) {
            level.displayAvailability();
        }
    }
}
