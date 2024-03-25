package app.views;

import app.entitys.NodeTree;
import app.models.BTreeModel;

import java.util.Scanner;

public class DeleteView {

    public void deleteProcessing(Scanner scanner, BTreeModel<Integer> bst) {
        while (true) {
            System.out.print("Input delete value: ");
            String inputStrValue = scanner.nextLine().trim();
            try {
                int inputIntValue = Integer.parseInt(inputStrValue);
                boolean deleteResult = bst.delete(inputIntValue);
                if (deleteResult) {
                    System.out.println("Deleted: " + inputStrValue);
                } else {
                    System.out.println("Value not found. Value didn't delete");
                }
                return;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input. Value must be integer");
            }
        }
    }
}
