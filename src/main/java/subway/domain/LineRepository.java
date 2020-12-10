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
        if(lines.contains(line)){
            throw new IllegalArgumentException("이미 존재하는 노선입니다.");
        }
        lines.add(line);
    }

    public static Line getByName(String name){
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("노선이 존재하지 않습니다."));
    }

    public static void deleteByName(String lineName) {
        Line deleteLine = getByName(lineName);
        lines.remove(deleteLine);
    }
}