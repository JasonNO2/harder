package DataStructure;

import java.util.Stack;

//二叉树
public class BinaryTree {
    private Node root=null;

    BinaryTree(int value) {
        root = new Node(value);
        root.leftNode=null;
        root.rightNode=null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node findNode(int value){
        Node cur=root;
        while (true) {
            if (cur.val == value) {
                return root;
            } else if (value < cur.val) {
                cur=cur.leftNode;
                return cur;
            } else if (value > cur.val) {
                cur = cur.rightNode;
                return cur;
            }
            if (cur == null) {
                return null;
            }
        }
    }
    public String insert(Node n){
        String message="";
        if (root == null) {
            root = n;
            root.leftNode=null;
            root.rightNode=null;
            message = "根节点为空,此节点已成为根节点";
        } else {
            Node cur=root;
            Node parent=null;
            while (true) {
                //判断要插入的节点值与当前结点值比较
                //如果大于当前节点值,改变父节点,当前节点改为原父节点的右节点
                //判断当前节点是否为空(原父节点的右节点),如果为空就将新节点添加
                //如果不为空,继续循环,找下一个节点
                if (n.val > cur.val) {
                   parent=cur;
                   cur=cur.rightNode;
                    if (cur == null) {
                        parent.rightNode=n;
                        message = "已添加当前节点为父节点："+parent.val+"的右节点";
                        break;
                    }
                } else if (n.val < cur.val) {
                    parent = cur;
                    cur = cur.leftNode;
                    if (cur == null) {
                        parent.leftNode = n;
                        message = "已添加当前节点为父节点：" + parent.val + "的左节点";
                        break;
                    }
                } else if (n.val == cur.val) {
                    message = "不可插入相同数据";
                    break;
                } else {
                    message = "having some value in binary tree";
                }
            }
        }
        return message;
    }
    //遍历数据,中序遍历：最常用的一种遍历方法

    /**
     * //中序遍历(递归)：
     * 1、调用自身来遍历节点的左子树
     * 2、访问这个节点
     * 3、调用自身来遍历节点的右子树
     */
    public void inOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.leftNode);
        node.display();
        inOrderTraverse(node.rightNode);
    }

    //中序非递归遍历
    public void inOrderByStack(){
        Stack<Node> stack = new Stack<>();
        Node cur=root;
        while (cur != null || !stack.isEmpty()) {
            //当前节点不为空,压栈,当前节点=当前左节点,如此循环
            while (cur != null) {
                stack.push(cur);
                cur=cur.leftNode;
            }
            //上一个while循环不成立时时,栈顶节点出栈,并显示,当前节点=当前右节点,若当前节点不为空,压栈,如果为空
            //重复出栈,查找右节点,不空：压栈,空：重复出栈
            if (!stack.isEmpty()) {
                cur = stack.pop();
                cur.display();
                cur=cur.rightNode;
            }
        }
        System.out.println("");
    }
    //前序遍历
    public void preOrderTravers(Node node){
        if (node == null) {
            return;
        }
        node.display();
        preOrderTravers(node.leftNode);
        preOrderTravers(node.rightNode);
    }
    //后序遍历
    public void postOrderTravers(Node node){
        if (node == null) {
            return;
        }
        preOrderTravers(node.leftNode);
        preOrderTravers(node.rightNode);
        node.display();
    }
    //最小值
    public int minValue(){
        Node cur=root;
        while (true) {
            if (cur.leftNode != null) {
                cur = cur.leftNode;
            } else {
                return cur.val;
            }
        }
    }//最大值
    public int maxValue(){
        Node cur=root;
        while (true) {
            if (cur.rightNode != null) {
                cur = cur.rightNode;
            } else {
                return cur.val;
            }
        }
    }
}
