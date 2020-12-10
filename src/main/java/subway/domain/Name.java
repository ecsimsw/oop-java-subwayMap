package subway.domain;

public class Name {
    private final String name;

    public Name(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("적절하지 않은 길이의 이름입니다.");
        }
        this.name = name;
    }

    public boolean equals(Name otherName) {
        return this.name.equals(otherName.name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
