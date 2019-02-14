package Graph;

import java.util.*;

public class Node<T> {

    private T vertex;
    private ArrayList<Edge<T>> edges;
   
    public Node(T vertex) {
        this.setVertex(vertex);
        this.setEdges(new ArrayList<Edge<T>>());
    }

    /*
     * Aggiunge un arco pesato che collega this a node
     */
    public void addEdge(Node<T> node, double weight) {
        Edge<T> newEdge = new Edge<T>(this, node, weight);
        getEdges().add(newEdge);
    }

    /*
     * Restitusce true se esiste un arco che collega this a node.
     */
    public boolean hasEdge(Node<T> node) {
        for (int i = 0; i < getEdges().size(); i++)
            if (getEdges().get(i).isBetween(this, node))
                return true;
        return false;
    }

    public T getVertex() {
        return vertex;
    }

    public void setVertex(T vertex) {
        this.vertex = vertex;
    }

    public ArrayList<Edge<T>> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge<T>> edges) {
        this.edges = edges;
    }

    public boolean equals (Node<T> node){
        return this.getVertex().equals(node.getVertex());
    }

}