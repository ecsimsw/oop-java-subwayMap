package subway.view;

import org.junit.jupiter.api.Test;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void printStationList() {
        List<Station> stations = StationRepository.stations();
        OutputView.printStationList(stations);
    }
}