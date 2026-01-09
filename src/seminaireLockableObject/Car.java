package seminaireLockableObject;

import java.util.List;

public class Car {

    private final int id;
    private final String model;

    public Car() {
        this.id = (int) (Math.random() * 1000);
        List<String> models = List.of("Sedan", "SUV", "Coupe", "Convertible", "Hatchback", "Van", "Truck", "Wagon", "Sports Car", "Diesel");
        this.model = models.get((int) (Math.random() * models.size()));
        List<String> colors = List.of("Red", "Blue", "Green", "Black", "White");
        String color = colors.get((int) (Math.random() * colors.size()));
    }

    public Object getName() {
        return model + " #" + id;
    }
    public boolean wash(Lockable target) {
        return target.wash(this);
    }

}
