package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    static{
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

    public static Station getStationByName(Name name){
        return stations.stream()
                .filter(station -> station.isName(name))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("찾는 역이 없습니다."));
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
