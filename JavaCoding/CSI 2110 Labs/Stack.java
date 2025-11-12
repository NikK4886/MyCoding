public interface Stack<E>{
	
	int size();
	
	boolean isEmpty();
	
	E top();
	
	void push(E Object);
	
	E pop();
	
	void forget(int k);
	
	
}