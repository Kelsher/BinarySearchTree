import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private Node root = null;

    public void insert (int value) {

        if (this.root == null) {
            this.root = new Node (value);
            return;
        }

        insertRecursive (this.root, new Node (value));
    }

    public void insertRecursive (Node currentParent, Node newNode) {
        if (newNode.getValue () > currentParent.getValue ()) {

            if (currentParent.getRight () == null) {
                currentParent.setRight (newNode);
            } else {
                insertRecursive (currentParent.getRight (), newNode);
            }
            return;
        }

        if (currentParent.getLeft () == null) {
            currentParent.setLeft (newNode);
        } else {
            insertRecursive (currentParent.getLeft (), newNode);
        }
        return;
    }

    public int min(){
        int min = 0;

        Node currentNode = this.root;
        while(currentNode != null){
            min = currentNode.getValue ();
            currentNode = currentNode.getLeft ();
        }

        return min;
    }

    public int max(){
        int max = 0;

        Node currentNode = this.root;
        while(currentNode != null){
            max = currentNode.getValue ();
            currentNode = currentNode.getRight ();
        }

        return max;
    }

    public String inOrder(Node current){
        if (current == null){
            return "";
        }
        String out = "";

        out += inOrder (current.getLeft ());
        out += ", ";
        out += Integer.toString (current.getValue ());
        out += ", ";
        out += inOrder (current.getRight ());

        return out.replaceAll("^, ", "").replaceAll(", $", "");
    }

    public String inOrder(){
        return this.inOrder(this.root);
    }

    public String preOrder(Node current){
        if (current == null){
            return "";
        }
        String out = "";

        out += Integer.toString (current.getValue ());
        out += ", ";
        out += preOrder (current.getLeft());
        out += ", ";
        out += preOrder (current.getRight ());

        return out.replaceAll("^, ", "").replaceAll(", , ", ", ").replaceAll(", $", "");
    }

    public String preOrder(){
        return this.preOrder(this.root);
    }

    public String postOrder(Node current){
        if (current == null){
            return "";
        }
        String out = "";

        out += postOrder(current.getLeft());
        out += ", ";
        out += postOrder(current.getRight());
        out += ", ";
        out += Integer.toString (current.getValue ());

        return out.replaceAll(", , ", ", ").replaceAll("^, ", "").replaceAll(", $", "");
    }

    public String postOrder(){
        return this.postOrder (this.root);
    }

    public Node getRoot(){
        return this.root;
    }

    public String levelOrder(Node parent){
        if(parent == null){
            return "";
        }

        Queue<Node> q = new LinkedList<Node>();

        q.add(parent);

        String out = "";

        while (!q.isEmpty()) {
            Node n = q.remove();

            out += n.getValue();
            out += ", ";
            // LEWIS'S TASK
            if (n.getLeft() != null  ) {
                q.add(n.getLeft());
            }

            if (n.getRight() != null){
                q.add(n.getRight());
            }
            // END OF LEWIS'S TASK
        }

        return out.replaceAll(", $", "");
    }

    public String levelOrder(){
        return this.levelOrder(this.root);
    }
}
