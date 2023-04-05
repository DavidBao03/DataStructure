package DataStructure.BookAlgrim.Chapter2;
//神中神 多读几遍
public class maxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {4,-3,5,-2,-1,2,6,-2};
        System.out.println(maxSubSum(arr, 0, arr.length - 1));
    }

    public static int maxSubSum(int[] arr, int left, int right){

        if(left == right){
            return arr[left] < 0 ? 0 : arr[left];
        }

        int center = (left + right) / 2;

        int maxSumLeft = maxSubSum(arr,left,center);
        int maxSumRight = maxSubSum(arr,center+1,right);

        int maxleftBorderSum = 0;
        int leftBorderSum = 0;
        for (int i = center; i >= 0; i--) {
            leftBorderSum += arr[i];
            if(maxleftBorderSum < leftBorderSum){
                maxleftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0;
        int rightBorderSum = 0;
        for (int i = center+1; i < right; i++) {
            rightBorderSum += arr[i];
            if(maxRightBorderSum < rightBorderSum){
                maxRightBorderSum = rightBorderSum;
            }
        }

        return max3(maxRightBorderSum+maxleftBorderSum,maxSumRight,maxSumLeft);
    }

    public static int max3(int a,int b,int c){
        int cur = a;
        if(cur < b){
            cur = b;
        }
        if (cur < c) {
            cur = c;
        }
        return cur;
    }
}
