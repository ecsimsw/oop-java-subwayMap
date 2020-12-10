package subway.controller;

import subway.domain.*;
import subway.validator.LineValidator;
import subway.validator.StationValidator;
import subway.view.InputView;
import subway.view.LineView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineController {
    private final Scanner scanner;
    private final LineView lineView;

    public LineController(Scanner scanner) {
        this.scanner = scanner;
        this.lineView = new LineView(scanner);
    }

    public void addNewLine(Scanner scanner){
        Name name = lineView.getNewLineName();
        Station first = lineView.getFirstStation();
        Station last = lineView.getLastStation(first);

        Line newLine = new Line(name, first, last);
        LineRepository.addLine(newLine);
    }

    public void addStationInLine(){

        // 이미 포함된 역인지 확인




        line.addStation(order.getOrder(), station);
    }

    public void removeStationInLine(){
        OutputView.printMsg("## 노선 이름 입력\n");
        Line line = InputView.getLine(scanner);

        OutputView.printMsg("## 역 이름 입력\n");
        Station station = getStationInLine(line);

        line.removeStation(station);

        OutputView.printMsg("## 구간이 삭제되었습니다.\n");
    }

    private Station getStationInLine(Line line){
        try{
            Station station = InputView.getStation(scanner);
            LineValidator.checkStationInLine(station, line);
            return station;
        }catch (Exception e){
            OutputView.printError(e);
            return getStationInLine(line);
        }
    }
}
