// MATTEO PASCUZZO matricola 7072913.

package DoppiaCatenaCircolare;

public class Node<T> {
	
	private T info;
	private int key;  // deve essere compresa tra 1 e 10^6
	private Node<T> next;
	private Node<T> prev;
	
	public Node() {   //creo un nodo vuoto, scollegato, con chiave 0
		info = null;
		key = 0;
		next = null;
		prev = null;
	}
	
	public Node(T info, int key) {   //quando credo un nodo so subito cosa conterrà
		this.info = info;
		this.key = key;
	}
	
	
	public T getInfo() {
		return info;
	}
	
	public int getKey() {
		return key;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public Node<T> getPrev() {
		return prev;
	}
	
	public void setInfo(T i) {
		info = i;
	}
	
	public void setKey(int k) {
		key = k;
	}
	
	public void setNext(Node<T> n) {
		next = n;
	}
	
	public void setPrev(Node<T> p) {
		prev = p;
	}
	
	@Override
	public String toString() {
		String s = "[" + info + "," + key + "]";
		return s;
	}

}
