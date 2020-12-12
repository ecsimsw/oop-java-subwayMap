package subway.view;

public class MenuRepository {
    private MenuRepository() {
    }

    public static final String selectMenu;
    public static final String mainMenu;
    public static final String stationMenu;
    public static final String lineMenu;
    public static final String sectionMenu;

    static {
        selectMenu = "## 원하는 기능을 선택하세요.\n";
    }

    static {
        mainMenu = "## 메인 화면\n"
                + "1. 역 관리 \n"
                + "2. 노선 관리\n"
                + "3. 구간 관리\n"
                + "4. 지하철 노선도 출력\n"
                + "Q. 종료\n";
    }

    static {
        stationMenu = "## 역 관리 화면\n"
                + "1. 역 등록\n"
                + "2. 역 삭제\n"
                + "3. 역 조회\n"
                + "B. 돌아가기\n";
    }

    static {
        lineMenu = "## 노선 관리 화면\n"
                + "1. 노선 등록\n"
                + "2. 노선 삭제\n"
                + "3. 노선 조회\n"
                + "B. 돌아가기\n";
    }

    static {
        sectionMenu = "## 구간 관리 화면\n"
                + "1. 구간 등록\n"
                + "2. 구간 삭제\n"
                + "B. 돌아가기\n";
    }
}
