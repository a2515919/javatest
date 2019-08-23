package graphAl;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphTest {

    //create a graph
    public static void createGraph(GraphMatrix gm){
        int i, j , k;
        int weight;
        char startV,endV;
        System.out.println("输入途中各顶点信息： ");
        Scanner scanner=new Scanner(System.in);
        for (i = 0;  i<gm.VertexNum ; i++) {
            System.out.println("第："+(i+1)+"个顶点");
            gm.Vertex[i]=scanner.nextLine().charAt(0);
        }
        System.out.println("输入各边的顶点及权值：");
        for (k=0;k<gm.EdgeNum;k++){
            System.out.println("第"+(k+1)+"条边");
            System.out.println("边的起点为：");
            startV=scanner.next().charAt(0);
            System.out.println("边的终点为：");
            endV=scanner.next().charAt(0);
            System.out.println("边的权值为：");
            weight=scanner.nextInt();
            for (i=0;gm.Vertex[i]!=startV;i++);  //通过用户输入的顶点信息来寻找该顶点，没有通过索引来查找
            for (j=0;gm.Vertex[j]!=endV;j++);
            gm.EdgeWeight[i][j]=weight;
            if(gm.GType==0)//判断是否为无向图：
                gm.EdgeWeight[j][i]=weight;
        }
    }
    //清空图：（初始化）
    static void clearGraph(GraphMatrix gm){
        for (int i=0;i<gm.VertexNum;i++)
            for (int j=0;j<gm.VertexNum;j++)
                gm.EdgeWeight[i][j]=gm.MaxValue;
    }
    //打印图：
    public static void printGraph(GraphMatrix gm){
        for (int i = 0; i<gm.VertexNum; i++) {
            System.out.printf("\t%c",gm.Vertex[i]);
        }
        System.out.println();
        for (int i=0;i<gm.VertexNum;i++){
            System.out.printf("%c",gm.Vertex[i]);
            for (int j=0;j<gm.VertexNum;j++){
                if (gm.EdgeWeight[i][j]==gm.MaxValue){
                    System.out.printf("\tZ");
                }else{
                    System.out.printf("\t"+gm.EdgeWeight[i][j]);
                }
            }
            System.out.println();
        }
    }
    //找到顶点V的对应下表：
    public static int locateVertex(GraphMatrix graphMatrix,char v){
        int i;
        for(i=0;i<graphMatrix.VertexNum;i++){
            if (graphMatrix.Vertex[i]==v)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        GraphMatrix gm=new GraphMatrix();
        gm.VertexNum=5;
        gm.EdgeNum=5;
        gm.GType=0;
        clearGraph(gm);
        createGraph(gm);
        printGraph(gm);
        BFS_Test2(gm,'c');
        clearGraph(gm);
        printGraph(gm);
    }

    /**
     * 图的广度优先遍历
     * 从start节点开始
     */
    @Test
    public static void BFS_Test2(GraphMatrix gm,char vStart){
        int v,u,i;
        boolean[] visited=new boolean[gm.VertexNum];
        for (int j=0;j<gm.VertexNum;j++)visited[j]=false;
        Queue<Integer> q=new LinkedList<Integer>();
        v=locateVertex(gm,vStart);
        if(v==-1){
            System.out.println("找不到该节点：vStart");
            return;
        }
        //for ( v = 0; v !=gm.Vertex[v] ; v++) ; //v是vStart在 节点数组里的位置
        System.out.println(vStart);
        //((LinkedList) q).push();
        visited[v]=true;
        q.offer(v);
        while(!q.isEmpty()){
            u=q.poll();//u是当前需要它的所有连接的节点下标
            //v=locateVertex(gm,u);
            for (i=0;i<gm.VertexNum;i++){
                if (gm.EdgeWeight[u][i]<gm.MaxValue&&visited[i]==false){
                    System.out.println(gm.Vertex[i]);
                    visited[i]=true;
                    q.offer(i);
                }
            }
        }
    }












}
