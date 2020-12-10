package subway.Repository;

import subway.domain.Name;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    static {
        stations.add(new Station(new Name("교대역")));
        stations.add(new Station(new Name("강남역")));
        stations.add(new Station(new Name("역삼역")));
        stations.add(new Station(new Name("남부터미널역")));
        stations.add(new Station(new Name("양재역")));
        stations.add(new Station(new Name("양재시민의숲역")));
        stations.add(new Station(new Name("매봉역")));
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("이미 존재하는 역 입니다.");
        }
        stations.add(station);
    }

    public static void deleteStation(Station station) {
        if (!stations.contains(station)) {
            throw new IllegalArgumentException("삭제할 역이 존재하지 않습니다.");
        }
        stations.remove(station);
    }

    public static Station getByName(Name name) {
        return stations.stream()
                .filter(station -> station.isName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 역 입니다."));
    }

    public static boolean isExistName(Name name) {
        return stations.stream()
                .anyMatch(station -> station.isName(name));
    }
}