package subway.view;

public class PageRepository {
    private PageRepository() {
    }

    public static final String selectPageMessage = "## 원하는 기능을 선택하세요.\n";

    public static final String mainPage;
    public static final String stationPage;
    public static final String sectionPage;
    public static final String linePage;

    static {
        mainPage = "## 메인 화면\n"
                + "1. 역 관리\n"
                + "2. 노선 관리\n"
                + "3. 구간 관리\n"
                + "4. 지하철 노선도 출력\n"
                + "Q. 종료\n";
    }

    static {
        stationPage = "## 역 관리 화면\n"
                + "1. 역 등록\n"
                + "2. 역 삭제\n"
                + "3. 역 조회\n"
                + "B. 돌아가기\n";
    }

    static {
        sectionPage = "## 노선 관리 화면\n"
                + "1. 노선 등록\n"
                + "2. 노선 삭제\n"
                + "3. 노선 조회\n"
                + "B. 돌아가기\n";
    }

    static {
        linePage = "1. 노선 등록\n"
                + "2. 노선 삭제\n"
                + "3. 노선 조회\n"
                + "B. 돌아가기\n";
    }
}
