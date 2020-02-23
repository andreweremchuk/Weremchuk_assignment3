
public class SavingsAccountTest {
	
	public static void main(String[] args) 
	{
		SavingsAccount saver1 = new SavingsAccount(2000);
		SavingsAccount saver2 = new SavingsAccount(3000);
		SavingsAccount.modifyInterestRate(4.0);
		
		System.out.println("Annual interest rate 4%");
		for (int i = 1; i < 13; i++)
		{
			saver1.calculateMonthlyInterest();
			System.out.print("Before interest: ");
			System.out.print("Month " + i + ": ");
			saver1.print();
			System.out.print("After interest: ");
			saver2.calculateMonthlyInterest();
			saver2.print();
			System.out.println();
		}
		
		System.out.println();
		SavingsAccount.modifyInterestRate(5.0);
		
		System.out.println("Annual interest rate 5%");
		
			saver1.calculateMonthlyInterest();
			System.out.print("Month " + 13  + ": ");
			saver1.print();
			
			System.out.print("After interest: ");
			saver2.calculateMonthlyInterest();
			saver2.print();
	}
	
	

}
