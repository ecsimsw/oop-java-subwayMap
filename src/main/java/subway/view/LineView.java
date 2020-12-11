package subway.view;

import subway.Repository.PageRepository;
import subway.Repository.StationRepository;
import subway.domain.*;
import subway.domain.validator.LineValidator;
import subway.domain.validator.MainValidator;

import java.util.Scanner;
import java.util.List;

public class LineView {
    private static final String[] buttons = new String[]{"1", "2", "3", "B"};
    private final Scanner scanner;

    public LineView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String selectLineMenu() {
        OutputView.print(PageRepository.linePage);
        try {
            String input = InputView.getSelect(scanner);
            MainValidator.checkValidSelection(input, buttons);
            return input;
        } catch (Exception e) {
            OutputView.printError(e);
            return selectLineMenu();
        }
    }

    public Name getLineNameToAdd() {
        OutputView.print("## 등록할 노선 이름을 입력하세요.\n");
        try {
            Name name = InputView.getName(scanner);
            LineValidator.checkNonExistLineName(name);
            return name;
        } catch (Exception e) {
            OutputView.printError(e);
            return getLineNameToAdd();
        }
    }

    public Station getFirstStation() {
        OutputView.print("## 등록할 노선의 상행 종점역 이름을 입력하세요.\n");
        try {
            return StationRepository.getByName(InputView.getName(scanner));
        } catch (Exception e) {
            OutputView.printError(e);
            return getFirstStation();
        }
    }

    public Station getLastStation(Station firstStation) {
        OutputView.print("## 등록할 노선의 하행 종점역 이름을 입력하세요.\n");
        try {
            Station lastStation = StationRepository.getByName(InputView.getName(scanner));
            LineValidator.checkDifferentTerminal(firstStation, lastStation);
            return lastStation;
        } catch (Exception e) {
            OutputView.printError(e);
            return getLastStation(firstStation);
        }
    }

    public void printAddSuccessMessage() {
        OutputView.printInfo("지하철 노선이 등록되었습니다. \n");
    }


    public Name getLineNameToDelete() {
        OutputView.print("## 삭제할 노선 이름을 입력하세요.\n");
        try {
            Name name = InputView.getName(scanner);
            LineValidator.checkExistLineName(name);
            return name;
        } catch (Exception e) {
            OutputView.printError(e);
            return getLineNameToDelete();
        }
    }

    public void printDeleteSuccessMessage() {
        OutputView.printInfo("지하철 노선이 삭제되었습니다. \n");
    }

    public void printLines(List<Line> lines) {
        OutputView.print("## 노션 목록\n");
        lines.stream()
                .forEach(line -> OutputView.printInfo(line.getName() + "\n"));
    }
}
