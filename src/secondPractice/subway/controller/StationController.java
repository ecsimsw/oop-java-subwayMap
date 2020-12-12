package subway.controller;

import subway.domain.Name;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.button.StationMenuButton;
import subway.domain.validator.StationValidator;
import subway.view.OutputView;
import subway.view.StationView;

import java.util.Scanner;

public class StationController {
    private final StationView stationView;

    public StationController(Scanner scanner) {
        stationView = new StationView(scanner);
    }

    public void addStation() {
        try {
            Station newStation = getNonExistentStation();
            StationRepository.addStation(newStation);
            stationView.printRegistrationSuccess();
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
        }
    }

    private Station getNonExistentStation() {
        try {
            Name name = stationView.getStationNameToAdd();
            StationValidator.checkNonExistentName(name);
            return new Station(name);
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
            return getNonExistentStation();
        }
    }

    public void deleteStation() {
        try {
            Name existingStationName = getExistingStationName();
            StationRepository.deleteStation(existingStationName);
            stationView.printDeletionSuccess();
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
        }
    }

    private Name getExistingStationName() {
        try {
            Name name = stationView.getStationNameToDelete();
            StationValidator.checkExistingName(name);
            return name;
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
            return getExistingStationName();
        }
    }

    public void printStations() {
        StationRepository.stations().stream()
                .forEach(station -> OutputView.printInfo(station.toString()));
    }

    public void printMenu() {
        stationView.printMenu();
    }

    public StationMenuButton getSelection() {
        return stationView.getUserSelection();
    }

    public void serviceSelection(StationMenuButton input) {
        if (input.equals(StationMenuButton.AddStation)) {
            addStation();
        }

        if (input.equals(StationMenuButton.DeleteStation)) {
            deleteStation();
        }

        if (input.equals(StationMenuButton.PrintStation)) {
            printStations();
        }
    }
}
