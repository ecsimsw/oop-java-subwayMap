package subway.view;

import subway.domain.Name;

import java.util.Scanner;

public class InputView {
    private InputView(){}

    public static Name deleteStation(Scanner scanner){
        OutputView.printMsg("삭제할 역 이름 입력 \n");
        // 존재 확인
        return getName(scanner);
    }

    public static Name registerStation(Scanner scanner){
        OutputView.printMsg("## 등록할 역 이름 입력\n");
        // 중복 확인
        return getName(scanner);
    }

    private static Name getName(Scanner scanner){
        return new Name(getInput(scanner));
    }

    private static String getInput(Scanner scanner){
        return scanner.nextLine();
    }
}
