package subway.view.pages;

import subway.view.InputView;
import subway.view.MenuRepository;
import subway.view.OutputView;

import java.util.Scanner;

public class LinePage {


    private LinePage(){}

    public static void printLinePage(Scanner scanner) {
        while(true){
            OutputView.printMsg(MenuRepository.lineManagementMenu);
            String input = InputView.selectMenu(scanner);
            if(input.equals("B")){
                break;
            }
            next(input);
        }
    }

    private static void next(String input){
        if(input.equals("1")){

            return;
        }

        if(input.equals("2")){

            return;
        }

        if(input.equals("3")){
            return;
        }
    }
}
