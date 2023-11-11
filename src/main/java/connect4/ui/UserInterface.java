package connect4.ui;

import connect4.Connect4Game;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UserInterface 
{
	public static final String MESSAGE_COLUMN_FULL = "\nDie angegebene Spalte ist leider bereits voll. Bitte versuche es erneut: ";
	public static final String MESSAGE_PLAYER_INPUT = "Bitte gebe eine Spalte ein: ";
	public static final String MESSAGE_WRONG_INPUT = "Bitte gebe eine Zahl zwischen 0-6 ein:";
	public static final String MESSAGE_GAME_EXPLANATION = "so gehts (anna)";
	public static final String MESSAGE_TOKEN_PLACED = "Token successfully placed";
	public static final String MESSAGE_GAME_TITLE = "Willkommen zu VierGewinnt! Wählen sie aus.";
	public static final String MESSAGE_CHOOSE_GAME_START = "Spiel starten";
	public static final String MESSAGE_CHOOSE_GAME_EXPLANATION = "Spielanleitung";
	public static final String MESSAGE_GAME_FINISHED = "Spiel beendet!";

	public static final int lowerInputLimit = 0;
	public static final int higherInputLimit = 6;

	private Connect4Game ctrl = new Connect4Game();

	public void placeToken() {

		Output.displayMessage(MESSAGE_PLAYER_INPUT);
		int column = (int)readColumn(lowerInputLimit,higherInputLimit);

		while (!ctrl.placeToken(column)) {
			Output.displayMessage(MESSAGE_COLUMN_FULL);
			column = (int)readColumn(lowerInputLimit,higherInputLimit);
		}
		Output.displayMessage(MESSAGE_TOKEN_PLACED);
		Output.displayMessage(ctrl.getCurrentBoard());

	}
	public void showExplaination(){
		Output.displayMessage(MESSAGE_GAME_EXPLANATION);

	}

	public void getDataFromCtrl2() {
	}

	public void getDataFromCtrl3() {
	}

	public void getDataForCustomInput() {
	}

	public void displayCurrentBoard(String board) {
		Output.displayMessage(board);
	}


	public void start() {
		Menu<Runnable> menu = new Menu<>("User Interface");

		menu.setTitel(MESSAGE_GAME_TITLE);
		menu.insert("S", MESSAGE_CHOOSE_GAME_START, this::run);
		menu.insert("A", MESSAGE_CHOOSE_GAME_EXPLANATION, this::showExplaination);
		Runnable choice;
		while ((choice = menu.exec()) != null) {
			 choice.run();
		}
		System.out.println(MESSAGE_GAME_FINISHED);
	}

	public void run() {
			while (ctrl.isGameActive()) {
				placeToken();
			}
	}

	protected String readLine() 
	{
		String value = "\0";
		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			value = inReader.readLine();
		} catch (IOException e) {
		}
		return value.trim();
	}

	protected double readColumn(int lowerlimit, int upperlimit)
	{
		Double number = null;
		while(number == null) {
			String str = this.readLine();
			try {
				number = Double.parseDouble(str);
			}catch(NumberFormatException e) {
				number=null;
				System.out.println(MESSAGE_WRONG_INPUT);
				continue;
			}
			if(number<lowerlimit) {
				System.out.println(MESSAGE_WRONG_INPUT);
				number=null;
			}else if(number>upperlimit) {
				System.out.println(MESSAGE_WRONG_INPUT);
				number=null;
			}
		}
		return number;
	}
}
