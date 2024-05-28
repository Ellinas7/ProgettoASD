// MATTEO PASCUZZO matricola 7072913.

package DoppiaCatenaCircolare;

public class DoublyCircularLinkedList<T> {
	
	private Node<T> HEAD;
	private int numeroNodi = 0;
	
	
	public DoublyCircularLinkedList(T info, int key) {   //la catena nasce già col nodo HEAD
		if(key >= 1 && key <= Math.pow(10, 6)) {
			HEAD = new Node<T>();
			HEAD.setInfo(info);
			HEAD.setKey(key);
			HEAD.setNext(HEAD);
			HEAD.setPrev(HEAD);
			numeroNodi++;
		} else {
			System.out.println("inserire un valore di chiave compreso fra 1 e 10^6");
		}
	}
	
	
	public int numeroElementiPresenti() { //ad ogni inserimento o cancellazione aumento o diminuisco il numero dei nodi
		return numeroNodi;
	}
	
	
	public Node<T> firstNode() {
		return HEAD;
	}
	
	
	public Node<T> lastNode() {
		return HEAD.getPrev();
	}
	
	
	public Node<T> findNode(int i) {
		Node<T> temp = HEAD;
		if(i >= 1 && i <= numeroNodi) {
			int contatore = 1;
			while(contatore < i) {
				temp = temp.getNext();
				contatore++;
			}
		} else {
			System.out.println("ci sono solo " + numeroNodi + " nodi");
		}
		return temp;
	}
	
	
	public void cancellaNodo(int k) {
		//non ci sono nodi con chiave k
		if(contaNodiConChiaveK(k) == 0) {   
			System.out.println("non ci sono nodi con questa chiave");
		}
		
		//se l'unico nodo da cancellare è HEAD
		if(contaNodiConChiaveK(k) == 1 && HEAD.getKey() == k) {
			deleteNode(HEAD);     
			HEAD = findNode(2);        
			numeroNodi--;                 
		}
		
		//il nodo da cancellare è solo uno e non è HEAD
		if(contaNodiConChiaveK(k) == 1) {
			cancellaNodoDestra(k);
		}
		
		//c'è più di un nodo da cancellare 
		if (contaNodiConChiaveK(k) > 1) {
			//uno dei più nodi da cancellare è HEAD --> devo cancellare quello più vicino
			if (HEAD.getKey() == k) {
				if (distanzaDaDestra(k) > distanzaDaSinistra(k)) {
					cancellaNodoSinistra(k);
				} else {
					cancellaNodoDestra(k);
				}
			}
			//nessuno dei nodi da cancellare è HEAD
			if (HEAD.getKey() != k) {
				
				if (distanzaDaSinistra(k) < distanzaDaDestra(k)) {
					cancellaNodoSinistra(k);
					
				} else if (distanzaDaDestra(k) < distanzaDaSinistra(k)) {
					cancellaNodoDestra(k);
					
				} else if (distanzaDaDestra(k) == distanzaDaSinistra(k)) {
					cancellaNodoDestra(k);
					cancellaNodoSinistra(k);
				}
			}
		}
	}
	
	
	public void insertNode(T x, int k) {
		Node<T> newNode = new Node<T>(x,k);
		boolean inserimentoPossibile = true;
		 //controllo che non ci siano chiavi uguali a quella che voglio inserire
		for(Node<T> n = HEAD.getNext(); n != HEAD; n = n.getNext()) {
			if(n.getInfo() == newNode.getInfo() && n.getKey() == newNode.getKey()) {
				inserimentoPossibile = false;
			}
		}
		if(inserimentoPossibile) {
			HEAD.getNext().setPrev(newNode);
			newNode.setNext(HEAD.getNext());
			HEAD.setNext(newNode);
			newNode.setPrev(HEAD);
			numeroNodi++;
		} else {
			System.out.println("impossibile inserire 2 nodi identici");
		}
	}
	
	
	@Override
	public String toString() {
		Node<T> temp = HEAD;
		String S = HEAD.toString();
		while(temp.getNext() != HEAD) {
			temp = temp.getNext();
			S = S + "," + temp.toString();
		}
		return S;
	}
	
	
	public String stringaOrdinata(DoublyCircularLinkedList<T> DCLL) {
		bubbleSortList(DCLL);
		String ordinamento = DCLL.toString();
		return ordinamento;
	}
	
	
	public String cercaPerValoreDiChiave(int k) {
		String nodiCercati = null;
		//non ci sono nodi con chiave k
		if(contaNodiConChiaveK(k) == 0) {
			nodiCercati = "non esistono nodi con valore di chiave " + k + ".";
		}
		//c'è un solo nodo con chiave k
		if(contaNodiConChiaveK(k) == 1) {
			for(Node<T> n = HEAD.getNext(); n != HEAD; n = n.getNext()) {
				if(n.getKey() == k) {
					nodiCercati = n.toString();
				}
			}
		}
		//ci sono più nodi con chiave k
		if(contaNodiConChiaveK(k) > 1) {
			if(distanzaDaDestra(k) < distanzaDaSinistra(k)) {
				int distanza = distanzaDaDestra(k);
				Node<T> temp = HEAD;
				while(distanza > 0) {
					temp = temp.getNext();
					distanza--;
				}
				nodiCercati = temp.toString();
			} else if(distanzaDaDestra(k) > distanzaDaSinistra(k)) {
				int distanza = distanzaDaSinistra(k);
				Node<T> temp = HEAD;
				while(distanza != 0) {
					temp = temp.getPrev();
					distanza--;
				}
				nodiCercati = temp.toString();
			} else if(distanzaDaDestra(k) == distanzaDaSinistra(k)) {
				int distanza = distanzaDaDestra(k);
				Node<T> temp1 = HEAD;
				Node<T> temp2 = HEAD;
				while(distanza != 0 && temp1.getKey() != k && temp2.getKey() != k) {
					temp1 = temp1.getNext();
					temp2 = temp2.getPrev();
					distanza--;
				}
				nodiCercati = temp1.toString() + temp2.toString();
			}
		}
		return nodiCercati;
	}
	
	
	////////// METODI DI SERVIZIO/////////////
	
	private void deleteNode(Node<T> n) {    //slaccia un nodo collegando il prec e il next tra loro
			n.getNext().setPrev(n.getPrev());
			n.getPrev().setNext(n.getNext());
	}
	
	
	private int distanzaDaDestra(int k) {  //trova la distanza tra HEAD e il nodo da cancellare scorrendo la catena verso destra
		int distanza = 0;
		Node<T> temp = HEAD;
		while(temp.getKey() != k) {
			distanza++;
			temp = temp.getNext();
		}
		return distanza;
	}
	
	
	private int distanzaDaSinistra(int k) {  //trova la distanza tra HEAD e il nodo da cancellare scorrendo la catena verso sinistra
		int distanza = 0;
		Node<T> temp = HEAD;
		while(temp.getKey() != k) {
			distanza++;
			temp = temp.getPrev();
		}
		return distanza;
	}
	
	
	private int contaNodiConChiaveK(int k) {  //conta i nodi con il valore di chiave k 
		int contatore = 0;
		Node<T> temp = HEAD;
		while(temp != lastNode()) {
			if(temp.getKey() == k) {
				contatore++;
			}
			temp = temp.getNext();
		}
		if(lastNode().getKey() == k) {
			contatore++;
		}
		return contatore;
	}
	
	private void cancellaNodoDestra(int k) { //scorre verso destra di quanto necessario e cancella il primo nodo con chiave k
		int distanza = distanzaDaDestra(k);
		Node<T> temp = HEAD;
		while(distanza > 0) {
			temp = temp.getNext();
			distanza--;
		}
		deleteNode(temp);
		numeroNodi--;
	}
	
	private void cancellaNodoSinistra(int k) { //scorre verso sinistra di quanto necessario e cancella il primo nodo con chiave k
		int distanza = distanzaDaSinistra(k);
		Node<T> temp = HEAD;
		while (distanza > 0) {
			temp = temp.getPrev();
			distanza--;
		}
		deleteNode(temp);
		numeroNodi--;
	}
	
	
	private void bubbleSortList(DoublyCircularLinkedList<T> c) {
		boolean swapped = true;
		while(swapped) {
			swapped = false;
			for(Node<T> n = c.HEAD; n != c.lastNode(); n = n.getNext()) {
				if(n.getKey() > n.getNext().getKey()) {
					swapped = true;
					int knTemp = n.getKey();
					T inTemp = n.getInfo();
					int knextTemp = n.getNext().getKey();
					T inextTemp =n.getNext().getInfo();
					n.setKey(knextTemp);
					n.setInfo(inextTemp);
					n.getNext().setKey(knTemp);
					n.getNext().setInfo(inTemp);
				}
			}
		}
	}

}
