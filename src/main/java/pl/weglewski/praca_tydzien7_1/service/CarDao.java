package pl.weglewski.praca_tydzien7_1.service;

import pl.weglewski.praca_tydzien7_1.model.Car;

import java.util.List;

public interface CarDao {

    List<Car> getAllCars();
    List<Car> getCarsByDate(int from, int to);
    int addCar(Car car);
    int removeCar(Car car);
    long maxId();
}
