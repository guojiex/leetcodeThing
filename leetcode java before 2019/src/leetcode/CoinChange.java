package leetcode;

import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
       int[] dp=new int[amount+1];
       dp[0]=0;
       for(int i=1;i<=amount;i++){
           int minNumber=Integer.MAX_VALUE;
           for(int j=0;j<coins.length;j++){
               if(i<coins[j])
                   continue;
               if(dp[i-coins[j]]!=Integer.MAX_VALUE)
                   minNumber=Math.min(minNumber, dp[i-coins[j]]+1);
           }
           dp[i]=minNumber;
       }
       return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
    
    public static void main(String[] args) {
        int[] coins={186,419,83,408};
        System.out.println(CoinChange.coinChange(coins,6249));  
    }

}
