package subway.view;

import subway.domain.Station;
import java.util.List;

public class OutputView {
    private static final String INFO_MESSAGE = "[INFO] %s \n";

    private OutputView(){}

    public static void printStationList(List<Station> stations){
        OutputView.printMsg("## 역 목록\n");
        for(Station station : stations){
            OutputView.printfMsg(INFO_MESSAGE, station.getName());
        }
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
