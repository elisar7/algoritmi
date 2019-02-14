package Graph;

public class Edge<T> {
    private Double weight;
    private Node<T> node1;
    private Node<T> node2;

    public Edge(Node<T> node1, Node<T> node2, Double weight) {
        this.setNode1(node1);
        this.setNode2(node2);
        this.setWeight(weight);
    }

    public Node<T> fromNode() {
        return getNode1();
    }

    public Node<T> toNode() {
        return getNode2();
    }

    public boolean isBetween(Node<T> node1, Node<T> node2) {
        return (this.getNode1().equals(node1) && this.getNode2().equals(node2));
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Node<T> getNode1() {
        return node1;
    }

    public void setNode1(Node<T> node1) {
        this.node1 = node1;
    }

    public Node<T> getNode2() {
        return node2;
    }

    public void setNode2(Node<T> node2) {
        this.node2 = node2;
    }

    public boolean equals(Edge<T> edge) {
        return (this.node1.equals(edge.node1) && this.node2.equals(edge.node2));
    }


}