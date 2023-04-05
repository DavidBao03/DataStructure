package DataStructure.Stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);

        arrayStack.show();
        System.out.println("---------------------------------------");

        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.show();
        System.out.println("---------------------------------------");

        System.out.println(arrayStack.pop());
        arrayStack.show();
        System.out.println("---------------------------------------");

        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.show();
        System.out.println("---------------------------------------");
    }
}

class ArrayStack{
    private int maxSize;
    private int[] arr;
    private int top = -1;

    public ArrayStack(int maxSize){
        arr = new int[maxSize];
        this.maxSize = maxSize;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int data){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        arr[top] = data;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        return arr[top--];
    }

    public void show(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("arr["+i+"] = "+arr[i]);
        }
    }
}
