package DataStructure.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {3,9,-1,10,20};
//        bubbleSort(arr);

        //测试时间复杂度
        // 开始时间
        long stime = System.currentTimeMillis();
        int[] arr = new int[320000];
        for (int i = 0; i < 320000; i++) {
            arr[i] = (int) (Math.random()*320000);
        }
        // 结束时间
        long etime = System.currentTimeMillis();
        // 计算执行时间
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));
        //测试结果:
        //8万数据用时:  8s
        //16万数据用时: 32s
        //32万数据用时: 128s
    }

    public static void bubbleSort(int[] arr){
        for (int i = 1; i <= arr.length-1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }
}
