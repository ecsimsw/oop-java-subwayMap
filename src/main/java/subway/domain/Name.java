package subway.domain;

public class Name {
    private String value;

    public Name(String value){
        if(value.length() <2 || value.length() >5){
            throw new IllegalArgumentException("잘못된 길이의 이름입니다.");
        }

        this.value = value;
    }

    public boolean isSame(Name name){
        return this.value == name.value;
    }
}
