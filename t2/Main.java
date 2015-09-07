import java.io.*;

public class Main {
	
	public static void main (String[] args) {
		long startTime = System.nanoTime();
		//codigo aqui
		
		Calculadora calc = new Calculadora();
		System.out.println("A calculadora foi criada");

		try (BufferedReader br = new BufferedReader(new FileReader("x7.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       	if(line.equals("quit")) System.exit(0);
				if(line.matches("[0-9]+")) calc.push(Integer.parseInt(line));
				if(line.equals("contador")) System.out.println("A calculadora possui " + calc.cont() + " números armazenados");
				if(line.equals("+")) calc.soma();
				if(line.equals("*")) calc.multiplicacao();
				if(line.equals("-")) calc.subtracao();
				if(line.equals("/")) calc.divisao();
				if(line.equals("sin")) calc.sin();
				if(line.equals("cos")) calc.cos();
				if(line.equals("atan")) calc.atan();
				if(line.equals("dup")) calc.dup();
				if(line.equals("pop")) System.out.println("O número " + calc.pop() + " foi removido da calculadora");
				if(line.equals("swap")) calc.swap();

				//calc.print();
				//System.out.println(line);
			}
			System.out.println("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-");
			System.out.println("Tamanho final máximo atingido pela pilha: " + calc.max());
			System.out.println("Tamanho final da pilha: " + calc.cont());
			System.out.println("Valor no topo da pilha: " + calc.peek());
			System.out.println("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-");
			
			long estimatedTime = System.nanoTime() - startTime;
			double s = (double)estimatedTime / 1000000000.0;
			System.out.println("Time: " + s + " segundos");
		}
	    catch (FileNotFoundException e){
		    System.out.println(e);
		}
		catch (IOException e){
		    System.out.println(e);
		}
	}
}