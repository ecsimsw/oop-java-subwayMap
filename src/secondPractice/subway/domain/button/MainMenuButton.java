package subway.domain.button;

import java.util.Arrays;

public enum MainMenuButton implements IButton {
    StationManagement("1"),
    LineManagement("2"),
    SectionManagement("3"),
    ShowSubwayMap("4"),
    Quit("Q");

    private String button;

    MainMenuButton(String button) {
        this.button = button;
    }

    public static MainMenuButton getButton(String input) {
        return Arrays.stream(values())
                .filter(mainMenuButton -> mainMenuButton.button.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 입력입니다."));
    }
}