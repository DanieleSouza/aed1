/*
 *	-Heapsort 
 *	--Árvore binária
 *	---Max-Heap
 *	---Min-Heap
 *
 *		1) A raiz é o Nodo da posição 0
 *		2) O filho esquerdo do Nodo na posição i está na posição 2i+1
 *		3) O filho direito do Nodo na posição i está na posição 2i+2
 *		
 *		|3|1|4|1|5|9|2|6|5|3|5|
 *		 0 1 2 3 4 5 6 7 8 9 10
 *
 *					  3
 *				  -		  -
 *			  1 			  4
 *			-	-			-	-
 *		  1 	  5		  9	      2
 *		 - -	 - -
 *		6	5	3	5
 *
 *		Pai(i)=[(i-1)/2] (arredonda para baixo)
 *
 *		     		Heap 1 - O(n) onde n é o tamanho do vetor
 *
 *					  9
 *				  -		  -
 *			  6 			  4
 *			-	-			-	-
 *		  5 	  5		  3	      2
 *		 - -	 - -
 *		1	1	3	5
 *
 *			    "Escorregador" - O(n log n)
 *
 *					  1
 *				  -		  -
 *			  1 			  2
 *			-	-			-	-
 *		  3 	  3		  4	      5
 *		 - -	 - -
 *		5	5	6	9
 *
 *		MaxHeap (bloqueia quem já está no lugar certo)
 *
 *		|1|1|2|3|3|4|5|5|5|6|9|
 *		 0 1 2 3 4 5 6 7 8 9 10
 *
 *		|9|6|4|5|5|3|2|1|1|3|5|
 *		 0 1 2 3 4 5 6 7 8 9 10
 *
 * 		Ideias? Heap começando em outro lugar... "azeda" tudo!
 * 		As fórmulas antigas não servem mais... criar fórmulas novas...
 *		ligações novas...
 *
 *		O(n log n) é o custo do algoritmo
 *
 *		Plotar gráfico no gnuplot
 */

public class Heap {
	
}