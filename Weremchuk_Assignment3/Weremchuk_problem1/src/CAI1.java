import java.security.SecureRandom; 
import java.util.Scanner;

public class CAI1 {
	
	Scanner input = new Scanner(System.in);
	int rand1;
	int rand2;
	int userAnswer;
	
	public static void main(String[] args) {
		
		CAI1 app = new CAI1 ();
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
		if (temp == 1)
		{
			System.out.println("Very good!");
			System.exit(1);
		}
		
	}
	
	void displayIncorrectResponse (int temp)
	{
		if (temp == 0)
		{
			System.out.println("No. Please try again.");
		}	
	}
}
