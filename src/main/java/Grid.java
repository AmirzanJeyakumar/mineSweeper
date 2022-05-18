import java.util.Arrays;
import java.util.Random;
public class Grid {


    final int rows;
    final int columns;
    final int numOfMines;
    private final int[][] visibleBoard;
    private final int[][] hiddenBoard;

    Random random = new Random();


    public Grid() {
        rows = 14;
        columns = 18;
        numOfMines = 40;
        visibleBoard = new int[rows][columns];
        hiddenBoard = new int[rows][columns];

    }

    public int getRows() {
        return rows;
    }

    public void printBoard(int [][] board) {
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print("   " + anInt);
            }
            System.out.println("\n");
        }
    }

    public void randomMines (int [][] board) {
        int occupiedSpots = 0;
        while (occupiedSpots < numOfMines) {
            int i = random.nextInt(board.length);
            int j = random.nextInt(board[i].length);
            if (board[i][j] == -1) {
                board[i][j] = 9;
                occupiedSpots++;
            }
        }
    }

    public void defaultValues (int [][] board) {
        for (int[] ints : board) {
            Arrays.fill(ints, -1);
        }
    }

    public void calcValues (int [][] board) {
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int mineCount = 0;
                if (board[i][j] != 9) {

                    if ((j - 1) != -1) {
                        if (board[i][j - 1] == 9) {
                            mineCount += 1;
                        }
                    }
                    if ((i - 1) != -1) {
                        if (board[i - 1][j] == 9) {
                            mineCount += 1;
                        }
                    }
                    if ((i + 1) != rows) {
                        if (board[i + 1][j] == 9) {
                            mineCount += 1;
                        }
                    }
                    if ((j + 1) != columns) {
                        if (board[i][j + 1] == 9) {
                            mineCount += 1;
                        }
                    }
                    if ((i - 1) != -1 && (j - 1) != -1) {
                        if (board[i - 1][j - 1] == 9) {
                            mineCount += 1;
                        }
                    }
                    if ((i - 1) != -1 && (j + 1) != columns) {
                        if (board[i - 1][j + 1] == 9) {
                            mineCount += 1;
                        }
                    }

                    if ((i + 1) != rows && (j + 1) != columns) {
                        if (board[i + 1][j + 1] == 9) {
                            mineCount += 1;
                        }
                    }
                    if ((i + 1) != rows && (j - 1) != -1) {
                        if (board[i + 1][j - 1] == 9) {
                            mineCount += 1;
                        }
                    }
                    board[i][j] = mineCount;
                }
            }
        }
    }

    public void visibleBoard() {

        defaultValues(visibleBoard);
        printBoard(visibleBoard);
    }

    public void hiddenBoard() {

        defaultValues(hiddenBoard);
        randomMines(hiddenBoard);
        calcValues(hiddenBoard);
        printBoard(hiddenBoard);
    }
}





