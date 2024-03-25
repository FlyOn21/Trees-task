package app;

import app.controlles.TreeController;

public class AppTree {
    private  static  final TreeController treeController = new TreeController();

    private void run() {
        treeController.treeController();
    }
    public static void main(String[] args) {
        new AppTree().run();
    }
}
