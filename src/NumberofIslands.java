import com.sun.imageio.plugins.gif.GIFImageReader;

import java.util.HashSet;
import java.util.Set;

public class NumberofIslands {
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

    public static int numIslands(char[][] grid) {

        if (grid.length == 0) return 0;

        UnionFindSet unionFindSet = new UnionFindSet(grid.length * grid[0].length);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i < grid.length - 1 && grid[i][j] == grid[i + 1][j])
                    unionFindSet.union(getId(grid, i, j), getId(grid, i + 1, j));
                if (j < grid[0].length - 1 && grid[i][j] == grid[i][j + 1])
                    unionFindSet.union(getId(grid, i, j), getId(grid, i, j + 1));
            }

        }

        Set<Integer> set = new HashSet <>();

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == '1')
                    set.add(unionFindSet.find(getId(grid, i, j)));

        return set.size();
    }

    private static int getId(char[][] grid, int i, int j) {
        return i * grid[0].length + j;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));
    }
}
