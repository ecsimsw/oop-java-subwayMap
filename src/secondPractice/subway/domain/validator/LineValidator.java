package subway.domain.validator;

import subway.domain.LineRepository;
import subway.domain.Name;

public class LineValidator {

    private LineValidator() {
    }

    public static void checkNonExistName(Name name) {
        if (LineRepository.isExistName(name)) {
            throw new IllegalArgumentException("이미 존재하는 노선 이름입니다.");
        }
    }
}
