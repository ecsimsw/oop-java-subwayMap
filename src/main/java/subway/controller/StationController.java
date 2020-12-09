package subway.controller;

import subway.domain.Name;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class StationController {
    private final Scanner scanner;

    public StationController(Scanner scanner){
        this.scanner = scanner;
    }

    public void addNewStation(){
        try{
            OutputView.printMsg("## 등록할 역 이름 입력\n");
            Name stationName = InputView.getName(scanner);
            StationRepository.addStation(new Station(stationName));
        }catch (Exception e){
            OutputView.printError(e);
        }
    }
}
