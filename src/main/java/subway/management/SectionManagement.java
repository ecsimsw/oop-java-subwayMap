package subway.management;

import subway.controller.SectionController;
import subway.domain.button.SectionMenuButton;

import java.util.Scanner;

public class SectionManagement implements IManagement {
    private final SectionController sectionController;

    public SectionManagement(Scanner scanner) {
        sectionController = new SectionController(scanner);
    }

    @Override
    public void run() {
        sectionController.printMenu();
        SectionMenuButton input = sectionController.getSelection();
        sectionController.serviceSelection(input);
    }
}
