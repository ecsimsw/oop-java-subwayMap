package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.PageRepository;

import java.util.Scanner;

public class MainController {
    private final Scanner scanner;
    private final LineController lineController;
    private final SectionController sectionController;
    private final StationController stationController;

    private boolean isOnLoop = true;

    public MainController(Scanner scanner){
        this.scanner = scanner;
        lineController = new LineController(scanner);
        sectionController = new SectionController(scanner);
        stationController = new StationController(scanner);
    }

    public void printStationMenu(){
        do {
            OutputView.print(PageRepository.mainPage);
            String input = InputView.getSelect(scanner);
            nextPage(input);
        } while (isOnLoop);
    }

    private void nextPage(String input){
        if(input.equals("1")){
            stationController.printStationMenu();
        }

        if(input.equals("2")){
            lineController.printLineMenu();
        }

        if(input.equals("3")){
            sectionController.printSectionMenu();
        }

        if(input.equals("4")){
            printSubwayMap();
        }

        if(input.equals("B")){
            setLoopEnd();
        }
    }

    private void setLoopEnd(){
        isOnLoop = false;
    }

    private void printSubwayMap(){
        for(Line line : LineRepository.lines()){
            OutputView.printInfo(line.getName());
            OutputView.printInfo("---\n");
            OutputView.printStationList(line.getStations());
        }
    }

}
