import java.util.Random;
import java.util.Scanner;
public class Blackjack
{
	static int userCard;
	static int dealerCard;
	static int dealerTotal = 0;
	static int userTotal = 0;
	static int dealerAceCounter;
	static int userAceCounter;
	static boolean replay = true;
	static Random random = new Random();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args)
	{	
		while(replay)
		{	
			userTotal = 0;
			dealerTotal = 0;
			userAceCounter = 0;
			dealerAceCounter = 0;
			userHand();
			userHand();
			if(userTotal == 21)
			{
				System.out.println("Congrats, you natural a 21.");
			}
			blankSpace();
			userHit();
			blankSpace();
			if(!(userTotal >= 21))
			{
				dealerHand();
				dealerHand();
				dealerHit();
				winner();
			}
			blankSpace();
			playAgain();
		}
	}

	public static void userHand()
	{
		int userCard = random.nextInt(13) + 1;
		switch(userCard)
		{
			case 11:
				System.out.println("User drew a Jack");
				userTotal += 10;
				System.out.println("User current total: " + userTotal);
				break;
			case 12:
				System.out.println("User drew a Queen");
				userTotal += 10;
				System.out.println("User current total: " + userTotal);
				break;
			case 13:
				System.out.println("User drew a King");
				userTotal += 10;
				System.out.println("User current total: " + userTotal);
				break;
			case 1:
				System.out.println("User drew an Ace");
				userTotal += 11;
				userAceCounter += 1;
				System.out.println("User current total: " + userTotal);
				break;
			default:
				System.out.println("User drew a " + userCard);
				userTotal += userCard;
				System.out.println("User current total: " + userTotal);
		}
	}
	
	public static void dealerHand()
	{
		dealerCard = random.nextInt(13) + 1;
		switch(dealerCard)
		{
			case 11:
				System.out.println("Dealer drew a Jack");
				dealerTotal += 10;
				System.out.println("Dealer current total: " + dealerTotal);
				break;
			case 12:
				System.out.println("Dealer drew a Queen");
				dealerTotal += 10;
				System.out.println("Dealer current total: " + dealerTotal);
				break;
			case 13:
				System.out.println("Dealer drew a King");
				dealerTotal += 10;
				System.out.println("Dealer current total: " + dealerTotal);
				break;
			case 1:
				System.out.println("Dealer drew an Ace");
				dealerTotal +=  11;
				dealerAceCounter += 1;
				System.out.println("Dealer current total: " + dealerTotal);
				break;
			default:
				System.out.println("Dealer drew a " + dealerCard);
				dealerTotal  += dealerCard;
				System.out.println("Dealer current total: " + dealerTotal);
		}
	}
	
	public static void userHit()
	{
		while(userTotal < 21)
		{	
			System.out.println("Would you like to hit?");
			String userInputValidationHit = scanner.nextLine();
			while(!userInputValidationHit.equalsIgnoreCase("Yes") && !userInputValidationHit.equalsIgnoreCase("no"))
			{
				System.out.println("Please enter either: Yes or no.");
				userInputValidationHit = scanner.nextLine();
			}
			if(userInputValidationHit.equalsIgnoreCase("yes"))
			{
				userHand();
			}
			else
			{
				break;
			}
		}
		if(userTotal > 21 && userAceCounter >= 1)
		{
			userTotal -= 10;
			System.out.println("User new total is " + userTotal + " to best fit the hand");
		}
		if(userTotal > 21)
		{
			System.out.println("User busted: " + userTotal);
			dealerWinMessage();
		if(userTotal == 21)
		{
			userWinMessage();
		}
		}
	}
	
	public static void dealerHit()
	{
		while(dealerTotal < 17 && userTotal < 21)
		{
			dealerHand();
		}
		if(dealerTotal > 21 && dealerAceCounter >= 1)
		{
			dealerTotal -= 10;
			System.out.println("Dealer new total is " + dealerTotal + " to best fit the hand");
		}
		if(dealerTotal > 21)
		{
			System.out.println("Dealer busted: " + dealerTotal);
			userWinMessage();
		}
	}
	
	public static void winner()
	{
		if(dealerTotal > userTotal && dealerTotal <= 21)
		{
			dealerWinMessage();
		}
		if(dealerTotal < userTotal && userTotal <= 21)
		{
			userWinMessage();
		}
		if(dealerTotal == userTotal)
		{
			System.out.println("It is a draw.");
		}
	}
	
	public static void playAgain()
	{
		System.out.println("Do you want to play again?");
		String replayQuestion = scanner.nextLine();
		while(!replayQuestion.equalsIgnoreCase("Yes") && !replayQuestion.equalsIgnoreCase("No"))
		{	
			System.out.println("Please enter either: Yes or No.");
			replayQuestion = scanner.nextLine();
		}
		if(replayQuestion.equalsIgnoreCase("no"))
		{
			replay = false;
		}
	}

	public static void userWinMessage()
	{
		System.out.println("Congrats, you won.");
	}
	
	public static void dealerWinMessage()
	{
		System.out.println("Dealer wins.");
	}
	
	public static void blankSpace()
	{
		System.out.println("");
	}
}