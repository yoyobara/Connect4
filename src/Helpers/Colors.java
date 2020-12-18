package Helpers;

public class Colors {
    public static final String BLUE_BOLD = "\033[1;34m"; // BLUE
    public static final String RED_BOLD = "\033[1;31m"; // RED
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String RESET = "\033[0m"; // Text Reset

    public static String coloredSymbol(int player) {
        if (player == -1)
            return " ";

        if (player == 1)
            return BLUE_BOLD + "O" + RESET;
        else if (player == 2)
            return RED_BOLD + "O" + RESET;
        return null;

    }
}
