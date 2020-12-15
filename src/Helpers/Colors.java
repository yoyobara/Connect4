package Helpers;

public class Colors {
    private static final String BLUE_BOLD = "\033[1;34m"; // BLUE
    private static final String RED_BOLD = "\033[1;31m"; // RED
    public static final String RESET = "\033[0m"; // Text Reset

    public static String BlueText(String text) {
        return (BLUE_BOLD + text + RESET);
    }

    public static String RedText(String text) {
        return (RED_BOLD + text + RESET);
    }
}
