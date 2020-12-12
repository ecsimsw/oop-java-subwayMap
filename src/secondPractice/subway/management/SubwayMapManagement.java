package subway.management;

import subway.controller.LineController;

import java.util.Scanner;

public class SubwayMapManagement implements IManagement {
    private final LineController lineController;

    public SubwayMapManagement(Scanner scanner) {
        lineController = new LineController(scanner);
    }

    @Override
    public void run() {
        lineController.printSubwayMap();
    }
}
