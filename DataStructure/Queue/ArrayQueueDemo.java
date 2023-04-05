package DataStructure.Queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("输入 s 来显示队列信息");
            System.out.println("输入 g 来取出队列数据");
            System.out.println("输入 a 来添加队列数据");
            System.out.println("输入 h 来显示队列头部数据");
            System.out.println("输入 e 来退出程序");
            char k = ' ';
            k = scanner.next().charAt(0);
            switch (k){
                case 's':
                    queue.showQueue();
                    break;
                case 'g':
                    try {
                        System.out.println(queue.getQueue());
                        break;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        break;
                    }
                case 'a':
                    System.out.println("请输入你想要放入的数据:");
                    int res = scanner.nextInt();
                    queue.addQueue(res);
                    break;
                case 'h':
                    try {
                        queue.headQueue();
                        break;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        break;
                    }
                case 'e':
                    scanner.close();
                    flag = false;
                    break;
                default:
                    System.out.println("输入不合理,请重新输入");
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
class ArrayQueue{
    private int MaxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize){
        MaxSize = arrMaxSize;
        arr = new int[MaxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull(){
        return rear == MaxSize-1;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满,无法加入数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空,无法取出数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空,无数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr["+i+"] = "+arr[i]+" ");
            System.out.println();
        }
    }

    public void headQueue(){
        if (isEmpty()){
            System.out.println("队列为空,无数据");
            return;
        }
        System.out.println(arr[front+1]);
    }

}
