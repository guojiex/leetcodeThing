package amazon;

public class LAS {
    public static int getLAS(int[] A){
        // Time: O(n)
        // Space: O(1)
        if (A.length < 3) return 0;
        
        int res = 0;
        int diff = Integer.MIN_VALUE;
        int count = 0;
        int start = 0;
        for (int i = 1; i < A.length; i++){
            int currDiff = A[i] - A[i - 1];
            if (diff == currDiff){
                System.out.println("start"+start);
                System.out.println("there"+(i-start-1));
                //count += i - start - 1 > 0 ? i - start - 1 : 0;
                count+=i-start-1;
            } else {
                start = i - 1;
                diff = currDiff;
                res += count;
                count = 0;
            }
        }
        res += count;
        return res;
    }
    public static void main(String[] args) {
        int[] array = {1,0,1,9,11,13};
        
        System.out.println(getLAS(array));
    }

}
