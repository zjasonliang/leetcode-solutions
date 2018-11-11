public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] fac = new int[n + 1];

        fac[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            fac[i] = fac[i - 1] * i;
        }

        boolean[] isUsed = new boolean[n + 1];
        isUsed[0] = true;

        StringBuilder sb = new StringBuilder();

        k = k - 1;

        while (n > 2) {
            n--;
            int rank = k / fac[n];
            int idx = 1;
            while (rank >= 0) {
                while (isUsed[idx]) {
                    idx++;
                }
                if (rank > 0)
                    idx++;
                rank--;
            }
            sb.append(idx);
            isUsed[idx] = true;
            k = k % fac[n];
        }

        if (k == 0) {
            for (int i = 1; i < isUsed.length; i++)
                if (!isUsed[i])
                    sb.append(i);
        } else {
            for (int i = isUsed.length - 1; i >= 0; i--)
                if (!isUsed[i])
                    sb.append(i);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 1;
        PermutationSequence s = new PermutationSequence();
        System.out.println(s.getPermutation(n, k));
    }
}
