package DataStructure.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] vertexes = {"A","B","C","D","E"};
        for (String vertex : vertexes) {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(1,0,1);
        graph.insertEdge(2,1,1);
        graph.insertEdge(3,1,1);
        graph.insertEdge(4,1,1);

        graph.showGraph();
    }
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;

    //构造器
    public Graph(int n){
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
        numOfEdges = 0;
    }

    //添加节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     * 添加边
     * @param v1 第一个节点的下标
     * @param v2 第二个节点的下标
     * @param weight 两个节点之间的权,1即连通,2即未连通
     */
    public void insertEdge(int v1 , int v2 , int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;//因为是无向图,所以赋值两次
        numOfEdges++;
    }

    //一些常用方法
    //获取节点数量
    public int getNumOfVertex(){
        return vertexList.size();
    }

    //获取边数量
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //获取两点之间的权
    public int getWeight(int v1 , int v2){
        return edges[v1][v2];
    }

    //根据索引获取节点信息
    public String getValueByIndex(int index){
        return vertexList.get(index);
    }

    //显示邻接矩阵
    public void showGraph(){
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }
}
