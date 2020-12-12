package subway.controller;

import subway.domain.*;
import subway.domain.button.LineMenuButton;
import subway.domain.validator.LineValidator;
import subway.view.LineView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class LineController {
    private final LineView lineView;

    public LineController(Scanner scanner) {
        lineView = new LineView(scanner);
    }

    public void addLine() {
        try {
            Name newLineName = getNonExistLineName();
            Station firstStation = getFirstStation();
            Station lastStation = getLastStation();

            LineRepository.addLine(Line.create(newLineName, firstStation, lastStation));
            lineView.printRegistrationSuccess();
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
        }
    }

    private Name getNonExistLineName() {
        try {
            Name name = lineView.getLineNameToAdd();
            LineValidator.checkNonExistName(name);
            return name;
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
            return getNonExistLineName();
        }
    }

    private Station getFirstStation() {
        try {
            Name firstStationName = lineView.getFirstStationName();
            return StationRepository.getStationByName(firstStationName);
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
            return getFirstStation();
        }
    }

    private Station getLastStation() {
        try {
            Name lastStationName = lineView.getLastStationName();
            return StationRepository.getStationByName(lastStationName);
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
            return getLastStation();
        }
    }

    public void deleteLine() {
        try {
            LineRepository.deleteLineByName(lineView.getLineNameToDelete());
            lineView.printDeletionSuccess();
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
            deleteLine();
        }
    }

    public void printLineList() {
        OutputView.print("## 노선 목록\n");
        List<Line> lines = LineRepository.lines();
        lines.stream().forEach(line -> OutputView.printInfo(line.toString()));
        OutputView.print("\n");
    }

    public void printSubwayMap() {
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            OutputView.printInfo(line.toString());
            OutputView.printInfo("---");
            line.getStationNames().stream().forEach(name -> OutputView.printInfo(name));
            OutputView.print("\n");
        }
    }

    public void printMenu() {
        lineView.printMenu();
    }

    public LineMenuButton getSelection() {
        return lineView.getUserSelection();
    }

    public void serviceSelection(LineMenuButton input) {
        if (input.equals(LineMenuButton.AddLine)) {
            addLine();
        }

        if (input.equals(LineMenuButton.DeleteLine)) {
            deleteLine();
        }

        if (input.equals(LineMenuButton.PrintLineList)) {
            printLineList();
        }
    }
}
