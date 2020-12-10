package subway.view;

import subway.Repository.LineRepository;
import subway.Repository.PageRepository;
import subway.Repository.StationRepository;
import subway.domain.Line;
import subway.domain.Name;
import subway.domain.Station;
import subway.domain.validator.LineValidator;
import subway.domain.validator.MainValidator;
import subway.domain.validator.SectionValidator;

import java.util.Scanner;

public class SectionView {
    private static final String[] buttons = new String[]{"1","2","B"};
    private final Scanner scanner;

    public SectionView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String selectSectionMenu() {
        OutputView.print(PageRepository.sectionPage);
        try{
            String input = InputView.getSelect(scanner);
            MainValidator.checkValidSelection(input, buttons);
            return input;
        }catch (Exception e){
            OutputView.printError(e);
            return selectSectionMenu();
        }
    }

    public Name getExistLineName() {
        OutputView.print("## 노선을 입력하세요. \n");
        try {
            Name name = InputView.getName(scanner);
            LineValidator.checkExistLineName(name);
            return name;
        } catch (Exception e) {
            OutputView.printError(e);
            return getExistLineName();
        }
    }

    public Station getStationToAddSection(Line line) {
        OutputView.print("## 역 이름을 입력하세요. \n");
        try {
            Station station = StationRepository.getByName(InputView.getName(scanner));
            SectionValidator.checkNotIncludeStation(line, station);
            return station;
        } catch (Exception e) {
            OutputView.printError(e);
            return getStationToAddSection(line);
        }
    }

    public int getOrder(Line line) {
        OutputView.print("## 순서을 입력하세요. \n");
        try {
            int order = Integer.parseInt(scanner.nextLine());
            SectionValidator.checkValidOrder(line, order);
            return order;
        } catch (Exception e) {
            OutputView.printError(e);
            return getOrder(line);
        }
    }

    public Station getStationToRemove(Line line) {
        OutputView.print("## 삭제할 구간의 역을 입력하세요. \n");
        try {
            Station station = StationRepository.getByName(InputView.getName(scanner));
            SectionValidator.checkIncludeStation(line, station);
            return station;
        } catch (Exception e) {
            OutputView.printError(e);
            return getStationToAddSection(line);
        }
    }

    public void printSuccessAddMessage() {
        OutputView.printInfo("구간이 등록되었습니다.\n");
    }

    public void printSuccessRemoveMessage() {
        OutputView.printInfo("구간이 삭제되었습니다.\n");
    }
}
