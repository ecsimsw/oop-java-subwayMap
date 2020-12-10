package subway.view;

import java.util.Scanner;

public class In {
    private In(){}

    public static String getSelect(Scanner scanner){
        Out.print(PageRepository.selectPageMessage);
        return getInput(scanner);
    }

    private static String getInput(Scanner scanner){
        return scanner.nextLine();
    }
}
