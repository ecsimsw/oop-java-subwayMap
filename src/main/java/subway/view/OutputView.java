package subway.view;

import subway.domain.Station;

import java.util.List;

public class OutputView {
    private static final String INFO_MESSAGE = "[INFO] %s\n";

    private OutputView(){}

    public static void printInfo(Object msg){
        printf(INFO_MESSAGE, msg);
    }

    public static void printStationList(List<Station> stations){
        for(Station station : stations){
            OutputView.printInfo(station.getName());
        }
    }

    public static void printf(String msg, Object... args){
        System.out.printf(msg, args);
    }

    public static void print(String msg){
        System.out.print(msg);
    }
}
