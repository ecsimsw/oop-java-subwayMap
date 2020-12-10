package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.Out;

import java.util.Scanner;

public class LineController {
    private final Scanner scanner;

    public LineController(Scanner scanner){
        this.scanner = scanner;
    }

    public void addLine(){
        Out.print("## 등록할 노선 이름을 입력하세요.");
        String name = scanner.nextLine();
        Out.print("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String first = scanner.nextLine();
        Out.print("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        String last = scanner.nextLine();

        Station firstStation = StationRepository.getByName(first);
        Station lastStation = StationRepository.getByName(last);

        LineRepository.addLine(new Line(name, firstStation, lastStation));
        Out.printInfo("지하철 노선이 등록되었습니다. \n");
    }

}

