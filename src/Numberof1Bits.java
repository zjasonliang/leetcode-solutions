public class Numberof1Bits {
    public static int hammingWeight(int n) {
        int count = (n & 1);
        for (int i = 0; i < 32; i++) {
            n = n >>> 1;
            count += (n & 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(128));
    }
}
