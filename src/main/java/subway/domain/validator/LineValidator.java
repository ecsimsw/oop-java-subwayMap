package subway.domain.validator;

import subway.Repository.LineRepository;
import subway.domain.Name;
import subway.domain.Station;

public class LineValidator {
    public static void checkExistLineName(Name name) {
        if (!LineRepository.isExistName(name)) {
            throw new IllegalArgumentException("존재하지 않는 노선 이름입니다.");
        }
    }

    public static void checkNonExistLineName(Name name) {
        if (LineRepository.isExistName(name)) {
            throw new IllegalArgumentException("이미 존재하는 노선 이름입니다.");
        }
    }

    public static void checkDifferentTerminal(Station first, Station last) {
        if (first.equals(last)) {
            throw new IllegalArgumentException("상행 종점과 하행 종점은 같을 수 없습니다.");
        }
    }
}
