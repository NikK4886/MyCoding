public class Account{

	private double balance;
	
	public Account(){
		this.balance = 0.0;
	}
	
	public void deposit(double n){
		balance = balance + n;
		System.out.println("New balance: " +balance); 
	}
	
	public void withdraw(double n){
		
		
		if(n > balance){
			System.out.println("you have not enough money to withdraw " + n + "$");
			throw new NotEnoughMoneyException(n,balance);
		}
		else{
			this.balance = balance - n;
			System.out.println("New balance: " +balance); 
		}
	}
	
	public double getBalance(){
		return balance;
	}
}