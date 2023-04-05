package DataStructure.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort_SelfVersion {
    public static void main(String[] args) {
        //测试时间复杂度
        int[] arr = new int[160000];
        for (int i = 0; i < 160000; i++) {
            arr[i] = (int) (Math.random()*160000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("before sort:"+date1Str);

        heapSort(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("after sort:"+date2Str);
        //测试结果:
        //8万数据用时: 5秒
        //16万数据用时:23秒
        //128万数据用时:已超过3分钟...
        //复杂度为 n^2
    }

    public static void heapSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            adjustHeap(arr,arr.length-1-i);
            swap(arr,0,arr.length-1-i);
        }
    }
    public static void adjustHeap(int[] arr,int length){
        for (int i = 0; i <= length; i++) {
            int curIndex = i;
            int fatherIndex = (i - 1)/2;
            while(arr[curIndex] < arr[fatherIndex]){
                swap(arr,curIndex,fatherIndex);
                curIndex = fatherIndex;
                fatherIndex = (curIndex - 1)/2;
            }
        }
    }
    public static void swap(int[] arr,int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
