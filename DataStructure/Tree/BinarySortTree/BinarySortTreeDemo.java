package DataStructure.Tree.BinarySortTree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }


        binarySortTree.infixOrder();
        System.out.println();
        binarySortTree.delNode(1);
        binarySortTree.delNode(3);
        binarySortTree.delNode(5);
        binarySortTree.delNode(7);
        binarySortTree.delNode(9);
        binarySortTree.delNode(10);
        binarySortTree.delNode(12);
        System.out.println();
        binarySortTree.infixOrder();
    }
}

class BinarySortTree{
    private Node root;

    public void add(Node node){
        if(root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public void infixOrder(){
        if(root == null){
            System.out.println("空树");
        }else {
            root.infixOrder();
        }
    }

    public Node search(int value){
        if(root == null){
            return null;
        }else {
            return root.search(value);
        }
    }

    public Node searchParent(int value){
        if(root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    public void delNode(int value){
        Node targetNode = search(value);
        if(targetNode == null){
            return;
        }
        if(root.right == null && root.left == null){
            root = null;
            return;
        }
        Node parent = searchParent(value);
        //删除叶子节点
        if(targetNode.right == null && targetNode.left == null){
            if(parent != null && parent.left == targetNode){
                parent.left = null;
            }else if(parent != null && parent.right == targetNode){
                parent.right = null;
            }
        } else if (targetNode.right != null && targetNode.left != null) {//删除有两个子节点的节点
            int maxVal = delMaxValRightTree(targetNode.left);
            targetNode.value = maxVal;
        } else {//删除只有一个子结点的节点(需要考虑根节点!!!!!!!!)
            if(targetNode.left != null){
                if(parent != null){
                    if(parent.left == targetNode){
                        parent.left = targetNode.left;
                    } else {
                        parent.right = targetNode.left;
                    }
                } else {
                    root = targetNode.left;
                }
            } else {
                if(parent != null){
                    if(parent.left == targetNode){
                        parent.left = targetNode.right;
                    } else {
                        parent.right = targetNode.right;
                    }
                } else {
                    root = targetNode.right;
                }
            }
        }
    }

    public int delMaxValRightTree(Node node){
        Node target = node;
        while (target.right != null){
            target = target.right;
        }
        delNode(target.value);
        return target.value;
    }
}
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void add(Node node){
        if(node == null){
            return;
        }

        if(node.value < this.value){
            if(this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if(this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }

    public Node search(int value){
        if(value == this.value){
            return this;
        }
        if(value < this.value){
            if(this.left != null){
                return this.left.search(value);
            }
            return null;
        }else {
            if(this.right != null){
                return this.right.search(value);
            }
            return null;
        }
    }

    public Node searchParent(int value){
        if((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }else if(this.left != null && this.value >= value){
            return this.left.searchParent(value);
        }else if(this.right != null && this.value < value){
            return this.right.searchParent(value);
        }else {
            return null;
        }
    }
}