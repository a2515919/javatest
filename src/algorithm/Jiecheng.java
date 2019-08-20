package algorithm;

public class Jiecheng {

    public static void jc(int n){
        long total=1;
        for(int i=1;i<=n;i++){
            total=total*i;
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        Jiecheng.jc(34);
    }
}
