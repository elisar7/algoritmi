package UnionFind;

public class UFNode<T> {
    private int rank;
    private T parent;

    public UFNode(T parent, int rank) {
        this.setParent(parent);
        this.setRank(rank);
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public T getParent() {
        return parent;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }
}
