package subway.view;

import java.util.Scanner;

public class InputView {
    private InputView(){}

    public static String getSelect(Scanner scanner){
        OutputView.print(PageRepository.selectPageMessage);
        return getInput(scanner);
    }

    private static String getInput(Scanner scanner){
        return scanner.nextLine();
    }
}
