package app.views;

import app.models.BTreeModel;

public class ShowView {
    public void showProcessing (BTreeModel<Integer> bst) {
        String showTree = bst.show();
        System.out.println(showTree);
    }
}
