package subway.domain.button;

import java.util.Arrays;

public enum LineMenuButton implements IButton {
    AddLine("1"), DeleteLine("2"), PrintLineList("3"), Back("B");

    private String button;

    LineMenuButton(String button) {
        this.button = button;
    }

    public static LineMenuButton getButton(String input) {
        return Arrays.stream(LineMenuButton.values())
                .filter(button -> button.button.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 입력입니다."));
    }
}
