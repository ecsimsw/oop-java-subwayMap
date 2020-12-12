package subway.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private static final int MINIMUM_NUMBER_OF_STATION = 2;

    private List<Station> stations;
    private Name name;

    private Line(Name name, Station first, Station last) {
        stations = new LinkedList<>();

        if (first.equals(last)) {
            throw new IllegalArgumentException("등록할 노선의 상행 종점역과 하행 종점역이 같을 수 없습니다.");
        }

        stations.add(first);
        first.registeredOnLine();

        stations.add(last);
        last.registeredOnLine();

        this.name = name;
    }

    public static Line create(Name name, Station first, Station last) {
        return new Line(name, first, last);
    }

    public Name getName() {
        return name;
    }

    public boolean isName(Name name) {
        return this.name.equals(name);
    }

    public void addStation(int index, Station station) {
        if (index < 1) {
            throw new IllegalArgumentException("순서는 1이상의 숫자여야 합니다.");
        }
        stations.add(index, station);
        station.registeredOnLine();
    }

    public void removeAllIncludeStations() {
        stations.forEach(station -> removeStationFromLine(station));
    }

    public void removeStationFromLine(Station station) {
        if (stations.size() <= MINIMUM_NUMBER_OF_STATION) {
            throw new IllegalArgumentException("노선의 최소 전철역 개수를 충족하지 않습니다.");
        }

        if (!stations.contains(station)) {
            throw new IllegalArgumentException("해당 노선은 입력한 전철역을 포함하고 있지 않습니다.");
        }

        stations.remove(station);
        station.removedFromLine();
    }

    public List<String> getStationNames() {
        return stations.stream()
                .map(station -> station.toString())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return name.getValue();
    }
}
