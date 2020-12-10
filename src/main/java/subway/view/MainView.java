package subway.view;

import subway.domain.Line;

import java.util.List;
import java.util.Scanner;

public class MainView {
    private final Scanner scanner;

    public MainView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String selectMainMenu() {
        OutputView.print(PageRepository.mainPage);
        return InputView.getSelect(scanner);
    }

    public void printSubwayMap(List<Line> lines) {
        for (Line line : lines) {
            OutputView.printInfo(line.getName());
            OutputView.printInfo("---\n");
            OutputView.printStationList(line.getStations());
        }
    }
}
