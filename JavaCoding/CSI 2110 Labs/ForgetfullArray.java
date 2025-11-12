public class ForgetfullStack<E> implements Stack<E>{
	public class Node<E>;
	
		private E object;
		private Node<E> next;
		
		public Node(){
			this(null,null);
		}
	
		public Node(E obj, Node<E> n){
			object = obj;
			next = n;
		}
	
		public E getObject() {
			return object; 
		}
		
		public Node<E> getNext() { 
			return next;
		}
		 
		public void setObject(E newObj) { 
			object = newObj; 
		}
		
		public void setNext(Node<E> newNext) {
			next = newNext; 
		}
	
	private int sz;
	private Node<E> head;
	
	public int size(){
		return sz;
	}
	
	public boolean isEmpty(){
		return(head.getNext() == null);
	}
	
	public E top(){
		if(isEmpty()){
			return null; 
		}
		else{
			return head.getNext;
		}
	}
	
	public void 
}