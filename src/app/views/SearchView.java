package app.views;

import app.entitys.NodeTree;
import app.models.BTreeModel;

import java.util.Scanner;

public class SearchView {
    public void searchProcessing (Scanner scanner, BTreeModel<Integer> bst) {
        while (true) {
            System.out.print("Input search value: ");
            String inputStrValue = scanner.nextLine().trim();
            try {
                int inputIntValue = Integer.parseInt(inputStrValue);
                NodeTree<Integer> searchResult = bst.search(inputIntValue);
                if (searchResult != null) {
                    System.out.println("Found: " + searchResult.value);
                } else {
                    System.out.println("Search value not found.");
                }
                return;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input. Value must be integer");
            }
        }
    }
}
