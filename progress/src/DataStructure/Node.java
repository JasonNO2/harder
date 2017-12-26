package DataStructure;

public class Node {
    Integer val;
    Node leftNode;
    Node rightNode;

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node() {
    }

    public Node(Integer val, Node leftNode, Node rightNode) {
        this.val = val;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
    public void display(){
        System.out.print(this.val + "\t");
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }

    public Node(Integer val) {
        this.val = val;
    }
}
