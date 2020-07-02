package pl.weglewski.praca_tydzien7_1.view;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.weglewski.praca_tydzien7_1.controller.CarController;
import pl.weglewski.praca_tydzien7_1.model.Car;

@Route("remove")
public class RemoveCar extends VerticalLayout {

    private CarController carController;

    @Autowired
    public RemoveCar(CarController carController) {
        Grid<Car> grid = new Grid<>(Car.class);
        this.carController = carController;
        grid.setItems(carController.getCars());
        grid.setSelectionMode(Grid.SelectionMode.NONE);
        grid.addColumn(new NativeButtonRenderer<>("Delete", item -> {
            carController.removeCar(item.getCarId());
            grid.setItems(carController.getCars());
            }));

        add(grid);
    }


}