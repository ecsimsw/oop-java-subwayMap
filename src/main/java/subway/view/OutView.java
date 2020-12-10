package subway.view;

import subway.domain.Station;

import java.util.List;

public class OutView {
    private static final String INFO_MESSAGE = "[INFO] %s\n";

    private OutView(){}

    public static void printInfo(String msg){
        printf(INFO_MESSAGE, msg);
    }

    public static void printStationList(List<Station> stations){
        for(Station station : stations){
            OutView.printf(INFO_MESSAGE, station.getName());
        }
    }

    public static void printf(String msg, Object... args){
        System.out.printf(msg, args);
    }

    public static void print(String msg){
        System.out.print(msg);
    }
}
