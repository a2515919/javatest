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
//    递归解法： O(n)O(n)
//    如果二叉树为空，二叉树的深度为0
//    如果二叉树不为空，二叉树的深度 = max(左子树深度， 右子树深度) + 1
    /**
     * 求二叉树的深度（高度）
     * 递归
     * @return 树的深度
     */
    public static int getDepthRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepthRec(root.left), getDepthRec(root.right)) + 1;
    }
//3. 求二叉树第k层的节点个数
//    递归解法： O(n)O(n)
//    思路：求以root为根的k层节点数目，等价于求以root左孩子为根的k-1层（因为少了root）节点数目 加上以root右孩子为根的k-1层（因为 少了root）节点数目。即：
//
//    如果二叉树为空或者k<1，返回0
//    如果二叉树不为空并且k==1，返回1
//    如果二叉树不为空且k>1，返回root左子树中k-1层的节点个数与root右子树k-1层节点个数之和
    /**
     * 求二叉树第k层的节点个数
     * 递归
     * @param root 根节点
     * @param k 第k个节点
     * @return 第k层节点数
     */
    public static int getNodeNumKthLevelRec(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getNodeNumKthLevelRec(root.left, k - 1) + getNodeNumKthLevelRec(root.right, k - 1);
    }
//    4. 求二叉树中叶子节点的个数
//    递归解法：
//
//    如果二叉树为空，返回0
//    如果二叉树是叶子节点，返回1
//    如果二叉树不是叶子节点，二叉树的叶子节点数 = 左子树叶子节点数 + 右子树叶子节点数
    /**
     * 4. 求二叉树中叶子节点的个数
     * 递归
     * @param root 根节点
     * @return 叶子节点个数
     */
    public static int getNodeNumLeafRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);
    }

   // 非递归解法：基于层次遍历进行求解，利用Queue进行。

    /**
     * 4. 求二叉树中叶子节点的个数（迭代）
     * 非递归
     * @param root 根节点
     * @return 叶子节点个数
     */
    public static int getNodeNumLeaf(TreeNode root){
        if (root == null) {
            return 0;
        }
        int leaf = 0; // 叶子节点个数
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left == null && temp.right == null) { // 叶子节点
                leaf++;
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return leaf;
    }





}
