package DataStructure.Recursion;

public class OwnQueen8 {
    static int max = 8;
    public static void main(String[] args) {
        String[][] map = new String[max][max];
        for(int i = 0; i < max; i++){
            for(int j = 0; j < max; j++){
                map[i][j] = "0";
            }
        }

        check(0,map);
    }

    public static void print(String[][] map){
        for(int i = 0; i < max; i++){
            for(int j = 0; j < max; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void check(int n,String[][] map){
        if(n == max){
            print(map);
            return;
        }
        for (int i = 0; i < max; i++) {
            map[n][i] = "1";
            if(judge(n,i,map)){
                check(n+1,map);
            }else{
                map[n][i] = "0";
            }
            map[n][i] = "0";
        }
    }

    public static boolean judge(int n,int l,String[][] map){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < max; j++){
                if(map[i][j].equals("1")){
                    if(j == l || Math.abs(n-i) == Math.abs(j-l)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}



