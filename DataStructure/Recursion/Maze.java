package DataStructure.Recursion;

public class Maze {
    public static void main(String[] args) {
        //创建一个迷宫
        int[][] maze = new int[8][8];

        //初始化迷宫
        //设置边界
        for (int i = 0; i < 8; i++) {
            maze[0][i] = 1;
            maze[i][0] = 1;
            maze[7][i] = 1;
            maze[i][7] = 1;
        }

        //设置障碍
        maze[1][3] = 1;
        maze[3][3] = 1;
        maze[3][4] = 1;
        maze[3][5] = 1;
        maze[4][1] = 1;
        maze[4][2] = 1;
        maze[4][3] = 1;
        maze[5][6] = 1;
        maze[5][5] = 1;

        showMaze(maze);

        setWay(maze,1,1);

        System.out.println("-------------------------------");

        showMaze(maze);


    }

    //寻路方法
    //使用递归回溯来给小球找路
    ////说明:
    //1. 如果小球能到map[6][6]位置,说明有通路找到
    //2. 0代表没有走过的地方,1代表迷宫障碍,2代表已经走过的地方,3代表无法通向终点的的地方
    //3. 在走迷宫时所确定的策略: 下->右->上->左, 如果该点走不通,再回溯
    /**
     *
     * @param map 迷宫的地图
     * @param i 初始位置的纵坐标
     * @param j 初始位置的横坐标
     * @return 如果找到通路,就返回true,否则返回false
     */
    public static boolean setWay(int[][] map,int i,int j) {
        if (map[6][6] == 2) {//通路已经找到
            return true;
        } else if (map[i][j] == 0) {//如果当前点还没走过
            //假定该点可以走通
            map[i][j] = 2;
            //按照策略: 下->右->上->左
            if (setWay(map, i + 1, j)) {//向下走
                return true;
            } else if (setWay(map, i, j + 1)) {//向右走
                return true;
            } else if (setWay(map, i - 1, j)) {//向上走
                return true;
            } else if (setWay(map, i, j - 1)) {//向左走
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else { //如果map[i][j] != 0, 可能是1,2,3
            return false;
        }
    }

    public static void showMaze(int[][] map){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
