package algorithm;

public class InsertSort {


    public  void insertSort(int[] a,int n)
    {
        int temp;
        n-=1;
        for(int i=0;i<n;i++)
        {
            int j=i+1;
            while(j>0)
            {
                if(a[j]<a[j-1])
                {
                    temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                    j--;
                }else
                    break;
            }
        }
    }
}
