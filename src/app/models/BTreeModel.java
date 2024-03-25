package app.models;


import app.entitys.NodeTree;

public class BTreeModel<T extends Comparable<T>> {
    private NodeTree<T> root;
    private boolean deletionOccurred;
    private boolean addOccurred;

    public BTreeModel() {
        root = null;
    }

    public boolean add(T key) {
        addOccurred = true;
        root = addRecursively(root, key);
        return addOccurred;
    }

    private NodeTree<T> addRecursively(NodeTree<T> current, T key) {
        if (current == null) {
            return new NodeTree<>(key);
        }

        int compareResult = key.compareTo(current.value);

        if (compareResult < 0) {
            current.left = addRecursively(current.left, key);
        } else if (compareResult > 0) {
            current.right = addRecursively(current.right, key);
        }
        else {
            addOccurred = false;
            return current;
        }

        return current;
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        buildString(root, 0, sb);
        return sb.toString();
    }

    private void buildString(NodeTree<T> current, int level, StringBuilder sb) {
        if (current == null) {
            return;
        }

        if (current.right != null) {
            buildString(current.right, level + 1, sb);
        }
        sb.append(printSpaces(level)).append(current.value).append("\n");
        if (current.left != null) {
            buildString(current.left, level + 1, sb);
        }
    }

    private String printSpaces(int level) {
        return " ".repeat(level * 4);
    }

    public NodeTree<T> search(T key) {
        return searchRecord(root, key);
    }

    private NodeTree<T> searchRecord(NodeTree<T> current, T key) {
        if (current == null || key.equals(current.value)) {
            return current;
        }

        int compareResult = key.compareTo(current.value);

        if (compareResult < 0) {
            return searchRecord(current.left, key);
        } else {
            return searchRecord(current.right, key);
        }
    }

    public boolean delete(T key) {
        deletionOccurred = false;
        root = deleteRecords(root, key);
        return deletionOccurred;
    }

    private NodeTree<T> deleteRecords(NodeTree<T> current, T key) {
        if (current == null) {
            return null;
        }

        int compareResult = key.compareTo(current.value);

        if (compareResult < 0) {
            current.left = deleteRecords(current.left, key);
        } else if (compareResult > 0) {
            current.right = deleteRecords(current.right, key);
        } else {
            deletionOccurred = true;
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            current.value = findSmallestValue(current.right);
            current.right = deleteRecords(current.right, current.value);
        }

        return current;
    }
    private T findSmallestValue(NodeTree<T> root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public String inorder() {
        StringBuilder sbInorder = new StringBuilder();
        inorderTraversal(root, sbInorder);
        return sbInorder.toString().trim();
    }

    private void inorderTraversal(NodeTree<T> current, StringBuilder sb) {
        if (current != null) {
            inorderTraversal(current.left, sb);
            sb.append(current.value).append(" ");
            inorderTraversal(current.right, sb);
        }
    }

    public String preorder() {
        StringBuilder sbPreorder = new StringBuilder();
        preorderTraversal(root, sbPreorder);
        return sbPreorder.toString().trim();
    }
    private void preorderTraversal(NodeTree<T> current, StringBuilder sb) {
        if (current != null) {
            sb.append(current.value).append(" ");
            preorderTraversal(current.left, sb);
            preorderTraversal(current.right, sb);
        }
    }

    public String postorder() {
        StringBuilder sbPostorder = new StringBuilder();
        postorderTraversal(root, sbPostorder);
        return sbPostorder.toString().trim();
    }

    private void postorderTraversal(NodeTree<T> current, StringBuilder sb) {
        if (current != null) {
            postorderTraversal(current.left, sb);
            postorderTraversal(current.right, sb);
            sb.append(current.value).append(" ");
        }
    }
}
