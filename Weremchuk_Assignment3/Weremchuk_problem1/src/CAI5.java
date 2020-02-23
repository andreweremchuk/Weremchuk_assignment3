import java.security.SecureRandom; 
import java.util.Scanner;

public class CAI5 {
	
	Scanner input = new Scanner(System.in);
	int rand1;
	int rand2;
	int userAnswer;
	int difficulty;
	int problemType;
	int randomCounter;
	
	public static void main(String[] args) {
		
		CAI5 app = new CAI5 ();
		int score = 0;
		int temp;
		int choice2;
		
		do 
		{
			app.readDifficulty();
			app.readProblemType();
			
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
		
		int questionReturn = askQuestion();
		readResponse();
	    temp2 = isAnswerCorrect (questionReturn);
		displayCorrectResponse(temp2);
		displayIncorrectResponse(temp2);
		
		return temp2;
	}
	
	void readProblemType ()
	{
		System.out.println("Please select a problem type.");
		System.out.println("Addition (1), Multiplication (2), Subtraction (3), Division (4), Mixed (5): ");
		
		this.problemType = input.nextInt();
		
		if (this.problemType < 1 || this.problemType > 5)
		{
			System.out.println("Invalid entry. Please reenter: ");
			readProblemType();
		}
		
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
	
	int askQuestion ()
	{
		if (this.problemType == 1)
		{
			System.out.printf("What is %d + %d? ", rand1, rand2);
			return 1;
		}
		
		if (this.problemType == 2)
		{
			System.out.printf("What is %d x %d? ", rand1, rand2);
			return 2;
		}
		
		if (this.problemType == 3)
		{
			System.out.printf("What is %d - %d? ", rand1, rand2);
			return 3;
		}
		
		if (this.problemType == 4)
		{
			System.out.printf("What is %d / %d? ", rand1, rand2);
			return 4;
		}
		
		if (this.problemType == 5)
		{
			SecureRandom rand = new SecureRandom();
			int randomSwitchInt = rand.nextInt(4);
			
			switch (randomSwitchInt)
			{
			
			case 0:
				System.out.printf("What is %d + %d? ", rand1, rand2);
				this.randomCounter = 0;
				break;
			
			case 1:
				System.out.printf("What is %d x %d? ", rand1, rand2);
				this.randomCounter = 1;
				break;
				
			case 2:
				System.out.printf("What is %d - %d? ", rand1, rand2);
				this.randomCounter = 2;
				break;
				
			case 3:
				System.out.printf("What is %d / %d? ", rand1, rand2);
				this.randomCounter = 3;
				break;
		
			}
			
			return 5;
			
		}
		
		return -1;
	}
	
	void readResponse ()
	{
		this.userAnswer = input.nextInt();
	}
	
	int isAnswerCorrect (int questionReturn)
	{
		int correctAnswer;
		
		if (questionReturn == 1)
		{
			correctAnswer = this.rand1 + this.rand2;
			
			if (this.userAnswer == correctAnswer)
			{
				return 1;
			}
			
			else 
			{
				return 0;
			}
		}
		
		if (questionReturn == 2)
		{
			correctAnswer = this.rand1 * this.rand2;
			
			if (this.userAnswer == correctAnswer)
			{
				return 1;
			}
			
			else 
			{
				return 0;
			}
		}
		
		if (questionReturn == 3)
		{
			correctAnswer = this.rand1 - this.rand2;
			
			if (this.userAnswer == correctAnswer)
			{
				return 1;
			}
			
			else 
			{
				return 0;
			}
		}
		
		if (questionReturn == 4)
		{
			correctAnswer = this.rand1 / this.rand2;
			
			if (this.userAnswer == correctAnswer)
			{
				return 1;
			}
			
			else 
			{
				return 0;
			}
		}
		
		if (questionReturn == 5)
		{
			if (this.randomCounter == 0)
			{
				correctAnswer = this.rand1 + this.rand2;
				
				if (this.userAnswer == correctAnswer)
				{
					return 1;
				}
				
				else 
				{
					return 0;
				}
			}
			
			if (this.randomCounter == 1)
			{
				correctAnswer = this.rand1 * this.rand2;
				
				if (this.userAnswer == correctAnswer)
				{
					return 1;
				}
				
				else 
				{
					return 0;
				}
			}
			
			if (this.randomCounter == 2)
			{
				correctAnswer = this.rand1 - this.rand2;
				
				if (this.userAnswer == correctAnswer)
				{
					return 1;
				}
				
				else 
				{
					return 0;
				}
			}
			
			if (this.randomCounter == 3)
			{
				correctAnswer = this.rand1 / this.rand2;
				
				if (this.userAnswer == correctAnswer)
				{
					return 1;
				}
				
				else 
				{
					return 0;
				}
			}
			
		}
		
	return -1;

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
