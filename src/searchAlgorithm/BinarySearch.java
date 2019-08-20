package searchAlgorithm;

public class BinarySearch {

    //递归实现：
    public static int binarySearch(int[] a,int key,int low,int high){
        if(low>high)return -1;
        int mid=low+(high-low)/2;
        System.out.println("mid:"+mid);
        if(a[mid]<key){
            low=mid+1;
            System.out.println("new low:"+low);
            return binarySearch(a,key,low,high);
        }else if (a[mid]>key){
            high=mid-1;
            System.out.println("new high:"+high);
           return  binarySearch(a,key,low,high);
        }else if (a[mid]==key){
            return mid;
        }
        return -1;
    }

    //非递归实现
    public static int binarySearch_n(int[] a,int key){
        int low,high;
        low=0;
        high=a.length-1;
        System.out.println(high);
        int mid;
        while(low<high){
            mid=low+(high-low)/2;
            System.out.println("mid"+mid);
            if(a[mid]<key){
                low=mid+1;
                System.out.println("小雨了"+a[mid]);
            }
            else if(a[mid]>key) {
                high = mid - 1;
                System.out.println(a[mid]);
            }
            else if (a[mid]==key)return mid;
        }
        return -1;

    }

}
