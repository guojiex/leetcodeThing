package amazon;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }
        int length = s.length();
        boolean[][] mark = new boolean[length][length];
        int maxLength = 0;
        String result = "";
        for (int i = length-1 ; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                mark[i][j] = ((s.charAt(i) == s.charAt(j)) && (j - i <= 2 || mark[i + 1][j - 1]));
//                if(mark[i][j])
//                    System.out.println(String.format("%d %d", i,j));
                if (mark[i][j] && j - i + 1 > maxLength) {
                    result = s.substring(i, j + 1);
                    maxLength = j - i + 1;
                }
            }
        }
//        for(int i=0;i<length;i++){
//            for(int j=0;j<length;j++){
//                System.out.print(mark[i][j]+" ");
//            }
//            System.out.println();
//        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aabbaaa"));
    }

}
