import java.util.Scanner;

public class Board {
    Scanner scanner = new Scanner(System.in);

    char[][] board = { { ' ', ' ', ' ', ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ', ' ', ' ', ' ' } };

    public void printBoard() {
        System.out.println("-----------------------------");
        for (int r = 5; r >= 0; r--) {
            char[] row = this.board[r];
            System.out.println("| " + row[0] + " | " + row[1] + " | " + row[2] + " | " + row[3] + " | " + row[4] + " | "
                    + row[5] + " | " + row[6] + " |");

            System.out.println("-----------------------------");
        }
    }

    public void turn(char player) {
        System.out.println("Enter move spot for " + player + " >> ");
        int moveSpot = scanner.nextInt() - 1;

        if (moveSpot > 6 || moveSpot < 0 || this.board[5][moveSpot] != ' ') {
            System.out.println("Spot is full! or the move is illegal. try another one.");
            turn(player); // restart the method for another try
        }

        for (int i = 0; i <= 5; i++) {
            char[] row = this.board[i];

            if (row[moveSpot] == ' ') {
                this.board[i][moveSpot] = player;
                break;
            }

        }
    }

    public char checkWin() {
        for (int r = 0; r < 6; r++) {
            for (int s = 0; s < 7; s++) {
                char currentSlot = this.board[r][s];

                try {
                    if (currentSlot != ' ' && currentSlot == this.board[r][s + 1] && currentSlot == this.board[r][s + 2]
                            && currentSlot == this.board[r][s + 3]) {
                        return currentSlot;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }

                try {
                    if (currentSlot != ' ' && this.board[r + 1][s] == currentSlot && currentSlot == this.board[r + 2][s]
                            && currentSlot == this.board[r + 3][s]) {
                        return currentSlot;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }

                try {
                    if (currentSlot != ' ' && this.board[r + 1][s + 1] == currentSlot
                            && currentSlot == this.board[r + 2][s + 2] && currentSlot == this.board[r + 3][s + 3]) {
                        return currentSlot;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }

                try {
                    if (currentSlot != ' ' && this.board[r + 1][s - 1] == currentSlot
                            && currentSlot == this.board[r + 2][s - 2] && currentSlot == this.board[r + 3][s - 3]) {
                        return currentSlot;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }

        boolean isDraw = true;

        // check draw
        for (char[] row : this.board) {
            for (char slot : row) {
                if (slot == ' ')
                    isDraw = false;
            }
        }

        if (isDraw)
            return 'd';
        return 'n'; // no one won, no draw. game continues
    }
}
