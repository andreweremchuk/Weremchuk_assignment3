
public class SavingsAccount {
	
	static double annualInterestRate;
	private double savingsBalance;

	public SavingsAccount(double total)
	{
		this.savingsBalance = total;  
	}
	
	public void calculateMonthlyInterest ()
	{
		this.savingsBalance += (this.savingsBalance * (SavingsAccount.annualInterestRate/100)) / 12;
	}
	
	public static void modifyInterestRate(double iN)
	{
		SavingsAccount.annualInterestRate = iN;
	}
	
	void print ()
	{
		System.out.println(this.savingsBalance);
	}
}
