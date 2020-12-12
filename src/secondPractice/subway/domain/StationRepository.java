package subway.domain;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static void deleteStation(Name name) {
        Station station = getStationByName(name);
        if (station.isOnLine()) {
            throw new IllegalArgumentException("노선에 등록된 역은 삭제할 수 없습니다.");
        }
        stations.remove(station);
    }

    public static Station getStationByName(Name name) {
        return stations.stream()
                .filter(station -> station.isName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 역이 존재하지 않습니다."));
    }

    public static boolean isExistName(Name name) {
        return stations.stream().anyMatch(station -> station.isName(name));
    }
}
