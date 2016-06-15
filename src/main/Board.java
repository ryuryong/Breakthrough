package main;

public class Board {												 

	public static char[][] board = new char[10][10];				
	
	public static void Boards(){
		
			board[0][1] = 'a'; 		board[9][1] = 'a';				
			board[0][2] = 'b';		board[9][2] = 'b';
			board[0][3] = 'c';		board[9][3] = 'c';
			board[0][4] = 'd';		board[9][4] = 'd';
			board[0][5] = 'e';		board[9][5] = 'e';
			board[0][6] = 'f';		board[9][6] = 'f';
			board[0][7] = 'g';		board[9][7] = 'g';
			board[0][8] = 'h';		board[9][8] = 'h';
			board[1][0] = '8';		board[1][9] = '8';
			board[2][0] = '7';		board[2][9] = '7';
			board[3][0] = '6';		board[3][9] = '6';
			board[4][0] = '5';		board[4][9] = '5';
			board[5][0] = '4';		board[5][9] = '4';
			board[6][0] = '3';		board[6][9] = '3';
			board[7][0] = '2';		board[7][9] = '2';
			board[8][0] = '1';		board[8][9] = '1';
		
	}
	
	public static void Start(){ 									
				
		Main.BlackCount = 16;
		Main.WhiteCount = 16;
		
		for (int i = 1; i < 3; i++) {
			for (int j = 1; j < 9; j++){
				board[i][j] = 'B';
			}
		}
		
		for (int i = 3; i < 7; i++) {
			for (int j = 1; j < 9; j++){
				board[i][j] = '_';
			}
		}		
		
		for (int i = 7; i < 9; i++) {
			for (int j = 1; j < 9; j++){
				board[i][j] = 'W';
			}
		}
	}
	
	public static void PrintBoard(){ 								
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				System.out.print("  " + board[i][j] + "  ");
			}	
			System.out.println("");
			System.out.println("");			
		}
	}		
}