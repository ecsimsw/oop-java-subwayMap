package subway.domain;

public class Name {
    private String name;

    public Name(String name){
        if(name.length() <2 || name.length() >5){
            throw new IllegalArgumentException("잘못된 길이의 이름입니다.");
        }

        this.name = name;
    }
}
