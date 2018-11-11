import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

public class FallingSquares {
    class SegmentTree {
        private int n;
        private int[] input;
        private int[] st;
        private int[] lazy;

        public SegmentTree() {
            // this.n = 33554432;
            this.n = 16;
            this.input = new int[n];
            this.lazy = new int[2 * n - 1];
            this.st = new int[2 * n - 1];
            // constructRec(0, n-1, 0);
        }

        private int constructRec(int start, int end, int current) {
            if (start == end) {
                st[current] = input[start];
                return st[current];
            }

            int mid = getMid(start, end);
            st[current] = Math.max(constructRec(start, mid, leftChild(current)),
                                    constructRec(mid + 1, end, rightChild(current)));
            return st[current];
        }

        private int getMid(int start, int end) {
            return (start + end) / 2;
        }

        private int leftChild(int node) {
            return node * 2 + 1;
        }

        private int rightChild(int node) {
            return node * 2 + 2;
        }

        public int query(int start, int end) {
            int res = queryRec(0, n - 1, start, end, 0);
            return res;
        }

        private int queryRec(int stStart, int stEnd, int qStart, int qEnd, int current) {
            updateCurrentNodeAndPropDown(current, stStart, stEnd);

            if (qStart <= stStart && stEnd <= qEnd) {
                return st[current];
            }

            if (stEnd < qStart || stStart > qEnd) {
                return 0;
            }

            int mid = getMid(stStart, stEnd);
            return Math.max(queryRec(stStart, mid, qStart, qEnd, leftChild(current)),
                            queryRec(mid + 1, stEnd, qStart, qEnd, rightChild(current)));
        }


        public void updateRange(int updateStart, int updateEnd, int newValue) {
            updateRangeRec(0, 0, n-1, updateStart, updateEnd, newValue);
        }

        private void updateRangeRec(int current, int stStart, int stEnd, int updateStart, int updateEnd, int newValue) {
            updateCurrentNodeAndPropDown(current, stStart, stEnd);

            if (stStart > stEnd || stStart > updateEnd || stEnd < updateStart) {
                return;
            }

            st[current] = newValue;

            if (updateStart <= stStart && stEnd <= updateEnd) {
                // st[current] = newValue;

                if (stStart != stEnd) {
                    lazy[leftChild(current)] = newValue;
                    lazy[rightChild(current)] = newValue;
                }
                return;
            }

            int mid = getMid(stStart, stEnd);
            updateRangeRec(leftChild(current), stStart, mid, updateStart, updateEnd, newValue);
            updateRangeRec(rightChild(current), mid + 1, stEnd, updateStart, updateEnd, newValue);
        }

        private void updateCurrentNodeAndPropDown(int current, int stStart, int stEnd) {
            if (lazy[current] != 0) {
                st[current] = lazy[current];
            }

            if (stStart != stEnd) {
                lazy[leftChild(current)] = lazy[current];
                lazy[rightChild(current)] = lazy[current];
            }

            lazy[current] = 0;
        }
    }

    public List<Integer> fallingSquares(int[][] positions) {
        SegmentTree tree = new SegmentTree();
        int maxHeight = 0;
        List<Integer> res = new ArrayList <>();
        for (int i = 0; i < positions.length; i++) {
            int start = positions[i][0];
            int end = positions[i][0] + positions[i][1] - 1;
            int temp = tree.query(start, end) + positions[i][1];
            tree.updateRange(positions[i][0], positions[i][0] + positions[i][1] - 1, temp);
            maxHeight = Math.max(maxHeight, temp);
            res.add(maxHeight);
        }

        return res;
    }

    public static void main(String[] args) {
        // int[][] positions = {
        //         {1, 2},
        //         {2, 3},
        //         {6, 1}
        // };

        int[][] positions = {
                {4, 6},
                {4, 2},
                {4, 3}
        };

        // [[4,6],[4,2],[4,3]]

        // int[][] positions = {
        //         {100, 100},
        //         {200, 100}
        // };

        FallingSquares s = new FallingSquares();
        System.out.println(s.fallingSquares(positions));
    }
}
