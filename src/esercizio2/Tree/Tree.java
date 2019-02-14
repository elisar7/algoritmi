package Tree;

import Sorting.Sorting;

import java.util.ArrayList;
import java.util.Comparator;

public class Tree<T> {

    private Node root;

    public Tree (){
        this.root = null;
    }

    public Tree(T data) {
        this.root = new Node(data);
    }

    public Tree(Node root) {
        this.root = root;
    }

    /*
     * Aggiunge un figlio all'elemento specificato (parent)
     */
    public void add(Node child, T parent) throws Exception {
        if (this.root == null)
            this.root = child;
        else {
            add(this.root, child, parent);
        }
    }

    /*
    *   Metodo ausiliario del metodo add
    */
    private void add(Node root, Node child, T parent) throws Exception {
        if (root.getChild() != null)
            add(root.getChild(), child, parent);
        if (root.getData().equals(parent)) {
            root.addChild(child);
        }
        if (root.getBrother() != null)
            add(root.getBrother(), child, parent);
    }

    /*
     * Restituisce true se l'albero è binario, false altrimenti
     */
    public Boolean isBin (){
        return (this.maxGrade() <= 2);
    }

    /*
    * Costruisce l'albero binario di ricerca, trasformando l'albero corrente in una lista,
    * che viene poi ordinata in modo da inserire gli elementi in un nuovo albero, che sarà binario,
    * nell'ordine corretto.
    */
    public Tree binarySearchTree(Comparator cmp) {
        ArrayList<T> treeList = new ArrayList<T>();
        this.treeToList(this.root, treeList);
        Sorting.quickSort(treeList, cmp);
        Tree bSTree = new Tree(new Node<T>());
        binaryAdder(bSTree.root, treeList, 0, treeList.size() - 1);
        return bSTree;
    }

    /*
     * Trasforma l'albero in una lista.
     */
    private void treeToList(Node<T> root, ArrayList<T> treeList) {
        if (root.getChild() != null)
            treeToList(root.getChild(), treeList);
        treeList.add(root.getData());
        if (root.getBrother() != null)
            treeToList(root.getBrother(), treeList);
    }


    /*
     * Aggiunge un elemento all'albero binario.
     */
    private void binaryAdder(Node<T> root, ArrayList<T> treeList, int i, int j) {
        if (i >= 0 && j < treeList.size()) {
            int k = (i + j + 1) / 2;
            root.setData(treeList.get(k));
            Node<T> left = new Node(null, root);
            Node<T> right = new Node(null, root);
            root.addChild(left);
            left.setBrother(right);
            if (i <= (k - 1))
                binaryAdder(left, treeList, i, k - 1);
            if (k + 1 <= j)
                binaryAdder(right, treeList, k + 1, j);
        }
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /*
    *   Restituisce il numero di nodi presenti nell'albero
    */
    public int size() {
        return size(root);
    }

    private int size(Node<T> root) {
        if (root.getChild() != null && root.getBrother() != null)
            return 1 + size(root.getChild()) + size(root.getBrother());
        if (root.getChild() != null)
            return 1 + size(root.getChild());
        if (root.getBrother() != null)
            return 1 + size(root.getBrother());
        return 1;
    }

    /*
    *   Restituisce il grado massimo dell'albero
    */
    public int maxGrade() {
        return maxGrade(this.root);
    }

    private int maxGrade(Node<T> root) {
        if (root.getChild() != null && root.getBrother() != null)
            return Math.max(root.getGrade(),
                    Math.max(maxGrade(root.getBrother()), maxGrade(root.getChild())));
        if (root.getChild() != null)
            return Math.max(root.getGrade(), maxGrade(root.getChild()));
        if (root.getBrother() != null)
            return maxGrade(root.getBrother());
        return 0;
    }

    /*
    *   Restituisce la profondità dell'albero
    */
    public int depth() {
        return depth(this.root);
    }

    private int depth(Node<T> root) {
        if (root.getChild() != null && root.getBrother() != null)
            return Math.max(1 + depth(root.getChild()), depth(root.getBrother()));
        if (root.getChild() != null)
            return 1 + depth(root.getChild());
        if (root.getBrother() != null)
            return depth(root.getBrother());
        return 0;
    }

}


