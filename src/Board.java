public class Board {
    public void getQueenPosition() {
        int[] board = new int[8];
        position(0, board);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[row] == col) {
                    System.out.print("F ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    private static boolean position(int row, int[] board) {
        if (row == 8) {
            return true;
        }
        for (int col = 0; col < 8; col++) {
            boolean queenPosition = true;
            for (int i = 0; i < row; i++) {
                if ((board[i] == col) || (board[i] == col - row + i)
                        || (board[i] == col + row - i)) {
                    queenPosition = false;
                    break;
                }
            }
            if (queenPosition) {
                board[row] = col;
                if (position(row + 1, board)) {
                    return true;
                }
            }
        }
        return false;
    }
}
