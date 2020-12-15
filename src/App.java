import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean newGame = true;

        cls();
        while (newGame) {
            char game = newGame();

            if (game == 'X') {
                System.out.println("\nX won the game!!!");
            } else if (game == 'O') {
                System.out.println("\nO won the game!!!");
            } else {
                System.out.println("\nDraw!!!");
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

    public static char newGame() {
        Board board = new Board();
        char turn = 'X';

        while (board.checkWin() == 'n') {
            board.printBoard();
            board.turn(turn);

            if (turn == 'X') {
                turn = 'O';
            } else {
                turn = 'X';
            }
            cls();
        }

        return board.checkWin();
    }
}
