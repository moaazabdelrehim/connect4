package VierGewinnt;

import java.util.Scanner;

public class GameLogic {
    public void gameExplanation(){
        //Instructions how to play the game
        System.out.print("Spielbeschreibung: tbd \nSpielanleitung: tbd \n");
    }

    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        char start;

        do{
            System.out.print("Once you have read the instructions, please start the game by clicking \"S\"");
            start = scanner.next().charAt(0);
            if (start != 'S' && start != 's'){
                System.out.print("INVALID INPUT, start the game with S...\n");
            }
        }
        while(start != 'S' && start != 's');
        System.out.print("game started...\n");
    }
}
