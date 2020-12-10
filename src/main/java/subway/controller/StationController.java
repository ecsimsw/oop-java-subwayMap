package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.PageRepository;

import java.util.Scanner;

public class StationController {
    private final Scanner scanner;

    public StationController(Scanner scanner){
        this.scanner = scanner;
    }

    public void printStationMenu(){
        OutputView.print(PageRepository.stationPage);
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
        OutputView.print("## 등록할 역 이름을 입력하세요.\n");
        try{
            Station station = new Station(InputView.getName(scanner));
            StationRepository.addStation(station);
            OutputView.printInfo("지하철 역이 등록되었습니다.\n");
        }catch (Exception e){
            OutputView.printError(e);
            addStation();
        }
    }

    public void deleteStation(){
        OutputView.print("## 삭제할 역 이름을 입력하세요.\n");
        try{
            Station station = new Station(InputView.getName(scanner));
            StationRepository.deleteStation(station);
            OutputView.printInfo("지하철 역이 삭제되었습니다.\n");
        }catch (Exception e){
            OutputView.printError(e);
        }
    }

    public void printStation(){
        OutputView.print("## 역 목록\n");
        OutputView.printStationList(StationRepository.stations());
        OutputView.print("\n");
    }
}
