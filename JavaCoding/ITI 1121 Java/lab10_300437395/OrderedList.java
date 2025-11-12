import java.util.NoSuchElementException;
import java.util.*;

public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

      	private Comparable value;
      	private Node previous;
      	private Node next;

      	private Node ( Comparable value, Node previous, Node next ) {
      	    this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}
    }

    // Instance variables

    private Node head;
	

    // Representation of the empty list.

    public OrderedList() {
        
		this.head = null;
		
    }

    // Calculates the size of the list

    public int size() {
      	int size = 0;
		
		

		if(head == null){
			return size;
		}
		
		Node temp = head;
		
		while(temp != null){
			size++;
			temp = temp.next;
			
		}
		return size;
    }


    public Object get( int pos ) {
		
		if(pos<0 || this.size() == 0){
			throw new IndexOutOfBoundsException();
		}
		
		
        Object ans;
		Node temp = head;
		
		for(int i = 0; i<pos; i++){
			temp = temp.next;
		}
		
		ans = (Object) temp.value;
		return ans;
		
    }

    // Adding an element while preserving the order

    public boolean add( Comparable o ) {
		
		if(o == null){
			throw new IllegalArgumentException();
		}
		
		Node temp;
		Node tempPrev; 
		Node tempNext;
		
		//Adds element
        if(head == null){
			head = new Node (o,null,null);
			return true;
		}
		temp = head;
		tempPrev = null;
		while(temp != null){
			tempPrev = temp;
			temp = temp.next;
		}
		
		tempPrev.next = new Node(o, tempPrev, null);
		
		
		//Sorts the list
		temp = head;
		Comparable tempComp = null; 
		int num; 
		
		for(int i = 1; i<this.size();i++){
			num = temp.value.compareTo(temp.next.value);
			if(num > 0){
				tempComp = temp.value;
				temp.value = temp.next.value;
				temp.next.value = tempComp;
			}
			else if(num == 0){
				return false;
			} 
			temp = temp.next;
		}
		
		
		return true;
		
    }

    //Removes one item from the position pos.

    public void remove( int pos ) {
		
		if(pos<0 || this.size() == 0){
			throw new IndexOutOfBoundsException();
		}
		
		Node temp = head;
		Node tempPrev = null;
		Node tempNext = null;
		
		if(pos == 0){
			tempNext = temp.next;
			if(tempNext == null){
				this.head = null;
			}
			else{
				this.head = new Node(tempNext.value,null,tempNext.next);
			}
			
		}
		else{
			for(int i = 0; i<pos; i++){
				tempPrev = temp;
				temp = temp.next;
				tempNext = temp.next;
			}
			
			tempPrev.next = tempNext;
		}
    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge( OrderedList other ) {
		Node otherTemp = other.head;
		while(otherTemp != null){
			this.add(otherTemp.value);
			otherTemp = otherTemp.next;
		}
	  
    }
	
}