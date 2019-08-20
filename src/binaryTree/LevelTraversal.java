package binaryTree;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * c层次遍历
 * 计算层数（深度）
 */
public class LevelTraversal {

    /**
     * 层次遍历 使用递归
     * 借助队列结构
     */
    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode processNode;
        while(!queue.isEmpty()){
            processNode=queue.poll();
            if(processNode!=null){
                System.out.print("-"+processNode.val);
                queue.offer(processNode.left);
                queue.offer(processNode.right);
            }
        }
        return;
    }
    /**
     * 计算二叉树的层数（深度）
     * 使用非递归方法
     */
    public static int computeBTreeLevel(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        TreeNode processNode;
        int depth = 0;
        while (!q.isEmpty()) {
            int len = q.size();//遍历一层结束，把该层的所有子孩子加入队列，
            // 设置len值为每一层的节点数总标记
            depth++;
            while (len > 0) {
                len--;
                processNode = q.poll();
                if (processNode != null) {
                    q.offer(processNode.left);
                    q.offer(processNode.right);
                }
            }
        }
        return depth - 1;
    }
    /**
     * 计算二叉树的深度，使用递归的方法
     */
    public static int computeDepth_n(TreeNode root){
        int depth=root!=null?1+Math.max(computeDepth_n(root.left),computeDepth_n(root.right)):0;

        return depth;
    }
}
