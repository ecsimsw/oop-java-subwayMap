package subway.management;

import subway.controller.LineController;
import subway.domain.button.LineMenuButton;

import java.util.Scanner;

public class LineManagement implements IManagement {
    private final LineController lineController;

    public LineManagement(Scanner scanner) {
        lineController = new LineController(scanner);
    }

    @Override
    public void run() {
        lineController.printMenu();
        LineMenuButton input = lineController.getSelection();
        lineController.serviceSelection(input);
    }
}
