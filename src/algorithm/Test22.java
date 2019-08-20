package algorithm;

public class Test22 {

    public static void main(String[] args) {
        int[] a={5,6,2,8,6,54,5,0,0,0};
        Test22.backoff(a,3);
        for (int i:a
             ) {
            System.out.print(","+i);
        }
    }

    public static void backoff(int[] a,int x){

        //从a[x]包括a[x] 开始，所有元素向后移动一位
        int temp1=a[x];
        int temp2;
        int i;
        for( i=x+1;a[i]!=0;i++){
            temp2=a[i];
            a[i]=temp1;
            temp1=temp2;
        }
        a[i]=temp1;

    }
}
