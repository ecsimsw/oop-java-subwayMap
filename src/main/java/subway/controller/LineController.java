package subway.controller;

import subway.domain.*;
import subway.validator.LineValidator;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineController {
    private final Scanner scanner;

    public LineController(Scanner scanner){
        this.scanner = scanner;
    }

    public void addNewLine(){
        Name name = getNewLineName();
        Station first = getFirstStation();
        Station last = getLastStation(first);

        Line newLine = new Line(name, first, last);
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
            return InputView.getStation(scanner);
        }catch (Exception e){
            OutputView.printError(e);
            return getFirstStation();
        }
    }

    private Station getLastStation(Station firstStation){
        OutputView.printMsg("## 등록할 노선의 하행 종점역 이름을 입력하세요.\n");
        try{
            Station lastStation = InputView.getStation(scanner);
            LineValidator.checkValidTerminal(firstStation, lastStation);
            return lastStation;
        }catch (Exception e){
            OutputView.printError(e);
            return getLastStation(firstStation);
        }
    }

    public void deleteLine(){
        OutputView.printMsg("## 삭제할 라인 이름 입력\n");
        LineRepository.deleteLine(InputView.getLine(scanner));
    }
}