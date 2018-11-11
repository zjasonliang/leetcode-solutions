public class LongestPalindromicSubstring {
    public static String longestPalindromeDP(String s) {
        boolean [][] dpTable = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++)
            dpTable[i][i] = true;

        for (int i = 0; i < s.length() - 1; i++)
            if (s.charAt(i)==s.charAt(i+1))
                dpTable[i][i+1] = true;

        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                if (dpTable[i+1][i+len-2] && s.charAt(i) == s.charAt(i+len-1))
                    dpTable[i][i+len-1] = true;
            }
        }

        for (int len = s.length(); len > 0; len--)
            for (int i = 0; i <= s.length() - len; i++)
                if (dpTable[i][i+len-1])
                    return s.substring(i, i + len);


        return "";

    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeDP("cbbd"));
    }
}
