package subway.controller;

import subway.Repository.LineRepository;
import subway.view.MainView;

import java.util.Scanner;

public class MainController {
    private final LineController lineController;
    private final SectionController sectionController;
    private final StationController stationController;
    private final MainView mainView;

    private boolean isOnLoop = true;

    public MainController(Scanner scanner) {
        lineController = new LineController(scanner);
        sectionController = new SectionController(scanner);
        stationController = new StationController(scanner);
        mainView = new MainView(scanner);
    }

    public void printStationMenu() {
        do {
            nextPage(mainView.selectMainMenu());
        } while (isOnLoop);
    }

    private void nextPage(String input) {
        if (input.equals("1")) {
            stationController.printStationMenu();
        }

        if (input.equals("2")) {
            lineController.runLineMenu();
        }

        if (input.equals("3")) {
            sectionController.printSectionMenu();
        }

        if (input.equals("4")) {
            printSubwayMap();
        }

        if (input.equals("Q")) {
            setLoopEnd();
        }
    }

    private void setLoopEnd() {
        isOnLoop = false;
    }

    private void printSubwayMap() {
        mainView.printSubwayMap(LineRepository.lines());
    }
}
