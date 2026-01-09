package seminaireLockableObject;

public interface Lockable {
    boolean isLocked();
    Car getLocker();
    boolean wash(Car car);
    void finishWash(Car car);
}
