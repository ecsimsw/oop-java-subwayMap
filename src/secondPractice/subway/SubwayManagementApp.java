package subway;

import subway.domain.button.MainMenuButton;
import subway.management.*;
import subway.view.InputView;
import subway.view.MenuRepository;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayManagementApp {
    public final StationManagement stationManagement;
    private final LineManagement lineManagement;
    private final SectionManagement sectionManagement;
    private final SubwayMapManagement subwayMapManagement;

    private final Scanner scanner;
    private boolean isAppEnd = false;

    public SubwayManagementApp(Scanner scanner) {
        this.scanner = scanner;

        stationManagement = new StationManagement(scanner);
        lineManagement = new LineManagement(scanner);
        sectionManagement = new SectionManagement(scanner);
        subwayMapManagement = new SubwayMapManagement(scanner);
    }

    public void run() {
        do {
            OutputView.print(MenuRepository.mainMenu);
            OutputView.print(MenuRepository.sectionMenu);
            selectNextPage();
        } while (!isAppEnd);
    }

    public void selectNextPage() {
        MainMenuButton button = InputView.getUserSelection(scanner);
        if (button.equals(MainMenuButton.Quit)) {
            isAppEnd = true;
            return;
        }
        getNextPage(button).run();
    }

    private IManagement getNextPage(MainMenuButton button) {
        if (button.equals(MainMenuButton.StationManagement)) {
            return stationManagement;
        }

        if (button.equals(MainMenuButton.LineManagement)) {
            return lineManagement;
        }

        if (button.equals(MainMenuButton.SectionManagement)) {
            return sectionManagement;
        }

        if (button.equals(MainMenuButton.ShowSubwayMap)) {
            return subwayMapManagement;
        }

        throw new IllegalArgumentException("잘못된 접근 입니다.");
    }
}
