package subway.domain.button;

import java.util.Arrays;

public enum SectionMenuButton implements IButton {
    AddSection("1"), DeleteSection("2"), Back("B");

    private String button;

    SectionMenuButton(String button) {
        this.button = button;
    }

    public static SectionMenuButton getButton(String input) {
        return Arrays.stream(SectionMenuButton.values())
                .filter(button -> button.button.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 입력입니다."));
    }
}