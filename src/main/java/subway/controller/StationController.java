package subway.controller;

import subway.domain.Station;
import subway.Repository.StationRepository;
import subway.view.StationView;

import java.util.Scanner;

public class StationController {
    private final StationView stationView;

    public StationController(Scanner scanner) {
        stationView = new StationView(scanner);
    }

    public void printStationMenu() {
        nextPage(stationView.selectStationMenu());
    }

    private void nextPage(String input) {
        if (input.equals("1")) {
            addStation();
        }

        if (input.equals("2")) {
            deleteStation();
        }

        if (input.equals("3")) {
            printStation();
        }

        if (input.equals("B")) {
            return;
        }
    }

    public void addStation() {
        Station station = new Station(stationView.getStationNameToAdd());
        StationRepository.addStation(station);
        stationView.printAddSuccessMessage();
    }

    public void deleteStation() {
        StationRepository.deleteStation(stationView.getStationToDelete());
        stationView.printDeleteSuccessMessage();
    }

    public void printStation() {
        stationView.printStation(StationRepository.stations());
    }
}
