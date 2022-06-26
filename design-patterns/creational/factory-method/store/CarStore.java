package store;

import car.Car;

public abstract class CarStore {
    public abstract Car makeCar(String type);

    public Car prepareToSell(String type) {
        Car newCar = this.makeCar(type);
        newCar.drive();
        newCar.polish();
        return newCar;
    }
}
