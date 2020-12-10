package subway.domain;

public class Station {
    private Name name;
    private int inLineCount = 0;

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
        return inLineCount>0;
    }

    public void inLine(){
        inLineCount++;
    }

    public void outLine(){
        if(inLineCount < 1){
            throw new IllegalArgumentException("inLineCount를 더 이상 줄일 수 없습니다.");
        }

        inLineCount--;
    }
}
