package subway.domain;

public class Station {
    private Name name;

    public Station(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public boolean isName(Name name){
        return this.name.isSame(name);
    }

    public boolean isEquals(Station station){
        return name.isSame(station.name);
    }
}
