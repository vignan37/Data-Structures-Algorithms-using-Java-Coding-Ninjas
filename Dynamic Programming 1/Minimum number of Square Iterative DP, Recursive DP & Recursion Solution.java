
//This is a tricky question, greedy will fail for few test cases like 12, going through the nearest perfect square and finding out the rest doesnt work.
// you will need to call every possiblity and take min of all of them
public class Solution {

// Iterative DP approach
	public static int minCount(int n){
		
		if (n == 0) {
			return 0;
		}
	

		int dp[] = new int[n+1];
		
		dp[0] =0;
		
		// Fill all the values till n+1
		for(int i=1;i<n+1;i++){
			
			int minAns = Integer.MAX_VALUE;

			//Find the minimum of all the possibilities at that index
			for(int j=1;j*j<=i;j++){
				int ans = dp[i-j*j];
				if(ans<minAns){
					minAns=ans;
				}
			}

			dp[i]=1+minAns;
		}
		
		return dp[n];
	}
}




/* Recursive DP approach

	public static int minCount(int n){
		int dp[] = new int[n+1];
		for(int i=0;i<n+1;i++){
			dp[i]=-1;
		}
		return minCount(n,dp);
	}

	public static int minCount(int n, int dp[]) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (n == 3) {
			return 3;
		}
		if (n == 4) {
			return 1;
		}

		int minAns = Integer.MAX_VALUE;

		if(dp[n]==-1){
		for (int i = 1; i * i < n; i++) {
			if (i*i<= n) {

				int ans = minCount(n - i * i);
				if (ans < minAns) {
					minAns = ans;
				}
			}
			}
			dp[n]=1+minAns;
		}
		 return dp[n];
	}
}

*/



/* Normal recursive approach

	public static int minCount(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (n == 3) {
			return 3;
		}
		if (n == 4) {
			return 1;
		}

		int minAns = Integer.MAX_VALUE;

		for (int i = 1; i * i < n; i++) {
			if (i*i <= n) {

				int ans = minCount(n - i * i);
				if (ans < minAns) {
					minAns = ans;
				}
			}
		}
		return 1 + minAns;
	}
*/


/*

Minimum Number Of Squares

Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.
That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. The output will be 1, as 1 is the minimum count of numbers required to represent N as sum of squares.
Input format :
The first and the only line of input contains an integer value, 'N'.
 Output format :
Print the minimum count of numbers required.
Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1 :
12
Sample Output 1 :
3
Explanation of Sample Output 1 :
12 can be represented as : 
A) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)

B) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)  + (2 ^ 2)

C) (1^2) + (1^2) + (1^2) + (1^2) + (2 ^ 2) + (2 ^ 2)

D) (2 ^ 2) + (2 ^ 2) + (2 ^ 2)

As we can see, the output should be 3.
Sample Input 2 :
9
Sample Output 2 :
1
*/
