import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Minesweeper!");
        System.out.println("\n");
        System.out.println("Number -1 = 'Hidden Tile'");
        System.out.println("Number 9 = 'Mine'");
        System.out.println("Number 0-8 represents how many mines are touching that tile");
        System.out.println("\n");

        // start game
        Grid game = new Grid();
        game.createVisibleBoard();
        game.createHiddenBoard();


        game.printBoard(game.getHiddenBoard()); // check everything matches
        System.out.println("---------------------------------------------------");
        game.printBoard(game.getVisibleBoard());


        while (true) {
            System.out.println("Choose a tile and input the X and Y coordinates");
            int y = scanner.nextInt();
            int x = scanner.nextInt();
            game.matchXY(x,y);

        }






































    }
}
