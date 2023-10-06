package viergewinnt;

import java.util.Scanner;

public class Board {
    // Initialize game board variables rows/columns for adjusting game board
    int columns = 7;
    int rows = 6;
    char p1Color;
    char p2Color;

    public void chooseGameColor(){

        Scanner scanner = new Scanner(System.in);

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
    }

    public void drawBoard() {
        char[][] board = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                board[row][column] = ' ';
            }
        }

        // Output game board
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                System.out.print(board[row][column] + "|");
            }
            System.out.println();
        }
    }
}
