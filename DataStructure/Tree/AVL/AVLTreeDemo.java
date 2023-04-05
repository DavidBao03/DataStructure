package DataStructure.Tree.AVL;

public class AVLTreeDemo {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        int[] arr = {10, 11, 7, 6, 8, 9 };
        for (int i = 0; i < arr.length ; i++) {
            avlTree.add(new Node(arr[i]));
        }
        avlTree.infixOrder();
        System.out.println(avlTree.root.getLeftHeight());
        System.out.println(avlTree.root.getRightHeight());
    }
}

class AVLTree {
    public Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root == null) {
            System.out.println("空树");
        } else {
            root.infixOrder();
        }
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    public void delNode(int value) {
        Node targetNode = search(value);
        if (targetNode == null) {
            return;
        }
        if (root.right == null && root.left == null) {
            root = null;
            return;
        }
        Node parent = searchParent(value);
        //删除叶子节点
        if (targetNode.right == null && targetNode.left == null) {
            if (parent != null && parent.left == targetNode) {
                parent.left = null;
            } else if (parent != null && parent.right == targetNode) {
                parent.right = null;
            }
        } else if (targetNode.right != null && targetNode.left != null) {//删除有两个子节点的节点
            int maxVal = delMaxValRightTree(targetNode.left);
            targetNode.value = maxVal;
        } else {//删除只有一个子结点的节点(需要考虑根节点!!!!!!!!)
            if (targetNode.left != null) {
                if (parent != null) {
                    if (parent.left == targetNode) {
                        parent.left = targetNode.left;
                    } else {
                        parent.right = targetNode.left;
                    }
                } else {
                    root = targetNode.left;
                }
            } else {
                if (parent != null) {
                    if (parent.left == targetNode) {
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

    public int delMaxValRightTree(Node node) {
        Node target = node;
        while (target.right != null) {
            target = target.right;
        }
        delNode(target.value);
        return target.value;
    }
}


class Node {
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

    public void add(Node node) {
        if (node == null) {
            return;
        }

        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        //平衡方法
        if(getLeftHeight() - getRightHeight() > 1){
            if(this.left != null && this.left.getRightHeight() > this.left.getLeftHeight()){
                this.left.leftRotate();//一定是对前一个"根"节点先旋转!!!!!!!!
                rightRotate();
            }else {
                rightRotate();
            }
        }

        if(getRightHeight() - getLeftHeight() > 1){
            if(this.right != null && this.right.getRightHeight() < this.right.getLeftHeight()){
                this.right.rightRotate();
                leftRotate();
            }else {
                leftRotate();
            }
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public Node search(int value) {
        if (value == this.value) {
            return this;
        }
        if (value < this.value) {
            if (this.left != null) {
                return this.left.search(value);
            }
            return null;
        } else {
            if (this.right != null) {
                return this.right.search(value);
            }
            return null;
        }
    }

    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else if (this.left != null && this.value >= value) {
            return this.left.searchParent(value);
        } else if (this.right != null && this.value < value) {
            return this.right.searchParent(value);
        } else {
            return null;
        }
    }
    public int getLeftHeight(){
        if(this.left == null){
            return 0;
        }else {
            return this.left.getHeight();
        }
    }

    public int getRightHeight(){
        if(this.right == null){
            return 0;
        }else {
            return this.right.getHeight();
        }
    }
    public int getHeight() {
        return Math.max(this.left == null ? 0 : this.left.getHeight(), this.right == null ? 0 : this.right.getHeight()) + 1;
    }

    public void leftRotate(){
        //创建新节点保留当前结点的值
        Node newNode = new Node(this.value);
        //将新节点的左子树变为当前节点的左子树
        newNode.left = this.left;
        //将新节点的右子树变为当前节点右子树的左子树
        newNode.right = this.right.left;
        //将当前节点的值改为其右子树的值
        this.value = this.right.value;
        //将当前节点的右子树变为当前节点右子树的右子树
        this.right = this.right.right;
        //将当前节点的左子树变为新节点
        this.left = newNode;
    }

    public void rightRotate(){
        //创建新节点保留当前结点的值
        Node newNode = new Node(this.value);
        //将新节点的右子树变为当前节点的右子树
        newNode.right = this.right;
        //将新节点的左子树变为当前节点左子树的右子树
        newNode.left = this.left.right;
        //将当前节点的值改为其左子树的值
        this.value = this.left.value;
        //将当前节点的左子树变为当前节点左子树的左子树
        this.left = this.left.left;
        //将当前节点的右子树变为新节点
        this.right = newNode;
    }
}
