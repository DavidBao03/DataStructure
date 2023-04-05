package DataStructure.BookAlgrim.Chapter3.MyArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyArrayListDemo {
    public static void main(String[] args) {
        MyArrayList<Integer> mls = new MyArrayList<>();
        mls.add(1);
        mls.add(2);

        mls.add(1,3);
        print(mls);

        System.out.println(mls.remove(1));
        print(mls);
    }

    private static void print(MyArrayList<Integer> mls) {
        Iterator<Integer> it = mls.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
