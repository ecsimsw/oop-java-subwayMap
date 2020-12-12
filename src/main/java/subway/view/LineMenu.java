package subway.view;

import java.util.Arrays;
import java.util.function.Consumer;

public class LineMenu {

    public enum Menu{
        STATION_MANAGEMENT("1","1. 역 관리", ()->MainMenu.run()),
        LINE_MANAGEMENT("2","2. 노선 관리", ()-> MainMenu.run()),
        SECTION_MANAGEMENT("3","3. 구간 관리", ()->MainMenu.run()),
        LINES_VIEW_OUTPUT("4","4. 지하철 노선도 출력", ()->MainMenu.run()),
        QUIT("Q","Q. 종료", ()-> MainMenu.run());

        private String userInput;
        private String menuName;
        private Runnable expression;

        Menu(String userInput, String menuName, Runnable expression){
            this.userInput=userInput;
            this.menuName = menuName;
            this.expression=expression;
        }

        public String getMenuName(){
            return menuName;
        }

        public void next(){

        }

        public static Menu getSelection(String input){
            return Arrays.stream(values()).filter(menu -> menu.userInput.equals(input))
                    .findFirst()
                    .orElseThrow(()-> new IllegalArgumentException("적절하지 않은 입력입니다."));
        }
    }
}
