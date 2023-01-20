public class Solution {

	public static int smallestSuperSequence(String str1, String str2) {
        int rows =str1.length();
		int cols = str2.length();
		int dp[][] = new int[rows+1][cols+1];

		//setting the base case for last column
		int count=rows;
		for(int i=0;i<rows;i++){
			dp[i][cols]=count; 
			count--;
		}

		//setting base case for last row 3210
		count=cols;
		for(int j=0;j<cols;j++){
			dp[rows][j]=count;
			count--;
		}

		for(int i=rows-1; i>=0;i--){
			for(int j=cols-1;j>=0;j--){
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = dp[i + 1][j + 1] + 1;
				}
				else dp[i][j]= 1+Math.min(dp[i+1][j], dp[i][j+1]);
			}
		}

		return dp[0][0];
	}
}


/*

public class Solution {

	public static int smallestSuperSequence(String str1, String str2) {
        return smallestSuperSequenceHelper(str1, str2, 0, 0);
	}
	public static int smallestSuperSequenceHelper(String str1, String str2,int i,int j) {
		
		if(i>=str1.length()){
			return str2.length()-j;
		}

		if(j>=str2.length()){
			return str1.length()-i;
		}

		if(str1.charAt(i)==str2.charAt(j)){
			return 1+smallestSuperSequenceHelper(str1, str2, i+1, j+1);
		}

		return 1+Math.min(smallestSuperSequenceHelper(str1, str2, i+1, j), smallestSuperSequenceHelper(str1, str2, i, j+1));
	}
}
*/

/*
Smallest Super-Sequence

 Given two strings S and T with lengths M and N. Find and return the length of their shortest 'Super Sequence'.
 The shortest 'Super Sequence' of two strings is defined as the smallest string possible that will have both the given strings as its subsequences.
Note :
If the two strings do not have any common characters, then return the sum of the lengths of the two strings. 
Input Format:
The first only line of input contains a string, that denotes the value of string S. The following line contains a string, that denotes the value of string T.
Output Format:
Length of the smallest super-sequence of given two strings. 
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
ab
ac
Sample Output 1 :
3
Explanation of Sample Output 1 :
Their smallest super sequence can be "abc" which has length = 3.
Sample Input 2 :
pqqrpt
qerepct
Sample Output 2 :
9
*/
