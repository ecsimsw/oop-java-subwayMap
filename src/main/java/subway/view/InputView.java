package subway.view;

import subway.domain.Name;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Scanner;

public class InputView {
    private InputView(){}

    public static Name deleteStation(Scanner scanner){
        OutputView.printMsg("삭제할 역 이름 입력 \n");
        // 존재 확인
        return getName(scanner);
    }

    public static String selectMenu(Scanner scanner){
        OutputView.printMsg("## 원하는 기능을 선택하세요.\n");
        return getInput(scanner);
    }

    public static Name getName(Scanner scanner){
        try{
            return new Name(getInput(scanner));
        }catch (Exception e){
            OutputView.printError(e);
            return getName(scanner);
        }
    }

    private static String getInput(Scanner scanner){
        return scanner.nextLine();
    }
}
