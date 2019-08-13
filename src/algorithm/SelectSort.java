package algorithm;

/**
 * select sort
 * @author ZHOU
 *
 */
public class SelectSort {

    /**
     * 别人的代码
     * @param a
     * @param n
     */
    public void selectSort(int[] a, int n) {
        for (int i = 0; i <= n; i++) {
            int min_pos = i;
            for (int j = i + 1; j <= n; j++)
                if (a[j] < a[min_pos])
                    min_pos = j;
            if (min_pos != i) {
                int temp = a[i];
                a[i] = a[min_pos];
                a[min_pos] = temp;
            }
        }
    }
    /**
     * write by myself
     */
    public void selectSort_ByMe(int[] a,int n){
        int min_position=0;
        for (int i = 0; i <n ; i++) {
            min_position=i;
            for (int j = i+1; j <n ; j++) {
                if (a[i]>a[j]){
                    min_position=j;
                }
            }
            if (min_position!=i){
                int temp =a[i];
                a[i]=a[min_position];
                a[min_position]=temp;
            }
        }
    }



}
