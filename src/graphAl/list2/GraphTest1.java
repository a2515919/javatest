package graphAl.list2;

import graphAl.list1.CreateGraph;

import java.util.Scanner;

public class GraphTest1 {

    /**
     *
     * 根据顶点信息String 返回边的对象
     */
    public static int vtoe(Graph graph,String str){
        for (int i=0;i<graph.vertexNum;i++){
            if (graph.vertexList.get(i).vertexName.equals(str)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 图的初始化
     */
    public static void initialGraph(Graph graph){

        @SuppressWarnings("resource")
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入顶点数 边数：");
        graph.vertexNum=scan.nextInt();
        graph.edgeNum=scan.nextInt();
        System.out.println("请依次输入顶点名称：");
        for (int i = 0; i <graph.vertexNum ; i++) {
            Vertex vertex=new Vertex();
            vertex.vertexName= scan.next();
            vertex.firstEdge=null;
            graph.vertexList.add(vertex);
        }
        System.out.println("请依次输入每个边： ");
        for (int i=0;i<graph.edgeNum;i++){
            String  preV=scan.next();
            String  folV=scan.next();
            int v1=vtoe(graph,preV);
            int v2=vtoe(graph,folV);
            if (v1==-1||v2==-1)
                System.out.println("输入的顶点有误！ ");

            Edge edge1=new Edge();
            edge1.edgeName=v2;
            edge1.next=graph.vertexList.get(v1).firstEdge;
            graph.vertexList.get(v1).firstEdge=edge1;

            //以上是构建有向图，加入下面代码构建无向图：
            Edge edge2=new Edge();
            edge2.edgeName=v1;
            edge2.next=graph.vertexList.get(v2).firstEdge;
            graph.vertexList.get(v2).firstEdge=edge2;
        }
    }

    /**
     * 输出图的邻接表表示：
     */
    public static void outputGraph(Graph graph){
        Edge edge=new Edge();
        for (int i=0;i<graph.vertexNum;i++){
            System.out.print(graph.vertexList.get(i).vertexName);
            edge=graph.vertexList.get(i).firstEdge;
            while(edge!=null){
                System.out.print("-->"+graph.vertexList.get(edge.edgeName).vertexName);
                edge=edge.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphTest1 graphTest1=new GraphTest1();
        Graph graph=new Graph();
        graphTest1.initialGraph(graph);
        graphTest1.outputGraph(graph);

    }









}
