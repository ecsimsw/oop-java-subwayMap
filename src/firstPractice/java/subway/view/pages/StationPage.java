package subway.view.pages;

import subway.controller.StationController;
import subway.view.InputView;
import subway.view.MenuRepository;
import subway.view.OutputView;

import java.util.Scanner;

public class StationPage {

    private StationPage(){}

    public static void printStationPage(Scanner scanner){
        while(true){
            printMenu();
            String input = InputView.selectMenu(scanner);
            if(input.equals("B")){
                break;
            }
            next(input, scanner);
        }
    }

    private static void printMenu(){
        OutputView.printMsg(MenuRepository.stationManagementMenu);
    }

    private static void next(String input, Scanner scanner){
        if(input.equals("1")){
            StationController.addNewStation(scanner);
            OutputView.printInfoMsg(" 지하철 역이 등록되었습니다.\n");
            return;
        }

        if(input.equals("2")){
            StationController.addNewStation(scanner);
            OutputView.printInfoMsg(" 지하철 역이 삭제되었습니다.\n");
            return;
        }

        if(input.equals("3")){
            StationController.printStations();
            return;
        }
    }
}
