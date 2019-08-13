package algorithm;

public class ShellSort {

    public  void shellSort1(int[] a, int n) {
        int temp;
        for (int gap = n / 2; gap >= 1; gap = gap / 2) {
            for (int i = gap; i < n; i++) {
                temp = a[i];
                for (int j = i; j >= gap && a[j] < a[j - gap]; j = j - gap) {
                    temp = a[j];
                    a[j] = a[j - gap];
                    a[j - gap] = temp;
                }
            }
        }
    }
}
