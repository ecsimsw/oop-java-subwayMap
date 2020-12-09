package subway.domain;

public class Station {
    private Name name;
    private boolean inLine = false;

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

    public boolean isInLine(){
        return inLine;
    }

    public void inLine(){
        inLine = true;
    }
}
