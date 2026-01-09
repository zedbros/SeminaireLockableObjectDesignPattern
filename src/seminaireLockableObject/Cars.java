package seminaireLockableObject;

public class Cars implements Runnable{
    private final Car car;
    private final Lockable target;

    public Cars(@NonNull Car car, @NonNull Lockable target) {
        this.car = car;
        this.target = target;
    }

    @Override
    public void run() {
        if (car.wash(target)) {
            useCarWash(car, target.getLocker(), target);
        } else {
            System.out.println("{} has started his car wash." + target.getLocker().getName());
        }
    }

    public void useCarWash(Car car, Car locker, Lockable target) {
        System.out.println("{} is waiting for the car wash occupied by {}."+ car.getName() +locker.getName());
        while (car.wash(target)) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("{} has started his car wash."+ car.getName());
    }
}
