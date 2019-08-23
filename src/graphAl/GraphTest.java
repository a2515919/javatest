package graphAl;

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
            System.out.println("变的起点为：");
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

    public static void main(String[] args) {
        GraphMatrix gm=new GraphMatrix();
        gm.VertexNum=5;
        gm.EdgeNum=5;
        gm.GType=0;
        createGraph(gm);
        printGraph(gm);
        clearGraph(gm);
        printGraph(gm);
    }





















}
