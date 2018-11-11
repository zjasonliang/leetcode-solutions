import java.util.HashSet;
import java.util.Set;

class UnionFindSet {
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

public class RedundantConnection {
    public static int[] findRedundantConnection(int[][] edges) {

        UnionFindSet unionFindSet = new UnionFindSet(edges.length);

        for (int i = 0; i < edges.length; i++) {
            if (unionFindSet.find(edges[i][0]) == unionFindSet.find(edges[i][1]))
                return edges[i];
            else
                unionFindSet.union(edges[i][0], edges[i][1]);
        }

        return null;
    }

    public static void main(String[] args) {
        // int[][] input = new int[3][];
        // input[0] = new int[]{1,2};
        // input[1] = new int[]{1,3};
        // input[2] = new int[]{2,3};

        int[][] input = new int[5][];
        input[0] = new int[]{1,5};
        input[1] = new int[]{3,4};
        input[2] = new int[]{3,5};
        input[3] = new int[]{4,5};
        input[4] = new int[]{2,4};

        int[] result = findRedundantConnection(input);

        System.out.println(result[0] + " " + result[1]);

    }
}
