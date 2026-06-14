import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] student = new int[n+1];

        int res = -1;

        for(int i=1; i<=m; i++){
            int index = sc.nextInt();
            student[index]+=1;
            if(student[index]>=k){
                res = index;
                break;
            }
        }

        System.out.println(res);
    }
}