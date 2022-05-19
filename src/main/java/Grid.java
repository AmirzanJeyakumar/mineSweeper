import java.util.Arrays;
import java.util.Random;

public class Grid {


    final int rows;
    final int columns;
    final int numOfMines;
    private int[][] visibleBoard;
    private int[][] hiddenBoard;



    Random random = new Random();


    public Grid() {
        rows = 10;
        columns = 10;
        numOfMines = 20;
        visibleBoard = new int[rows][columns];
        hiddenBoard = new int[rows][columns];

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

    public void setVisibleBoard(int [][] newBoard) {
        visibleBoard = newBoard;
    }

    public void setHiddenBoard(int [][] newBoard) {
        hiddenBoard = newBoard;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getVisibleBoard() {
        return visibleBoard;
    }
    public int[][] getHiddenBoard() {
        return hiddenBoard;
    }

    public void createVisibleBoard() {
        defaultValues(visibleBoard);
        setVisibleBoard(visibleBoard);
    }

    public void createHiddenBoard() {
        defaultValues(hiddenBoard);
        randomMines(hiddenBoard);
        calcValues(hiddenBoard);
        setHiddenBoard(hiddenBoard);
    }
    public void matchXY(int x, int y) {
        int status = 0;
        if (getHiddenBoard()[x-1][y-1]==9) {
            System.out.println("GAME OVER!");
            System.exit(status);
        } else {
            getVisibleBoard()[x-1][y-1] = getHiddenBoard()[x-1][y-1];
            printBoard(getVisibleBoard());
        }
        int uncoveredTile = 0;
        for (int [] ints: getVisibleBoard()) {
            for (int anInt : ints) {
                if (anInt != -1) {
                    uncoveredTile++;
                }
            }
        }
        if (uncoveredTile == rows*columns) {
            System.out.println("Congrats! You Won");
            System.exit(status);
        }

    }




}





