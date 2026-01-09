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
        if (!car.acquire(target)) {
            useCarWash(car, target.getLocker(), target);
        } else {
            LOGGER.info("{} has started his car wash.", target.getLocker().getName());
        }
    }
}
