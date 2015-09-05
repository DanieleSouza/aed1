import java.lang.Math.*;

public class Calculadora {
	
	private Node first;


	public static class Node {
		Node next;
		float data;

		Node(float newData) {
			data = newData;
			next = null;
		}
	}

	public Calculadora() {
		first = null;

	}

	public void inteiro(float n) {
		Node aux = new Node (n);
		aux.next = first;
		first = aux;
	}

	public int contador() {
		return contador(first);
	}

	private int contador(Node p) {
		if(p==null) return 0;
		return 1 + contador(p.next);
	}

	public boolean soma() {
		//soma dos dois ultimos numeros
		if(contador()<=1) return false;
		else {
			float aux = first.next.data + first.data;
			pop();
			first.data = aux;
		}
		return true;
	}

	public boolean multiplicacao() {
		//multiplicacao entre os dois ultimos numeros
		if(contador()<=1) return false;
		else {
			float aux = first.next.data * first.data;
			pop();
			first.data = aux;
		}
		return true;
	}

	public boolean subtracao() {
		//subtracao entre os dois ultimos numeros
		if(contador()<=1) return false;
		else {
			float aux = first.next.data - first.data;
			pop();
			first.data = aux;
		}
		return true;
	}

	public boolean divisao() {
		//divisao entre os dois ultimos numeros
		if(contador()<=1) return false;
		else {
			float aux = first.next.data / first.data;
			pop();
			first.data = aux;
		}
		return true;
	}

	public float pop() {
		//descarta o ultimo resultado da calculadora
		float aux = first.data;
		first = first.next;
		return aux;
	}

	public void dup() {
		//repete o ultimo resultado
		inteiro(first.data);
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
		if(contador()==0) return false;
		else {
			float aux = (float) Math.sin(first.data);
			first.data = aux;
		}
		return true;
	}

	public boolean cos() {
		//calcula o cosseno do ultimo resultado
		if(contador()==0) return false;
		else {
			float aux = (float) Math.cos(first.data);
			first.data = aux;
		}
		return true;
	}

	public boolean atan() {
		//calcula o arco-tangente usando dois numero das pilha
		if(contador()==0) return false;
		else {
			float aux = (float) Math.atan2(first.next.data, first.data);
			first.data = aux;
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