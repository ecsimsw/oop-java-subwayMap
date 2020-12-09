package subway;

import subway.controller.StationController;
import subway.domain.Name;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        OutputView.printStationList(StationRepository.stations());

        StationController stationController = new StationController(scanner);
        stationController.addNewStation();

        OutputView.printStationList(StationRepository.stations());
    }
}
