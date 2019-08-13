package algorithm;

/**
 * 快读排序
 */
public class QuickSort {

    public static void quick_sort(int[] a, int l, int r) {
        if (l < r) {
            int temp;
            int x = a[l]; //选定中间值
            int i = l;    //左标
            int j = r;    //右标
            while (i < j) {
                while (i < j && a[j] >= x)
                    j--;
                if (i < j) {
                    a[i] = a[j];
                    i++;
                }
                while (i < j && a[i] < x)
                    i++;
                if (i < j) {
                    a[j] = a[i];
                    j--;
                }
            }
            a[i] = x;
            quick_sort(a, l, i - 1);
            quick_sort(a, i + 1, r);
        }
    }
}
