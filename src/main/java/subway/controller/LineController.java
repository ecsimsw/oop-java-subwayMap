package subway.controller;

import subway.domain.*;
import subway.validator.LineValidator;
import subway.validator.StationValidator;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineController {
    private final Scanner scanner;

    public LineController(Scanner scanner){
        this.scanner = scanner;
    }

    public void addNewLine(){
        Name newLineName = getNewLineName();
        Station firstStation = getFirstStation();
        Station lastStation = getLastStation(firstStation);

        Line newLine = new Line(newLineName, firstStation, lastStation);
        LineRepository.addLine(newLine);
    }

    private Name getNewLineName(){
        try{
            OutputView.printMsg("## 등록할 라인 이름 입력\n");
            Name name = InputView.getName(scanner);
            LineValidator.checkDuplicatedName(name);
            return name;
        }catch (Exception e){
            OutputView.printError(e);
            return getNewLineName();
        }
    }

    private Station getFirstStation(){
        OutputView.printMsg("## 등록할 노선의 상행 종점역 이름을 입력하세요.\n");
        try{
            return getStation();
        }catch (Exception e){
            OutputView.printError(e);
            return getFirstStation();
        }
    }

    private Station getLastStation(Station firstStation){
        OutputView.printMsg("## 등록할 노선의 하행 종점역 이름을 입력하세요.\n");
        try{
            Station lastStation = getStation();
            LineValidator.checkValidTerminal(firstStation, lastStation);
            return lastStation;
        }catch (Exception e){
            OutputView.printError(e);
            return getLastStation(firstStation);
        }
    }

    private Station getStation(){
        return StationRepository.getStationByName(InputView.getName(scanner));
    }
}
