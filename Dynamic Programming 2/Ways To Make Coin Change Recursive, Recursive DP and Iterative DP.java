//ITerative Dp approach we have to set the base case in the array first , and that corresponds to value=0 , so all items of column 0 is 1. 
// in this we are picking and not picking, and even if we are picking we can use the same coin so no i+1
// it follows down to up and left to right filling.

// Recursive approach : in this solution we are picking and not picking, even if we are picking we are allowed to use the same coin so no i+1 but value -denom[i]
// if we are not picking then i+1 and value


public class Solution {

	
	public static int countWaysToMakeChange(int denominations[], int value){
		

		int n = denominations.length;

		int dp[][] = new int[n+1][value+1];

		for(int i=0;i<n;i++){
			dp[i][0]=1;
		}

		for(int i=n-1;i>=0;i--){
			for(int j=1;j<=value;j++){
				
				int notPicked=dp[i+1][j];
				 
				int picked =0;
				if(j>=denominations[i]){
					picked = dp[i][j-denominations[i]];
				}
				dp[i][j] = picked+notPicked;
			}
		}
		return dp[0][value];
	}
}



/* Recursive DP approach work well and no time limit exceed

public class Solution {

	
	public static int countWaysToMakeChange(int denominations[], int value){
		int dp[][] = new int[denominations.length+1][value+1];
		for(int i=0;i<denominations.length+1;i++){
			for(int j=0;j<value+1;j++){
				dp[i][j]=-1;
			}
		}
      return countWaysToMakeChangeHelper(denominations,value,0,dp);
	}

	public static int countWaysToMakeChangeHelper(int denominations[], int value,int i,int[][] dp){
		  // Write your code here
		if(value==0){
			return 1;
		}

		if(value<0 || i>=denominations.length){
			return 0;
		}

		if(value<denominations[i]){
			return 0;
		}
			int pick,notPicked;
		
			//if i pick the i
			if(dp[i][value-denominations[i]]==-1){
			pick = countWaysToMakeChangeHelper(denominations,value-denominations[i],i,dp);
			dp[i][value-denominations[i]]=pick;
			}
			else{
				pick = dp[i][value-denominations[i]];
			}

			//if I dont pick i
			if(dp[i+1][value]==-1){
			notPicked = countWaysToMakeChangeHelper(denominations,value,i+1,dp);
			dp[i+1][value]=notPicked;
			}
			else{
				notPicked=dp[i+1][value];
			}
			return pick+notPicked;
	}
}

*/


/* Recursive approach time limit exceeded

	public static int countWaysToMakeChange(int denominations[], int value){
      return countWaysToMakeChangeHelper(denominations,value,0);
	}

	public static int countWaysToMakeChangeHelper(int denominations[], int value,int i){
		  // Write your code here
		if(value==0){
			return 1;
		}

		if(value<0 || i>=denominations.length){
			return 0;
		}

		if(value<denominations[i]){
			return 0;
		}
		
		
			//if i pick the i
			int pick = countWaysToMakeChangeHelper(denominations,value-denominations[i],i);

			//if I dont pick i
			int notPicked = countWaysToMakeChangeHelper(denominations,value,i+1);

			return pick+notPicked;
	}

*/

/*

Ways To Make Coin Change

For the given infinite supply of coins of each of denominations, D = {D0, D1, D2, D3, ...... Dn-1}. You need to figure out the total number of ways W, in which you can make the change for Value V using coins of denominations D.
Return 0 if the change isn't possible.
Input Format
The first line of the input contains an integer value N, which denotes the total number of denominations.

The second line of input contains N values, separated by a single space. These values denote the value of denomination.

The third line of the input contains an integer value, that denotes the value of V.
Output Format
Print the total total number of ways i.e. W.
Constraints :
1 <= n <= 10
1 <= V <= 1000

Time Limit: 1sec
Sample Input 1 :
3
1 2 3
4
Sample Output 1 :
4
Explanation to Sample Input 1 :
Number of ways are - 4 total i.e. (1,1,1,1), (1,1, 2), (1, 3) and (2, 2).
Sample Input 2 :
6
1 2 3 4 5 6
250
Sample Output 2 :
13868903
*/
