package DataStructure.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
//        int[] arr = {3,9,1,10,20,2,3,23,23,132,423,2,23,2,1};
//        radixSort(arr);
//        System.out.println(Arrays.toString(arr));
        //测试时间复杂度
        int[] arr = new int[1280000];
        for (int i = 0; i < 1280000; i++) {
            arr[i] = (int) (Math.random()*1280000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("before sort:"+date1Str);

        radixSort(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("after sort:"+date2Str);
        //测试结果:
        //32万数据用时: 不到1秒
        //64万数据用时: 不到1秒
        //128万数据用时:不到1秒
    }

    public static void radixSort(int[] arr){
        //获取数组中最大数的位数
        int max = arr[0];
        for (int i : arr) {
            max = i > max ? i : max;
        }
        int maxDigit = (max+"").length();

        for (int i = 0,n = 1; i < maxDigit; i++,n *= 10) {
            int[][] bucket = new int[10][arr.length];
            //记录桶中元素个数
            int[] bucketElementCount = new int[10];
            for (int j = 0; j < arr.length; j++) {
                int lowestDigit = arr[j] / n % 10;
                bucket[lowestDigit][bucketElementCount[lowestDigit]] = arr[j];
                bucketElementCount[lowestDigit]++;
            }

            int arrIndex = 0;
            for (int j = 0; j < bucket.length; j++) {
                for (int k = 0; k < bucket[0].length; k++) {
                    if(bucket[j][k] != 0){
                        arr[arrIndex] = bucket[j][k];
                        arrIndex++;
                    }
                }
            }
        }
    }
}
