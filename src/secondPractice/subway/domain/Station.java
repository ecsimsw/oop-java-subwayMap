package subway.domain;

public class Station {
    private Name name;
    private int registeredCount;

    public Station(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public boolean isOnLine() {
        return registeredCount > 0;
    }

    public boolean isName(Name name) {
        return this.name.equals(name);
    }

    public void registeredOnLine() {
        registeredCount++;
    }

    public void removedFromLine() {
        if (registeredCount <= 0) {
            throw new IllegalArgumentException("삭제될 수 없는 역입니다.");
        }

        registeredCount--;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Station) {
            return ((Station) o).name.equals(this.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return name.getValue();
    }
}
