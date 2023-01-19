// This is Iterative DP 
// The Dp array is 1+sizes coz we need 0,maxWeight index.
// The filling is done in a wierd , bottom up left to right way and the answer is stored at 0,maxweight
// here dp[i][w] is max value of a knack sack for ith item with maxweight of w.
// Cant fill the knapscak with i if the weight of it is greater than max weight
// if weight is less than max weight then we got 2 conditions to check, 1 fill it 2 dont fill it with value and move on.

public class Solution {

    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {

		int dp[][] = new int[n+1][maxWeight+1];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<maxWeight+1;j++){
                if(j<weights[i]){
                    dp[i][j]= dp[i+1][j];
                }
                else{
                    dp[i][j] = Math.max(values[i]+dp[i+1][j-weights[i]], dp[i+1][j]);
                }
            }
        }
        return dp[0][maxWeight];

    }
}





/* Debug this code later its giving error and its recursive dp approach

	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {

		int dp[][] = new int[n+1][maxWeight+1];

		for(int i=0;i<=n;i++){
			for(int j=0;j<=n;j++){
				dp[i][j] = -1;
			}
		}

		return knapsackHelper(weights, values, 0, maxWeight,dp);
	}
	
	public static int knapsackHelper(int[] weights, int[] values, int i, int maxWeight, int dp[][]) {
		
		if(i>values.length || maxWeight<=0){
			return 0;
		}

		int finalAns;
		// if the weight is more than max weight we cant put it in knap sack so go to next index.
		if(weights[i]>maxWeight){
			if(dp[i+1][maxWeight]==-1){
			finalAns= knapsackHelper(weights, values, i+1, maxWeight,dp);
			dp[i+1][maxWeight]=finalAns;
			}
			else finalAns=dp[i+1][maxWeight];
		}

		else{
			int ans1,ans2;

			// including the item in knap sack
			if(dp[i+1][maxWeight-weights[i]]==-1){
			ans1 = values[i]+ knapsackHelper(weights, values, i+1, maxWeight-weights[i],dp);
			dp[i+1][maxWeight-weights[i]]=ans1;
			}
			else{
				ans1 = dp[i+1][maxWeight-weights[i]];
			}
			//excluding the item and moving to next
			if(dp[i+1][maxWeight]==-1){
			ans2 = knapsackHelper(weights, values, i+1, maxWeight,dp);
			dp[i+1][maxWeight]=ans2;
			}
			else ans2= dp[i+1][maxWeight];
			//checking which of the two is max
			finalAns = Math.max(ans1, ans2);

			
		}
		return finalAns;
	}

}

*/

//Recursive approach

/*


public class Solution {


	public static int knapsack(int[] weights, int[] values, int i, int maxWeight) {
		return knapsackHelper(weights, values, 0, maxWeight);
	}
	
	public static int knapsackHelper(int[] weights, int[] values, int i, int maxWeight) {
		
		if(i>=values.length || maxWeight<=0){
			return 0;
		}

		int finalAns;
		// if the weight is more than max weight we cant put it in knap sack so go to next index.
		if(weights[i]>maxWeight){
			finalAns= knapsackHelper(weights, values, i+1, maxWeight);
		}

		else{
			int ans1,ans2;

			// including the item in knap sack
			ans1 = values[i]+ knapsackHelper(weights, values, i+1, maxWeight-weights[i]);
			
			//excluding the item and moving to next
			ans2 = knapsackHelper(weights, values, i+1, maxWeight);

			//checking which of the two is max
			finalAns = Math.max(ans1, ans2);

			
		}
		return finalAns;
	}

}

*/

/*
Question :

0 1 Knapsack - Problem

A thief robbing a store can carry a maximal weight of W into his knapsack. There are N items, and i-th item weigh 'Wi' and the value being 'Vi.' What would be the maximum value V, that the thief can steal?
Input Format :
The first line of the input contains an integer value N, which denotes the total number of items.

The second line of input contains the N number of weights separated by a single space.

The third line of input contains the N number of values separated by a single space.

The fourth line of the input contains an integer value W, which denotes the maximum weight the thief can steal.
Output Format :
Print the maximum value of V that the thief can steal.
Constraints :
1 <= N <= 20
1<= Wi <= 100
1 <= Vi <= 100

Time Limit: 1 sec
Sample Input 1 :
4
1 2 4 5
5 4 8 6
5
Sample Output 1 :
13
Sample Input 2 :
5
12 7 11 8 9
24 13 23 15 16
26
Sample Output 2 :
51

*/
