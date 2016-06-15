package main;

import java.util.Scanner;

public class WhiteMove {
	
	public static int i = 0, j = 0, Move = 0;

	public static void ChosePawnW() {
		
		System.out.println("Wybierz bia³y pionek (np 2c)");
		
		Scanner WPawn = new Scanner(System.in);
		String PawnLoc = WPawn.nextLine();
		if ((PawnLoc.length() < 2)||(PawnLoc.length() > 2)) {
			System.out.println("B³êdny wybór, spróbuj ponownie");
			ChosePawnW();
		} else {
			String J = String.valueOf(PawnLoc.charAt(1));
			switch (J) {
				case "a" : j = 1; break;
				case "b" : j = 2; break;
				case "c" : j = 3; break;
				case "d" : j = 4; break;
				case "e" : j = 5; break;
				case "f" : j = 6; break;
				case "g" : j = 7; break;
				case "h" : j = 8; break;
				default : {
					System.out.println("B³êdny wybór, spróbuj ponownie");
					ChosePawnW();
					break;
				}
			} 
			
			String I = String.valueOf(PawnLoc.charAt(0));
			switch (I) {
				case "1" : i = 8; break;
				case "2" : i = 7; break;
				case "3" : i = 6; break;
				case "4" : i = 5; break;
				case "5" : i = 4; break;
				case "6" : i = 3; break;
				case "7" : i = 2; break;
				case "8" : i = 1; break;
				default : {
					System.out.println("B³êdny wybór, spróbuj ponownie");
					ChosePawnW();
					break;
				}
			}
		}
		IfWhite(i, j);
	}

	public static void IfWhite(int i, int j){
		if (Board.board[i][j] != 'W') {
			System.out.println("Wybrane pole nie zawiera bia³ego pionka");
			ChosePawnW();
		} else { 
			CheckMovesW(i, j);
		}
	}
	
	public static void CheckMovesW(int i, int j){
		
		int PossibleMoves = 5;
		
		if (Board.board[i-1][j-1] != '_') {
			PossibleMoves--;
		} else {
			ChoseMoveW(i, j);
		}

		if (Board.board[i-1][j-1] != 'B') {
			PossibleMoves--;
		} else {
			ChoseMoveW(i, j);
		}
		
		if (Board.board[i-1][j] != '_') {
			PossibleMoves--;
		} else {
			ChoseMoveW(i, j);
		}
		
		if (Board.board[i-1][j+1] != '_') {
			PossibleMoves--;
		} else {
			ChoseMoveW(i, j);
		}
		
		if (Board.board[i-1][j+1] != 'B') {
			PossibleMoves--;
		} else {
			ChoseMoveW(i, j);
		}
		
		if (PossibleMoves == 0) {
			System.out.println("Brak mo¿liwych ruchów dla wybranego pionka, wybierz ponownie");
			ChosePawnW();
		}
	}
	
	public static void ChoseMoveW(int i, int j) {	
		
		System.out.println("Wybierz ruch: 1. = Góra lewo");
		System.out.println("              2. = Góra");
		System.out.println("              3. = Góra prawo");
		
		Scanner MoveW = new Scanner(System.in);
		String MoveString = MoveW.nextLine();
		switch (MoveString) {
			case "1" : Move = 1; break;
			case "2" : Move = 2; break;
			case "3" : Move = 3; break;
			default : 	{
				System.out.println("B³êdny wybór, spróbuj ponownie");
				ChoseMoveW(i, j);
				break;
			}
		}
		CheckMoveW(i, j, Move);
	}
	
	public static void CheckMoveW(int i, int j, int Move) {
		
		switch (Move){
			case 1 : {
				if ((Board.board[i-1][j-1] == '_')||(Board.board[i-1][j-1] == 'B')) {
					if (Board.board[i-1][j-1] == 'B') { Main.BlackCount--; }
					Board.board[i-1][j-1] = 'W';
					Board.board[i][j] = '_';
					Board.PrintBoard();
					BeatW(i-1, j-1);
				} else {
					System.out.println("");
					System.out.println("Niedozwolony ruch, wybierz ponownie");
					ChoseMoveW(i, j);
				}
				break;
			}
			case 2 : {
				if (Board.board[i-1][j] == '_') {
					Board.board[i-1][j] = 'W';
					Board.board[i][j] = '_';
					Board.PrintBoard();
					BeatW(i-1, j);
				} else {
					System.out.println("Niedozwolony ruch, wybierz ponownie");
					ChoseMoveW(i, j);
				}
				break;
			}
			case 3 : {
				if ((Board.board[i-1][j+1] == '_')||(Board.board[i-1][j+1] == 'B')) {
					if (Board.board[i-1][j+1] == 'B') { Main.BlackCount--; }
					Board.board[i-1][j+1] = 'W';
					Board.board[i][j] = '_';
					Board.PrintBoard();
					BeatW(i-1, j+1);
				} else {
					System.out.println("Niedozwolony ruch, wybierz ponownie");
					ChoseMoveW(i, j);
				}
				break;
			}
			default : {
				System.out.println("Podano nieprawid³ow¹ opcjê, wybierz ponownie");
				ChoseMoveW(i, j);
			}
			break;
		}
	}
	public static void BeatW(int i, int j) {
		
		int CounterW = 0;
		
		if (Main.BlackCount < 1) {
			System.out.println("");
			System.out.println("Gracz numer 1 wygrywa!! Gratulacje!!");	
			System.exit(0);
		} else {
			CounterW++;
		}
		
		if (i == 1 ) { 
			System.out.println("");
			System.out.println("Gracz numer 1 wygrywa!! Gratulacje!!");	
			System.exit(0);
		} else {
			CounterW++;
		}
		
		if ((CounterW == 2)&&(Menu.Token == 0)) { 
			System.out.println("---------------------------------------------");
			BlackMove.ChosePawnB(); 
		} 
		
		if ((CounterW == 2)&&(Menu.Token == 2)) {
			System.out.println("---------------------------------------------");
			ComputerBlack.ComputerBlackPawn();
		}
	}
} 
