package app.views;

import app.models.BTreeModel;

public class InorderView {
    public void inorderProcessing(BTreeModel<Integer> bst) {
        String inorder = bst.inorder();
        System.out.println("Inorder traversal: " + inorder);
    }
}
