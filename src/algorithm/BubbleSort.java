package algorithm;
import algorithm.InsertSort.*;
import algorithm.ShellSort.*;
public class BubbleSort {

    /**
     * nomal bubble sort code inplements
     * @param a
     * @param n
     */
    public static void bubbleSorts(int a[], int n)
    {
        int temp;
        n-=1;
        for (int i = 0; i < n; i++)
        {
            for (int j = n; j > i; j--)
            {
                if (a[j] < a[j - 1])
                {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
            System.out.println("第"+(i)+"次");
        }
    }

    /**
     * @descritption optimized bubble sorts
     * @param a n
     */
    public  static void optBubbleSort(int[] a,int n)
    {
        n-=1;
        int flag;
        int temp;
        for(int i=0;i<n;i++)
        {
            flag=0;
            for (int j = n; j >i ; j--) {
                if (a[j]<a[j-1]){
                 temp=a[j];
                 a[j]=a[j-1];
                 a[j-1]=temp;
                 flag=1;
                }
            }
            System.out.println("第"+(i)+"次");
            if(flag==0)
                break;
        }
    }

    public static void main(String[] args) {
        int[] a={1,5,2,6,6,8,7,5,3,4};
        int[] b={5,6,3,6,2,1,58,98,9,9};
        int[] c={1,2,3,4,5,6,8,9,7,3};
        //bubbleSorts(a,10);
        //optBubbleSort(c,10);
        //InsertSort is=new InsertSort();
        //ss.insertSort(c,10);
       // ShellSort ss=new ShellSort();
       // ss.shellSort1(b,10);
        //MergeSort.sort(b,0,9);
       // RealMergeSort.sort(b,0,9);
        QuickSort.quick_sort(b,0,9);
        for (int i:b) {
            System.out.println(i);
        }
    }
}
