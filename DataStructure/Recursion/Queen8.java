package DataStructure.Recursion;

public class Queen8 {

    //先定义一个max表示共有多少个皇后
    final int max = 5;
    //定义数组array,保存皇后放置位置的结果
    final int[] arr = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(count);
    }

    //方法:将皇后摆放的位置输出
    private void print(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        count++;
        System.out.println();
    }

    //方法:放置第n个皇后
    //特别注意: check 是每一次递归时,进入到check中都有for循环,因此会有回溯
    private void check(int n){
        if(n == max){//已经放满8个皇后
            print();
            return;
        }
        //依次放入皇后并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前皇后 n 放到该行的第一列
            arr[n] = i;
            //判断当放置第n个皇后到i列时,是否冲突
            if(judge(n)){//如果不冲突
                //接着放置第n+1个皇后,即开始递归
                check(n+1);
            }
            //如果冲突,就继续执行arr[n] = i;
            //即将第n个皇后,放置在本行的后移一个位置
        }
    }

    //方法:判断当我们放置第n个皇后时,就去检测该皇后是否和前面已经摆放的皇后冲突
    /**
     *
     * @param n 表示第n+1个皇后
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //1.arr[i] == arr[n] 判断是否在同一列
            //2.Math.abs(n-i) == Math.abs(arr[n] - arr[i] 判断是否在同一斜线
            //3.不需要判断在同一行,n每次都在递增
            if(arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n] - arr[i])){
                return false;
            }
        }
        return true;
    }
}
