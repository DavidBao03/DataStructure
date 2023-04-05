package DataStructure.Tree.ThreadedBinaryTree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode h1 = new HeroNode(1,"A");
        HeroNode h3 = new HeroNode(3,"B");
        HeroNode h8 = new HeroNode(8,"C");
        HeroNode h10 = new HeroNode(10,"D");
        HeroNode h6 = new HeroNode(6,"E");
        HeroNode h14 = new HeroNode(14,"F");

        binaryTree.root = h1;
        h1.left = h3;
        h1.right = h6;
        h3.left = h8;
        h3.right = h10;
        h6.left = h14;

//        binaryTree.infixthreadNode(h1);
//        binaryTree.infixthreadList();

//        binaryTree.prethreadNode(h1);
//        binaryTree.prethreadList();

        binaryTree.postthreadNode(h1);
        //binaryTree.postthreadList();//后续线索化需要父指针实现
    }
}

class BinaryTree{
    public HeroNode root;
    public HeroNode pre;
    //前序遍历
    public void preOrder(){
        if(root != null){
            root.preOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
    //中序遍历
    public void infixOrder(){
        if(root != null){
            root.infixOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
    //后序遍历
    public void postOrder(){
        if(root != null){
            root.postOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    //使用前序遍历查找元素
    public HeroNode preOrderSearch(int no){
        if(root != null){
            return root.preOrderSearch(no);
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    //使用中序遍历查找元素
    public HeroNode infixOrderSearch(int no){
        if(root != null){
            return root.infixOrderSearch(no);
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    //使用后序遍历查找元素
    public HeroNode postOrderSearch(int no){
        if(root != null){
            return root.postOrderSearch(no);
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    public void delNode(int no){
        if(root != null && root.no == no){
            root = null;
        }else if(root != null){
            root.delNode(no);
        }else {
            System.out.println("二叉树为空");
        }
    }

    //前序线索化二叉树
    public void prethreadNode(HeroNode node){
        if(node == null){
            return;
        }
        //线索化当前节点
        //1. 处理当前节点的前驱节点
        if(node.left == null){
            //让当前节点的左指针指向前驱节点
            node.left = pre;
            //修改当前节点的类型
            node.leftType = 1;
        }
        //2. 处理当前节点的后继节点
        if(pre != null && null == pre.right){
            //让当前节点的右指针指向后继节点
            pre.right = node;
            //修改当前节点的类型
            pre.rightType = 1;
        }
        //移动指针
        pre = node;
        //线索化左树
        if(node.leftType == 0){
            prethreadNode(node.left);
        }
        //线索化右树
        if(node.rightType == 0){
            prethreadNode(node.right);
        }

    }

    //前序线索遍历二叉树
    public void prethreadList(){
        HeroNode node = root;
        while(node != null){
            while(node.leftType == 0){
                System.out.println(node);
                node = node.left;
            }
            System.out.println(node);
            node = node.right;
        }
    }

    //中序线索遍历二叉树
    public void infixthreadList(){
        HeroNode node = root;
        while(node != null){
            while(node.leftType == 0){
                node = node.left;
            }
            System.out.println(node);
            while(node.rightType == 1){
                node = node.right;
                System.out.println(node);
            }
            node = node.right;
        }
    }

    //中序线索化二叉树
    public void infixthreadNode(HeroNode node){
        if(node == null){
            return;
        }
        //线索化左树
        infixthreadNode(node.left);
        //线索化当前节点
        //1. 处理当前节点的前驱节点
        if(node.left == null){
            //让当前节点的左指针指向前驱节点
            node.left = pre;
            //修改当前节点的类型
            node.leftType = 1;
        }
        //2. 处理当前节点的后继节点
        if(pre != null && null == pre.right){
            //让当前节点的右指针指向后继节点
            pre.right = node;
            //修改当前节点的类型
            pre.rightType = 1;
        }
        //移动指针
        pre = node;
        //线索化右树
        infixthreadNode(node.right);
    }

    //后序线索化二叉树
    public void postthreadNode(HeroNode node){
        if(node == null){
            return;
        }
        //线索化左树
        postthreadNode(node.left);
        //线索化右树
        postthreadNode(node.right);
        //线索化当前节点
        //1. 处理当前节点的前驱节点
        if(node.left == null){
            //让当前节点的左指针指向前驱节点
            node.left = pre;
            //修改当前节点的类型
            node.leftType = 1;
        }
        //2. 处理当前节点的后继节点
        if(pre != null && null == pre.right){
            //让当前节点的右指针指向后继节点
            pre.right = node;
            //修改当前节点的类型
            pre.rightType = 1;
        }
        //移动指针
        pre = node;
    }
}
class HeroNode{
    public int no;
    public String name;
    public HeroNode left;
    public HeroNode right;

    public int leftType;
    public int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.left != null){
            this.left.postOrder();
        }
        if(this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //使用前序遍历查找元素
    public HeroNode preOrderSearch(int no){
        System.out.println("已调用该方法");
        if(this.no == no){
            return this;
        }
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //使用中序遍历查找元素
    public HeroNode infixOrderSearch(int no){
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        System.out.println("已调用该方法");
        if(this.no == no){
            return this;
        }
        if(this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //使用后序遍历查找元素
    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        System.out.println("已调用该方法");
        if(this.no == no){
            return this;
        }
        return resNode;
    }

    public void delNode(int no){
        if(this.left != null && this.left.no == no){
            if(this.left.left != null){
                if(this.left.right != null){
                    HeroNode temp = this.left.right;
                    this.left = this.left.left;
                    this.left.right = temp;
                }else {
                    this.left = this.left.left;
                }
            }else if(this.left.right != null){
                this.left = this.left.right;
            } else {
                this.left = null;
            }
            return;
        }
        if(this.right != null && this.right.no == no){
            if(this.right.left != null){
                if(this.right.right != null){
                    HeroNode temp = this.right.right;
                    this.right = this.right.left;
                    this.right.right = temp;
                }else {
                    this.right = this.right.left;
                }
            }else if(this.right.right != null){
                this.right = this.right.right;
            } else {
                this.right = null;
            }
            return;
        }
        if(this.left != null){
            this.left.delNode(no);
        }
        if(this.right != null){
            this.right.delNode(no);
        }
    }
}