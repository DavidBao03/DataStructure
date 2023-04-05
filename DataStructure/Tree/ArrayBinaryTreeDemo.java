package DataStructure.Tree;

public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        arrayBinaryTree arrayBinaryTree = new arrayBinaryTree(arr);
        System.out.println("前序遍历");
        arrayBinaryTree.preOrder();
        System.out.println("中序遍历");
        arrayBinaryTree.infixOrder();
        System.out.println("后序遍历");
        arrayBinaryTree.postOrder();
    }
}

class arrayBinaryTree{
    public int[] arr;

    public arrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //前序遍历
    public void preOrder(){
        this.preOrder(0);
    }
    public void preOrder(int no){
        if(no >= arr.length){
            return;
        }
        System.out.println(arr[no]);
        if(no * 2 + 1 < arr.length){
            preOrder(no * 2 + 1);
        }
        if(no * 2 + 2 < arr.length){
            preOrder(no * 2 + 2);
        }
    }

    //后序遍历
    public void postOrder(){
        this.postOrder(0);
    }
    public void postOrder(int no){
        if(no >= arr.length){
            return;
        }
        if(no * 2 + 1 < arr.length){
            postOrder(no * 2 + 1);
        }
        if(no * 2 + 2 < arr.length){
            postOrder(no * 2 + 2);
        }
        System.out.println(arr[no]);
    }

    //中序遍历
    public void infixOrder(){
        this.infixOrder(0);
    }
    public void infixOrder(int no){
        if(no >= arr.length){
            return;
        }
        if(no * 2 + 1 < arr.length){
            infixOrder(no * 2 + 1);
        }
        System.out.println(arr[no]);
        if(no * 2 + 2 < arr.length){
            infixOrder(no * 2 + 2);
        }
    }
}
