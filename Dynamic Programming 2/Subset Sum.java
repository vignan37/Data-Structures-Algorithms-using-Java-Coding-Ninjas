public class Solution{
    static boolean isSubsetPresent(int[] arr, int n, int sum)
    {
        //dp[i][j] is true if we can create arr subset sum of j from first i elements
        boolean[][] dp = new boolean [n + 1][sum + 1];

        //If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
        {
            dp[i][0] = true;
        }

        //If sum is not 0 and set is empty, then answer is false
        for (int i = 1; i <= sum; i++)
        {
            dp[0][i] = false;
        }

        //Fill the table in bottom up manner
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= sum; j++)
            {
                if (j < arr[i - 1])
                {
                    dp[i][j] = dp[i - 1][j];
                }
                else
                {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        boolean result = dp[n][sum];

        return result;
    }
}
