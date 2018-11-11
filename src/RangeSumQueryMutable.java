public class RangeSumQueryMutable {
    private int[] inputArray;
    private int n;
    private int[] stArray;


    public RangeSumQueryMutable(int[] nums) {
        this.inputArray = nums;
        this.n = nums.length;
        this.stArray = new int[4 * n];
        if (n != 0) constructRec(0, n-1, 0);
    }

    private int constructRec(int start, int end, int current) {
        if (start == end) {
            stArray[current] = inputArray[start];
            return stArray[current];
        }

        int mid = getMid(start, end);

        stArray[current] = constructRec(start, mid, leftChild(current))
                + constructRec(mid + 1, end, rightChild(current));
        return stArray[current];
    }

    private int getMid(int begin, int end) {
        return (begin + end) / 2;
    }

    private int leftChild(int node) {
        return 2 * node + 1;
    }

    private int rightChild(int node) {
        return 2 * node + 2;
    }

    public void update(int i, int val) {
        if (i < 0 || i > n - 1)
            throw new IndexOutOfBoundsException();

        int diff = val - inputArray[i];
        inputArray[i] = val;
        updateRec(0, n-1, i, diff, 0);
    }

    private void updateRec(int start, int end, int index, int diff, int current) {
        if (index < start || index > end)
            return;

        stArray[current] = stArray[current] + diff;

        if (start != end) {
            int mid = getMid(start, end);
            updateRec(start, mid, index, diff, leftChild(current));
            updateRec(mid + 1, end, index, diff, rightChild(current));
        }
    }

    public int sumRange(int i, int j) {
        if (n == 0) return 0;

        if (i < 0 || j > n -1 || i > j)
            return Integer.MIN_VALUE;
        return getSumRec(0, n-1, i, j, 0);
    }

    private int getSumRec(int stStart, int stEnd, int qStart, int qEnd, int current) {
        if (qStart <= stStart && stEnd <= qEnd)
            return stArray[current];

        if (qStart > stEnd || qEnd < stStart)
            return 0;

        int mid = getMid(stStart, stEnd);
        return getSumRec(stStart, mid, qStart, qEnd, leftChild(current))
                + getSumRec(mid + 1, stEnd, qStart, qEnd, rightChild(current));
    }

    public static void main(String[] args) {
        int[] nums = {};
        RangeSumQueryMutable s = new RangeSumQueryMutable(nums);
        System.out.println(s.sumRange(0 ,2));
        // s.update(1, 2);
        System.out.println(s.sumRange(0,2));
    }
}
