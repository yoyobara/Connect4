import java.util.Scanner;

public class Board {
    Scanner scanner = new Scanner(System.in);

    char[][] board = { { ' ', ' ', ' ', ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ', ' ', ' ', ' ' } };

    public void printBoard() {
        System.out.println("-----------------------------");
        for (char[] row : this.board) {
            System.out.println("| " + row[0] + " | " + row[1] + " | " + row[2] + " | " + row[3] + " | " + row[4] + " | "
                    + row[5] + " | " + row[6] + " |");

            System.out.println("-----------------------------");
        }
    }

    public void turn(char player) {
        System.out.println("Enter move spot for " + player + " >> ");
        int moveSpot = scanner.nextInt() - 1;

        if (this.board[5][moveSpot] != ' ') {
            System.out.println("Spot is full! try another one.");
            turn(player); // restart the method for another try
        }

        for (int i = 0; i <= 9; i++) {
            char[] row = this.board[i];

            if (row[moveSpot] == ' ') {
                this.board[i][moveSpot] = player;
                break;
            }

        }
    }
}
