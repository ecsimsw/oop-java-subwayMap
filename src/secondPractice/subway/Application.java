package subway;

import subway.controller.LineController;
import subway.controller.StationController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현

        SubwayManagementApp app = new SubwayManagementApp(scanner);
        app.run();
    }
}
