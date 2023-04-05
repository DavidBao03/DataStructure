package DataStructure.Search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-1,3,9,10,20};
        System.out.println(binarySearch(arr,50,0,arr.length-1));
    }

    public static int binarySearch(int[] arr,int findVal,int left,int right){
        if(left > right){
            return -1;
        }
        int mid = (right-left)/2+left;
        if(arr[mid] < findVal){//向右递归
            return binarySearch(arr,findVal,mid+1,right);
        } else if (arr[mid] > findVal) {//向左递归`
            return binarySearch(arr,findVal,left,mid-1);
        }else return mid;

    }
}
