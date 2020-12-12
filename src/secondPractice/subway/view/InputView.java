package subway.view;

import subway.domain.Name;
import subway.domain.button.MainMenuButton;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    public static Name getName(Scanner scanner) {
        return new Name(getInput(scanner));
    }

    public static MainMenuButton getUserSelection(Scanner scanner) {
        return MainMenuButton.getButton(getInput(scanner));
    }

    public static String getInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
