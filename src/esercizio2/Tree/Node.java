package Tree;

public class Node<T> {

    private Node<T> child;
    private Node<T> parent;
    private Node<T> brother;
    private T data;
    private int grade = 0;

    public Node() {
        this.setParent(this);
    }

    public Node(T data) {
        this.setChild(null);
        this.setParent(this);
        this.setBrother(null);
        this.setGrade(0);
        this.setData(data);
    }

    public Node(T data, Node<T> parent) {
        this.setChild(null);
        this.setParent(parent);
        this.setBrother(null);
        this.setGrade(0);
        this.setData(data);
    }

    public void addChild(Node<T> toAdd) {
        if (this.getChild() == null) {
            this.setChild(toAdd);
            this.setGrade(this.getGrade() + 1);
            toAdd.parent = this;
        } else
            this.getChild().addBrother(toAdd);
    }

    //Aggiunge il nodo toAdd come fratello di this
    public void addBrother(Node<T> toAdd) {
        Node<T> it;
        for (it = this; it.getBrother() != null; it = it.getBrother()) ;
        it.setBrother(toAdd);
        it.getParent().setGrade(it.getParent().getGrade() + 1);
        toAdd.setParent(it.getParent());
    }

    public String toString() {
        return "" + this.getData();
    }

    public Node<T> getChild() {
        return child;
    }

    public void setChild(Node<T> child) {
        this.child = child;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getBrother() {
        return brother;
    }

    public void setBrother(Node<T> brother) {
        this.brother = brother;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
