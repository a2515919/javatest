package leetcode;

import binaryTree.TreeNode;
import linkList.List;
import org.junit.Test;

import java.util.*;

import static java.util.Arrays.asList;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class LeetCode {

    public static String reverseWords(String s) {
        String string="runoob";
        String reverse = new StringBuffer(string).reverse().toString();
        System.out.println("字符串反转前:"+string);
        System.out.println("字符串反转后:"+reverse);
        String[] a=s.split(" ");
        StringBuffer result=new StringBuffer("");
        for (int i = 0; i <a.length ; i++) {
            result.append(new StringBuffer(a[i]).reverse().toString()+" ");
        }



        //ArrayList list=new ArrayList<String>(s.split(" "));
        //List<String> list=Arrays.asList(new String[]{"aaa","bbb"});
        //Collections.reverse(s);
        ArrayList list=new ArrayList<String>(Arrays.asList(s.split(" ")));
        Collections.reverse(list);
        System.out.println(list.toString());
        return result.toString().substring(0,result.length()-1);

    }


    public boolean containsDuplicate(int[] nums) {
       // Collections.sort(nums);
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]==nums[i+1])
                return true;
        }
        return false;
    }

    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null)return head;

        ListNode z,x,c;
        z=head;x=head.next;
        head.next=null;
        while(x!=null){
            c=x.next;
            x.next=z;
            z=x;
            x=c;
        }
        return z;
    }
    public int majorityElement(int[] nums) {

        Stack<Integer> s=new Stack<Integer>();
        int temp;
        for (int i = 0; i <nums.length ; i++) {
            if (s.empty()){
                s.push(nums[i]);
                continue;
            }
            if (s.peek()==nums[i]){
                s.push(nums[i]);
            }else
                s.pop();
        }

        return s.peek();
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1=headA;
        ListNode l2=headB;
        ListNode shortt,longg;
        int numsA=0,numsB=0,chazhi;
        //遍历headA
        while(l1!=null){
            numsA++;
            l1=l1.next;
        }
        //开始遍历headB
        while(l2!=null){
            numsB++;
            l2=l2.next;
        }
        //计算差值
        chazhi=numsA-numsB;
        if (chazhi<0){
            longg=headB;
            shortt=headA;
            chazhi*=(-1);
        }else{
            longg=headA;
            shortt=headB;
        }
        //长的先遍历差值个节点和短的保持一致
        for (int i = 0; i <chazhi ; i++) {
            longg=longg.next;
        }
        while(longg!=null&&shortt!=null){
            if (longg==shortt)
                return longg;
            longg=longg.next;
            shortt=shortt.next;
        }

        return null;
    }

    public static int singleNumber(int[] nums) {
        int x=nums[0];
        for (int i = 1; i <nums.length; i++) {
            x = x^nums[i];
        }
        return x;
    }

    public static void main(String[] args) {
        String s="sadf jjsaf sad asd sdf as dsa";
        reverseWords(s);

        TreeNode n1=new TreeNode(5);
        TreeNode x1,x2;
        x1=n1;
        x2=n1;
        System.out.println(x1==x2);
       // int[] nums={2,3,6,5,6,5,2,3,1};
        //System.out.println(LeetCode.singleNumber(nums));

        ArrayList<Integer> arr=new ArrayList<>();
        int a=arr.get(1);
        arr.remove(2);
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void test2() {
        int a=2;
        int b=3;
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("a="+a+",b="+b);
    }

    public int maxProfit(int[] prices) {
        if (prices.length<1)return 0;
        int max=0,min=0;
        min=prices[0];
        max=prices[0];
        int profit=0;
        for (int i = 0; i <prices.length ; i++) {
            if(prices[i]<min){
                if(max>min)
                    profit +=(max-min);
                min=prices[i];
                max=prices[i];
            }
            if(prices[i]>max){
                max=prices[i];
            }
            if (prices[i]<max&&prices[i]>=min){
                profit+=(max-min);
                min=prices[i];
                max=prices[i];
            }
        }

                return profit;
    }

}
