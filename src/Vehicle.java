package src;

public abstract class Vehicle {
    protected String id;
    protected vehicletype type;

    public Vehicle(String id, vehicletype type) {
        this.id = id;
        this.type = type;
    }

    public vehicletype getType() {
        return this.type;
    }
}
