package subway.view.pages;

import subway.controller.LineController;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.MenuRepository;
import subway.view.OutputView;

import java.util.Scanner;

public class MainPage {
    private MainPage(){}

    public static void printMainPage(Scanner scanner){
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
        OutputView.printMsg(MenuRepository.mainMenu);
    }

    private static void next(String input, Scanner scanner){
        if(input.equals("1")){
            StationPage.printStationPage(scanner);
            return;
        }

        if(input.equals("2")){
            LinePage.printLinePage(scanner);
            return;
        }

        if(input.equals("3")){
            SectionPage.printSectionPage(scanner);
            return;
        }

        if (input.equals("4")){
            OutputView.printMap(LineRepository.lines());
            return;
        }
    }
}
