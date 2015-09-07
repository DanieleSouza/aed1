import java.lang.Math.*;

public class Calculadora {
	
	private Node first;
	int cont, max;

	public static class Node {
		Node next;
		double data;

		Node(double newData) {
			data = newData;
			next = null;
		}
	}

	public Calculadora() {
		first = null;
		cont = 0;
		max = 0;
	}

	public void push(double n) {
		Node aux = new Node (n);
		aux.next = first;
		first = aux;
		cont++;
		if (cont > max) max = cont;
	}

	public int cont() {
		return cont;
	}

	public int max() {
		return max;
	}

	public double peek() {
		return first.data;
	}
/*
	public int cont() {
		return cont(first);
	}

	private int cont(Node p) {
		if(p==null) return 0;
		return 1 + cont(p.next);
	}
*/
	public boolean soma() {
		//soma dos dois ultimos numeros
		if(cont()<=1) return false;
		else push(pop() + pop());
		return true;
	}

	public boolean multiplicacao() {
		//multiplicacao entre os dois ultimos numeros
		if(cont()<=1) return false;
		else push(pop() * pop());
		return true;
	}

	public boolean subtracao() {
		//subtracao entre os dois ultimos numeros
		if(cont()<=1) return false;
		else push(pop() - pop());
		return true;
	}

	public boolean divisao() {
		//divisao entre os dois ultimos numeros
		if(cont()<=1) return false;
		else push(pop() / pop());
		return true;
	}

	public double pop() {
		//descarta o ultimo resultado da calculadora
		double aux = first.data;
		first = first.next;
		cont--;
		return aux;
	}

	public void dup() {
		//repete o ultimo resultado
		push(first.data);
	}

	public void swap() {
		//troca de ordem os dois ultimos resultados
		Node aux = first;
		first = first.next;
		aux.next = first.next;
		first.next = aux;
	}

	public boolean sin() {
		//calcula o seno do ultimo resultado
		if(cont()==0) return false;
		else first.data = (double) Math.sin(first.data);
		return true;
	}

	public boolean cos() {
		//calcula o cosseno do ultimo resultado
		if(cont()==0) return false;
		else first.data = (double) Math.cos(first.data);
		return true;
	}

	public boolean atan() {
		//calcula o arco-tangente usando dois numero das pilha
		if(cont()==0) return false;
		else {
			double aux = (double) Math.atan2(pop(), pop());
			push(aux);
		}
		return true;
	}

	public void print() {
		print("", first);
	}

	private void print(String s, Node n) {
		if(n==null) System.out.println(s);
		else print(s + "\n" + n.data, n.next);
	}
}