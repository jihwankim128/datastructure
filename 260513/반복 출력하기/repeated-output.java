import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        printSomething(n);
    }

    public static void printSomething(int n){
        for(int i=0;i<n;i++){
            System.out.println("12345^&*()_");
        }
    }
}