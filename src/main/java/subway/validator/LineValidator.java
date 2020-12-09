package subway.validator;

import subway.domain.LineRepository;
import subway.domain.Name;
import subway.domain.Station;

public class LineValidator {
    private LineValidator(){}

    public static void checkValidTerminal(Station firstStation, Station lastStation){
        if(firstStation.isEquals(lastStation)){
            throw new IllegalArgumentException("상행 종점역과 하행 종점역은 같을 수 없습니다.");
        }
    }

    public static void checkDuplicatedName(Name name){
        if(LineRepository.isExistName(name)){
            throw new IllegalArgumentException("이미 존재하는 노선 이름 입니다.");
        }
    }


}
