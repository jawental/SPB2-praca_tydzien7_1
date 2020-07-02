package pl.weglewski.praca_tydzien7_1.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.weglewski.praca_tydzien7_1.controller.CarController;
import pl.weglewski.praca_tydzien7_1.model.Car;

@Route("show-bydate")
public class ShowCarByDate extends VerticalLayout {

    private CarController carController;

    @Autowired
    public ShowCarByDate(CarController carController) {
        Grid<Car> grid = new Grid<>(Car.class);
        this.carController = carController;
        IntegerField textFieldOd = new IntegerField();
        textFieldOd.setLabel("Podaj datę od:");
        IntegerField textFieldDo = new IntegerField();
        textFieldDo.setLabel("Podaj datę do:");
        Button button = new Button("Show");

        button.addClickListener(buttonClickEvent -> {

            grid.setItems(carController.getCarByDate(
                    textFieldOd.getValue(),
                    textFieldDo.getValue()));
            grid.setSortableColumns();
            add(grid);
        });
        add(textFieldOd,textFieldDo, button);
    }

}
