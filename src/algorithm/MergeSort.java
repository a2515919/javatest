package algorithm;

public class MergeSort {

    public static void mergeSort(int[] a,int n){
        sort(a,0,a.length-1);
    }
    public static void sort(int[] a,int L,int R){
        if(L==R)return;
        int mid=L+((R-L)/2);
        sort(a,L,mid);
        sort(a,mid+1,R);
        merge(a,L,mid,R);
    }
    public static void merge(int[] a,int L,int mid,int R){
        int i,j,k=0;
        int[] temp=new int[R-L+1];
        i=L;
        j=mid+1;
        while(i<=mid&&j<R){
            if(a[i]>a[j]) {
                temp[k]=a[j];
                k++;j++;
            }
            else {
                temp[k]=a[i];
                k++;i++;
            }
        }
        while(i<=mid){
            temp[k]=a[i];
            k++;i++;
        }
        while(j<R){
            temp[k]=a[j];
            k++;j++;
        }
        for (i = 0;i<temp.length ; i++) {
            a[L+i]=temp[i];
        }



    }



}
