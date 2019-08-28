package graphAl.kruskal;

import java.io.IOException;
import java.util.Scanner;

public class MatrixUDG {
    public int mEdgNum;         //边的数量
    public char[] mVexs;        //顶点集合
    public int[][] mMatrix;     //邻接矩阵
    public static final int INF=Integer.MAX_VALUE;

    //创建图（自己输入数据的方式：）
    public MatrixUDG(){
        System.out.println("输入顶点数：");
        int vlen=readInt();
        System.out.println("输入边数：");
        int elen =readInt();
        if (vlen<1||elen<1||(elen>(vlen*(vlen-1)))){
            System.out.println("输入有误！");
            return ;
        }
        //初始化各个“顶点”
        mVexs=new char[vlen];
        for (int i = 0; i < mVexs.length ; i++) {
            System.out.printf("Vertex(%d",i);
            mVexs[i]=readChar();
        }
        //初始化“边”的权值：
        mEdgNum=elen;
        mMatrix=new int [vlen][vlen];
        for (int i = 0; i <vlen ; i++) {
            for (int j = 0; j <vlen ; j++) {
                if (i==j)
                    mMatrix[i][j]=0;
                else
                    mMatrix[i][j]=INF;
            }
        }
        //初始化“边”的权值：根据用户输入的信息进行初始化：
        for (int i = 0; i < elen; i++) {
            System.out.printf("请输入edge(%d)的起点终点以及权",i);
            char start_char=readChar();
            char end_char=readChar();
            int weight=readInt();
            int startPos=getPosition(start_char);
            int endPos=getPosition(end_char);
            if (startPos==-1||endPos==-1){
                System.out.println("输入有误！");
                return;
            }
            mMatrix[startPos][endPos]=weight;
            mMatrix[endPos][startPos]=weight;
        }
    }
    //创建图，用已给的矩阵

    /**
     *
     * @param vexs 顶点数组
     * @param matrix    矩阵
     */
    public MatrixUDG(char[] vexs,int[][] matrix){
        //初始化顶点数和边数
        int vlen =vexs.length;
        //初始化顶点：
        mVexs=new char[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            mVexs[i]=vexs[i];
        }
        //初始化边：
        mMatrix =new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                mMatrix[i][j]=matrix[i][j];
            }
        }
        //统计边：
        mEdgNum=0;
        for (int i = 0; i < vlen; i++)
            for (int j = i+1; j <vlen ; j++)
                if (mMatrix[i][j]!=INF)
                    mEdgNum++;
        System.out.println("边数："+mEdgNum);
    }

    //返回顶点名字为：ch   的位置
    private int getPosition(char ch) {
        for (int i = 0; i < mVexs.length;i++) {
            if (mVexs[i]==ch)
                return i;

        }
        return -1;
    }


    //读取一个输入的数字
    public int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    //读取一个字符：
    public char readChar() {
        char ch = '0';
        do {
            try {
                ch = (char) System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')));
        return ch;
    }

    //边的结构
    public static class EData{
        char start;
        char end;
        int weight;
        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    /**
     *
     * @return EData
     */
    private EData[] getEdges() {
        int index=0;
        EData[] edges;
        edges=new EData[mEdgNum];
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = i+1; j <mVexs.length ; j++) {
                if (mMatrix[i][j]!=INF){
                    edges[index++]=new EData(mVexs[i],mVexs[j],mMatrix[i][j]);
                }
            }
        }
        return edges;
    }
    //对所有边进行排序（从小到大）
    private void sortEdges(EData[] edges, int elen) {
        for (int i = 0; i <elen ; i++) {
            for (int j = i+1; j <elen ; j++) {
                if (edges[i].weight>edges[j].weight) {
                    EData etemp = edges[i];
                    edges[i]=edges[j];
                    edges[j]=etemp;
                }
            }
        }
    }

    /**
     * 获取i的终点
     * @param vends
     * @param i
     * @return
     */
    private int getEnd(int[] vends, int i) {
        while(vends[i]!=0){
            i=vends[i];
        }
        return i;
    }


    public void kruskal(){
        int index=0;
        int[] vends=new int[mEdgNum];
        EData[] rets=new EData[mEdgNum];
        EData[] edges;
        //获取图中所有的边，并用EData结构封装
        edges=getEdges();
        //将边按照权的大小进行排序（从小到大）：
        sortEdges(edges,mEdgNum);

        for (int i = 0; i < mEdgNum; i++) {
            int startPos=getPosition(edges[i].start);
            int endPos=getPosition(edges[i].end);

            int start_end=getEnd(vends,startPos);
            int end_end=getEnd(vends,endPos);
            if (start_end!=end_end){
                vends[start_end]=end_end;
                rets[index++]=edges[i];
            }
        }
        //统计并打印kruskal最小生成树的信息：
        int length=0;
        for (int i = 0; i < index; i++)
            length+=rets[i].weight;
        System.out.println("Kruskal 最小生成树的总权值："+ length);
        for (int i = 0; i < index; i++)
            System.out.println(rets[i].start+"-->"+rets[i].end);
        System.out.println();
    }

    //Prime最小生成树算法：

    /**
     * 从start 位置开始：
     * @param start
     */
    public void prim(int start) {
        int num = mVexs.length;               //顶点个数
        int index = 0;                        //prim最小数的索引，即peimes数组的索引
        char[] prims = new char[num];         //prim最小数的结果数组
        int[] weights = new int[num];         //顶点间边的权值

        //prim最小生成树中第一个数是“途中第start个顶点”因为是从start开始的：
        prims[index++] = mVexs[start];

        //初始化“顶点的权值数组”
        //将每个顶点的权值初始化为“第start个顶点”到“该顶点”的权值：
        for (int i = 0; i < num; i++)
            weights[i] = mMatrix[start][i];
        //将第start个顶点的权值初始化为0
        //可以理解为“第start个顶点到他自身的距离为0”
        weights[start] = 0;
        for (int i = 0; i < num; i++) {
            if (start == i)
                continue;
            int j = 0;
            int k = 0;
            int min = INF;
            //经过上面的处理后，在未被加入到最小生成树的顶点中权值最小的顶点是第K个顶点
            //将第k个顶点加入到最小生成树的结果数组中
            while (j < num) {
                //找到距离当前prime最小生成树最短的点
                if (weights[j] != 0 && weights[j] < min) {
                    min = weights[j];
                    k = j;
                }
                j++;
            }
            //经过上面的处理后，在未被加入到最小生成树的顶点中，权值最小的顶点是第k个顶点
            //将第k个顶点加入到最小生成树的结果数组中
            prims[index++] = mVexs[k];
            //将第k个顶点的权值标记为0，代表这个顶点已经加入到生成树中了
            weights[k] = 0;
            for (j = 0; j < num; j++) {
                //当第J个节点没有被处理，并且需要更新时才被更新
                //也就是在加入新节点之后，需要更新该最小生成树到其余未加入的节点的最短距离。
                if (weights[j] != 0 && mMatrix[k][j] < weights[j]) {
                    weights[j] = mMatrix[k][j];
                }
            }
        }
        //计算最小生成树的权值：
        int sum = 0;
        for (int i = 1; i < index; i++) {//检索一个最小生成树的节点
            int min=INF;
            int n=getPosition(prims[i]);
            for (int j = 0; j < i; j++) {//检查在该节点前的所有最小生成树的节点距离该节点的最小距离即为该节点与最小生成树连接的那条边的权值。
                int m=getPosition(prims[j]);
                if (mMatrix[m][n]<min)
                    min=mMatrix[m][n];
            }
            sum+=min;
        }
        System.out.println(mVexs[start]+":" +sum);
        for (int i = 0; i < index; i++) {
            System.out.println(prims[i]);
        }
    }



    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        MatrixUDG pG;

        // 自定义"图"(输入矩阵队列)
        //pG = new MatrixUDG();
        // 采用已有的"图"
        pG = new MatrixUDG(vexs, matrix);

        //pG.print();   // 打印图
        //pG.DFS();     // 深度优先遍历
        //pG.BFS();     // 广度优先遍历
        pG.prim(0);   // prim算法生成最小生成树
        //pG.kruskal();   // Kruskal算法生成最小生成树
    }


}
