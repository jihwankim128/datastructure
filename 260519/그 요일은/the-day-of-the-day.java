import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();

        int[] dayOfMonth = new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};
        String[] days = new String[]{"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        int sum = 0;
        for(int i=0; i<m2; i++){
            sum+=dayOfMonth[i];
        }
        sum+=d2;
        for(int i=0; i<m1; i++){
            sum-=dayOfMonth[i];
        }
        sum-=d1;

        int remain = sum%7;
        int count=0;
        for(int i=0; i<days.length; i++){
            if(days[i].equals(A)){
                if(remain>=i){
                    count+=1;
                }
            }
        }
        count+=sum/7;
        System.out.println(count);

    }
}
