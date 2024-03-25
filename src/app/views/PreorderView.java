package app.views;

import app.models.BTreeModel;

public class PreorderView {
    public void preorderProcessing(BTreeModel<Integer> bst) {
        String preorder = bst.preorder();
        System.out.println("Preorder traversal: " + preorder);
    }
}
