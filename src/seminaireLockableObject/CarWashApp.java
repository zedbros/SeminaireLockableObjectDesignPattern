package seminaireLockableObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarWashApp implements Runnable {
    @Override
    public void run() {
        var carwash = new CarWash();
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        ExecutorService service = Executors.newFixedThreadPool(cars.size());
        for (var i=0; i<cars.size(); i++) {
            service.submit(new Cars(cars.get(i), carwash));
        }
    }
}

