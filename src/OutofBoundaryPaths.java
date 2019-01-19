public class OutofBoundaryPaths {
    private int[][][] memo;

    private int recur(int m, int n, int N, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return 1;

        if (memo[i][j][N] != 0) {
            return memo[i][j][N];
        }

        if (N == 0)
            return 0;

        int ret = recur(m, n, N - 1, i - 1, j);
        ret = (ret + recur(m, n, N - 1, i + 1, j)) % 1000000007;
        ret = (ret + recur(m, n, N - 1, i, j + 1)) % 1000000007;

        memo[i][j][N] = (ret + recur(m, n, N - 1, i, j - 1)) % 1000000007;
        return memo[i][j][N];
    }

    public int findPaths(int m, int n, int N, int i, int j) {
        this.memo = new int[m][n][N + 1];
        return recur(m, n, N, i, j);
    }

    public static void main(String[] args) {
        OutofBoundaryPaths s = new OutofBoundaryPaths();
        System.out.println(s.findPaths(45, 35, 47, 20, 31));
    }
}
