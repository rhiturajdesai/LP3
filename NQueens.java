import java.util.*;
import java.lang.*;

public class NQueens
{
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of queens : (n)");
         
        int n = sc.nextInt();
        int[][] board= new int[n][n];

        if(solveNQueens(board, 0, n))
        {
            System.out.println("Solution is exist");
            printBoard(board);
        }
        else
        {
            System.out.println("Solution is not exist");

        }

    }

    static bolean isSafe(int[][] board, int row, int col, int n)
    {
        for(int i=0; i<row; i++)
        {
            if( board[i][col]== 1)
            {
                return false;
            }
        }
        for(int i=row, j=col; i>=0 && j>=0; i--, j--)
        {
            if(board[i][j]==1)
            {
                return false;
            }
        }
        for(int i=row, j=col; i>=0 && j<n; i--, j++)
        {
            if(board[i][j]==1)
            {
                return false;
            }
        }
        return true;
    }

    static boolean solveNQueens(int[][] board, int row, int n) 
    {
    if (row >= n)
     {
        return true;
     }

    for (int i = 0; i < n; i++) 
    {
        if (isSafe(board, row, i, n)) 
        {
            board[row][i] = 1;

            if (solveNQueens(board, row + 1, n))
            {
                return true;
            }

            board[row][i] = 0;
        }
    }

    return false;
}
    static void printBoard(int[][] board)
    {
        for (int[] row : board) 
        {
            for (int cell : row) 
            {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
