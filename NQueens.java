import java.util.Scanner;

public class NQueens {

    static boolean isSafe(int[][] board, int row, int col, int n) {
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1) return false;
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;
        for (int i = row, j = col; i < n && j >= 0; i++, j--)
            if (board[i][j] == 1) return false;
        return true;
    }

    static boolean solveNQueensUtil(int[][] board, int col, int n) {
        if (col >= n) return true;
        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) {
                board[i][col] = 1;
                if (solveNQueensUtil(board, col + 1, n)) return true;
                board[i][col] = 0; 
            }
        }
        return false;
    }

    static void printBoard(int[][] board, int n) {
        for (int[] row : board) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the board (n): ");
        int n = scanner.nextInt();
        int[][] board = new int[n][n];

        System.out.print("Enter the row and column of the first queen (0-based index): ");
        int firstRow = scanner.nextInt();
        int firstCol = scanner.nextInt();
        board[firstRow][firstCol] = 1;

        if (solveNQueensUtil(board, 1, n)) {
            System.out.println("Solution:");
            printBoard(board, n);
        } else {
            System.out.println("No solution exists for the given initial placement.");
        }

        scanner.close();
    }
}
