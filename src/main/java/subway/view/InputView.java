package subway.view;

import subway.Repository.PageRepository;
import subway.domain.Name;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    public static String getSelect(Scanner scanner) {
        OutputView.print(PageRepository.selectPageMessage);
        return getInput(scanner);
    }

    public static Name getName(Scanner scanner) {
        return new Name(getInput(scanner));
    }

    private static String getInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
