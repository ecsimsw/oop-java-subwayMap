package subway.view;

import subway.Repository.PageRepository;
import subway.domain.Name;
import subway.domain.Station;
import subway.Repository.StationRepository;
import subway.domain.validator.MainValidator;
import subway.domain.validator.StationValidator;

import java.util.Scanner;
import java.util.List;

public class StationView {
    private static final String[] buttons = new String[]{"1", "2", "3", "B"};
    private final Scanner scanner;

    public StationView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String selectStationMenu() {
        OutputView.print(PageRepository.stationPage);
        try {
            String input = InputView.getSelect(scanner);
            MainValidator.checkValidSelection(input, buttons);
            return input;
        } catch (Exception e) {
            OutputView.printError(e);
            return selectStationMenu();
        }
    }

    public Name getStationNameToAdd() {
        OutputView.print("## 등록할 역 이름을 입력하세요.\n");
        try {
            Name name = InputView.getName(scanner);
            StationValidator.checkNonExistStationName(name);
            return name;
        } catch (Exception e) {
            OutputView.printError(e);
            return getStationNameToAdd();
        }
    }

    public Station getStationToDelete() {
        OutputView.print("## 삭제할 역 이름을 입력하세요.\n");
        try {
            return StationRepository.getByName(InputView.getName(scanner));
        } catch (Exception e) {
            OutputView.printError(e);
            return getStationToDelete();
        }
    }

    public void printStation(List<Station> stations) {
        OutputView.print("## 역 목록\n");
        OutputView.printStationList(stations);
        OutputView.print("\n");
    }

    public void printAddSuccessMessage() {
        OutputView.printInfo("지하철 역이 등록되었습니다.\n");
    }

    public void printDeleteSuccessMessage() {
        OutputView.printInfo("지하철 역이 삭제되었습니다.\n");
    }
}
