package subway.domain.button;

import java.util.Arrays;

public enum StationMenuButton implements IButton {
    AddStation("1"), DeleteStation("2"), PrintStation("3"), Back("B");

    private String button;

    StationMenuButton(String button) {
        this.button = button;
    }

    public static StationMenuButton getButton(String input) {
        return Arrays.stream(StationMenuButton.values())
                .filter(button -> button.button.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 입력입니다."));
    }
}
