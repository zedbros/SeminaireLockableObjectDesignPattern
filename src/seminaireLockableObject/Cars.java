package seminaireLockableObject;

public class Cars implements Runnable {
    private final Car car;
    private final Lockable target;

    public Cars(Car car, Lockable target) {
        this.car = java.util.Objects.requireNonNull(car, "car");
        this.target = java.util.Objects.requireNonNull(target, "target");
    }
    @Override
    public void run() {
        if (!car.wash(target)) {
            useCarWash(car, target.getLocker(), target);
        } else {
            System.out.println(car.getName() + " has started his car wash.");
        }
    }
    public void useCarWash(Car car, Car locker, Lockable target) {
        System.out.println(car.getName() + " is waiting for the car wash occupied by " + locker.getName());
        while (!car.wash(target)) {
            try {
                System.out.println("Go to sleepppppppp");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println(car.getName() + " has started his car wash.");
    }
}
