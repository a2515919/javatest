package algorithm;

import java.util.Scanner;

public class Solution {
    public  long climbStairs(int n) {
        int i,j=0,total=0;
        long account=0;
        if(n%2==0)
            account=1;
        for(i=1;i<=n;i++){
            if((n-i)%2==0){
                j=(n-i)/2;
                total=i+j;
                account+=C(total,i);
            }
        }
        int total1=(int)account;
        return total1;
    }
    // 求排列数 A(n,m) n>m
    public static long jc(int n)
    {
        long total=1;
        for(int i=1;i<=n;i++){
            total=total*i;
        }
        return total;
    }
    public static long C(int n, int m)// 应用组合数的互补率简化计算量
    {
        return jc(n)/(jc(m)*jc(n-m));
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        Scanner sc=new Scanner(System.in);
        int ipu;
        System.out.println(jc(24));
//        for (int i = 1; i <30 ; i++) {
//            System.out.print("shurushuzi :"+i);
//            //ipu=sc.nextInt();
//            System.out.println("output: "+s.climbStairs(i));
//
//        }
        // System.out.println(Solution.climbStairs(35));
    }
}
