package app.controlles;

import app.config.Config;
import app.models.BTreeModel;
import app.views.*;

import java.util.Scanner;

public class TreeController {
    String title = """
            =========================
            Home work Trees task demo
            =========================
            """;

    String menu = """
            --------------
            Choice action:
            --------------
            Choice 1 => Show binary tree
            Choice 2 => Add value in binary tree
            Choice 3 => Search value in binary tree
            Choice 4 => Delete value from binary tree
            Choice 5 => Inorder traversal
            Choice 6 => Preorder traversal
            Choice 7 => Postorder traversal
            Choice 8 => stop and exit
            """;

    public void treeController() {
        System.out.println(title);
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        BTreeModel<Integer> bst = new BTreeModel<>();
        Config.INTEGER_VALUE_FOR_DEMO_TREE.forEach(bst::add);
        while (running) {
            System.out.println(menu);
            System.out.print("Input your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    ShowView showView = new ShowView();
                    showView.showProcessing(bst);
                    break;
                case "2":
                    AddView addView = new AddView();
                    addView.addProcessing(scanner, bst);
                    break;
                case "3":
                    SearchView searchView = new SearchView();
                    searchView.searchProcessing(scanner, bst);
                    break;
                case "4":
                    DeleteView deleteView = new DeleteView();
                    deleteView.deleteProcessing(scanner, bst);
                    break;
                case "5":
                    InorderView inorderView = new InorderView();
                    inorderView.inorderProcessing(bst);
                    break;
                case "6":
                    PreorderView preorderView = new PreorderView();
                    preorderView.preorderProcessing(bst);
                    break;
                case "7":
                    PostorderView postorderView = new PostorderView();
                    postorderView.postorderProcessing(bst);
                    break;
                case "8":
                    System.out.println("Stop ...");
                    running = false;
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
        scanner.close();
    }
}
