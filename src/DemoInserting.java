import java.util.Scanner;


public class DemoInserting {
    public static String getStrInput (String message) {
        System.out.println (message);

        Scanner inputScanner = new Scanner (System.in);
        String input = inputScanner.nextLine ();

        return input.trim ();
    }

    public static int getIntInput (String message) {
        return Integer.parseInt (getStrInput (message));
    }

    public static void main (String[] args) {
        BinarySearchTree bst = new BinarySearchTree ();
        while (true) {
            String input = getStrInput ("Please enter a number to add to the BST:");

            if (input.equalsIgnoreCase ("n")) {
                break;
            }
            bst.insert (Integer.parseInt (input));
        }
        System.out.println ("min is:" + bst.min());
        System.out.println ("max is:" + bst.max ());
        System.out.println (bst.inOrder());
        System.out.println (bst.preOrder ());
        System.out.println (bst.postOrder ());
    }
}