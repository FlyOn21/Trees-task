package app.entitys;

public class NodeTree<T> {
    public T value;
    public NodeTree<T> left;
    public NodeTree<T> right;

    public NodeTree(T item) {
        value = item;
        left = null;
        right = null;
    }
}
