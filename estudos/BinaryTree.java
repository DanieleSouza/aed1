// BinaryTree.java
public class BinaryTree {

  // Referência para a raiz da árvore. É null para o caso de uma
  // árvore vazia.

  private Node root;

  private static class Node {
    Node left;
    Node right;
    int data;

    Node( int newData ) {
      left = right = null;
      data = newData;
    }
  }

  /* Cria uma árvore vazia, ou seja, uma referência nula. */
  public BinaryTree() {
    root = null;
  }

  public void insere(int val) {
    root = insere(root, val);
  }

  private Node insere(Node p, int val) {
    if(p == null) return new Node(val);
    if(p.data >= val) p.left = insere(p.left, val);
    if(p.data < val) p.right = insere(p.right, val);
    return p;
  }

  public void imprime() {
      imprime(root, "");
  }

  private void imprime(Node p, String s) {
      if(p == null) return;
      imprime(p.right, s + "\t");
      System.out.println(s + p.data);
      imprime(p.left, s + "\t");
  }

  public boolean existe(int val) {
      return existe(root, val);
  }

  private boolean existe(Node p, int val) {
      if(p == null) return false;
      if(p.data == val) return true;
      if(p.data > val) return existe(p.left, val);
      if(p.data < val) return existe(p.right, val);
      return false;
  }

  public int altura() {
      return altura(root) - 1;
  }

  private int altura(Node p) {
    if(p == null) return 0;
    int e = altura(p.left);
    int d = altura(p.right);
    if(e > d) return e + 1;
    return d + 1;
  }

  public int numNodos() {
    return numNodos(root);
  }  

  private int numNodos(Node p) {
    if(p == null) return 0;
    int e = numNodos(p.left);
    int d = numNodos(p.right);
    return e + d + 1;
  }

  public int pai(int val) {
    if(root == null) return -1;
    if(root.data == val) return -1;
    return pai(root, val);
  }

  private int pai(Node p, int val) {
    if(p.left != null) {
      if(p.left.data == val) return p.data;
      if(p.data > val) return pai(p.left, val);
    }
    if(p.right != null) {
      if(p.right.data == val) return p.data;
      if(p.data < val) return pai(p.right, val);
    }
    return -1;
  }

  public int soma() {
    return soma(root);
  }

  private int soma(Node p) {
    if(p == null) return 0;
    int e = soma(p.left);
    int d = soma(p.right);
    return e + d + p.data;
  }

  public int conta(int val) {
    return conta(root, val, 0);
  }

  private int conta(Node p, int val, int n) {
    if(p == null) return 0;
    if(p.data == val) {
      n += 1;
      if(p.left == null || p.left.data != val) return n;
    }

    if(p.data >= val) return conta(p.left, val, n);
    if(p.data < val) return conta(p.right, val, n);

    return n;
  }

  public int numPares() {
    return numPares(root);
  }

  private int numPares(Node p) {
    if(p == null) return 0;
    if(p.data%2==0) return 1 + numPares(p.left) + numPares(p.right);
    return numPares(p.left) + numPares(p.right);
  }

  public int filhosDir() {
    return filhosDir(root);
  }

  private int filhosDir(Node p) {
    if(p == null) return 0;
    if(p.right != null) return 1 + filhosDir(p.left) + filhosDir(p.right);
    return filhosDir(p.left) + filhosDir(p.right);
  }






  //max

  public void destroy( ) {
    root = destroy( root );
  }

  private Node destroy( Node n ) {
    if(n == null)return n;          
    n.right = destroy (n.right);
    n.left = destroy (n.left);
    System.out.println(n.data + ": AAAAAAH!");
    return null;
  }

  public int profundidade(){
     return profundidade(root, 0) - 1;
  }
  
  private int profundidade( Node n, int p){
      if( n == null) return p;
      int x = profundidade( n.right, p+1);
      int y = profundidade( n.left, p+1);
      if(x > y) return x;
      return y;
  }
  
}