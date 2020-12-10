package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    static {
        Station gyodae = StationRepository.getByName(new Name("교대역"));
        Station gangnam = StationRepository.getByName(new Name("강남역"));
        Station yoeksam = StationRepository.getByName(new Name("역삼역"));
        Name newLineName = new Name("2호선");
        lines.add(new Line(newLineName, gyodae, gangnam, yoeksam));
    }

    static {
        Station gyodae = StationRepository.getByName(new Name("교대역"));
        Station namboo = StationRepository.getByName(new Name("남부터미널역"));
        Station yangjae = StationRepository.getByName(new Name("양재역"));
        Station maebong = StationRepository.getByName(new Name("매봉역"));
        Name newLineName = new Name("3호선");
        lines.add(new Line(newLineName, gyodae, namboo, yangjae, maebong));
    }

    static {
        Station gangnam = StationRepository.getByName(new Name("강남역"));
        Station yangjae = StationRepository.getByName(new Name("양재역"));
        Station yangjaeForest = StationRepository.getByName(new Name("양재시민의숲역"));
        Name newLineName = new Name("신분당선");
        lines.add(new Line(newLineName, gangnam, yangjae, yangjaeForest));
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        if (lines.contains(line)) {
            throw new IllegalArgumentException("이미 존재하는 노선입니다.");
        }
        lines.add(line);
    }

    public static void deleteByName(Name lineName) {
        Line deleteLine = getByName(lineName);
        lines.remove(deleteLine);
    }

    public static Line getByName(Name name) {
        return lines.stream()
                .filter(line -> line.isName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("노선이 존재하지 않습니다."));
    }

    public static boolean isExistName(Name name) {
        return lines.stream()
                .anyMatch(line -> line.isName(name));
    }
}