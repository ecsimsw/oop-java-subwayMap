package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.PageRepository;

import java.util.Scanner;

public class LineController {
    private final Scanner scanner;

    public LineController(Scanner scanner){
        this.scanner = scanner;
    }

    public void printLineMenu(){
        OutputView.print(PageRepository.linePage);
        String input = InputView.getSelect(scanner);
        nextPage(input);
    }

    private void nextPage(String input){
        if(input.equals("1")){
            addLine();
        }

        if(input.equals("2")){
            deleteLine();
        }

        if(input.equals("3")){
            printLines();
        }

        if(input.equals("B")){
            return;
        }
    }

    public void addLine(){
        Name name = getLineNameToAdd();
        Station firstStation = getFirstStation();
        Station lastStation = getLastStation(firstStation);

        LineRepository.addLine(new Line(name, firstStation, lastStation));
        OutputView.printInfo("지하철 노선이 등록되었습니다. \n");
    }

    private Name getLineNameToAdd(){
        OutputView.print("## 등록할 노선 이름을 입력하세요.\n");
        try{
            Name name = InputView.getName(scanner);
            InputValidator.checkNonExistLineName(name);
            return name;
        }catch (Exception e){
            OutputView.printError(e);
            getLineNameToAdd();
            return getLineNameToAdd();
        }
    }

    private Station getFirstStation(){
        OutputView.print("## 등록할 노선의 상행 종점역 이름을 입력하세요.\n");
        try{
            return StationRepository.getByName(InputView.getName(scanner));
        }catch (Exception e){
            OutputView.printError(e);
            return getFirstStation();
        }
    }

    private Station getLastStation(Station firstStation){
        OutputView.print("## 등록할 노선의 하행 종점역 이름을 입력하세요.\n");
        try{
            Station lastStation = StationRepository.getByName(InputView.getName(scanner));
            InputValidator.checkDuplicatedTerminal(firstStation, lastStation);
            return lastStation;
        }catch (Exception e){
            OutputView.printError(e);
            return getLastStation(firstStation);
        }
    }


    public void deleteLine(){
        OutputView.print("## 삭제할 노선 이름을 입력하세요.\n");
        try{
            LineRepository.deleteByName(InputView.getName(scanner));
            OutputView.printInfo("지하철 노선이 삭제되었습니다. \n");
        }catch (Exception e){
            OutputView.printError(e);
            deleteLine();
        }
    }

    public void printLines(){
        OutputView.print("## 노션 목록\n");
        LineRepository.lines()
                .stream()
                .map(Line::getName)
                .forEach(name -> OutputView.printInfo(name+"\n"));
    }
}

