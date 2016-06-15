package main;

import java.util.Scanner;

public class BlackMove {
	
	public static int i = 0, j = 0, Move = 0;

	public static void ChosePawnB() {
		
		System.out.println("Wybierz czarny pionek (np 2c)");
		
		Scanner BPawn = new Scanner(System.in);
		String PawnLoc = BPawn.nextLine();
		if (PawnLoc.length() < 2) {
			System.out.println("B³êdny wyór, spróbuj ponownie");
			ChosePawnB();
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
					ChosePawnB();
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
					ChosePawnB();
					break;
				}
			}
		}
		IfBlack(i, j);
	}

	public static void IfBlack(int i, int j){
		if (Board.board[i][j] != 'B') {
			System.out.println("Wybrane pole nie zawiera czarnego pionka");
			ChosePawnB();
		} else { 
			CheckMovesB(i, j);
		}
	}
	
	public static void CheckMovesB(int i, int j){
		
		int PossibleMoves = 5;
		
		if (Board.board[i+1][j-1] != '_') {				
			PossibleMoves--;
		} else {
			ChoseMoveB(i, j);
		}
		
		if (Board.board[i+1][j-1] != 'W') {
			PossibleMoves--;
		} else {
			ChoseMoveB(i, j);
		}
		
		if (Board.board[i+1][j] != '_') {
			PossibleMoves--;
		} else {
			ChoseMoveB(i, j);
		}
		
		if (Board.board[i+1][j+1] != '_') {
			PossibleMoves--;
		} else {
			ChoseMoveB(i, j);
		}
		
		if (Board.board[i+1][j+1] != 'W') {
			PossibleMoves--;
		} else {
			ChoseMoveB(i, j);
		}
		
		if (PossibleMoves == 0) {
			System.out.println("Brak mo¿liwych ruchów dla wybranego pionka, wybierz ponownie");
			ChosePawnB();
		}
	}
	
	public static void ChoseMoveB(int i, int j) {	
		
		System.out.println("Wybierz ruch: 1. = Dó³ lewo");
		System.out.println("              2. = Dó³");
		System.out.println("              3. = Dó³ prawo");
		
		Scanner MoveB = new Scanner(System.in);
		String MoveString = MoveB.nextLine();
		switch (MoveString) {
			case "1" : Move = 1; break;
			case "2" : Move = 2; break;
			case "3" : Move = 3; break;
			default : 	{
				System.out.println("B³êdny wybór, spróbuj ponownie");
				ChoseMoveB(i, j);
				break;
			}
		}
		CheckMoveB(i, j, Move);
	}
	
	public static void CheckMoveB(int i, int j, int Move) {
		
		switch (Move){
			case 1 : {
				if ((Board.board[i+1][j-1] == '_')||(Board.board[i+1][j-1] == 'W')) {
					if (Board.board[i+1][j-1] == 'W') { Main.WhiteCount--; }
					Board.board[i+1][j-1] = 'B';
					Board.board[i][j] = '_';
					Board.PrintBoard();
					BeatB(i+1, j-1);
				} else {
					System.out.println("Niedozwolony ruch, wybierz ponownie");
					ChoseMoveB(i, j);
				}
				break;
			}
			case 2 : {
				if (Board.board[i+1][j] == '_') {
					Board.board[i+1][j] = 'B';
					Board.board[i][j] = '_';
					Board.PrintBoard();
					BeatB(i+1, j);
				} else {
					System.out.println("");
					System.out.println("Niedozwolony ruch, wybierz ponownie");
					ChoseMoveB(i, j);
				}
				break;
			}
			case 3 : {
				if ((Board.board[i+1][j+1] == '_')||(Board.board[i+1][j+1] == 'W')) {
					if (Board.board[i+1][j+1] == 'W') { Main.WhiteCount--; }
					Board.board[i+1][j+1] = 'B';
					Board.board[i][j] = '_';
					Board.PrintBoard();
					BeatB(i+1, j+1);
				} else {
					System.out.println("Niedozwolony ruch, wybierz ponownie");
					ChoseMoveB(i, j);
				}
				break;
			}
			default : {
				System.out.println("Podano nieprawid³ow¹ opcjê, wybierz ponownie");
				ChoseMoveB(i, j);
			}
			break;
		}
	}
	public static void BeatB(int i, int j) {
		
		int CounterB = 0;
		
		if (Main.WhiteCount < 1) { 
			System.out.println("");
			System.out.println("Gracz numer 2 wygrywa!! Gratulacje!!");
			System.exit(0);
		} else {
			CounterB++;
		}
		
		if (i == 8) { 
			System.out.println("");
			System.out.println("Gracz numer 2 wygrywa!! Gratulacje!!");
			System.exit(0);
		} else {
			CounterB++;
		}
		
		if ((CounterB == 2)&&(Menu.Token == 0)) { 
			System.out.println("---------------------------------------------");
			WhiteMove.ChosePawnW(); 
		} 
		
		if ((CounterB == 2)&&(Menu.Token == 1)) {
			System.out.println("---------------------------------------------");
			ComputerWhite.ComputerWhitePawn();
		}
	}
}
