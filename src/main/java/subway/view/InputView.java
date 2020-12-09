package subway.view;

import subway.domain.*;

import java.util.Scanner;

public class InputView {
    private InputView(){}

    public static Station getStation(Scanner scanner){
        try{
            return StationRepository.getStationByName(InputView.getName(scanner));
        }catch (Exception e){
            OutputView.printError(e);
            return getStation(scanner);
        }
    }

    public static Line getLine(Scanner scanner){
        try{
            return LineRepository.getByName(InputView.getName(scanner));
        }catch (Exception e){
            OutputView.printError(e);
            return getLine(scanner);
        }
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
