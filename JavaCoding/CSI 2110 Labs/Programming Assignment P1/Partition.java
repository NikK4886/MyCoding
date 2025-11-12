import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Partition<E> {
	
	public static class Cluster<E>{
		Node<E> head, tail;
		E leader;
		int size;
		
		Cluster(Node<E> node){
			this.head = this.tail = Objects.requireNonNull(node, "seed node");
			this.size = 1;
			this.leader = head.getElement();
		}	
	}
	
	private final Map<E, Node<E>> clusterMap = new HashMap<>();
	
	public Node<E> makeCluster(E x){
		
		if (clusterMap.containsKey(x)) throw new IllegalArgumentException("Element already present: " + x);
		
		Node<E> node = new Node<>(x);
		Cluster<E> cluster = new Cluster<>(node);
		node.setCluster(cluster);
		clusterMap.put(x, node);
		
		return cluster.head;
		
	}
	
	public void union(Node<E> p, Node<E> q){
		if (p.getCluster() == null || q.getCluster() == null)
			throw new NoSuchElementException("Node(s) does not exist in a cluster.");

		Cluster<E> clustP = p.getCluster();
		Cluster<E> clustQ = q.getCluster();

		if (clustP == clustQ) return;

		Cluster<E> big, small;
		if (clusterSize(clustP.head) >= clusterSize(clustQ.head)) {
			big = clustP;
			small = clustQ;
		} else {
			big = clustQ;
			small = clustP;
		}

		big.tail.setNext(small.head);
		big.tail = small.tail;      
		big.size += small.size;

		Node<E> current = small.head;
		while (current != null) {   
			current.setCluster(big);
			current = current.getNext();
		}
	}


	public Node<E> find(Node<E> p){
		
		if (p.getCluster() == null) throw new NoSuchElementException("Node does not exist in a cluster.");
		Cluster<E> tempClust = p.getCluster();
	
		return tempClust.head;
		
	}
	
	public E element(Node<E> p){
		return p.getElement();
	}
	
	public int numberOfClusters(){
		java.util.HashSet<Cluster<E>> uniq = new java.util.HashSet<>();
		for (Node<E> n : clusterMap.values()) {
			Cluster<E> c = n.getCluster();
			if (c != null) uniq.add(c);
		}
		return uniq.size();
	}
	
	public int clusterSize(Node<E> p){
		if (p.getCluster() == null) throw new NoSuchElementException("Node does not exist in a cluster.");
		Cluster<E> tempClust = p.getCluster();
		return tempClust.size;
	}
	
	public Node<E>[] clusterPositions(Node<E> p){

		int temp = clusterSize(p);
		
		if (p.getCluster() == null) throw new NoSuchElementException("Node does not exist in a cluster.");
		Cluster<E> tempClust = p.getCluster();
		
		Node<E> current = tempClust.head;
		
		@SuppressWarnings("unchecked")
		Node<E>[] arry = (Node<E>[]) new Node[temp];
		
		for(int i = 0; i<temp; i++){
			arry[i] = current;
			current = current.getNext();
		}
		
		return arry;
		
	} 
	
	public int[] clusterSizes(){
		java.util.HashSet<Cluster<E>> uniq = new java.util.HashSet<>();
		for (Node<E> n : clusterMap.values()) {
			Cluster<E> c = n.getCluster();
			if (c != null) uniq.add(c);
		}
		int[] arry = new int[uniq.size()];
		int i = 0;
		for (Cluster<E> c : uniq) arry[i++] = c.size;
		return arry;
	}
	
}