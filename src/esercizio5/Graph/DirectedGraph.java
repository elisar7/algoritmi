package Graph;

import Sorting.Sorting;

import java.util.ArrayList;
import java.util.HashMap;

public class DirectedGraph<T> {

    private HashMap<T, Node<T>> adjacencyList;

    public DirectedGraph() {
        setAdjacencyList(new HashMap<>());
    }

    /*
     * Aggiunge un vertice al grafo
     */
    public void addVertex(T vertex) {
        if (!getAdjacencyList().containsKey(vertex)) {
            getAdjacencyList().put(vertex, new Node<T>(vertex));
        }
    }

    /*
     * Restituisce true se nel grafo esiste un vertice uguale a vertex, false altrimenti
     */
    public boolean containsVertex(T vertex) {
        return getAdjacencyList().containsKey(vertex);
    }

    /*
     * Aggiunge un arco non pesato al grafo
     */
    public void addEdge(T vertex1, T vertex2) {
        addEdge(vertex1, vertex2, 0.0);
    }

    /*
     * Aggiunge un arco pesato al grafo
     */
    public void addEdge(T vertex1, T vertex2, Double weight) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            throw new RuntimeException("Vertex does not exist.");
        }
        if (!containsEdge(vertex1, vertex2)){
            Node<T> node1 = getNode(vertex1);
            Node<T> node2 = getNode(vertex2);
            node1.addEdge(node2, weight);
        }
    }

    /*
     * Restituisce true se nel grafo esiste un arco che collega vertex1 con vertex2,
     * false altrimenti
     */
    public boolean containsEdge(T vertex1, T vertex2) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            return false;
        }
        return getNode(vertex1).hasEdge(getNode(vertex2));
    }

    /*
    *   Restituisce il peso del grafo
    */
    public Double weight(){
        Double weight = 0.0;
        ArrayList<Edge<T>> res = new ArrayList<>();
        for (T v1 : getAdjacencyList().keySet()) {
            Node<T> v = getAdjacencyList().get(v1);
            for (int i = 0; i < v.getEdges().size(); i++)
                weight += v.getEdges().get(i).getWeight();
        }
        Sorting.quickSort(res, new EdgeComparator());
        return weight;
    }

    /*
     *   Restituisce un ArrayList contenente tutti gli archi presenti nel grafo
     *   in ordine non decrescente
     */
    public ArrayList<Edge<T>> getEdges() {
        ArrayList<Edge<T>> res = new ArrayList<>();
        for (T v1 : getAdjacencyList().keySet()) {
            Node<T> v = getAdjacencyList().get(v1);
            for (int i = 0; i < v.getEdges().size(); i++)
                res.add(v.getEdges().get(i));
        }
        Sorting.quickSort(res, new EdgeComparator());
        return res;
    }

    /*
     * Restituisce un ArrayList contenente tutti i vertici presenti nel grafo
     * in ordine non rilevante.
     */
    public ArrayList<Node<T>> getVertexes() {
        ArrayList<Node<T>> res = new ArrayList<>();
        for (T v1 : getAdjacencyList().keySet()) {
            res.add(getNode(v1));
        }
        return res;
    }

    public HashMap<T, Node<T>> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(HashMap<T, Node<T>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public Node<T> getNode(T value) {
        return getAdjacencyList().get(value);
    }

}
