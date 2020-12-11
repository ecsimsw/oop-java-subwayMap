package subway.domain.validator;

import java.util.Arrays;

public class MainValidator {

    private MainValidator() {
    }

    public static void checkValidSelection(String input, String[] buttons) {
        boolean isValid = Arrays.stream(buttons)
                .anyMatch(button -> button.equals(input));

        if (isValid) {
            throw new IllegalArgumentException("적절하지 않는 입력입니다.");
        }
    }
}
