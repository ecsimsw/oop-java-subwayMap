package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutView;
import subway.view.PageRepository;

import java.util.Scanner;

public class StationController {
    private final Scanner scanner;

    public StationController(Scanner scanner){
        this.scanner = scanner;
    }

    public void printStationMenu(){
        OutView.print(PageRepository.stationPage);
        String input = InputView.getSelect(scanner);
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
            printStation();
        }

        if(input.equals("B")){
            return;
        }
    }

    public void addStation(){
        OutView.print("## 등록할 역 이름을 입력하세요.\n");
        Station station = new Station(scanner.nextLine());
        StationRepository.addStation(station);
        OutView.printInfo("지하철 역이 등록되었습니다.\n");
    }

    public void deleteStation(){
        OutView.print("## 삭제할 역 이름을 입력하세요.\n");
        Station station = new Station(scanner.nextLine());
        StationRepository.deleteStation(station);
        OutView.printInfo("지하철 역이 삭제되었습니다.\n");
    }

    public void printStation(){
        OutView.print("## 역 목록\n");
        OutView.printStationList(StationRepository.stations());
        OutView.print("\n");
    }
}
