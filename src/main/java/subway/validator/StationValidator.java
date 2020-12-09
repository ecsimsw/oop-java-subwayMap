package subway.validator;

import subway.domain.Name;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationValidator {

    private StationValidator(){}

    public static void checkDuplicated(Station station){
        if(StationRepository.isExist(station)){
            throw new IllegalArgumentException("이미 존재하는 역입니다.");
        }
    }

    public static void checkIfNonExistentStation(Station station){
        if(!StationRepository.isExist(station)){
            throw new IllegalArgumentException("존재하지 않는 역 입니다.");
        }
    }

    public static void checkInLineStation(Station station){
        if(station.isInLine()){
            throw new IllegalArgumentException("노선에 등록되어 있는 역은 삭제할 수 없습니다.");
        }
    }
}
