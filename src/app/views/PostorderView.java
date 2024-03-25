package app.views;

import app.models.BTreeModel;

public class PostorderView {

    public void postorderProcessing(BTreeModel<Integer> bst) {
        String postorder = bst.postorder();
        System.out.println("Postorder traversal: " + postorder);
    }
}
