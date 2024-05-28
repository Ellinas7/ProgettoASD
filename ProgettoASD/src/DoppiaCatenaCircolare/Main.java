// MATTEO PASCUZZO matricola 7072913.

package DoppiaCatenaCircolare;

public class Main {

	public static void main(String[] args) {
		DoublyCircularLinkedList<Integer> DCLL = new DoublyCircularLinkedList<Integer>(1,1);
		DCLL.insertNode(2,9);
		DCLL.insertNode(1,2);
		DCLL.insertNode(1,4);
		DCLL.insertNode(1,5);
		DCLL.insertNode(1,6);
		DCLL.insertNode(3,2);
		DCLL.insertNode(1,8); 
		DCLL.insertNode(1,9);
		System.out.println(DCLL.toString());
		System.out.println(DCLL.findNode(5));
		System.out.println(DCLL.cercaPerValoreDiChiave(9));
		DCLL.cancellaNodo(9);
		System.out.println(DCLL.toString());
		DCLL.insertNode(1, 10);
		System.out.println(DCLL.toString());
		System.out.println(DCLL.stringaOrdinata(DCLL));
		System.out.println(DCLL.cercaPerValoreDiChiave(2));
		DCLL.insertNode(2, 10);
		System.out.println(DCLL.toString());
		System.out.println(DCLL.cercaPerValoreDiChiave(10));
	}

}
