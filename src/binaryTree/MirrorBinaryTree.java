package binaryTree;

import javax.mail.internet.MimeMessage;

public class MirrorBinaryTree {

    /**
     * 二叉树的镜像
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     * 使用递归，当节点存在至少一个孩子时，交换左右孩子，再递归处理。
     */
    public static void mirrorTree(TreeNode root){
        TreeNode process;
        if(root!=null&&(root.left!=null||root.right!=null)){
            process=root.left;
            root.left=root.right;
            root.right=process;
            mirrorTree(root.left);
            mirrorTree(root.right);
        }
        return;
    }



}
