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
        rows = 5;
        columns = 5;
        numOfMines = 5;
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

    public void revealBlanks(int x, int y) {
        if ((y - 2) != -1) {
            getVisibleBoard()[x-1][y-2] = getHiddenBoard()[x-1][y-2];
            }

        if ((x - 2) != -1) {
            getVisibleBoard()[x-2][y-1] = getHiddenBoard()[x-2][y-1];
        }
        if ((x) != rows) {
            getVisibleBoard()[x][y-1] = getHiddenBoard()[x][y-1];
        }
        if ((y) != columns) {
            getVisibleBoard()[x-1][y] = getHiddenBoard()[x-1][y];
        }
        if ((x - 2) != -1 && (y - 2) != -1) {
            getVisibleBoard()[x-2][y-2] = getHiddenBoard()[x-2][y-2];
        }
        if ((x - 2) != -1 && (y) != columns) {
            getVisibleBoard()[x-2][y] = getHiddenBoard()[x-2][y];
        }

        if ((x) != rows && (y) != columns) {
            getVisibleBoard()[x][y] = getHiddenBoard()[x][y];
        }
        if ((x) != rows && (y - 2) != -1) {
            getVisibleBoard()[x][y-2] = getHiddenBoard()[x][y-2];
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
    public int getNumOfMines() {
        return numOfMines;
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
    public void matchXY(int x, int y, String marker) {

        int a = x;
        int b = y;

        if ((getHiddenBoard()[x-1][y-1]==9) && marker.equals("s") ) {
            System.out.println("GAME OVER!");
            System.exit(0);
        } else if ((getHiddenBoard()[x-1][y-1]==9) && (marker.equals("m"))) {
            getVisibleBoard()[x-1][y-1] = 9;
            printBoard(getVisibleBoard());
        } else if ((getHiddenBoard()[x-1][y-1]==0) && marker.equals("s")) {
            revealBlanks(a,b);
            getVisibleBoard()[x-1][y-1] = getHiddenBoard()[x-1][y-1];
            printBoard(getVisibleBoard());
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
        if (uncoveredTile == (rows*columns)) {
            System.out.println("Congrats! You Won");
            System.exit(0);
        }

    }




}





