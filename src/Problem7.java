import java.util.PriorityQueue;

/**
 * Created by Bob_JIANG on 8/14/2015.
 */
public class Problem7 {

    public static int getKthMagicNumber(int n) {
        PriorityQueue<Integer> PI = new PriorityQueue<>();
        PI.add(1);
        int i;
        for(i = 0; i < n; i++) {
            int temp = PI.poll();
            PI.add(temp * 3);
            PI.add(temp * 5);
            PI.add(temp * 7);
        }
        return PI.peek();
    }

    //Notice the use of Priority queue here. Just put everything in the priority queue
    public static void main(String[] args) {
        for (int i = 0; i < 14; i++) {
            System.out.println(i + " : " + getKthMagicNumber(i));
        }
    }
}
