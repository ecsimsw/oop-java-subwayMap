package subway.view;

import subway.domain.Line;
import subway.domain.Station;
import java.util.List;

public class OutputView {
    private static final String INFO_MESSAGE = "[INFO] %s \n";
    private static final String ERROR_MESSAGE = "[ERROR] %s \n";

    private OutputView(){}

    public static void printMap(List<Line> lines){
        OutputView.printMsg("## 지하철 노선도\n");
        for(Line line : lines){
            OutputView.printfMsg(INFO_MESSAGE, line.getName());
            OutputView.printfMsg(INFO_MESSAGE, "---\n");
            printStationNames(line.getStations());
            OutputView.printfMsg("\n");
        }
    }

    public static void printStationList(List<Station> stations){
        OutputView.printMsg("## 역 목록\n");
        printStationNames(stations);
    }

    public static void printStationNames(List<Station> stations){
        for(Station station : stations){
            OutputView.printfMsg(INFO_MESSAGE, station.getName());
        }
    }

    public static void printError(Exception e){
        OutputView.printfMsg(ERROR_MESSAGE, e.getMessage());
    }

    public static void printSectionManagement(){
        OutputView.printMsg(MenuRepository.sectionManagementMenu);
    }

    public static void printLineManagement(){
        OutputView.printMsg(MenuRepository.lineManagementMenu);
    }

    public static void printStationManagement(){
        OutputView.printMsg(MenuRepository.stationManagementMenu);
    }

    public static void printMainPage(){
        OutputView.printMsg(MenuRepository.mainMenu);
    }

    public static void printfMsg(String msg, Object... args){
        System.out.printf(msg, args);
    }

    public static void printMsg(Object msg){
        System.out.print(msg);
    }
}
