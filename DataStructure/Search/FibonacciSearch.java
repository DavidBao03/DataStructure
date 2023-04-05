package DataStructure.Search;

import java.util.Arrays;

public class FibonacciSearch {
    public static int MAX_SIZE = 20;

    public static void main(String[] args) {
        int[] arr = {-1,3,9,10,20,50,70};
       System.out.println(fibonacciSearch(arr,70));
    }

    //生成斐波那契数列
    public static int[] fib(){
        int[] fib = new int[MAX_SIZE];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < MAX_SIZE; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib;
    }

    public static int fibonacciSearch(int[] arr,int findVal){
        int[] fib = fib();
        int left = 0;
        int right = arr.length-1;
        int k = 0;

        while (fib[k] - 1 < arr.length){
            k++;
        }

        int[] temp;
        temp = Arrays.copyOf(arr,fib[k]);
        for (int i = arr.length; i < temp.length; i++) {
            temp[i] = arr[arr.length-1];
        }

        while(left <= right){
            int mid = fib[k-1] - 1 + left;
            if(temp[mid] > findVal){
                right = mid - 1;
                k --;
            } else if (temp[mid] < findVal) {
                left = mid + 1;
                k -= 2;
            }else return Math.min(mid,right);
        }
        return -1;
    }
}
