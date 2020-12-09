package subway.domain;

import subway.validator.StationValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
                .orElseThrow(()-> new IllegalArgumentException("역이 존재하지 않습니다."));
    }

    public static void addStation(Station station) {
        StationValidator.checkDuplicated(station);

        stations.add(station);
    }

    public static void deleteStation(Station station) {
        StationValidator.checkIfNonExistentStation(station);
        StationValidator.checkStationInLine(station);

        stations.remove(station);
    }

    public static boolean isExist(Station searchStation){
        return stations.stream()
                .anyMatch(station -> station.isEquals(searchStation));
    }

    public static boolean isExistName(Name name){
        return stations.stream()
                .anyMatch(station -> station.isName(name));
    }
}
