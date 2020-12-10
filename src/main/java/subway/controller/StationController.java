package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.In;
import subway.view.Out;
import subway.view.PageRepository;

import java.util.Scanner;

public class StationController {
    private final Scanner scanner;

    public StationController(Scanner scanner){
        this.scanner = scanner;
    }

    public void printStationMenu(){
        Out.print(PageRepository.stationPage);
        String input = In.getSelect(scanner);
        nextPage(input);
    }

    private void nextPage(String input){
        if(input.equals("1")){
            addStation();
        }

        if(input.equals("2")){
            deleteStation();
        }

        if(input.equals("3")){
            deleteStation();
        }

        if(input.equals("B")){
            return;
        }
    }

    public void addStation(){
        Out.print("## 등록할 역 이름을 입력하세요.\n");
        Station station = new Station(scanner.nextLine());
        StationRepository.addStation(station);
        Out.printInfo("지하철 역이 등록되었습니다.\n");
    }

    public void deleteStation(){
        Out.print("## 삭제할 역 이름을 입력하세요.\n");
        Station station = new Station(scanner.nextLine());
        StationRepository.deleteStation(station);
        Out.printInfo("지하철 역이 삭제되었습니다.\n");
    }

    public void printStation(){
        Out.print("## 역 목록\n");
        Out.printStationList(StationRepository.stations());
        Out.print("\n");
    }
}
