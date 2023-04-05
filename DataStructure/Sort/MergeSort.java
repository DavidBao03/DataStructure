package DataStructure.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
        //int[] arr = {3,9,-1,10,20,2,3,23,23,132,423,2,23,2,1};
        //测试时间复杂度
        int[] arr = new int[1280000];
        for (int i = 0; i < 1280000; i++) {
            arr[i] = (int) (Math.random()*1280000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("before sort:"+date1Str);

        int[] temp = new int[arr.length];
        mergeSort(arr,0, arr.length-1,temp);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("after sort:"+date2Str);
        //测试结果:
        //32万数据用时: 不到1秒
        //64万数据用时: 不到1秒
        //128万数据用时:不到1秒

        //System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left < right){
            int mid = (right - left)/2 + left;
            //向左递归
            mergeSort(arr,left,mid,temp);
            //向右递归
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }

    //合并的方法
    public static void merge(int[] arr, int left, int mid, int right,int[] temp){
        int l = left;
        int r = mid+1;
        int t = l;


        while(l <= mid && r <= right){
            if(arr[l] > arr[r]){
                temp[t] = arr[r];
                r++;
            }else {
                temp[t] = arr[l];
                l++;
            }
            t++;
        }

        while (l <= mid){
            temp[t] = arr[l];
            t++;
            l++;
        }
        while (r <= right){
            temp[t] = arr[r];
            t++;
            r++;
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}
