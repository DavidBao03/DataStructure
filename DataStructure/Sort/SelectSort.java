package DataStructure.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) throws InterruptedException {
//        int[] arr = {3,9,-1,10,20,2,3,23,23,132,423,2,23,2,1};
//        selectSort(arr);
//        System.out.println(Arrays.toString(arr));

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
        //8万数据用时:  1s
        //16万数据用时: 5s
        //32万数据用时: 21s
    }

    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int targerIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < min){
                    targerIndex = j;
                    min = arr[j];
                }
            }
            if(targerIndex != i){
                arr[targerIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
