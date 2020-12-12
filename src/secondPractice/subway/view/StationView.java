package subway.view;

import subway.domain.Name;
import subway.domain.button.StationMenuButton;

import java.util.Scanner;

public class StationView {
    private final Scanner scanner;

    public StationView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printMenu() {
        OutputView.print(MenuRepository.stationMenu);
    }

    public StationMenuButton getUserSelection() {
        return StationMenuButton.getButton(InputView.getInput(scanner));
    }

    public Name getStationNameToAdd() {
        OutputView.print("## 등록할 역 이름을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public void printRegistrationSuccess() {
        OutputView.printInfo("지하철 역이 등록되었습니다. \n");
    }

    public Name getStationNameToDelete() {
        OutputView.print("## 삭제할 역 이름을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public void printDeletionSuccess() {
        OutputView.printInfo("지하철 역이 삭제되었습니다.\n");
    }
}
