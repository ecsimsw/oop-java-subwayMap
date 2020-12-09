package subway.domain;

public class Name {
    private static final int MIN_NAME_LEN =2;
    private String value;

    public Name(String value){
        if(value.length() <MIN_NAME_LEN){
            throw new IllegalArgumentException("잘못된 길이의 이름입니다.");
        }

        this.value = value;
    }

    public boolean isSame(Name name){
        return this.value == name.value;
    }

    @Override
    public String toString(){
        return value;
    }
}
