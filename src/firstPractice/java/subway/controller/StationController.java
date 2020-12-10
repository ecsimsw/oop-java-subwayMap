package subway.controller;

import subway.domain.Name;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.validator.StationValidator;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class StationController {

    public static void addNewStation(Scanner scanner){
        try{
            OutputView.printMsg("## 등록할 역 이름 입력\n");
            Station station = new Station(InputView.getName(scanner));
            StationRepository.addStation(station);
        }catch (Exception e){
            OutputView.printError(e);
        }
    }

    public static void deleteStation(Scanner scanner){
        try{
            OutputView.printMsg("## 삭제할 역 이름 입력\n");
            Station station = new Station(InputView.getName(scanner));
            StationRepository.deleteStation(station);
        }catch (Exception e){
            OutputView.printError(e);
        }
    }

    public static void printStations(){
        OutputView.printStationList(StationRepository.stations());
    }
}
