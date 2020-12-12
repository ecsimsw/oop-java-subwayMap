package subway.view;

import subway.domain.Name;
import subway.domain.button.LineMenuButton;

import java.util.Scanner;

public class LineView {
    private final Scanner scanner;

    public LineView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printMenu() {
        OutputView.print(MenuRepository.lineMenu);
    }

    public LineMenuButton getUserSelection() {
        return LineMenuButton.getButton(InputView.getInput(scanner));
    }

    public Name getLineNameToAdd() {
        OutputView.print("## 등록할 노선 이름을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public Name getFirstStationName() {
        OutputView.print("## 등록할 노선의 상행 종점역 이름을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public Name getLastStationName() {
        OutputView.print("## 등록할 노선의 하행 종점역 이름을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public void printRegistrationSuccess() {
        OutputView.printInfo("지하철 노선이 등록되었습니다.");
    }

    public Name getLineNameToDelete() {
        OutputView.print("## 삭제할 노선 이름을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public void printDeletionSuccess() {
        OutputView.printInfo("지하철 노선이 삭제되었습니다.");
    }
}
