public class Cashier{
	private ArrayQueue<Customer> queue;
	private Customer currentCustomer;
	private int totalCustomerWaitTime; 
	private int customersServed;
	private int totalItemsServed;
	
	@SuppressWarnings( "unchecked" )
	
	public Cashier(){
		this.queue = new ArrayQueue();
		this.totalCustomerWaitTime = 0;
		this.customersServed = 0;
		this.totalItemsServed = 0;
	}
	
	public void addCustomer(Customer c){
		queue.enqueue(c);
	}
	
	public int getQueueSize(){
		return queue.size();
	}
	
	public int getTotalCustomerWaitTime(){
		return totalCustomerWaitTime;
	}
	
	public int getTotalCustomersServed(){
		return customersServed;
	}
	
	public int getTotalItemsServed(){
		return totalItemsServed;
	}
	
	public void serveCustomers(int currentTime){
		if(getQueueSize() != 0){
			currentCustomer = queue.peek();
			int time = currentCustomer.getArrivalTime();
			
			currentCustomer.serve();
			totalItemsServed ++;
			
			int numOfItems = currentCustomer.getNumberOfItems();
			
			if(numOfItems == 0){
				customersServed = customersServed + 1;
				totalCustomerWaitTime = totalCustomerWaitTime + (currentTime - time);
				queue.dequeue();
			}
			
		}
	}
	
}