import java.security.SecureRandom; 
import java.util.Scanner;

public class CAI2 {
	
	Scanner input = new Scanner(System.in);
	int rand1;
	int rand2;
	int userAnswer;
	
	public static void main(String[] args) {
		
		CAI2 app = new CAI2 ();
		int temp;
		app.quiz();	
		
		do 
		{
			app.askQuestion();
			app.readResponse();
		    temp = app.isAnswerCorrect ();
			app.displayCorrectResponse(temp);
			app.displayIncorrectResponse(temp);
		}
		while (temp != 1);
		
	} 

	public void quiz ()
	{
		SecureRandom rand = new SecureRandom();
		this.rand1 = rand.nextInt(10); 
		this.rand2 = rand.nextInt(10); 

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
			
			System.exit(1);
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
					System.out.println("Don�t give up!");
					break;
					
				case 4:
					System.out.println("No. Keep trying.");
					break;
			}
		}	
	}
	
}
