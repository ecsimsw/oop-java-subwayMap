package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    static{
        stations.add(new Station("교대역"));
        stations.add(new Station("강남역"));
        stations.add(new Station("역삼역"));
        stations.add(new Station("남부터미널역"));
        stations.add(new Station("양재역"));
        stations.add(new Station("양재시민의숲역"));
        stations.add(new Station("매봉역"));
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if(stations.contains(station)){
            throw new IllegalArgumentException("이미 존재하는 역 입니다.");
        }
        stations.add(station);
    }

    public static void deleteStation(Station station) {
        if(!stations.contains(station)){
            throw new IllegalArgumentException("삭제할 역이 존재하지 않습니다.");
        }
        stations.remove(station);
    }

    public static Station getByName(String name){
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 역 입니다."));
    }
}