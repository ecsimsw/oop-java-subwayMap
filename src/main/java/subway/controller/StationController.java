package subway.controller;

import subway.domain.Name;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.validator.StationValidator;
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
            Station station = new Station(InputView.getName(scanner));

            StationValidator.checkDuplicated(station);

            StationRepository.addStation(station);
        }catch (Exception e){
            OutputView.printError(e);
        }
    }

    public void deleteStation(){
        try{
            OutputView.printMsg("## 삭제할 역 이름 입력\n");
            Station station = new Station(InputView.getName(scanner));

            StationValidator.checkIfNonExistentStation(station);
            StationValidator.checkInLineStation(station);

            StationRepository.deleteStation(station);
        }catch (Exception e){
            OutputView.printError(e);
        }
    }
}
