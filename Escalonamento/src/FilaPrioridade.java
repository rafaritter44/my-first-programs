import java.util.LinkedList;
import java.util.Queue;

public class FilaPrioridade {

	private class Nodo {
		public Nodo next;
		public Queue<Processo> fila;

		public Nodo() {
			next = null;
			fila = new LinkedList<Processo>();
		}

	}

	private Nodo head, tail;

	public FilaPrioridade() {
		head = null;
		tail = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public Processo consulta() {
		
		if(head == null)
			return null;
		
		return head.fila.element();
		
	}
	
	public Processo remove(Processo p) {

		if(head.fila.element().getPrioridade() == p.getPrioridade()) {
			head.fila.remove(p);
			if(head.fila.isEmpty())
				head = head.next;
		}
		
		else {
			
			Nodo ant = head, aux = head.next;
			while(aux.fila.element().getPrioridade() != p.getPrioridade()) {
				ant = aux;
				aux = aux.next;
			}
			aux.fila.remove(p);
			if(aux.fila.isEmpty()) {
				ant.next = aux.next;
				if(aux == tail)
					tail = ant;
			}
		}
		
		return p;
	}

	public Processo remove() {

		if(head == null)
			return null;
		
		Processo p = head.fila.remove();
		
		if(head.fila.isEmpty())
			head = head.next;
		
		return p;

	}

	public void insereOrdenado(Processo p) {

		if(head == null) {
			Nodo nodo = new Nodo();
			head = nodo;
			tail = nodo;
			nodo.fila.add(p);
			return;
		}

		if(p.getPrioridade() < head.fila.element().getPrioridade()) {
			Nodo nodo = new Nodo();
			nodo.next = head;
			head = nodo;
			nodo.fila.add(p);
			return;
		}
		
		if(p.getPrioridade() == head.fila.element().getPrioridade()) {
			head.fila.add(p);
			return;
		}

		if(p.getPrioridade() > tail.fila.element().getPrioridade()) {
			Nodo nodo = new Nodo();
			tail.next = nodo;
			tail = nodo;
			nodo.fila.add(p);
			return;
		}
		
		if(p.getPrioridade() == tail.fila.element().getPrioridade()) {
			tail.fila.add(p);
			return;
		}

		Nodo aux = head;

		while(aux.next != null) {
			
			if(p.getPrioridade() < aux.next.fila.element().getPrioridade()) {
				Nodo nodo = new Nodo();
				nodo.next = aux.next;
				aux.next = nodo;
				break;
			}
			
			if(p.getPrioridade() == aux.next.fila.element().getPrioridade()) {
				aux.next.fila.add(p);
				break;
			}
			
			aux = aux.next;
		}
	}
}
