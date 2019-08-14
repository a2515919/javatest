package searchAlgorithm;

public class NormalSearch {

    public int nSearch(int[] a,int x){
        for (int i = 0; i <a.length ; i++) {
            if (a[i] == x) {
                return i+1;
            }
        }
        return -1;
    }






}
