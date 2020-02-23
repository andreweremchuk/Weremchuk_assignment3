import java.security.SecureRandom; 
import java.util.Scanner;

public class CAI4 {
	
	Scanner input = new Scanner(System.in);
	int rand1;
	int rand2;
	int userAnswer;
	int difficulty;
	
	public static void main(String[] args) {
		
		CAI4 app = new CAI4 ();
		int score = 0;
		int temp;
		int choice2;
		
		do 
		{
			app.readDifficulty();
			
			for (int i = 0; i < 10; i++)
			{
				temp = app.quiz();

				if (temp == 1)
					{
						score++;
					}
			}	

			app.displayCompletionMessage(score);
			
			System.out.printf("Score is: %d%%\n", score*10);
			
			choice2 = app.exitOrRestart();
			
		} while (choice2 != 0);
		
	} 

	int quiz ()
	{
		int temp2;
		generateQuestionArgument();
		
		askQuestion();
		readResponse();
	    temp2 = isAnswerCorrect ();
		displayCorrectResponse(temp2);
		displayIncorrectResponse(temp2);
		
		return temp2;
	}
	
	void generateQuestionArgument ()
	{
		SecureRandom rand = new SecureRandom();
		
		if (this.difficulty == 1)
		{
			this.rand1 = rand.nextInt(10); 
			this.rand2 = rand.nextInt(10);
		}
		
		if (this.difficulty == 2)
		{
			this.rand1 = rand.nextInt(100); 
			this.rand2 = rand.nextInt(100);
		}
		
		if (this.difficulty == 3)
		{
			this.rand1 = rand.nextInt(1000); 
			this.rand2 = rand.nextInt(1000);
		}
		
		if (this.difficulty == 4)
		{
			this.rand1 = rand.nextInt(10000); 
			this.rand2 = rand.nextInt(10000);
		}
		 
	}
	
	void readDifficulty ()
	{
		System.out.println("Enter a difficulty 1-4: ");
		this.difficulty = input.nextInt();
		
		if (this.difficulty < 1 || this.difficulty > 4)
		{
			System.out.println("Invalid entry. Please reenter: ");
			readDifficulty ();
		}
	}
	
	int exitOrRestart ()
	{
		int choice2;
		
		System.out.println("0. Exit program: ");
		System.out.println("1. Solve another problem set: ");
		choice2 = input.nextInt();
		
		if (choice2 == 0)
		{
			System.exit(1);
		}
		
		return choice2;
	}
	
	void displayCompletionMessage (int score)
	{
		System.out.printf("Score is: %d%%\n", score*10);
		
		double overallScore = (double)score / 10;
		//System.out.println(overallScore);
		
		if (overallScore < .75)
		{
			System.out.println("Please ask your teacher for extra help.");
		}
		
		if (overallScore >= .75)
		{
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
	}
	
	void askQuestion ()
	{
		System.out.printf("What is %d x %d? ", rand1, rand2);
	}
	
	void readResponse ()
	{
		this.userAnswer = input.nextInt();
	}
	
	int isAnswerCorrect ()
	{
		int correctAnswer = this.rand1 * this.rand2;
		
		if (this.userAnswer == correctAnswer)
		{
			return 1;
		}
		
		else 
		{
			return 0;
		}
	}
	
	void displayCorrectResponse (int temp)
	{
		SecureRandom rand = new SecureRandom();
		int randomSwitchInt = rand.nextInt(4)+1;
		//System.out.println(randomSwitchInt);
		
		if (temp == 1)
		{
			switch (randomSwitchInt)
			{
				case 1: 
					System.out.println("Very good!");
					break;
				
				case 2:
					System.out.println("Excellent!");
					break;
					
				case 3:
					System.out.println("Nice work!");
					break;
					
				case 4:
					System.out.println("Keep up the good work!");
					break;
			}
			
		}
		
	}
	
	void displayIncorrectResponse (int temp)
	{
		SecureRandom rand = new SecureRandom();
		int randomSwitchInt = rand.nextInt(4)+1;
		
		if (temp == 0)
		{
			switch (randomSwitchInt)
			{
				case 1: 
					System.out.println("No. Please try again.");
					break;
				
				case 2:
					System.out.println("Wrong. Try once more.");
					break;
					
				case 3:
					System.out.println("Don’t give up!");
					break;
					
				case 4:
					System.out.println("No. Keep trying.");
					break;
			}
		}	
	}
	
}
