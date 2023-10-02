package VierGewinnt;

// needed for player assignment
import java.util.Scanner;

public class VierGewinnt {
    public static void main(String[] args) {

        //instructions how to play the game
        System.out.print("Spielbeschreibung: tbd \nSpielanleitung: tbd \n");

        // game start
        Scanner scanner = new Scanner(System.in);
        char start;

        do{
            System.out.print("please start the game with S...\n");
            start = scanner.next().charAt(0);
            if (start != 'S' && start != 's'){
                System.out.print("INVALID INPUT, start the game with S...\n");
            }
        }
        while(start != 'S' && start != 's');
        System.out.print("game started...\n");

        // user input - color selection
        //Scanner scanner = new Scanner(System.in);
        char p1Color;
        char p2Color;

        do{
            System.out.print("player 1 please pick your color:\nR for red, G for green, B for blue...\n");
            p1Color = scanner.next().charAt(0);
            if (p1Color != 'R' && p1Color != 'r' &&
                p1Color != 'G' && p1Color != 'g' &&
                p1Color != 'B' && p1Color != 'b'){
                System.out.print("INVALID INPUT, please choose between R, G or B...\n");
            }
        }
        while(p1Color != 'R' && p1Color != 'r' &&
              p1Color != 'G' && p1Color != 'g' &&
              p1Color != 'B' && p1Color != 'b');
        System.out.print("player 1 color: " + p1Color + "\n");

        do{
            System.out.print("player 2 please pick your color:\nR for red, G for green, B for blue...\n");
            p2Color = scanner.next().charAt(0);
            if (p2Color == p1Color){
                System.out.print("INVALID INPUT, please use another color than player 1...\n");
            }
            if (p2Color != 'R' && p2Color != 'r' &&
                p2Color != 'G' && p2Color != 'g' &&
                p2Color != 'B' && p2Color != 'b'){
                System.out.print("INVALID INPUT, please choose between R, G or B...\n");
            }
        }
        while(p2Color != 'R' && p2Color != 'r' &&
              p2Color != 'G' && p2Color != 'g' &&
              p2Color != 'B' && p2Color != 'b' ||
              p2Color == p1Color);
        System.out.print("player 2 color: " + p2Color + "\n");

        // moved to class Board
        Board board1 = new Board();

        board1.temp();

    }
}
