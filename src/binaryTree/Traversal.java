package binaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Traversal {
    /**
     * 递归方法
     * 先序遍历
     * @param root
     */
    public static void preOrder(TreeNode root){
        if(root==null)return;
        System.out.print("-"+root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 非递归方法
     * 先序遍历
     * 借助栈，每遍历一个节点，就把它的右孩子和左孩子依次进栈
     * （一定是右孩子先进，左孩子后进，遍历的时候就会先遍历左孩子），
     * 然后循环遍历栈，直到栈为空。
     * @param root
     */
    public static void preOrder_n(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);//根节点进栈
        TreeNode processNode; //中间要处理的节点
        while (!stack.empty()) {  //判断栈是否为空
            processNode = stack.peek(); //取栈顶元素，不删除该节点
            stack.pop();   //该节点出栈，（删除栈顶节点）
            if (processNode != null) {
                System.out.print("-" + processNode.val); //（遍历该节点）
                if (processNode.right != null)
                    stack.push(processNode.right);
                if (processNode.left != null)
                    stack.push(processNode.left);
            }
        }
    }


    /**
     * 递归方法
     * 中序遍历
     * @param root
     */
    public static void inOrder(TreeNode root){
        if (root==null)return;
        inOrder(root.left);
        System.out.print("-"+root.val);
        inOrder(root.right);
    }

    /**
     * 非递归方法
     * 中序遍历
     * 借助栈结构。
     * @param root
     */
    public static void inOrder_n(TreeNode root){
        Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode processNode;
        //s.push(root);
        processNode=root;
        while(!s.empty()||root!=null){
            while(root!=null){
                s.push(root);
                root=root.left;
            }
            processNode=s.peek();
            s.pop();
            System.out.print("-"+processNode.val);
            root=processNode.right;
        }
        return;


    }

    /**
     * 递归方法
     * 后序遍历
     * @param root
     */
    public static void postOrder(TreeNode root){
        if (root==null)return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print("-"+root.val);

    }

    /**
     * 非递归方法
     * 后序遍历
     *
     * @param root
     * 是先序遍历的逆序列
     */
    public static void postOrder_n(TreeNode root,int n){
        Stack<TreeNode> s=new Stack<TreeNode>();
        s.push(root);
        TreeNode processN;
        ArrayList<Integer> arr=new ArrayList<Integer>(n);
        while(!s.empty()){
            processN=s.peek();
            s.pop();
            if (processN!=null){
                arr.add(processN.val);
                //System.out.print("-"+processN.val);
                s.push(processN.left);
                s.push(processN.right);
            }
        }
        Collections.reverse(arr);
        for (int i:arr) {
            System.out.print("-"+i);
        }
        return;


    }


}
