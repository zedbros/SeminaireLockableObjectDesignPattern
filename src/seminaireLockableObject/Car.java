package seminaireLockableObject;

public class Car {

    private int id;
    private String model;
    private String color;

    public Object getName() {
        return model + " " + id;
    }
    public boolean wash(Lockable target) {
        return target.wash(this);
    }

}
