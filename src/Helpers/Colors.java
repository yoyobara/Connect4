package Helpers;

public class Colors {
    private static final String BLUE_BOLD = "\033[1;34m"; // BLUE
    private static final String RED_BOLD = "\033[1;31m"; // RED
    private static final String RESET = "\033[0m"; // Text Reset

    public static String coloredSymbol(char ch) {
        if (ch == ' ')
            return " ";

        if (ch == 'X')
            return BLUE_BOLD + ch + RESET;
        else if (ch == 'O')
            return RED_BOLD + ch + RESET;
        return null;

    }
}
