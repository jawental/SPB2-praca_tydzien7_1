package pl.weglewski.praca_tydzien7_1.view;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.weglewski.praca_tydzien7_1.controller.CarController;
import pl.weglewski.praca_tydzien7_1.model.Car;

@Route("show-all")
public class ShowCars extends VerticalLayout {

    private CarController carController;

    @Autowired
    public ShowCars(CarController carController) {
        this.carController = carController;
        Grid<Car> grid = new Grid<>(Car.class);
        grid.setItems(carController.getCars());
        add(grid);
    }

}
