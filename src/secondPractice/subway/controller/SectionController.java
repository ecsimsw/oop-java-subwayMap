package subway.controller;

import subway.domain.*;
import subway.domain.button.SectionMenuButton;
import subway.view.OutputView;
import subway.view.SectionView;

import java.util.Scanner;

public class SectionController {
    private final SectionView sectionView;

    public SectionController(Scanner scanner) {
        sectionView = new SectionView(scanner);
    }

    public void addSection() {
        try {
            Line line = getLineOfSection();
            Station station = getStationToAddSection();
            line.addStation(getOrder(), station);
            sectionView.printRegistrationSuccess();
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
        }
    }

    private Line getLineOfSection() {
        try {
            Name lineName = sectionView.getLineNameToAddSection();
            return LineRepository.getLineByName(lineName);
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
            return getLineOfSection();
        }
    }

    private Station getStationToAddSection() {
        try {
            Name stationName = sectionView.getStationNameToAddSection();
            return StationRepository.getStationByName(stationName);
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
            return getStationToAddSection();
        }
    }

    private int getOrder() {
        return sectionView.getOrder();
    }

    public void deleteSection() {
        try {
            Line line = getLineOfSectionToDelete();
            Station station = getStationOfSection();
            line.removeStationFromLine(station);
            sectionView.printDeletionSuccess();
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
        }
    }

    private Line getLineOfSectionToDelete() {
        Name name = sectionView.getLineNameToDelete();
        return LineRepository.getLineByName(name);
    }

    private Station getStationOfSection() {
        Name name = sectionView.getStationNameToDelete();
        return StationRepository.getStationByName(name);
    }

    public void printMenu() {
        sectionView.printMenu();
    }

    public SectionMenuButton getSelection() {
        return sectionView.getUserSelection();
    }

    public void serviceSelection(SectionMenuButton input) {
        if (input.equals(SectionMenuButton.AddSection)) {
            addSection();
        }

        if (input.equals(SectionMenuButton.DeleteSection)) {
            deleteSection();
        }
    }
}
