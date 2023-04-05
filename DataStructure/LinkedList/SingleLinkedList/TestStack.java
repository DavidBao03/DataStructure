package DataStructure.LinkedList.SingleLinkedList;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        //创建新栈
        Stack<Integer> stack = new Stack<>();
        //添加
        stack.add(1);
        stack.add(2);
        stack.add(3);
        //取出
        while (stack.size() > 0){
            int res = stack.pop();//取出栈顶数据
            System.out.println(res);
        }
    }
}
