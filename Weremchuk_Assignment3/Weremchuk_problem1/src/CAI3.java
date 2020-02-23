import java.security.SecureRandom; 
import java.util.Scanner;

public class CAI3 {
	
	Scanner input = new Scanner(System.in);
	int rand1;
	int rand2;
	int userAnswer;
	
	public static void main(String[] args) {
		
		CAI3 app = new CAI3 ();
		int score = 0;
		int temp;
		int choice2;
		
		do 
		{
			for (int i = 0; i < 10; i++)
			{
				//System.out.println("entered for loop");
				app.quiz();
				//System.out.println("entered do loop");
				app.askQuestion();
				app.readResponse();
			    temp = app.isAnswerCorrect ();
				app.displayCorrectResponse(temp);
				app.displayIncorrectResponse(temp);

				if (temp == 1)
					{
						score++;
					}
			}	
			
			app.displayCompletionMessage(score);
			
			choice2 = app.exitOrRestart();
			
		} while (choice2 != 0);
		
	} 

	void quiz ()
	{
		SecureRandom rand = new SecureRandom();
		this.rand1 = rand.nextInt(10); 
		this.rand2 = rand.nextInt(10); 

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
