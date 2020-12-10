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
        OutputView.print("## 등록할 노선 이름을 입력하세요.\n");
        Name name = InputView.getName(scanner);
        OutputView.print("## 등록할 노선의 상행 종점역 이름을 입력하세요.\n");
        Name firstStationName = InputView.getName(scanner);
        OutputView.print("## 등록할 노선의 하행 종점역 이름을 입력하세요.\n");
        Name lastStationName = InputView.getName(scanner);

        Station firstStation = StationRepository.getByName(firstStationName);
        Station lastStation = StationRepository.getByName(lastStationName);

        LineRepository.addLine(new Line(name, firstStation, lastStation));
        OutputView.printInfo("지하철 노선이 등록되었습니다. \n");
    }

    public void deleteLine(){
        OutputView.print("## 삭제할 노선 이름을 입력하세요.\n");
        LineRepository.deleteByName(InputView.getName(scanner));
        OutputView.printInfo("지하철 노선이 삭제되었습니다. \n");
    }

    public void printLines(){
        OutputView.print("## 노션 목록\n");
        LineRepository.lines()
                .stream()
                .map(Line::getName)
                .forEach(name -> OutputView.printInfo(name+"\n"));
    }
}

