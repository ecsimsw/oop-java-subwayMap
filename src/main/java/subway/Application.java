package subway;

import subway.controller.MainController;
import subway.view.In;
import subway.view.Out;
import subway.view.PageRepository;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        MainController mainController = new MainController(scanner);
        mainController.printStationMenu();
    }
}