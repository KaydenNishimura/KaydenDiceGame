import java.util.Random;
import java.util.Scanner;

public class DiceGame {
	private static String [][]	Language;
	private static int lang = -1;
	
	public static void main(String[] args) {
	
	
		
		
		int die1;
		int die2;
		String[] playerChoices;
		Language = langlnlit();
		String langChoice = getInput("Select a language: \n[0]English\n[1]Hawaiian Pidgin\n[2]Chinese Mandarin");
		lang = Integer.parseInt(langChoice);
		die1 = roll();
		die2 = roll();
		String choice;
		choice = getInput(Language[lang][0]);
		//choice = getInput(Language[0][1]);
		choice = choice.toLowerCase();
		int count = 0;
		String playerCount = getInput(Language[lang][1]);
		count = Integer.parseInt(playerCount);
		playerChoices = new String[count];
		while(choice.equals(Language[lang][2])) {
			
			for(int c= 0; c < count; c++) {
			playerChoices[c] = getInput(Language[lang][3]+(c+1)+Language[lang][4]);
			
			}
			System.out.println(Language[lang][5]+die1+Language[lang][6]+die2);
			//Start a new loop here.
			for(int c=0; c<count;c++) {
				if(didIWin(die1,die2,playerChoices[c]))
				{
					System.out.println(Language[lang][3]+(c+1)+Language[lang][7]);
				}else
				{
					System.out.println(Language[lang][3]+(c+1)+Language[lang][8]);
				}
			}
			
			choice = getInput(Language[lang][9]);
			choice = choice.toLowerCase();
			die1 = roll();
			die2 = roll();
		}
	}
	private static boolean didIWin(int die1, int die2, String choice)
	{
		if((die1 + die2)%2==0 && choice.equals(Language[lang][10])) {
			return true;
		}
		if(( die1 + die2)%2==1 && choice.equals(Language[lang][11])) {
			return false;
		}
		return false;
	}
	
	private static String[][] langlnlit() {
		String[][] temp = new String[][] {
			//English floor 0
			{
				"Do you want to play?\nYes\nNo", 
				"How many players are there?",
				"yes",
				"Player ", ": [0] Even\n[1] Odd",
				"Die 1: ", "\nDie 2: ",
				" wins!" , 
				" loses!" , 
				"Do you want to play?\nYes\nNo", 
				"even",
				"odd"
				
			},
			//Hawaiian Pidgin 
			{
				"Like try brah?\nYessah\nNo need brah", 
				"How many guys get",
				"yessah",
				"Braddah ", ": [0] Even\n[1] Odd",
				"Die 1: ", "\nDie 2: ",
				" one winnah!" , 
				" nevah win!" , 
				"Like try brah?\nYessah\nNo need brah", 
				"even",
				"odd"
			},
			//Chinese
			{
				"你想玩吗?\n好啊\n不用了",
				"有多少人玩?",
				"好啊",
				"玩家 ", ": [0] 偶\n[1] 奇",
				"骰子 1: ", "\n骰子 2: ",
				" 赢了!" ,
				" 输了!" ,
				"你想玩吗?\n好啊\n不用了",
				"偶",
				"奇"
			}
			
		};
		return temp;
	}
	
	private static int roll()
	{
		return roll(6,1);
	}
	private static int roll(int sides,int start) {
		Random roller = new Random();
		return roller.nextInt(sides)+start;
	}
	private static String getInput(String text) {
		Scanner input = new Scanner(System.in);
		String choice = "";
		try 
		{
			System.out.println(text);
			choice = input.nextLine();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return choice;
	}
	
	private static boolean isInputInteger(String input) {
		boolean isAnInteger = true;
		for(int c = 0; c < input.length();c++) {
			char letter = input.charAt(c);
			//'-' is 45 '0 - 9' 48 - 57
			if(c!=0 &&!(letter >= 48 && letter<= 57))
			{
				isAnInteger = false;
			}else if(letter != 45 && !(letter >= 48 && letter <= 57))
			{
				isAnInteger = false;
			}
		}
		return isAnInteger;
	}
}
