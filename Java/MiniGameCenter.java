import java.util.Scanner;
import java.util.Random;

public class Main
{
	//creating objects
	static GuessTheNumber guessTheNumber = new GuessTheNumber();
	static TicTacToe ticTacToe = new TicTacToe();
	static Scanner sc = new Scanner(System.in);
	
	//main function
	public static void main(String args[])
	{
		int gameChoice;
		
		System.out.print("Mini Game Center!\n--------------------\nGames Available\n\t1 -> Tic Tac Toe\n\t2 -> Guess The Number\n--------------------\nEnter the index of the corresponding game you want to play : ");
		gameChoice = sc.nextInt();
		startGame(gameChoice);
	}
	
	//starts the desired game
	static void startGame(int gameNum)
	{
		switch(gameNum)
		{
			case 1:
				ticTacToe.game();
				break;
			case 2:
				guessTheNumber.game();
				break;
			default:
				System.out.println("Invalid input <" + gameNum + ">");
		}
	}
}

class GuessTheNumber
{
	//creating objects
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	
	//variables
	int number, guess, attempts = 10, lowerLimit = 0, upperLimit = 1000;
	boolean win = false;
	
	//constructor
	GuessTheNumber()
	{
		number = randomizeNumber();
	}
	
	//randomizes the number
	int randomizeNumber()
	{
		return random.nextInt(upperLimit + 1);
	}
	
	//checks whether the number is high or low
	String highOrLow(int num)
	{
		if(num > number + 250)
		return "Way too high!";
		else if(num > number + 100)
		return "Too high!";
		else if(num > number)
		return "High!";
		else if(num < number - 250)
		return "Way too low!";
		else if(num < number - 100)
		return "Too low!";
		else if(num < number)
		return "Low!";
		else
		return "Equal!";
	}
	
	//main function
	void game()
	{
		attempts -= 1;
		
		System.out.print("Guess The Number!\n--------------------\nYou have 10 attempts to guess a number between 0 and 1000\n--------------------\nWhat's your guess? ");
		guess = sc.nextInt();
		System.out.println("--------------------");
		while(attempts > 0)
		{
			if(highOrLow(guess) != "Equal!")
			{
				System.out.println(highOrLow(guess) + "\n--------------------");
				System.out.println("You have " + attempts + " attempts left!\n--------------------");
				System.out.print("What's your guess? ");
				guess = sc.nextInt();
				System.out.println("--------------------");
				attempts -= 1;
			}
			else
			{
				System.out.println("You Won!\n--------------------");
				win = true;
				break;
			}
		}
		if(!win)
		{
			System.out.println("You Lost :(\n--------------------");
		}
	}
	
}

class TicTacToe
{
	//creating objects
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	
	//declaring variables
	char c1S, p1S, winner = '-', b[] = {'1','2','3','4','5','6','7','8','9'}, symbols[] = {'X','O'};
	int randomNum, cNum, userNum, turn = 1, spotsLeft[] = {1,2,3,4,5,6,7,8,9}, winCases[][] = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
	String Board;
	
	//constructor
	TicTacToe()
	{
		randomNum = random.nextInt(2);
		
		//assigning specific symbols to each of the two players
		p1S = symbols[randomNum];
		
		if(randomNum == 0)
		c1S = symbols[1];
		else
		c1S = symbols[0];
	}
	
	//returning the board in the form of a string
	String board()
	{
		Board = "";
		for(int i = 0;i <= 8;i++)
		{
			Board += " " + b[i] + " ";
			if(i == 2 | i == 5)
			Board += "\n-----------\n";
			else
			Board += "|";
		}
		Board += "\n";
		return Board;
	}
	
	//player 1's turn
	void p1(int pos)
	{
		for(int i = 0;i <= 8;i++)
		{
			if(spotsLeft[i] == pos)
			{
				spotsLeft[i] = 0;
				b[i] = p1S;
				turn = 2;
				break;
			}
		}
	}
	
	//computer's turn
	void computer()
	{
		cNum = random.nextInt(9) + 1;
		for(int i = 0;i <= 8;i++)
		{
			if(spotsLeft[i] == cNum)
			{
				spotsLeft[i] = 0;
				b[i] = c1S;
				turn = 1;
				break;
			}
		}
	}
	
	//checks whether a player won or not
	boolean checkGameEnd()
	{
		for(int i = 0; i <= 7;i++)
		{
			if(b[winCases[i][0]] ==  b[winCases[i][1]] && b[winCases[i][0]] == b[winCases[i][2]] && b[winCases[i][1]] == b[winCases[i][2]])
			{
				winner = b[winCases[i][0]];
				return true;
			}
		}
		return false;
	}
	
	//main function
	void game()
	{
		System.out.println("--------------------\nTic Tac Toe\n--------------------\n\n" + board() + "\n\n--------------------");
		
		while(true)
		{
			while(turn == 1)
			{
				System.out.print("Enter a positioning index : ");
				userNum = sc.nextInt();
				p1(userNum);
			}
			System.out.println("--------------------\n" + board() + "--------------------\n");
			
			while(turn == 2)
			computer();
			System.out.println("Computer choosed index " + cNum + "\n--------------------\n\n" + board() + "\n\n--------------------\n");
			
			if(checkGameEnd())
			{
				if(winner == p1S)
				System.out.println("You Win!\n\n--------------------");
				else
				System.out.println("Computer Wins!\n\n--------------------");
				break;
			}
		}
	}
	
}