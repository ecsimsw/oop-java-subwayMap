package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.PageRepository;

import java.util.Scanner;

public class SectionController {
    private final Scanner scanner;

    public SectionController(Scanner scanner){
        this.scanner = scanner;
    }

    public void printSectionMenu(){
        OutputView.print(PageRepository.sectionPage);
        String input = InputView.getSelect(scanner);
        nextPage(input);
    }

    private void nextPage(String input){
        if(input.equals("1")){
            addSection();
        }

        if(input.equals("2")){
            removeSection();
        }

        if(input.equals("B")){
            return;
        }
    }

    public void addSection(){
        OutputView.print("## 노선을 입력하세요. \n");
        Line line = LineRepository.getByName(scanner.nextLine());
        OutputView.print("## 역 이름을 입력하세요. \n");
        Station station = StationRepository.getByName(scanner.nextLine());
        OutputView.print("## 순서을 입력하세요. \n");
        int order = Integer.parseInt(scanner.nextLine());
        line.addSection(order, station);
        OutputView.printInfo("구간이 등록되었습니다.\n");
    }

    public void removeSection(){
        OutputView.print("## 삭제할 구간의 노선을 입력하세요. \n");
        Line line = LineRepository.getByName(scanner.nextLine());
        OutputView.print("## 삭제할 구간의 역을 입력하세요. \n");
        Station station = StationRepository.getByName(scanner.nextLine());
        line.removeSection(station);
        OutputView.printInfo("구간이 삭제되었습니다.\n");
    }
}
