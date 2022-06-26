package store;

import car.Car;
import car.CheapFastCar;
import car.RacingCar;

public class QuickCarStore extends CarStore {
    public Car makeCar(String type) {
        if (type.equals("Race")) {
            return new RacingCar();
        } else {
            return new CheapFastCar();
        }
    }
}
