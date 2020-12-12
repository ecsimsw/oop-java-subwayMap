package subway.view;

public class OutputView {
    private static final String INFO_MESSAGE = "[INFO] %s \n";
    private static final String ERROR_MESSAGE = "[ERROR] %s \n";

    private OutputView() {
    }

    public static void printErrorMessage(Exception e) {
        printf(INFO_MESSAGE, e.getMessage());
    }

    public static void printInfo(String msg) {
        printf(INFO_MESSAGE, msg);
    }

    public static void printf(String msg, Object... args) {
        System.out.printf(msg, args);
    }

    public static void print(Object msg) {
        System.out.print(msg);
    }
}
