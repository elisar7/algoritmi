package Graph;

import java.util.HashMap;

public class UndirectedGraph<T> extends DirectedGraph<T> {

    public UndirectedGraph() {
        setAdjacencyList(new HashMap<>());
    }

    /*
     * Aggiunge un doppio arco al grafo (v1 -> v2 e v2 -> v1) per rappresentare un arco non orientato
     */
    @Override
    public void addEdge(T v1, T v2, Double weight) {
        if (!containsVertex(v1) || !containsVertex(v2)) {
            throw new RuntimeException("Vertex does not exist");
        }
        if (!v1.equals(v2) && !containsEdge(v1, v2)) {
            Node<T> node1 = getNode(v1);
            Node<T> node2 = getNode(v2);
            node1.addEdge(node2, weight);
            node2.addEdge(node1, weight);
        }
    }

    @Override
    /*
    *   Restituisce il peso del grafo
    */
    public Double weight(){
        Double weight = 0.0;
        for (T v1 : getAdjacencyList().keySet()) {
            Node<T> v = getAdjacencyList().get(v1);
            for (int i = 0; i < v.getEdges().size(); i++)
                weight += v.getEdges().get(i).getWeight();
        }
        return weight / 2;
    }

}