package subway.view.pages;

import subway.view.InputView;
import subway.view.MenuRepository;
import subway.view.OutputView;

import java.util.Scanner;

public class SectionPage {
    private SectionPage(){}

    public static void printSectionPage(Scanner scanner){
        while(true){
            printMenu();
            String input = InputView.selectMenu(scanner);
            if(input.equals("Q")){
                break;
            }
            next(input, scanner);
        }
    }

    private static void printMenu(){
        OutputView.printMsg(MenuRepository.sectionManagementMenu);
    }

    private static void next(String input, Scanner scanner){
        if(input.equals("1")){
            return;
        }

        if(input.equals("2")){
            return;
        }

        if(input.equals("3")){
            return;
        }

        if (input.equals("4")){

            return;
        }
    }
}
