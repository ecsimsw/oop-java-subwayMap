package subway.management;

import subway.controller.StationController;
import subway.domain.button.StationMenuButton;

import java.util.Scanner;

public class StationManagement implements IManagement {
    private final StationController stationController;

    public StationManagement(Scanner scanner) {
        stationController = new StationController(scanner);
    }

    @Override
    public void run() {
        stationController.printMenu();
        StationMenuButton input = stationController.getSelection();
        stationController.serviceSelection(input);
    }
}
