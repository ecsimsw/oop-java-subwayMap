package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.LineView;
import subway.view.OutputView;
import subway.view.PageRepository;

import java.util.Scanner;

public class LineController {
    private final Scanner scanner;
    private final LineView lineView;

    public LineController(Scanner scanner){
        this.scanner = scanner;
        lineView = new LineView(scanner);
    }

    public void runLineMenu(){
        String input = lineView.selectLineMenu();
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
            lineView.printLines();
        }

        if(input.equals("B")){
            return;
        }
    }

    private void addLine(){
        Name name = lineView.getLineNameToAdd();
        Station firstStation = lineView.getFirstStation();
        Station lastStation = lineView.getLastStation(firstStation);

        LineRepository.addLine(new Line(name, firstStation, lastStation));
        lineView.printAddSuccessMessage();
    }

    private void deleteLine(){
        Name name = lineView.getLineNameToDelete();
        LineRepository.deleteByName(name);
        lineView.printDeleteSuccessMessage();
    }
}

