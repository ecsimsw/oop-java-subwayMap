package subway.view;

import subway.Repository.PageRepository;
import subway.domain.Line;
import subway.domain.validator.MainValidator;

import java.util.List;
import java.util.Scanner;

public class MainView {
    private static final String[] buttons = new String[]{"1","2","3","4","Q"};
    private final Scanner scanner;

    public MainView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String selectMainMenu() {
        OutputView.print(PageRepository.mainPage);
        try{
            String input = InputView.getSelect(scanner);
            MainValidator.checkValidSelection(input, buttons);
            return input;
        }catch (Exception e){
            OutputView.printError(e);
            return selectMainMenu();
        }
    }

    public void printSubwayMap(List<Line> lines) {
        for (Line line : lines) {
            OutputView.printInfo(line.getName());
            OutputView.printInfo("---");
            OutputView.printStationList(line.getStations());
            OutputView.print("\n");
        }
    }
}
