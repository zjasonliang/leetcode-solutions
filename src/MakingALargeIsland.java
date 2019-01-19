import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    private int[][] group;
    private int[][] grid;
    private int m;
    private int n;

    private int dfs(int i, int j, int firstI, int firstJ) {
        group[i][j] = firstI * n + firstJ;

        if (grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = -1;

        int size = 0;

        if (i > 0 && grid[i - 1][j] == 1) {
            size += dfs(i - 1, j, firstI, firstJ);
        }

        if (i < m - 1 && grid[i + 1][j] == 1) {
            size += dfs(i + 1, j, firstI, firstJ);
        }

        if (j > 0 && grid[i][j - 1] == 1) {
            size += dfs(i, j - 1, firstI, firstJ);
        }

        if (j < n - 1 && grid[i][j + 1] == 1) {
            size += dfs(i, j + 1, firstI, firstJ);
        }

        return size + 1;
    }

    public int largestIsland(int[][] grid) {
        if (grid.length == 0)
            return 0;

        this.m = grid.length;
        this.n = grid[0].length;

        this.group = new int[m][n];
        this.grid = grid;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != -1) {
                    int size = dfs(i, j, i, j);
                    map.put(i * n + j, size);
                }
            }

        int max = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> used = new HashSet<>();

                    int sum = 1;
                    if (i > 0 && !used.contains(group[i - 1][j])) {
                        sum += map.get(group[i - 1][j]);
                        used.add(group[i - 1][j]);
                    }

                    if (i < m - 1 && !used.contains(group[i + 1][j])) {
                        sum += map.get(group[i + 1][j]);
                        used.add(group[i + 1][j]);
                    }

                    if (j > 0 && !used.contains(group[i][j - 1])) {
                        sum += map.get(group[i][j - 1]);
                        used.add(group[i][j - 1]);
                    }

                    if (j < n - 1 && !used.contains(group[i][j + 1])) {
                        sum += map.get(group[i][j + 1]);
                        used.add(group[i][j + 1]);
                    }

                    max = Math.max(max, sum);
                } else {
                    max = Math.max(max, map.get(group[i][j]));
                }
            }
        return max;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,1,1},{0,1,1,1},{0,1,1,0}};
        MakingALargeIsland s = new MakingALargeIsland();
        System.out.println(s.largestIsland(grid));
    }
}
