package UnionFind;

import java.util.HashMap;


public class UnionFind<T> {

    private HashMap<T, UFNode<T>> node;

    public UnionFind() {
        this.setNode(new HashMap<T, UFNode<T>>());
    }

    /*
     * Crea un nuovo insieme il cui unico elemento (e rappresentante) e' x
     */
    public void makeSet(T x) {
        getNode().put(x, new UFNode<T>(x, 0));
    }

    /*
     * Trova il rappresentante dell'insieme a cui x appartiene, con la compressione del cammino.
     */
    public T findSet(T x) {
        UFNode<T> node = getNode().get(x);
        if (node == null) {
            return null;
        }
        if (x != node.getParent()) {
            node.setParent(findSet(node.getParent()));
        }
        return node.getParent();
    }

    /*
     * Unisce gli insiemi dinamici che contengono x e y nell'insieme che ha rank maggiore
     */
    public void union(T x, T y) {
        T setX = findSet(x);
        T setY = findSet(y);
        if (setX == null || setY == null || setX == setY) {
            return;
        }
        UFNode<T> nodeX = getNode().get(setX);
        UFNode<T> nodeY = getNode().get(setY);
        if (nodeX.getRank() > nodeY.getRank()) {
            nodeY.setParent(x);
        } else if (nodeX.getRank() > nodeY.getRank()) {
            nodeX.setParent(y);
        } else { //nodeX.getRank() == nodeY.getRank()
            nodeX.setParent(y);
            nodeX.setRank(nodeX.getRank()+1);
        }
    }

    public HashMap<T, UFNode<T>> getNode() {
        return node;
    }

    public void setNode(HashMap<T, UFNode<T>> getNode) {
        this.node = getNode;
    }
}