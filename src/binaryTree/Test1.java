package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的前中后遍历，包含递归和非递归两种方法
 */
public class Test1 {
    //我自己写的层次遍历
    public int maxDepth(TreeNode root) {
        int depth=0;
        Queue<TreeNode> queue = new LinkedList();
        TreeNode tn;
        queue.offer(root);
        while(queue.size()>0){
            tn=queue.poll();
            System.out.println(tn.val);
            if (tn.left!=null)
                queue.offer(tn.left);
            if (tn.right!=null)
                queue.offer(tn.right);
        }
        return 0;
    }

    /**
     * 递归算法的测试方法
     * @param args
     */
    public static void main(String[] args) {
        int[] tree1={3,9,20,0,0,15,7};
        TreeNode[] nodes=new TreeNode[tree1.length];
        for (int i = 0; i <tree1.length ; i++) {
            TreeNode node2=new TreeNode();
            nodes[i]=node2;
        }
        TreeNode root=createBTree(tree1,nodes);
        System.out.println("层次遍历：");
        LevelTraversal.levelOrderTraversal(root);
        System.out.print("\n"+"计算二叉树的深度(使用非递归方法）：");
        System.out.print(LevelTraversal.computeBTreeLevel(root));
        System.out.print("\n"+"计算二叉树的深度(使用递归方法）：");
        System.out.print(LevelTraversal.computeDepth_n(root));
        System.out.println("\n"+"递归算法：");
        System.out.print("pre : ");
        Traversal.preOrder(root);
        System.out.print("\n"+"inOder: ");
        Traversal.inOrder(root);
        System.out.print("\n"+"Post ：");
        Traversal.postOrder(root);
        System.out.println("\n"+"非递归算法： ");
        System.out.print("pre : ");
        Traversal.preOrder_n(root);
        System.out.print("\n"+"inOder: ");
        Traversal.inOrder_n(root);
        System.out.print("\n"+"Post ：");
        Traversal.postOrder_n(root,tree1.length);
        //计算二叉树的镜像
        System.out.print("\n"+"计算二叉树的镜像： ");
        MirrorBinaryTree.mirrorTree(root);
        System.out.print("\n"+"pre : ");
        Traversal.preOrder(root);

    }

    /**
     * 给一个数组，生成一个完全二叉树
     * 0代表空
     * @return
     */
    public static TreeNode createBTree(int[] a,TreeNode[] nodes){
        if (a[0]==0)return null;
        //TreeNode[] nodes=new TreeNode[a.length];
        for (int i = 0; i <a.length ; i++) {
            nodes[i].val=a[i];
        }
        for (int i = 0; i <nodes.length ; i++) {
            if(nodes[i].val!=0){
                if((2*i+1)<nodes.length&&nodes[2*i+1].val!=0)
                    nodes[i].left=nodes[2*i+1];
                if ((2*i+2)<nodes.length&&nodes[2*i+2].val!=0)
                    nodes[i].right=nodes[2*i+2];
            }
        }
        return nodes[0];
    }
}
