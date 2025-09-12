import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> blocks = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            blocks.addLast(sc.nextInt());
        }
        int s1 = sc.nextInt() - 1;
        int e1 = sc.nextInt() - s1;
        int s2 = sc.nextInt() - 1;
        int e2 = sc.nextInt() - s2;
        
        for (int i = 0; i < e1; i++) {
            blocks.remove(s1);
        }
        for (int i = 0; i < e2; i++) {
            blocks.remove(s2);
        }

        System.out.println(blocks.size());
        for (int block: blocks) {
            System.out.println(block);
        }
    }
}