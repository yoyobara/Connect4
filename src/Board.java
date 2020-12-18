import java.util.Scanner;
import Helpers.Colors;

public class Board {
    Scanner scanner = new Scanner(System.in);

    int[][] board = { { -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1 } };

    public void printBoard() {
        System.out.println("-----------------------------");
        for (int r = 5; r >= 0; r--) {
            int[] row = this.board[r];
            System.out.println("| " + Colors.coloredSymbol(row[0]) + " | " + Colors.coloredSymbol(row[1]) + " | "
                    + Colors.coloredSymbol(row[2]) + " | " + Colors.coloredSymbol(row[3]) + " | "
                    + Colors.coloredSymbol(row[4]) + " | " + Colors.coloredSymbol(row[5]) + " | "
                    + Colors.coloredSymbol(row[6]) + " |");

            System.out.println("-----------------------------");
        }
        System.out.println("  1   2   3   4   5   6   7  \n");
    }

    public String ColorFromInt(int pl) {
        if (pl == 1)
            return "Blue";
        if (pl == 2)
            return "RED";
        return null;
    }

    public void turn(int player) {
        while (true) {
            System.out.println("Enter move spot for " + ColorFromInt(player) + " >> ");
            int moveSpot = scanner.nextInt() - 1;

            if (moveSpot > 6 || moveSpot < 0 || this.board[5][moveSpot] != -1) {
                System.out.println("Spot is full! or the move is illegal. try another one.");
                continue;
            }

            for (int i = 0; i <= 5; i++) {
                int[] row = this.board[i];

                if (row[moveSpot] == -1) {
                    this.board[i][moveSpot] = player;
                    break;
                }

            }
            break;
        }
    }

    public int checkWin() {
        for (int r = 0; r < 6; r++) {
            for (int s = 0; s < 7; s++) {
                int currentSlot = this.board[r][s];

                try {
                    if (currentSlot != -1 && currentSlot == this.board[r][s + 1] && currentSlot == this.board[r][s + 2]
                            && currentSlot == this.board[r][s + 3]) {
                        return currentSlot;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }

                try {
                    if (currentSlot != -1 && this.board[r + 1][s] == currentSlot && currentSlot == this.board[r + 2][s]
                            && currentSlot == this.board[r + 3][s]) {
                        return currentSlot;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }

                try {
                    if (currentSlot != -1 && this.board[r + 1][s + 1] == currentSlot
                            && currentSlot == this.board[r + 2][s + 2] && currentSlot == this.board[r + 3][s + 3]) {
                        return currentSlot;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }

                try {
                    if (currentSlot != -1 && this.board[r + 1][s - 1] == currentSlot
                            && currentSlot == this.board[r + 2][s - 2] && currentSlot == this.board[r + 3][s - 3]) {
                        return currentSlot;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }

        boolean isDraw = true;

        // check draw
        for (int[] row : this.board) {
            for (int slot : row) {
                if (slot == -1)
                    isDraw = false;
            }
        }

        if (isDraw)
            return 'd';
        return 'n'; // no one won, no draw. game continues
    }
}
