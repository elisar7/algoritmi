package Graph;


import UnionFind.UnionFind;
import java.util.*;

public class MSTKruskal<T> {
    private Double weight;
    private int edgeNumber;
    private int vertexNumber;
    private ArrayList<Edge<T>> mst = new ArrayList<>();

    /*
     * Restituisce un albero di copertura minima generato mediante l'algoritmo di Kruskal
     */
    public MSTKruskal(UndirectedGraph<T> G) {
        setWeight(0.0);
        setEdgeNumber(0);
        ArrayList<Node<T>> vertexes = G.getVertexes();
        ArrayList<Edge<T>> edges = G.getEdges();
        UnionFind uf = new UnionFind();
        for (int i = 0; i < vertexes.size(); i++) {
            uf.makeSet(vertexes.get(i));
        }
        setVertexNumber(vertexes.size());
        //I due nodi non appartengono alla stessa componente connessa
        for (int i = 0; i < edges.size(); i++) {
            Edge<T> e = edges.get(i);
            if (uf.findSet(e.fromNode()) != uf.findSet(e.toNode())) {
                uf.union(e.fromNode(), e.toNode());
                mst.add(e);
                setEdgeNumber(getEdgeNumber() + 1);
                this.setWeight(this.getWeight() + e.getWeight());
            }
        }
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public int getEdgeNumber() {
        return edgeNumber;
    }

    public void setEdgeNumber(int edgeNumber) {
        this.edgeNumber = edgeNumber;
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public void setVertexNumber(int vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public ArrayList<Edge<T>> getMst() {
        return mst;
    }

    public void setMst(ArrayList<Edge<T>> mst) {
        this.mst = mst;
    }
}
