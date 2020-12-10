package subway.domain;

import java.util.LinkedList;
import java.util.List;

public class Line {
    private String name;
    private LinkedList<Station> stations;

    public Line(String name, Station first, Station last) {
        this.name = name;

        stations.add(0,first);
        stations.add(stations.size(),last);
    }

    public Line(String name, Station... args) {
        this.name = name;

        if(args.length <2){
            throw new IllegalArgumentException("노선은 종착역과 종점역을 포함해야 합니다.");
        }

        for(Station station : args){
            stations.addLast(station);
        }
    }

    public String getName() {
        return name;
    }

    public void addSection(int index, Station station){
        if(stations.size() < index){
            throw new IllegalArgumentException("잘못된 순서입니다.");
        }

        if(stations.contains(station)){
            throw new IllegalArgumentException("이미 포함된 역입니다.");
        }

        stations.add(index, station);
    }
}