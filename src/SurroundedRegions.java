import com.sun.beans.finder.FieldFinder;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class SurroundedRegions {
    static class UnionFindSet {
        private int [] parents;
        private int [] ranks;

        public UnionFindSet(int size) {
            parents = new int[size];
            ranks = new int[size];

            for (int i = 0; i < parents.length; i++)
                parents[i] = i;
        }

        public int find(int x) {
            if (x == parents[x]) return x;
            else parents[x] = find(parents[x]);
            return parents[x];
        }

        public void union(int x, int y) {
            int xParent = find(x);
            int yParent = find(y);

            if (ranks[xParent] > ranks[yParent]) parents[yParent] = xParent;
            else if (ranks[xParent] < ranks[yParent]) parents[xParent] = yParent;
            else {
                parents[yParent] = xParent;
                ranks[xParent]++;
            }
        }
    }

    private static int getId(char[][] board, int i, int j) {
        return i * board[0].length + j;
    }

    public static void solve(char[][] board) {
        if (board.length == 0) return;

        UnionFindSet unionFindSet = new UnionFindSet(board.length * board[0].length);

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (i + 1 < board.length && board[i][j] == board[i+1][j])
                    unionFindSet.union(getId(board, i, j), getId(board, i + 1, j));
                if (j + 1 < board[0].length && board[i][j] == board[i][j+1])
                    unionFindSet.union(getId(board, i, j), getId(board, i, j + 1));
            }

        Set<Integer> set = new HashSet <>();

        for (int j = 0; j < board[0].length; j++) {
            set.add(unionFindSet.find(getId(board, 0, j)));
            set.add(unionFindSet.find(getId(board, board.length - 1, j)));
        }

        for (int i = 0; i < board.length; i++) {
            set.add(unionFindSet.find(getId(board, i, 0)));
            set.add(unionFindSet.find(getId(board, i, board[0].length - 1)));
        }


        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (!set.contains(unionFindSet.find(getId(board, i, j))))
                    board[i][j] = 'X';
            }

    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        solve(board);

        System.out.println(board);
    }


}
