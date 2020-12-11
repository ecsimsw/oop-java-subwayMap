package subway.controller;

import subway.Repository.LineRepository;
import subway.domain.*;
import subway.view.LineView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineController {
    private final LineView lineView;

    public LineController(Scanner scanner) {
        lineView = new LineView(scanner);
    }

    public void runLineMenu() {
        nextPage(lineView.selectLineMenu());
    }

    private void nextPage(String input) {
        if (input.equals("1")) {
            addLine();
        }

        if (input.equals("2")) {
            deleteLine();
        }

        if (input.equals("3")) {
            printLines();
        }

        if (input.equals("B")) {
            return;
        }
    }

    private void addLine() {
        try {
            Name name = lineView.getLineNameToAdd();
            Station firstStation = lineView.getFirstStation();
            Station lastStation = lineView.getLastStation(firstStation);

            LineRepository.addLine(new Line(name, firstStation, lastStation));
            lineView.printAddSuccessMessage();
        } catch (Exception e) {
            OutputView.printError(e);
            addLine();
        }
    }

    private void deleteLine() {
        try {
            Name name = lineView.getLineNameToDelete();
            LineRepository.deleteByName(name);
            lineView.printDeleteSuccessMessage();
        } catch (Exception e) {
            OutputView.printError(e);
            deleteLine();
        }
    }

    private void printLines() {
        lineView.printLines(LineRepository.lines());
    }
}

