package DataStructure.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {
    public static void main(String[] args) {

        //测试时间复杂度
        int[] arr = new int[1280000];
        for (int i = 0; i < 1280000; i++) {
            arr[i] = (int) (Math.random()*1280000);
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
        //32万数据用时: 不到1秒
        //64万数据用时: 不到1秒
        //128万数据用时:不到1秒

    }

    public static void heapSort(int[] arr){
        for (int i = arr.length/2-1; i >= 0 ; i--) {
            adjustHeap(arr,i, arr.length);
        }
        for (int i = arr.length-1; i >= 0 ; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,i);
        }
    }

    /**
     * 创建大顶堆的方法
     * @param arr 需要调整的数组
     * @param i 需要调整的元素,即顶端元素
     * @param length 需要调整的元素个数
     */
    public static void adjustHeap(int[] arr,int i,int length){
        //记录父节点的值
        int temp = arr[i];
        for(int k = i*2 +1; k < length ; k = k*2 +1){
            if(k+1 < length && arr[k+1] > arr[k]){//记录左右子节点中大的那一个
                k++;
            }
            if(arr[k] > temp){//如果子节点更大,则赋值给父节点
                arr[i] = arr[k];
                i = k;//调整指针位置,使其指向赋值给父节点的子节点
            }else {//如果父节点更大,说明该子树已完成调整
                break;
            }
        }
        //将被覆盖的父结点的值赋值给先前赋值给父节点的子节点
        arr[i] = temp;
    }
}
