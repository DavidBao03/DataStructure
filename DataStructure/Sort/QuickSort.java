package DataStructure.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) throws InterruptedException {
//        int[] arr = {-9,78,0,10,-23};
//        quickSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
        //测试时间复杂度
        int[] arr = new int[320000];
        for (int i = 0; i < 320000; i++) {
            arr[i] = (int) (Math.random()*320000);
        }

        // 开始时间
        long stime = System.currentTimeMillis();
        // 执行时间（1s）
        Thread.sleep(1000);
        // 结束时间
        long etime = System.currentTimeMillis();
        // 计算执行时间
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));
        //测试结果:
        //8万数据用时:  --
        //16万数据用时: --
        //32万数据用时: 1010ms
    }

    public static void quickSort(int[] arr, int left,int right){
        int l = left;
        int r = right;
        int midVal = arr[(r - l)/2 + l];
        while(l < r){
            //在基准值左边找到比基准值大的值
            while(arr[l] < midVal){
                l++;
            }
            //在基准值右边找到比基准值小的值
            while (arr[r] > midVal){
                r--;
            }
            //交换两侧的值
            if(l != r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
            //如果找到的值等于基准值,则移动对侧指针
            if(arr[l] == midVal){
                r--;
            }
            if(arr[r] == midVal){
                l++;
            }
        }
        //避免递归时栈溢出
        if(l == r){
            l++;
            r--;
        }
        //向左递归:即对基准值左半部分进行操作
        if(left < r){
            quickSort(arr,left,l);
        }
        //向右递归:即对基准值右半部分进行操作
        if(right > l){
            quickSort(arr,right,r);
        }
    }
}
