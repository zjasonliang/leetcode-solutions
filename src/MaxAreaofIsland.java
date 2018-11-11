public class MaxAreaofIsland {
    private int search(int[][] grid, int x, int y) {
        grid[x][y] = 0;

        int ret = 1;

        if (0 <= x - 1 && grid[x-1][y] == 1)
            ret += search(grid, x-1, y);

        if (x + 1 < grid.length && grid[x+1][y] == 1)
            ret += search(grid, x+1, y);

        if (0 <= y - 1 && grid[x][y-1] == 1)
            ret += search(grid, x, y-1);

        if (y + 1 < grid[0].length && grid[x][y+1] == 1)
            ret += search(grid, x, y+1);

        return ret;
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, search(grid, i, j));
                }
            }

        return maxArea;
    }

    public static void main(String[] args) {
        MaxAreaofIsland s = new MaxAreaofIsland();

        int[][] grid = {
                {0, 0, 1, 0, 1},
                {0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1}
        };

        System.out.println(s.maxAreaOfIsland(grid));
    }
}
