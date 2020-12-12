package subway;

import subway.controller.LineController;
import subway.controller.StationController;
import subway.view.MainMenu;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MainMenu.run();
    }
}
