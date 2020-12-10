package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.Out;

import java.util.Scanner;

public class SectionController {
    private final Scanner scanner;

    public SectionController(Scanner scanner){
        this.scanner = scanner;
    }

    public void addSection(){
        Out.print("## 노선을 입력하세요. \n");
        Line line = LineRepository.getByName(scanner.nextLine());
        Out.print("## 역 이름을 입력하세요. \n");
        Station station = StationRepository.getByName(scanner.nextLine());
        Out.print("## 순서을 입력하세요. \n");
        int order = Integer.parseInt(scanner.nextLine());
        line.addSection(order, station);
        Out.printInfo("구간이 등록되었습니다.\n");
    }

    public void removeSection(){
        Out.print("## 삭제할 구간의 노선을 입력하세요. \n");
        Line line = LineRepository.getByName(scanner.nextLine());
        Out.print("## 삭제할 구간의 역을 입력하세요. \n");
        Station station = StationRepository.getByName(scanner.nextLine());
        line.removeSection(station);
        Out.printInfo("구간이 삭제되었습니다.\n");
    }
}
