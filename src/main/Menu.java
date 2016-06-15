package main;

import java.util.Scanner;
import java.util.Random;

public class Menu {
	
	public static int MenuChoice = 0, Token = 0;

	public static void MainMenu() {
			
		System.out.println("Witaj w grze BREAKTHROUGH\n");
		System.out.println();
		System.out.println("Wybierz rodzaj rozgrywki");
		System.out.println("1. 2 Graczy");
		System.out.println("2. Gracz vs. Komputer");
		//System.out.println("3. Tryb demo");
		System.out.println("4. Wyjœcie z gry");
		
		Scanner Choice = new Scanner(System.in);
		MenuChoice = Choice.nextInt();
		
		switch (MenuChoice) {
			case 1 : { HvH(); break; }
			case 2 : { HvC(); break; }
			//case 3 : { CvC(); break; }
			case 4 : {
				System.out.println("Zapraszamy ponownie do gry.");
				System.exit(0);
			}
			default : {
				System.out.println("B³êdny wybór - spróbuj ponownie");
				MainMenu();
			}
		}
	}	
	
	public static void HvH() {
		Token = 0;
		Board.Boards();
		Board.Start();
		Board.PrintBoard();
		System.out.println("---------------------------------------------");
		WhiteMove.ChosePawnW();
	}
	
	public static void HvC() {
		
		Random WorB = new Random();
		
		int ThrowWorB = WorB.nextInt(100);
		
		if (ThrowWorB < 50) {
			Token = 1;
			System.out.println("Gracz komputerowy gra bia³ymi");
			Board.Boards();
			Board.Start();
			Board.PrintBoard();
			ComputerWhite.ComputerWhitePawn();
		} else {
			Token = 2;
			System.out.println("Gracz komputerowy gra czarnymi");
			Board.Boards();
			Board.Start();
			Board.PrintBoard();
			WhiteMove.ChosePawnW();
		}
	}
	
	/* public static void CvC() {
			Token = 3;
			Board.Boards();
			Board.Start();
			Board.PrintBoard();
			ComputerWhite.ComputerWhitePawn();
		
	} */
}
