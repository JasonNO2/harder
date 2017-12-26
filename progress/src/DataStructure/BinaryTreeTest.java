package DataStructure;

public class BinaryTreeTest {
    public static void main (String[] args){
        BinaryTree bt=new BinaryTree(10);
        Node n = new Node(15);
        Node n1 = new Node(5);
        Node n2 = new Node(30);
        Node n3 = new Node(8);
        Node n4 = new Node(50);
        Node n5 = new Node(60);
        Node n6 = new Node(14);
        Node n7 = new Node(12);
        bt.insert(n);
        bt.insert(n1);
        bt.insert(n2);
        bt.insert(n3);
        bt.insert(n4);
        bt.insert(n5);
        bt.insert(n6);
        bt.insert(n7);
        System.out.println("中序遍历：");
        bt.inOrderTraverse(bt.getRoot());
        //Node find = bt.findNode(15);
        //System.out.println(find.val);输出15
        System.out.println("非递归中序遍历：");
        bt.inOrderByStack();
        System.out.println("前序遍历：");
        bt.preOrderTravers(bt.getRoot());
        System.out.println("后序遍历");
        bt.postOrderTravers(bt.getRoot());
        System.out.println("最大值："+bt.maxValue());
        System.out.println("最小值："+bt.minValue());

    }
}
