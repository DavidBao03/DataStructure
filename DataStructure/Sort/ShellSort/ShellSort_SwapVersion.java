package DataStructure.Sort.ShellSort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShellSort_SwapVersion {
    public static void main(String[] args) {
//        int[] arr = {3,2,-1,10,20};
//        ShellSort(arr);
//        System.out.println(Arrays.toString(arr));

        //测试时间复杂度
        int[] arr = new int[320000];
        for (int i = 0; i < 320000; i++) {
            arr[i] = (int) (Math.random()*320000);
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
        //8万数据用时:  3s
        //16万数据用时: 10s
        //32万数据用时: 40s
    }

    public static void ShellSort(int[] arr){
        int length = arr.length;
        int temp = 0;
        for(int gap = length; gap>0 ; gap /= 2){
            for(int i = gap; i < length ; i += gap){
                for (int j = i - gap; j >= 0; j -= gap) {
                    if(arr[j] > arr[i]){
                        temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
        }
    }
}
