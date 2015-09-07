import java.util.Scanner;
import java.io.*;

public class Teste {
	
	public static void main (String[] args) {
		Calculadora calc = new Calculadora();
		System.out.println("A calculadora foi criada");
		Scanner input = new Scanner(System.in);

		while(input.hasNext()) {
			String temp = input.next();

			if(temp.equals("quit")) System.exit(0);
			if(temp.matches("[0-9]+")) calc.push(Integer.parseInt( temp));
			if(temp.equals("contador")) System.out.println("A calculadora possui " + calc.cont() + " números armazenados");
			if(temp.equals("+")) calc.soma();
			if(temp.equals("*")) calc.multiplicacao();
			if(temp.equals("-")) calc.subtracao();
			if(temp.equals("/")) calc.divisao();
			if(temp.equals("sin")) calc.sin();
			if(temp.equals("cos")) calc.cos();
			if(temp.equals("atan")) calc.atan();
			if(temp.equals("dup")) calc.dup();
			if(temp.equals("pop")) System.out.println("O número " + calc.pop() + " foi removido da calculadora");
			if(temp.equals("swap")) calc.swap();
			if(temp.equals("estatisticas")) {
				System.out.println("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-");
				System.out.println("Tamanho final máximo atingido pela pilha: " + calc.max());
				System.out.println("Tamanho final da pilha: " + calc.cont());
				System.out.println("Valor no topo da pilha: " + calc.peek());
				System.out.println("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-");
			}

			calc.print();
		}
	}

}