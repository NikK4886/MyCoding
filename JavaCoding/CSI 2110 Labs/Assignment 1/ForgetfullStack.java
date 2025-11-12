public class ForgetfullStack<E> implements Stack<E>{
	public class Node<E>;
	
		private E object;
		private Node<E> next;
		private Node<E> prev;
		
		public Node(){
			this(null,null,this);
		}
	
		public Node(E obj, Node<E> n, Node<E> p){
			object = obj;
			next = n;
			prev = p;
		}
	
		public E getObject() {
			return object; 
		}
		
		public Node<E> getNext() { 
			return next;
		}
		
		public Node<E> getPrev() { 
			return prev;
		}
		 
		public void setObject(E newObj) { 
			object = newObj; 
		}
		
		public void setNext(Node<E> newNext) {
			next = newNext; 
		}
		
		public void setPrev(Node<E> newPrev) {
			next = newPrev; 
		}
	
	int sz = 0;
	Node<String> head;
	Node<String> dummy;
	
	head.setPrev(dummy);
	head.setNext(dummy);
	
	dummy.setPrev(head);
	dummy.setNext(head);
	
	public int size(){
		return sz;
	}
	
	public boolean isEmpty(){
		return(head.getNext() == dummy);
	}
	
	public E top(){
		if(isEmpty()){
			return null; 
		}
		else{
			return head.getNext;
		}
	}
	
	public void push(E Object){
		Node<String> temp = new Node<>(Object, null);
		if(isEmpty()){
			head.setNext(temp);
			dummy.setPrev(temp);
			temp.setNext(dummy);
			sz++;
		}
		else{
			Node<String> current = head.getNext;
			temp.setNext(current);
			current.setPrev(temp);
			head.setNext(temp);
			sz ++;
		}
		
	}
	
	public E pop(){
		if(isEmpty()){
			return null;
		}
		else{
			Node<String> current = head.getNext;
			head.setNext(current.getNext);
			current.getNext.setPrev(head); 
			sz --;
		}
		
	}
	
	public void forget(int k){
		for(int i = 0; i<k; i++){
			if(sz<=0){return;}
			
			else{
				Node<String> temp = dummy.getPrev;
				dummy.setPrev(temp.getPrev);
			}
		}
	}
	
	public static void main(String [] args){
		ForgetfullStack s = new ForgetfullStack();
		
		s.push("A");
		s.push("B");
		s.push("C");
		s.push("D");
		s.push("E");
		s.push("F");
		s.pop();
		s.forget(2);
	}
}