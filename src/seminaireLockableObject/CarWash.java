package seminaireLockableObject;

public class CarWash implements Lockable{

    private boolean locked;
    private Car locker;

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public Car getLocker() {
        return locker;
    }

    @Override
    public boolean wash(Car car) {
        if (!locked) {
            locker = car;
            locked = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void finishWash(Car car) {
        locked = false;
        locker = null;
    }

}
