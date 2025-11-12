import java.util.Random;

public class Customer{
	private int arrivalTime;
	private int initialNumberOfItems;
	private int numberOfItems;
	private int MAX_NUM_ITEMS;
	
	Random generator = new Random();
	
	public Customer(int arrivalTime){
		this.arrivalTime = arrivalTime;
		this.MAX_NUM_ITEMS = 500;
		this.initialNumberOfItems = generator.nextInt(MAX_NUM_ITEMS-1)+1;
		this.numberOfItems = 0;
	}
	
	public int getArrivalTime(){
		return arrivalTime;
	}
	
	public int getNumberOfItems(){
		return initialNumberOfItems;
	}
	
	public int getNumberOfServedItems(){
		return numberOfItems;
	}
	
	public void serve(){
		initialNumberOfItems--;
		numberOfItems++;	
	}
	
}