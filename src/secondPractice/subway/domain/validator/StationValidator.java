package subway.domain.validator;

import subway.domain.Name;
import subway.domain.StationRepository;

public class StationValidator {
    private StationValidator() {
    }

    public static void checkNonExistentName(Name name) {
        if (StationRepository.isExistName(name)) {
            throw new IllegalArgumentException("이미 존재하는 역 이름 입니다.");
        }
    }

    public static void checkExistingName(Name name) {
        if (!StationRepository.isExistName(name)) {
            throw new IllegalArgumentException("이미 존재하는 역 이름 입니다.");
        }
    }
}
