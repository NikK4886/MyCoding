import java.util.*;
public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
        // Your code here.
		if(capacity<DEFAULT_INC){
			this.elems = (E[]) new Object[DEFAULT_INC];
		}
		else{
			this.elems = (E[]) new Object[capacity];
		}
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {
		if(this.isEmpty()){
			throw new EmptyStackException();
		}
        return elems[ top-1 ];
    }

    @SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {
        // Your code here.
		if(this.isEmpty()){
			throw new EmptyStackException();
		}
		E saved = elems[--top];
		elems[top] = null;
		
		int count = 0;
		int cap = this.getCapacity();
		E[] temp;
		
		for(int i = 0; i<cap;i++){
			if(elems[i] == null){
				count++;
			}
		}
		if(!this.isEmpty()){
			while(count>=DEFAULT_INC){
				cap = this.getCapacity();
				temp = (E[]) new Object[cap-DEFAULT_INC];
				for(int i = 0; i<cap;i++){
					if(elems[i] != null){
						temp[i] = elems[i];
					}
				}
				this.elems = temp;
				count = count - DEFAULT_INC;
			}
		}
		
		return saved;
    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {
        // Your code here.
		int numElem = 0;
		int cap = this.getCapacity();
		
		for(int i = 0; i<cap; i++){
			if(elems[i] != null){
				numElem++;
			}
		}
		if(numElem == cap){
			E[] temp = (E[]) new Object[cap+DEFAULT_INC];
			for(int i = 0; i<cap; i++){
				temp[i] = elems[i];
			}
			temp[top++] = element;
			this.elems = temp;
		}
		else{
			elems[top++] = element;
		}
		
    }

    @SuppressWarnings( "unchecked" )

    public void clear() {
        // Your code here.
		while(!this.isEmpty()){
			this.pop();
		}
    }
}