package subway.view;

import subway.domain.*;
import subway.validator.LineValidator;

import java.util.Scanner;

public class LineView {
    private final Scanner scanner;

    public LineView(Scanner scanner){
        this.scanner = scanner;
    }

    public Name getNewLineName(){
        try{
            OutputView.printMsg("## 등록할 노선 이름 입력\n");
            Name name = InputView.getName(scanner);
            LineValidator.checkDuplicatedName(name);
            return name;
        }catch (Exception e){
            OutputView.printError(e);
            return getNewLineName();
        }
    }

    public Station getFirstStation(){
        OutputView.printMsg("## 등록할 노선의 상행 종점역 이름을 입력하세요.\n");
        try{
            return InputView.getStation(scanner);
        }catch (Exception e){
            OutputView.printError(e);
            return getFirstStation();
        }
    }

    public Station getLastStation(Station firstStation){
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
        OutputView.printMsg("## 삭제할 노선 이름 입력\n");
        LineRepository.deleteLine(InputView.getLine(scanner));
    }

    public Line getLine(){
        OutputView.printMsg("## 노선 이름 입력\n");
        return InputView.getLine(scanner);
    }

    public void getStationNotInLine(){


        OutputView.printMsg("## 역 이름 입력\n");
        Station station = InputView.getStation(scanner);

        OutputView.printMsg("## 순서를 입력하세요.\n");
        Order order = InputView.getOrder(scanner, line);
    }
}
