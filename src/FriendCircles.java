import java.util.HashSet;
import java.util.Set;

public class FriendCircles {
    static class UnionFindSet {
        int [] parents;
        int [] ranks;

        public UnionFindSet(int size) {
            parents = new int[size+1];

            for (int i = 1; i < parents.length; i++)
                parents[i] = i;

            ranks = new int[size+1];
        }

        public int find(int x) {
            if (x != parents[x])
                parents[x] = find(parents[x]);
            return parents[x];
        }

        public void union(int x, int y) {
            int xParent = find(x);
            int yParent = find(y);

            if (ranks[xParent] > ranks[yParent])
                parents[yParent] = xParent;
            else if (ranks[xParent] < ranks[yParent])
                parents[xParent] = yParent;
            else {
                parents[yParent] = xParent;
                ranks[xParent]++;
            }
        }
    }

    public static int findCircleNum(int[][] M) {
        UnionFindSet unionFindSet = new UnionFindSet(M.length);

        for (int i = 0; i < M.length; i++)
            for (int j = 0; j < i; j++)
                if (M[i][j] == 1)
                    unionFindSet.union(i, j);

        Set<Integer> set = new HashSet <>();

        for (int i = 0; i < M.length; i++)
            set.add(unionFindSet.find(i));

        return set.size();
    }

    public static void main(String[] args) {
        int[][] M = {
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
        };

        System.out.println(findCircleNum(M));

    }

}
