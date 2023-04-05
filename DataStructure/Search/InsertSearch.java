package DataStructure.Search;

public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = {-1,3,9,10,20};
        System.out.println(insertSearch(arr,20,0,arr.length-1));
    }

    public static int insertSearch(int[] arr, int findVal, int left, int right){
        if(left > right || findVal < arr[left] || findVal > arr[right]){
            return -1;
        }
        int mid = (right-left)*(findVal-arr[left])/(arr[right]-arr[left])+left;
        if(arr[mid] < findVal){//向右递归
            return insertSearch(arr,findVal,mid+1,right);
        } else if (arr[mid] > findVal) {//向左递归`
            return insertSearch(arr,findVal,left,mid-1);
        }else return mid;

    }
}
