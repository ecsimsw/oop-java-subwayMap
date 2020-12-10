package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    static {
        Station gyodae = StationRepository.getByName("교대역");
        Station gangnam = StationRepository.getByName("강남역");
        Station yoeksam = StationRepository.getByName("역삼역");
        lines.add(new Line("2호선", gyodae, gangnam, yoeksam));
    }

    static {
        Station gyodae = StationRepository.getByName("교대역");
        Station namboo = StationRepository.getByName("남부터미널역");
        Station yangjae = StationRepository.getByName("양재역");
        Station maebong = StationRepository.getByName("매봉역");
        lines.add(new Line("3호선", gyodae, namboo, yangjae, maebong));
    }

    static {
        Station gangnam = StationRepository.getByName("강남역");
        Station yangjae = StationRepository.getByName("양재역");
        Station yangjaeForest = StationRepository.getByName("양재시민의숲역");
        lines.add(new Line("신분당선", gangnam, yangjae, yangjaeForest));
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}