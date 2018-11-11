import java.rmi.MarshalException;
import java.util.*;

public class KthSmallestElementinaSortedMatrix {
    class Pair {
        int x;
        int y;
        int val;
        Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0) return 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(11, Comparator.comparingInt(o -> o.val));

        pq.add(new Pair(0, 0, matrix[0][0]));

        int count = 1;
        while (true) {
            Pair p = pq.poll();
            if (count == k)
                return p.val;

            count++;

            if (p.y == 0 && p.x < matrix.length - 1)
                pq.add(new Pair(p.x + 1, 0, matrix[p.x + 1][0]));

            if (p.y < matrix[0].length - 1)
                pq.add(new Pair(p.x, p.y + 1, matrix[p.x][p.y + 1]));
        }
    }
}
