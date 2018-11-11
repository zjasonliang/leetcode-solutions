public class FirstBadVersion {
    private int first;

    private boolean isBadVersion(int v) {
        if (v >= first) return true;
        else return false;
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (isBadVersion(mid)) end = mid;
            else start = mid + 1;
        }

        return start;
    }

    public static void main(String[] args) {
        FirstBadVersion s = new FirstBadVersion();
        s.first = 1702766719;
        System.out.println(s.firstBadVersion(2126753390));
    }
}
