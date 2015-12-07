import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    System.out.println("Olá!");
    BinaryTree tree = new BinaryTree();

    Scanner input = new Scanner(System.in);

    while(input.hasNext()) {
      String temp = input.next();

      if(temp.equals("quit")) System.exit(0);
      if(temp.matches("insere")){
        tree.insere(Integer.parseInt(input.next()));
      }
      if(temp.matches("existe")){
        System.out.println(tree.existe(Integer.parseInt(input.next())));
      }
      if(temp.matches("altura")){
        System.out.println(tree.altura());
      }
      if(temp.matches("nodos")){
        System.out.println(tree.numNodos());
      }
      if(temp.matches("pai")){
        System.out.println(tree.pai(Integer.parseInt(input.next())));
      }
      if(temp.matches("soma")){
        System.out.println(tree.soma());
      }
      if(temp.matches("conta")){
        System.out.println(tree.conta(Integer.parseInt(input.next())));
      }
      if(temp.matches("pares")){
        System.out.println(tree.numPares());
      }
      if(temp.matches("direita")){
        System.out.println(tree.filhosDir());
      }

      tree.imprime();
      System.out.println();
    }
  }
}