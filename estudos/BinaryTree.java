import java.util.ArrayList;

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

  public void emOrdem() {
    emOrdem(root);
  }

  private void emOrdem(Node p) {
    if(p == null) return;
    emOrdem(p.left);
    System.out.print(p.data + " ");
    emOrdem(p.right);
  }

  public void emOrdemReversa() {
    emOrdemReversa(root);
  }

  private void emOrdemReversa(Node p) {
    if(p == null) return;
    emOrdemReversa(p.right);
    System.out.print(p.data + " ");
    emOrdemReversa(p.left);
  }

  public void espelho() {
    espelho(root);
  }

  private void espelho(Node p) {
    if(p == null) return;
    Node aux = p.left;
    p.left = p.right;
    p.right = aux;
    espelho(p.left);
    espelho(p.right);
  }

  public void copy(BinaryTree b) {
    this.destroy();
    copy(b, b.root);
  }

  private void copy(BinaryTree b, Node p) {
    if(p == null) return;
    this.insere(p.data);
    copy(b, p.left);
    copy(b, p.right);
  }

  public boolean hasRep() {
    ArrayList<Integer> lista = new ArrayList<>();
    return hasRep(root, lista);
  }

  private boolean hasRep(Node p, ArrayList<Integer> lista) {
    if(p == null) return false;
    if(lista.contains(p.data)) return true;
    lista.add(p.data);
    if(hasRep(p.left, lista)) return true;
    if(hasRep(p.right, lista)) return true;
    return false;
  }

  public void join(BinaryTree b, BinaryTree c) {
    this.destroy();
    ArrayList<Integer> lista = new ArrayList<>();
    join(b, b.root, c, c.root, lista);
  }

  private void join(BinaryTree b, Node nb, BinaryTree c, Node nc, ArrayList<Integer> lista) {
    if(nb == null) return;
    if(!lista.contains(nb.data)) {
      this.insere(nb.data);
      lista.add(nb.data);
    }
    if(nc == null) return;
    if(!lista.contains(nc.data)) {
      this.insere(nc.data);
      lista.add(nc.data);
    }
    join(b, nb.left, c, nc.left, lista);
    join(b, nb.right, c, nc.right, lista);
  }


  //max

  public void destroy() {
    root = destroy( root );
  }

  private Node destroy(Node n) {
    if(n == null)return n;          
    n.right = destroy(n.right);
    n.left = destroy(n.left);
    System.out.println(n.data + ": AAAAAAH!");
    return null;
  }

  public int profundidade() {
     return profundidade(root, 0) - 1;
  }
  
  private int profundidade(Node n, int p) {
      if(n == null) return p;
      int x = profundidade(n.right, p+1);
      int y = profundidade(n.left, p+1);
      if(x > y) return x;
      return y;
  }
  
}