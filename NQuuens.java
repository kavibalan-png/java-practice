public class NQuuens {
    static int N = 4;
    static boolean[][] board = new boolean[N][N];
    public static void solve(int row) {
        if (row == N) {
            printBoard();
            System.out.println();
            return;
        }
        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row][col] = true;      // Place Queen
                solve(row + 1);              // Next Row
                board[row][col] = false;     // Backtrack
            }
        }
    }
    static boolean isSafe(int row, int col) {
        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col])
                return false;
        }
        // Check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j])
                return false;
        }
        // Check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j])
                return false;
        }
        return true;
    }
    static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j])
                    System.out.print("QUEEN ");
                else
                    System.out.print("King ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        solve(0);

    }
}