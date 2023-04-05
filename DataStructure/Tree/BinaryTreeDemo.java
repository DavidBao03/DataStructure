package DataStructure.Tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode heroNode1 = new HeroNode(1,"D");
        HeroNode heroNode2 = new HeroNode(2,"E");
        HeroNode heroNode3 = new HeroNode(3,"T");
        HeroNode heroNode4 = new HeroNode(4,"A");
        HeroNode heroNode5 = new HeroNode(5,"J");
        HeroNode heroNode6 = new HeroNode(6,"K");
        HeroNode heroNode7 = new HeroNode(7,"L");
        HeroNode heroNode8 = new HeroNode(8,"M");

        binaryTree.root = heroNode1;
        heroNode1.left = heroNode2;
        heroNode1.right = heroNode3;
        heroNode2.right = heroNode4;
        heroNode2.left = heroNode5;
        heroNode4.left = heroNode7;
        heroNode4.right = heroNode8;
        heroNode3.right = heroNode6;

//        System.out.println("------------------前序遍历的结果为------------------");
//        binaryTree.preOrder();
//        System.out.println("------------------中序遍历的结果为------------------");
//        binaryTree.infixOrder();
//        System.out.println("------------------后序遍历的结果为------------------");
//        binaryTree.postOrder();
//
//        System.out.println(binaryTree.preOrderSearch(5));
//        System.out.println(binaryTree.infixOrderSearch(5));
//        System.out.println(binaryTree.postOrderSearch(5));

        System.out.println("删除前树:");
        binaryTree.preOrder();
        binaryTree.delNode(3);
        System.out.println("删除后树");
        binaryTree.preOrder();
    }
}

class BinaryTree{
    public HeroNode root;

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
}
class HeroNode{
    public int no;
    public String name;
    public HeroNode left;
    public HeroNode right;

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
