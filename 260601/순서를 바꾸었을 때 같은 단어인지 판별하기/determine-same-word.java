import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();
        char[] newWord1 = word1.toCharArray();
        char[] newWord2 = word2.toCharArray();

        Arrays.sort(newWord1);
        Arrays.sort(newWord2);

        String finalWord1 = new String(newWord1);
        String finalWord2 = new String(newWord2);

        if(finalWord1.equals(finalWord2)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
