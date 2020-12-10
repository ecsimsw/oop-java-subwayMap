package subway.domain.validator;

import subway.domain.Line;
import subway.domain.Station;

public class SectionValidator {
    private SectionValidator() {
    }

    public static void checkIncludeStation(Line line, Station station) {
        if (!line.isStationOnLine(station)) {
            throw new IllegalArgumentException("노선에 존재하지 않는 역입니다.");
        }
    }

    public static void checkNotIncludeStation(Line line, Station station) {
        if (line.isStationOnLine(station)) {
            throw new IllegalArgumentException("이미 포함된 역입니다.");
        }
    }

    public static void checkValidOrder(Line line, int order) {
        if (line.getSize() < order) {
            throw new IllegalArgumentException("순서는 노선의 현재 길이를 넘을 수 없습니다.");
        }

        if (order < 0) {
            throw new IllegalArgumentException("순서는 음수일 수 없습니다.");
        }
    }
}
