package subway.view;

import subway.domain.Name;
import subway.domain.button.SectionMenuButton;

import java.util.Scanner;

public class SectionView {
    private final Scanner scanner;

    public SectionView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printMenu() {
        OutputView.print(MenuRepository.sectionMenu);
    }

    public SectionMenuButton getUserSelection() {
        return SectionMenuButton.getButton(InputView.getInput(scanner));
    }

    public Name getLineNameToAddSection() {
        OutputView.print("## 노선을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public Name getStationNameToAddSection() {
        OutputView.print("## 역 이름을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public int getOrder() {
        OutputView.print("## 순서를 입력하세요.\n");
        return Integer.parseInt(InputView.getInput(scanner));
    }

    public void printRegistrationSuccess() {
        OutputView.printInfo("구간이 등록되었습니다.\n");
    }

    public Name getLineNameToDelete() {
        OutputView.print("## 삭제할 구간의 노선을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public Name getStationNameToDelete() {
        OutputView.print("## 삭제할 구간의 역을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public void printDeletionSuccess() {
        OutputView.printInfo("구간이 삭제되었습니다.\n");
    }

}
