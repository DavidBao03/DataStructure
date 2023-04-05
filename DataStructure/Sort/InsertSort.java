package DataStructure.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {3,2,-1,10,20};
//        insertSort(arr);
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

        insertSort(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("after sort:"+date2Str);
        //测试结果:
        //8万数据用时:  不到1s
        //16万数据用时: 2s
        //32万数据用时: 5s
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertIndex = i - 1;
            int insertVal = arr[i];
            while(insertIndex >= 0 && arr[insertIndex] > insertVal){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 != i){
                arr[insertIndex+1] = insertVal;
            }
        }
    }
}
