package app.views;

import app.entitys.NodeTree;
import app.models.BTreeModel;

import java.util.Scanner;

public class AddView {
    public void addProcessing (Scanner scanner, BTreeModel<Integer> bst) {
        while (true) {
            System.out.print("Input add value: ");
            String inputStrValue = scanner.nextLine().trim();
            try {
                int inputIntValue = Integer.parseInt(inputStrValue);
                boolean isAdded = bst.add(inputIntValue);
                if (!isAdded) {
                    System.out.println("Input value exist in tree. Value didn't add");
                    return;
                }
                System.out.println("New value added");
                return;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input. Value must be integer");
            }
        }
    }
}
