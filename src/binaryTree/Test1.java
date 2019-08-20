package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Test1 {
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
}
