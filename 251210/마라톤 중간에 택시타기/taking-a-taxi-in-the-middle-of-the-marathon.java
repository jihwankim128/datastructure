import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        
        int[] xl = new int[n];
        int[] yl = new int[n];
        for (int i = 1; i < n; i++) {
            xl[i] = Math.abs(x[i] - x[i-1]) + xl[i-1];
            yl[i] = Math.abs(y[i] - y[i-1]) + yl[i-1];
        }
        
        int[] xr = new int[n];
        int[] yr = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            xr[i] = Math.abs(x[i] - x[i+1]) + xr[i+1];
            yr[i] = Math.abs(y[i] - y[i+1]) + yr[i+1];
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < n - 1; i++) {
            int nx = xl[i-1] + xr[i+1] + Math.abs(x[i-1] - x[i+1]);
            int ny = yl[i-1] + yr[i+1] + Math.abs(y[i-1] - y[i+1]);

             ans = Math.min(min, nx + ny);
        }
        System.out.println(ans);
    }
}