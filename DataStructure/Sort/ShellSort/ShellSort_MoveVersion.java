package DataStructure.Sort.ShellSort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort_MoveVersion {
    public static void main(String[] args) {
//        int[] arr = {3,2,-1,10,20};
//        ShellSort(arr);
//        System.out.println(Arrays.toString(arr));

        //测试时间复杂度
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random()*80000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("before sort:"+date1Str);

        ShellSort(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("after sort:"+date2Str);
        //测试结果:
        //8万数据用时:  1s
        //16万数据用时: 3s
        //32万数据用时: 10s
    }

    public static void ShellSort(int[] arr){
        int length = arr.length;
        for(int gap = length; gap>0 ; gap /= 2){
            for(int i = gap; i < length ; i += gap){
                int temp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > temp){
                    arr[j+gap] = arr[j];
                    j -= gap;
                }
                arr[j+gap] = temp;
            }
        }
    }
}
