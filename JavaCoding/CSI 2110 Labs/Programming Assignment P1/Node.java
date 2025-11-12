public class Node<E>{

	private E element;
	private Node<E> next = null;
	private Partition.Cluster<E> set = null;
	
	public Node(E e){
		element = e;
	}
	
	public E getElement(){return element;}
	
	public Node<E> getNext(){return next;}
	
	public Partition.Cluster<E> getCluster(){return set;}
	
	public void setElem(E elem){
		element = elem;
	}

	public void setNext(Node<E> newNext){
		next = newNext;
	}
	
	public void setCluster(Partition.Cluster<E> c){
		set = c;
	}
	
}