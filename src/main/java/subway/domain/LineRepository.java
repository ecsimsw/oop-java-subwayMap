package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void deleteLineByName(Name name) {
        Line line = getLineByName(name);
        line.removeAllIncludeStations();
        lines.remove(line);
    }

    public static Line getLineByName(Name name) {
        return lines.stream()
                .filter(line -> line.isName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 노선 이름입니다."));
    }

    public static boolean isExistName(Name name) {
        return lines.stream().anyMatch(line -> line.isName(name));
    }
}
