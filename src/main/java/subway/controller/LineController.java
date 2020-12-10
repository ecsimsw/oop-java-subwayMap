package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutView;
import subway.view.PageRepository;

import java.util.Scanner;

public class LineController {
    private final Scanner scanner;

    public LineController(Scanner scanner){
        this.scanner = scanner;
    }

    public void printLineMenu(){
        OutView.print(PageRepository.linePage);
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
        OutView.print("## 등록할 노선 이름을 입력하세요.\n");
        String name = scanner.nextLine();
        OutView.print("## 등록할 노선의 상행 종점역 이름을 입력하세요.\n");
        String first = scanner.nextLine();
        OutView.print("## 등록할 노선의 하행 종점역 이름을 입력하세요.\n");
        String last = scanner.nextLine();

        Station firstStation = StationRepository.getByName(first);
        Station lastStation = StationRepository.getByName(last);

        LineRepository.addLine(new Line(name, firstStation, lastStation));
        OutView.printInfo("지하철 노선이 등록되었습니다. \n");
    }

    public void deleteLine(){
        OutView.print("## 삭제할 노선 이름을 입력하세요.\n");
        String name = scanner.nextLine();
        LineRepository.deleteByName(name);
        OutView.printInfo("지하철 노선이 삭제되었습니다. \n");
    }

    public void printLines(){
        OutView.print("## 노션 목록\n");
        LineRepository.lines()
                .stream()
                .map(Line::getName)
                .forEach(name -> OutView.printInfo(name+"\n"));
    }
}

