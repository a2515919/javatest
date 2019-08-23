package graphAl.list1;

import org.junit.Test;

import java.util.Scanner;

public class CreateGraph {

    /**
     * 查找顶点
     * 根据用户输入顶点名称String
     * 返回该顶点
     */
    public static Vertex1 getVetex(Graph1 graph,String str){
        for (int i=0;i<graph.verNum;i++){
            if (graph.vertexArray[i].verName.equals(str))
                return graph.vertexArray[i];
        }
        return null;
    }

    /**
     * 生成一个图（初始化一个图）
     * 用户输入信息
     */
    public static void initialGraph(Graph1 graph){
        @SuppressWarnings("resource")
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入顶点数和边数：");
        graph.verNum=scan.nextInt();
        graph.edgeNum=scan.nextInt();
        System.out.println("请依次输入顶点名称：");
        for (int i = 0; i <graph.verNum ; i++) {
            Vertex1 vertex=new Vertex1();
            vertex.verName=scan.next();
            vertex.nextNode=null;
            graph.vertexArray[i]=vertex;
        }
        System.out.println("请依次输入图的边：");
        for (int i=0;i<graph.edgeNum;i++){
            String preV=scan.next();
            String folV=scan.next();
            Vertex1 v1=getVetex(graph,preV);
            if (v1==null)
                System.out.println("输入有误，找不到该顶点");
            //重新生成一个名字为终点名字的节点 加入到起始节点的后边的链表里↓
            Vertex1 v2=new Vertex1();
            v2.verName=folV;
            v2.nextNode=v1.nextNode;//继承v1的已有链表
            v1.nextNode=v2;//完成v2节点的插入

            //以上就是构筑有向图的代码， 加入以下代码构筑无向图：↓
            Vertex1 endv1=getVetex(graph,folV);
            if (endv1==null)
                System.out.println("输入有误找不到终点：");
            Vertex1 endv2=new Vertex1();
            endv2.verName=preV;
            endv2.nextNode=endv1.nextNode;
            endv1.nextNode=endv2;
        }
    }
    /**
     * 输入该图的邻接表
     */
    public static void outputGraph(Graph1 graph){
        System.out.println("输出该图的邻接链表：");
        for (int i=0;i<graph.verNum;i++){
            Vertex1 vertex=graph.vertexArray[i];
            System.out.print(vertex.verName);
            Vertex1 current=vertex.nextNode;
            while (current!=null){
                System.out.print("-->"+current.verName);
                current=current.nextNode;
            }
            System.out.println();
        }
    }

    @Test
    public void testt(){
        Graph1 graph=new Graph1();
        initialGraph(graph);
        outputGraph(graph);
    }

}
