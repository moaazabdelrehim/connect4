package VierGewinnt;

// needed for player assignment
import java.util.Scanner;

public class VierGewinnt {
    public static void main(String[] args) {

        System.out.print("Spielbeschreibung: tbd \nSpielanleitung: tbd \n");

        // user input - color selection
        Scanner scanner = new Scanner(System.in);
        char p1Color;
        char p2Color;

        do{
            System.out.print("player 1 please pick your color:\nR for red, G for green, B for blue...\n");
            p1Color = scanner.next().charAt(0);
            if (p1Color != 'R' && p1Color != 'G' && p1Color != 'B'){
                System.out.print("INVALID INPUT, please choose between R, G or B...\n");
            }
        }
        while(p1Color != 'R' && p1Color != 'G' && p1Color != 'B');
        System.out.print("player 1 color: " + p1Color + "\n");

        do{
            System.out.print("player 2 please pick your color:\nR for red, G for green, B for blue...\n");
            p2Color = scanner.next().charAt(0);
            if (p2Color == p1Color){
                System.out.print("INVALID INPUT, please use another color than player 1...\n");
            }
            if (p2Color != 'R' && p2Color != 'G' && p2Color != 'B'){
                System.out.print("INVALID INPUT, please choose between R, G or B...\n");
            }
        }
        while(p2Color != 'R' && p2Color != 'G' && p2Color != 'B' || p2Color == p1Color);
        System.out.print("player 2 color: " + p2Color + "\n");


        // initialize game board variables rows/columns for adjusting game board
        int columns = 7;
        int rows = 6;
        char[][] board = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                board[row][column] = ' ';
            }
        }

        // output game board
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                System.out.print(board[row][column] + "|");
            }
            System.out.println();
        }
    }
}
