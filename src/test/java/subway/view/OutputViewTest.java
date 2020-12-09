package subway.view;

import org.junit.jupiter.api.Test;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

class OutputViewTest {

    @Test
    void printStationList() {
        List<Station> stations = StationRepository.stations();
        OutputView.printStationList(stations);
    }

    @Test
    void printMap() {
        OutputView.printMap(LineRepository.lines());
    }
}