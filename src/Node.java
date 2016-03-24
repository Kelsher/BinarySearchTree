
public class Node {

    private int value;
    private Node left = null;
    private Node right = null;

    public Node(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public void setLeft(Node n){
        this.left = n;
    }

    public void setRight(Node n){
        this.right = n;
    }

    public Node getLeft (){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }

}
