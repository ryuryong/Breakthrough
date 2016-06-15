package main;

import java.util.Random;

public class ComputerWhite {
	
	public static int i = 0, j = 0, Move = 0, MaxIW = 8, MaxJW = 8;

	public static void ComputerWhitePawn() {
		
		Random WComPawn = new Random();
		int i = (WComPawn.nextInt(MaxIW)+1);
		int j = (WComPawn.nextInt(MaxJW)+1);
		IfWhiteCom(i, j);
	}

	public static void IfWhiteCom(int i, int j){
		if (Board.board[i][j] != 'W') {
			ComputerWhitePawn();
		} else { 
			CheckMovesWCom(i, j);
		}
	}
	
	public static void CheckMovesWCom(int i, int j){
		
		int PossibleMoves = 5;
		
		if (Board.board[i-1][j-1] != '_') {				
			PossibleMoves--;
		} else {
			ChoseMoveWCom(i, j);
		}
		
		if (Board.board[i-1][j-1] != 'W') {
			PossibleMoves--;
		} else {
			ChoseMoveWCom(i, j);
		}
		
		if (Board.board[i-1][j] != '_') {
			PossibleMoves--;
		} else {
			ChoseMoveWCom(i, j);
		}
		
		if (Board.board[i-1][j+1] != '_') {
			PossibleMoves--;
		} else {
			ChoseMoveWCom(i, j);
		}
		
		if (Board.board[i-1][j+1] != 'W') {
			PossibleMoves--;
		} else {
			ChoseMoveWCom(i, j);
		}
		
		if (PossibleMoves == 0) {
			ComputerWhitePawn();
		}
	}
	
	public static void ChoseMoveWCom(int i, int j) {	
		
		Random RandMoveWCom = new Random();
		int MoveIntW = (RandMoveWCom.nextInt(3)+1);

		CheckMoveWCom(i, j, MoveIntW);
	}
	
	public static void CheckMoveWCom(int i, int j, int Move) {
		
		switch (Move){
			case 1 : {
				if ((Board.board[i-1][j-1] == '_')||(Board.board[i-1][j-1] == 'B')) {
					if (Board.board[i-1][j-1] == 'B') { Main.BlackCount--; }
					Board.board[i-1][j-1] = 'W';
					Board.board[i][j] = '_';
					Board.PrintBoard();
					BeatW(i-1, j-1);
				} else {
					ChoseMoveWCom(i, j);
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
					ChoseMoveWCom(i, j);
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
					ChoseMoveWCom(i, j);
				}
				break;
			}
			default : {
				ChoseMoveWCom(i, j);
			}
			break;
		}
	}
	public static void BeatW(int i, int j) {
		
		int CounterWCom = 0;
		
		if (Main.BlackCount < 1) { 
			System.out.println("");
			System.out.println("Gracz numer 1 wygrywa!! Gratulacje!!");
			System.exit(0);
		} else {
			CounterWCom++;
		}
		
		if (i == 1) { 
			System.out.println("");
			System.out.println("Gracz numer 1 wygrywa!! Gratulacje!!");
			System.exit(0);
		} else {
			CounterWCom++;
		}
		
		if ((CounterWCom == 2)&&(Menu.Token == 1)) { 
			System.out.println("---------------------------------------------");
			BlackMove.ChosePawnB(); 
		} 
		
		if ((CounterWCom == 2)&&(Menu.Token == 3)) {
			System.out.println("---------------------------------------------");
			ComputerBlack.ComputerBlackPawn();
		}
	}
} 