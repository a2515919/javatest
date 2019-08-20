package algorithm;

/**
 * 堆排序算法
 */
public class HeapSort {

    /**
     * Construct the max root heap
     * 下表从0开始。 n代表最大索引
     *
     * 最大非叶子结点的索引为=（n-1)/2
     * @param a 566
     * @param n 5656
     */
    public static void max_heap(int[] a,int n){
         //int child;
        //i代表当前完全二叉树的最大非叶子结点的索引
        /**
         *
         * 这个方法只是把最大的元素放在堆顶，每次调整的时候不再对子节点进行调整。
         */
        for (int i = (n - 1) / 2; i >= 0; i--) {
            if ((2 * i + 2) <= n && a[i] < a[2 * i + 2]) {
                System.out.println(a[i] + "==" + a[2 * i + 2]);
                swap(a, i, 2*i+2);
            }
            if (a[i]<a[2*i+1]){
                System.out.println(a[i] + "==" + a[2 * i + 1]);
                swap(a,i,2*i+1);
            }
        }

    }
    public static void swap(int[] a,int i,int j){
        int temp=0;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void heap_sort(int[] a,int n){
        n-=1;
        for (int i = n; i >0 ; i--) {
            max_heap(a,n);
            swap(a,i,0);
        }

    }













}
