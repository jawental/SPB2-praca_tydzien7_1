package pl.weglewski.praca_tydzien7_1.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.weglewski.praca_tydzien7_1.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CarDaoImp implements CarDao {


    private JdbcTemplate jdbcTemplate;

    public CarDaoImp(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Car> getAllCars() {
        String sql = "SELECT * FROM cars";
        List<Car> carList = new ArrayList<>();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> carList.add(new Car(
                Long.parseLong(String.valueOf(element.get("car_id"))),
                String.valueOf(element.get("mark")),
                String.valueOf(element.get("model")),
                String.valueOf(element.get("color")),
                Integer.parseInt(String.valueOf(element.get("prod_date")))
        )));
        return carList;
    }

    @Override
    public List<Car> getCarsByDate(int from, int to) {
        String sql = "SELECT * FROM cars where prod_date between ? and ?";
        List<Car> carList = new ArrayList<>();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, from, to);
        maps.stream().forEach(element -> carList.add(new Car(
                Long.parseLong(String.valueOf(element.get("car_id"))),
                String.valueOf(element.get("mark")),
                String.valueOf(element.get("model")),
                String.valueOf(element.get("color")),
                Integer.parseInt(String.valueOf(element.get("prod_date")))
        )));
        return carList;
    }


    @Override
    public int addCar(Car car) {
        String sql = "INSERT INTO cars VALUES(?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, car.getCarId(),car.getMark(), car.getModel(), car.getColor(), car.getProdDate());
    }


    @Override
    public int removeCar(Car car) {
        String sql = "DELETE FROM cars WHERE car_id = ?";
        return jdbcTemplate.update(sql, car.getCarId());
    }

    @Override
    public long maxId(){
        String sql = "SELECT IFNULL(MAX(car_id), 0) FROM cars";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    };
}
