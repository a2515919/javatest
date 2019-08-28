package graphAl.kruskal;


import com.ScannerTest;
import linkList.List;

import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 图的邻接链表表示法：
 */
public class ListUDG {
    private static int INF = Integer.MAX_VALUE;

    //邻接表中 边的结构：
    private class ENode {
        int ivex;   //该边所指向顶点的位置
        int weight; //该边的权
        ENode nextEdge; //该边所指向下一条边的“指针”
    }

    //邻接表中 顶点的结构：
    private class VNode {
        char data;      //顶点信息
        ENode firstEdge;    //该顶点所指向的第一条边
    }

    ;
    private int mEdgNum; //边的数量
    private VNode[] mVexs; //顶点数组

    //边的信息结构：
    public static class EData {
        char start;
        char end;
        int weight;

        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    ;


    //创建图(自己输入数据的方式)
    public ListUDG() {
        //输入顶点数边数：
        System.out.println("输入顶点数");
        int vlen = readInt();
        System.out.println("输入边数");
        int elen = readInt();
        if (vlen < 1 || elen < 1 || (elen > (vlen * (elen - 1)))) {
            System.out.println("输入不合法！");
            return;
        }

        //初始化“顶点”
        mVexs = new VNode[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("vertex(%d):", i);
            mVexs[i] = new VNode();
            mVexs[i].data = readChar();
            mVexs[i].firstEdge = null;
        }
        //初始化边：
        mEdgNum = elen;
        for (int i = 0; i < elen; i++) {
            //读取边的起点和终点：
            System.out.println("输入边的起点终点和权值：");
            char startChar = readChar();
            char endChar = readChar();
            int weight = readInt();
            int startPos = getPosition(startChar);
            int endPos = getPosition(endChar);
            ENode node1 = new ENode();
            node1.ivex = endPos;
            node1.weight = weight;
            //将该边连接到start对应顶点的所连接的边的链表里：
            node1.nextEdge = mVexs[startPos].firstEdge;
            mVexs[startPos].firstEdge = node1;
            ENode node2 = new ENode();
            node2.ivex = startPos;
            node2.weight = weight;
            //将该边连接到end对应的顶点所连接的边的链表里：（因为是无向图）
            node2.nextEdge = mVexs[endPos].firstEdge;
            mVexs[endPos].firstEdge = node2;
        }
    }

    //创建图（使用已提供的矩阵）
    //传入顶点名称字符串数组， 边的信息数组
    public ListUDG(char[] vexs, EData[] edges) {
        //初始化顶点数边数：
        int vlen = vexs.length;
        int elen = edges.length;
        int startPos;
        int endPos;
        //初始化顶点：
        mVexs = new VNode[vlen];//顶点数组
        for (int i = 0; i < mVexs.length; i++) {
            mVexs[i] = new VNode();
            mVexs[i].data = vexs[i];
            mVexs[i].firstEdge = null;
        }
        //初始化边：
        mEdgNum = elen;
        for (int i = 0; i < mEdgNum; i++) {
            //获得边的起点和终点：
            char startChar = edges[i].start;
            char endChar = edges[i].end;
            int weight = edges[i].weight;
            startPos = getPosition(startChar);
            endPos = getPosition(endChar);
            //创建该边的对象：
            ENode edge1 = new ENode();
            edge1.ivex = endPos;
            edge1.weight = weight;
            //将该边插入到起始顶点所连接的链表里
            edge1.nextEdge = mVexs[startPos].firstEdge;
            mVexs[startPos].firstEdge = edge1;
            //无向图所以要对终点的链表里也插入一条：
            ENode edge2 = new ENode();
            edge2.ivex = startPos;
            edge2.weight = weight;
            edge2.nextEdge = mVexs[endPos].firstEdge;
            mVexs[endPos].firstEdge = edge2;
        }
    }

    //深度优先搜索遍历图的递归实现：
    public void DFS(int i, boolean[] visited) {
        ENode edge;
        System.out.println(mVexs[i].data);
        visited[i] = true;
        edge = mVexs[i].firstEdge;
        while (edge != null) {
            if (!visited[edge.ivex])
                DFS(edge.ivex, visited);
            edge = edge.nextEdge;
        }
    }

    //深度优先搜索遍历图的调用：
    public void DFS() {
        boolean[] visited = new boolean[mVexs.length];
        for (int i = 0; i < mVexs.length; i++) {
            visited[i] = false;
        }
        System.out.println("DFS:");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i])
                DFS(i, visited);
        }
        System.out.println();
    }

    //广度优先搜索遍历：（类似于树的层次遍历
    public void BFS(char start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int tempPos;
        ENode tempENode;
        boolean[] visited = new boolean[mVexs.length];
        for (int i = 0; i < mVexs.length; i++) {
            visited[i] = false;
        }
        int startPos = getPosition(start);
        if (startPos == -1) {
            System.out.println("输入有误，找不到该节点！");
            return;
        }
        System.out.println("START BFS:");
        System.out.println(start);
        visited[startPos] = true;
        queue.offer(startPos);
        while (!queue.isEmpty()) {
            tempPos = queue.poll();
            for (tempENode = mVexs[tempPos].firstEdge; tempENode != null; tempENode = tempENode.nextEdge) {
                if (visited[tempENode.ivex] == false) {
                    System.out.print("-->");
                    System.out.println(mVexs[tempENode.ivex].data);
                    queue.offer(tempENode.ivex);
                }
            }
        }
    }

    //传入顶点名字返回顶点位置：
    public int getPosition(char ch) {
        for (int i = 0; i < mVexs.length; i++) {
            if (mVexs[i].data == ch)
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

    //获取图中所有的边：
    public EData[] getEdges() {
        int index = 0;
        EData[] edges;
        edges = new EData[mEdgNum];
        for (int i = 0; i < mVexs.length; i++) {
            ENode edge = mVexs[i].firstEdge;
            while (edge != null) {
                if (edge.ivex > i) {
                    edges[index++] = new EData(mVexs[i].data, mVexs[edge.ivex].data, edge.weight);
                }
                edge = edge.nextEdge;
            }
        }
        return edges;
    }

    //对所有边按照边的权值（大小）（从小到大）进行排序：
    public void sortEdges(EData[] edges, int elen) {
        for (int i = 0; i < elen; i++) {
            for (int j = i + 1; j < elen; j++) {
                if (edges[i].weight > edges[j].weight) {
                    EData tmp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = tmp;
                }
            }
        }
    }

    //获取i 的终点
    private int getEnd(int[] vends, int i) {
        while (vends[i] != 0)
            i = vends[i];
        return i;
    }

    //Krusakl 算法 最小生成树：
    public void kruskal() {
        int index = 0;     //rets 数组的索引
        int[] vends = new int[mEdgNum]; //用于保存已有最小生成树中的每个顶点在该最小树中的终点,初始即为0
        EData[] rets = new EData[mEdgNum]; //结果数组 保存kruskal最小生成树的所有边
        EData[] edges;       //该 图对应的所有边：
        //获取图中所有的边：
        edges = getEdges();
        //按照权的大小对边进行排序：
        sortEdges(edges, mEdgNum);
        for (int i = 0; i < mEdgNum; i++) {
            int startPos = getPosition(edges[i].start); //获取第i条边起点的序号
            int endPos = getPosition(edges[i].end);       //获取第i条边终点的序号
            int start_end = getEnd(vends, startPos);   //获取起点在“已有最小生成树”中的终点
            int end_end = getEnd(vends, endPos);       //获取终点在“已有最小生成树”中的终点
            //如果m!=n,意味着边i与 已经添加到 最小生成树中的顶点 没有形成环路
            if (start_end != end_end) {
                vends[start_end] = end_end;
                rets[index++] = edges[i];
            }
        }
        //统计并打印“Kruskal最小生成树”的信息：
        int length = 0;
        for (int i = 0; i < index; i++)
            length += rets[i].weight;
        System.out.println("kruskal最小生成树总长度为：" + length);
        for (int i = 0; i < index; i++)
            System.out.println(rets[i].start + "-->" + rets[i].end);
        System.out.println();
    }

    //prime最小生成树算法：
    public void prim(int start) {
        int min, i, j, k, m, n, tmp, sum;
        int num = mVexs.length;
        int index = 0;                        //prime最小树的索引，即prims数组的索引
        char[] prims = new char[num];        //prime最小树的结果数组
        int[] weights = new int[num];         //顶点间边的权值
        //prim最小生成树中第一个数是“图中第start个顶点”，因为是从start开始的
        prims[index++] = mVexs[start].data;
        //初始化start顶点到其他顶点距离
        for (i = 0; i < num; i++) {
            weights[i] = getWeight(start, i);
        }
        for (i = 0; i < num; i++) {
            if (start == i)
                continue;

            j = 0;
            k = 0;
            min = INF;
            while (j < num) {
                if (weights[j] != 0 && weights[j] < min) {
                    min = weights[j];
                    k = j;
                }
                j++;
            }
            //经过上面的处理后，在未被加入到最小生成树的顶点中权值最小的顶点就是第K个顶点
            //将第K个顶点加入到最小生成树的结果数组中
            prims[index++] = mVexs[k].data;
            //将第k个顶点的权值标记为0，表示已经加入到prim最小生成树中了
            weights[k] = 0;
            //在该第k顶点加入之后更新prim树到其他顶点的权值
            for (j = 0; j < num; j++) {
                //获取第k个顶点到第j个顶点的距离权值
                tmp = getWeight(k, j);
                if (weights[j] != 0 && weights[j] > tmp)
                    weights[j] = tmp;
            }
        }
        //计算最小生成树的权值：
        sum = 0;
        for (i = 1; i < index; i++) {
            min = INF;
            n = getPosition(prims[i]);
            for (j = 0; j < i; j++) {
                m = getPosition(prims[j]);
                tmp = getWeight(m, n);
                if (tmp < min)
                    min = tmp;
            }
            sum += min;
        }
        //打印最小生成树：
        System.out.println("prime:从" + mVexs[start].data + "开始，总距离为：" + sum);
        for (i = 0; i < index; i++) {
            System.out.println(prims[i]);
        }
    }

    private int getWeight(int start, int end) {
        if (start == end)
            return 0;
        ENode edge = mVexs[start].firstEdge;
        while (edge != null) {
            if (end == edge.ivex)
                return edge.weight;
            edge = edge.nextEdge;
        }
        return INF;
    }

    /**
     * Dijkstra单源最短路径算法（图中某点到其他各个顶点最短距离）
     *
     * @param vs   - - 起始顶点（start vertex）
     * @param prev - - 前驱顶点数组。即prev[i]的值是顶点vs到顶点i所经历的所有顶点中，
     *             位于顶点i前边的额那个顶点的索引
     * @param dist - - 长度数组，即，dist[i]是顶点vs到顶点i的最短路径的长度。
     */
    public void Dijkstra(int vs, int[] prev, int[] dist) {
        //判断到顶点的最短路径是否已经有了
        boolean[] flag = new boolean[mVexs.length];
        //initial
        for (int i = 0; i < mVexs.length; i++) {
            flag[i] = false;
            prev[i] = 0;  //初始化所有节点的前驱节点
            dist[i] = getWeight(vs, i);
        }
        //对顶点vs自身进行初始化：
        flag[vs] = true;
        dist[vs] = 0;

        //遍历mVexs.length-1次；每次找出一个顶点的最短路径
        int k = 0;
        for (int i = 1; i < mVexs.length; i++) {
            int min = INF;
            for (int j = 0; j < mVexs.length; j++) {
                if (flag[j] == false && dist[j] < min) {
                    min = dist[j];
                    k = j;
                }
            }
            flag[k] = true;
            //重新计算到其他未加入的节点的距离
            for (int j = 0; j < mVexs.length; j++) {
                int tmp = getWeight(k, j);
                tmp = (tmp == INF ? INF : (min + tmp));
                if (flag[j] == false && (tmp < dist[j])) {
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }
        System.out.println("Dijkstra: start with " + mVexs[vs].data);
        for (int i = 0; i < mVexs.length; i++) {
            System.out.println("最短路径（" + mVexs[vs].data + mVexs[i].data + "）  " + dist[i]);
        }
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        EData[] edges = {
                // 起点 终点 权
                new EData('A', 'B', 12),
                new EData('A', 'F', 16),
                new EData('A', 'G', 14),
                new EData('B', 'C', 10),
                new EData('B', 'F', 7),
                new EData('C', 'D', 3),
                new EData('C', 'E', 5),
                new EData('C', 'F', 6),
                new EData('D', 'E', 4),
                new EData('E', 'F', 2),
                new EData('E', 'G', 8),
                new EData('F', 'G', 9),
        };
        ListUDG pG;
        // 自定义"图"(输入矩阵队列)
        //pG = new ListUDG();
        // 采用已有的"图"
        pG = new ListUDG(vexs, edges);
        //pG.print();   // 打印图
        //pG.DFS();     // 深度优先遍历
        //pG.BFS();     // 广度优先遍历
        //pG.prim(0);   // prim算法生成最小生成树
        //pG.kruskal();   // Kruskal算法生成最小生成树
        int[] prev = new int[pG.mVexs.length];
        int[] dist = new int[pG.mVexs.length];
        // dijkstra算法获取"第4个顶点"到其它各个顶点的最短距离
        pG.Dijkstra(3, prev, dist);

    }
}
