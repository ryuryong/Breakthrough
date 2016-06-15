package main;

import java.util.Random;

public class ComputerBlack {
	
	public static int i = 0, j = 0, Move = 0, MaxI = 8, MaxJ = 8;

	public static void ComputerBlackPawn() {
		
		Random BCPawn = new Random();
		int i = (BCPawn.nextInt(MaxI)+1);
		int j = (BCPawn.nextInt(MaxJ)+1);
		IfBlackCom(i, j);
	}

	public static void IfBlackCom(int i, int j){
		if (Board.board[i][j] != 'B') {
			ComputerBlackPawn();
		} else { 
			CheckMovesBCom(i, j);
		}
	}
	
	public static void CheckMovesBCom(int i, int j){
		
		int PossibleMoves = 5;
		
		if (Board.board[i+1][j-1] != '_') {				
			PossibleMoves--;
		} else {
			ChoseMoveBCom(i, j);
		}
		
		if (Board.board[i+1][j-1] != 'W') {
			PossibleMoves--;
		} else {
			ChoseMoveBCom(i, j);
		}
		
		if (Board.board[i+1][j] != '_') {
			PossibleMoves--;
		} else {
			ChoseMoveBCom(i, j);
		}
		
		if (Board.board[i+1][j+1] != '_') {
			PossibleMoves--;
		} else {
			ChoseMoveBCom(i, j);
		}
		
		if (Board.board[i+1][j+1] != 'W') {
			PossibleMoves--;
		} else {
			ChoseMoveBCom(i, j);
		}
		
		if (PossibleMoves == 0) {
			ComputerBlackPawn();
		}
	}
	
	public static void ChoseMoveBCom(int i, int j) {	
		
		Random RandMoveBC = new Random();
		int MoveInt = (RandMoveBC.nextInt(3)+1);

		CheckMoveBCom(i, j, MoveInt);
	}
	
	public static void CheckMoveBCom(int i, int j, int Move) {
		
		switch (Move){
			case 1 : {
				if ((Board.board[i+1][j-1] == '_')||(Board.board[i+1][j-1] == 'W')) {
					if (Board.board[i+1][j-1] == 'W') { Main.WhiteCount--; }
					Board.board[i+1][j-1] = 'B';
					Board.board[i][j] = '_';
					Board.PrintBoard();
					BeatB(i+1, j-1);
				} else {
					ChoseMoveBCom(i, j);
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
					ChoseMoveBCom(i, j);
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
					ChoseMoveBCom(i, j);
				}
				break;
			}
			default : {
				ChoseMoveBCom(i, j);
			}
			break;
		}
	}
	public static void BeatB(int i, int j) {
		
		int CounterBCom = 0;
		
		if (Main.WhiteCount < 1) { 
			System.out.println("");
			System.out.println("Gracz numer 2 wygrywa!! Gratulacje!!");
			System.exit(0);
		} else {
			CounterBCom++;
		}
		
		if (i == 8) { 
			System.out.println("");
			System.out.println("Gracz numer 2 wygrywa!! Gratulacje!!");
			System.exit(0);
		} else {
			CounterBCom++;
		}
		
		if ((CounterBCom == 2)&&(Menu.Token == 2)) { 
			System.out.println("---------------------------------------------");
			WhiteMove.ChosePawnW(); 
		} 
		
		if ((CounterBCom == 2)&&(Menu.Token == 3)) {
			System.out.println("---------------------------------------------");
			ComputerWhite.ComputerWhitePawn();
		}
	}
} 


