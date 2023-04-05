package DataStructure.Tree;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,29,3,6,1};

        createHuffmanTree(arr).preOrder();

    }

    public static node createHuffmanTree(int[] arr){
        ArrayList<node> nodes = new ArrayList<>();

        for (int i : arr) {
            node node = new node(i);
            nodes.add(node);
        }

        while(nodes.size() > 1){
            Collections.sort(nodes);

            node leftNode = nodes.get(0);
            node rightNode = nodes.get(1);

            node parent = new node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(1);
            nodes.remove(0);

            nodes.add(parent);
        }

        return nodes.get(0);
    }
}

class node implements Comparable<node>{
    public int value;
    public node left;
    public node right;

    public node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(node o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
}
