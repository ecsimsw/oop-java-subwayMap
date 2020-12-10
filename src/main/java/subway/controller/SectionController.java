package subway.controller;

import subway.domain.Line;
import subway.Repository.LineRepository;
import subway.domain.Station;
import subway.view.SectionView;

import java.util.Scanner;

public class SectionController {
    private final SectionView sectionView;

    public SectionController(Scanner scanner) {
        sectionView = new SectionView(scanner);
    }

    public void printSectionMenu() {
        nextPage(sectionView.selectSectionMenu());
    }

    private void nextPage(String input) {
        if (input.equals("1")) {
            addSection();
        }

        if (input.equals("2")) {
            removeSection();
        }

        if (input.equals("B")) {
            return;
        }
    }

    public void addSection() {
        Line line = LineRepository.getByName(sectionView.getExistLineName());
        Station station = sectionView.getStationToAddSection(line);
        line.addSection(sectionView.getOrder(line), station);
        sectionView.printSuccessAddMessage();
    }

    public void removeSection() {
        Line line = LineRepository.getByName(sectionView.getExistLineName());
        Station station = sectionView.getStationToRemove(line);
        line.removeSection(station);
        sectionView.printSuccessRemoveMessage();
    }
}
