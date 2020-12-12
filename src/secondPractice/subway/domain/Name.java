package subway.domain;

public class Name {
    private String value;

    public Name(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("이름은 2글자 이상이어야 합니다.");
        }
        this.value = name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Name) {
            return value.equals(((Name) o).value);
        }
        return false;
    }
}
