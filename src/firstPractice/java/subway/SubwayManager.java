package subway;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayManager {
    private final Scanner scanner;

    public SubwayManager(Scanner scanner){
        this.scanner = scanner;
    }

    public void run(){


    }

    private void mainPage(){
        while(true){
            OutputView.printMainPage();
            String button = InputView.selectMenu(scanner);

        }


    }

    private void stationManagement(){
        OutputView.printStationManagement();
        String button = InputView.selectMenu(scanner);

    }

    private void lineManagement(){
        OutputView.printLineManagement();
        String button = InputView.selectMenu(scanner);
    }
}

