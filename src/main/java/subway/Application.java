package subway;

import subway.view.In;
import subway.view.Out;
import subway.view.PageRepository;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        Out.print(PageRepository.mainPage);
        String answer = In.getSelect(scanner);

        if(answer.equals("1")){
            Out.print(PageRepository.stationPage);

        }
    }
}