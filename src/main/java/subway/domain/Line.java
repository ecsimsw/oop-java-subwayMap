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

    public void removeSection(Station station){
        if(!stations.contains(station)){
            throw new IllegalArgumentException("노선에 존재하는 역이 아닙니다.");
        }

        if(stations.size() <= 2){
            throw new IllegalArgumentException("노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없습니다.");
        }

        stations.remove(station);
    }
}