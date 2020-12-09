package subway.domain;

import subway.validator.LineValidator;

import java.util.LinkedList;

public class Line {
    private final Name name;
    private final Station first;
    private final Station last;
    private final LinkedList<Station> stations = new LinkedList<>();

    public Line(Name name, Station first, Station last){
        LineValidator.checkDuplicatedName(name);
        LineValidator.checkValidTerminal(first, last);

        this.name = name;
        this.first = first;
        this.last = last;

        stations.addFirst(first);
        stations.addLast(last);

        first.inLine();
        last.inLine();
    }

    public LinkedList<Station> getStations(){
        return stations;
    }

    public boolean isName(Name name){
        return name.isSame(name);
    }

    public Name getName() {
        return name;
    }

    public boolean isEquals(Line line){
        return name.isSame(line.name);
    }

    public void addStation(int index, Station station){
        stations.add(index, station);
        station.inLine();
    }
}
