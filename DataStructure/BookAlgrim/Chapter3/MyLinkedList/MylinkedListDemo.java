package DataStructure.BookAlgrim.Chapter3.MyLinkedList;

import java.util.Iterator;

public class MylinkedListDemo {
    public static void main(String[] args) {
        MyLinkedList<Integer> mlls = new MyLinkedList<>();

        mlls.add(1);
        mlls.add(2);
        mlls.add(3);
        mlls.add(4);
        print(mlls);

        mlls.add(1,5);
        print(mlls);

        mlls.get(3);

        mlls.remove(3);
        print(mlls);

        mlls.set(0,100);
        print(mlls);
    }

    private static void print(MyLinkedList<Integer> mlls) {
        Iterator<Integer> it = mlls.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();
    }
}
