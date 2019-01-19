public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (newColor == image[sr][sc])
            return image;

        int m = image.length;
        int n = image[0].length;

        int oldColor = image[sr][sc];

        image[sr][sc] = newColor;

        if (sr > 0 && image[sr - 1][sc] == oldColor)
            floodFill(image, sr - 1, sc, newColor);

        if (sc > 0 && image[sr][sc - 1] == oldColor)
            floodFill(image, sr, sc - 1, newColor);

        if (sr < m - 1 && image[sr + 1][sc] == oldColor)
            floodFill(image, sr + 1, sc, newColor);

        if (sc < n - 1 && image[sr][sc + 1] == oldColor)
            floodFill(image, sr, sc + 1, newColor);

        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{0,0,0},{1,1,0}};
        int sr = 1;
        int sc = 1;
        int newColor = 1;

        FloodFill s = new FloodFill();
        System.out.println(s.floodFill(image, sr, sc, newColor));
    }
}
