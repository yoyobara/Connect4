import java.util.Scanner;
import Helpers.Colors;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean newGame = true;

        cls();
        while (newGame) {
            int game = newGame();

            if (game == 1) {
                System.out.println("\n" + Colors.BLUE_BOLD + "BLUE won the game!!!" + Colors.RESET);
            } else if (game == 2) {
                System.out.println("\n" + Colors.RED_BOLD + "RED won the game!!!" + Colors.RESET);
            } else {
                System.out.println("\n" + Colors.PURPLE_BOLD + "Draw!!!" + Colors.RESET);
            }

            System.out.print("\nPlay again? (y/n) >> ");
            char playagain = scanner.next().charAt(0);
            if (playagain == 'n')
                newGame = false;
        }
        scanner.close();
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int newGame() {
        Board board = new Board();
        int turn = 1;

        while (board.checkWin() == 'n') {
            board.printBoard();
            board.turn(turn);

            if (turn == 1) {
                turn = 2;
            } else {
                turn = 1;
            }
            cls();
        }

        board.printBoard();

        return board.checkWin();
    }
}
