package subway.domain;

import java.util.LinkedList;

public class Line {
    private final Name name;
    private final Station first;
    private final Station last;
    private final LinkedList<Station> stations = new LinkedList<>();

    public Line(Name name, Station first, Station last){
        this.name = name;
        this.first = first;
        this.last = last;
    }

    public Name getName() {
        return name;
    }

    public void addStation(int index, Station station){
        stations.add(index, station);
    }
}