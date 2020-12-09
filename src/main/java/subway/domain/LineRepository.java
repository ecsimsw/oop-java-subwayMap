package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    static{
        Station gyedae = StationRepository.getStationByName(new Name("교대역"));
        Station gangnam = StationRepository.getStationByName(new Name("강남역"));
        Station yoeksam = StationRepository.getStationByName(new Name("역삼역"));
        Line line = new Line(new Name("2호선"), gyedae, yoeksam);
        line.addStation(1, gangnam);
        lines.add(line);
    }

    static{
        Station gyedae = StationRepository.getStationByName(new Name("교대역"));
        Station nambu = StationRepository.getStationByName(new Name("남부터미널역"));
        Station yangjae = StationRepository.getStationByName(new Name("양재역"));
        Station maebong = StationRepository.getStationByName(new Name("매봉역"));
        Line line = new Line(new Name("3호선"), gyedae, maebong);
        line.addStation(1, nambu);
        line.addStation(2, yangjae);
        lines.add(line);
    }

    static{
        Station gangnam = StationRepository.getStationByName(new Name("강남역"));
        Station yangjae = StationRepository.getStationByName(new Name("양재역"));
        Station yangjaeForest = StationRepository.getStationByName(new Name("양재시민의숲역"));
        Line line = new Line(new Name("신분당선"), gangnam, yangjaeForest);
        line.addStation(1, yangjae);
        lines.add(line);
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void deleteLine(Line line) {
        line.removeAllIncludedStations();
        lines.remove(line);
    }

    public static boolean isExistName(Name name){
        return lines.stream()
                .anyMatch(line -> line.isName(name));
    }

    public static Line getByName(Name name){
        return lines.stream()
                .filter(line->line.isName(name))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 라인입니다."));
    }
}
