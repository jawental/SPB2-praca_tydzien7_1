package pl.weglewski.praca_tydzien7_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import pl.weglewski.praca_tydzien7_1.model.Car;
import pl.weglewski.praca_tydzien7_1.service.CarDao;

import java.util.List;
import java.util.Optional;

@Controller
public class CarController {

    private CarDao carDao;

    @Autowired
    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    public List<Car> getCars(){
        List<Car> allCars = carDao.getAllCars();
        return allCars;
    }


    public List<Car> getCarByDate(int from, int to){
        List<Car> carList = carDao.getCarsByDate(from, to);
        return carList;
    }

    public int addCar(Car car){
        return carDao.addCar(car);
    }


    public Car removeCar(@PathVariable long id){
        Optional<Car> first = carDao.getAllCars().stream().filter(car -> car.getCarId() == id).findFirst();
        return first.map(x -> {
                    carDao.removeCar(first.get());
                    return first.get();
                }
        ).orElseGet(() -> null);
    }

    public long maxId(){
        return carDao.maxId();
    }
}

