package graphAl;


public class GraphMatrix {
    static final int MaxNum=20;      //图的最大顶点数
    static final int MaxValue=65535; //顶点最大值
    int GType;                          //图的类型 定义 0：无向图；1：有向图
    int VertexNum;                      //顶点数量
    int EdgeNum;                        //边的数量
    char[] Vertex=new char[MaxNum];       //保存顶点信息
    int[][]EdgeWeight=new int[MaxNum][MaxNum];//保存权：边的信息
}
