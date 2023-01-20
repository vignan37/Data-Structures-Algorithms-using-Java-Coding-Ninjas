
// This is a very interesting question that needs optimization. 
// We use 2D array for memorization .
// Iterative dp the base cse here is setting oth row and 0th col , inverted to what is in array. if 1 in array then no max sqares will be 0 at that index.
// for rest of rows and cols a[i][j] is dependent on below index, left index and lower diagonal index ... It will be 1+min of those 3. Refer book for diagram.

public class Solution {
	
    static int maxSquares=0;

    public static int findMaxSquareWithAllZeros(int[][] input){

		if(input.length==0) return 0;

        int rows = input.length;
        int cols = input[0].length;
        int dp[][] = new int[rows][cols];

        //base case filling col 0 with opposites
        for(int i=0;i<rows;i++){
            
            if(input[i][0]==1){dp[i][0]=0;}
            else{ 
                dp[i][0]=1;
                maxSquares=1;
            }
        }

        //base case filling row 0 with opposites

        for(int j=0;j<cols;j++){
            if(input[0][j]==1) dp[0][j]=0;
            else {
                dp[0][j]=1;
                maxSquares=1;
            }
        }

        if(rows==1 || cols==1){return maxSquares; }
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){

                //if the value at index is 1 then direct 0 sq matix with all zero

                if(input[i][j]==1){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j]=1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
                    if(dp[i][j]>maxSquares){
                        maxSquares=dp[i][j];
                    }
                }
            }
        }
        return maxSquares;

    }

    }
	







/*
    public static int findMaxSquareWithAllZeros(int[][] input){
        
        int[][] storage = new int[input.length][input[0].length];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<input.length;i++) {
            storage[i][0] = input[i][0] ==0 ? 1: 0;
            max = Math.max(storage[i][0], max);
        }

        for(int i=0;i<input[0].length;i++) {
            storage[0][i] = input[0][i] ==0 ? 1: 0;
            max = Math.max(storage[0][i], max);
        }


        for(int i=1;i<input.length;i++) {
            for(int j=1;j<input[0].length;j++ ) {
                if(input[i][j]==1){
					storage[i][j] = 0;
                }
                else{
                    storage[i][j] = Math.min(Math.min(storage[i-1][j-1], storage[i-1][j] ),
                                             storage[i][j-1]
                                            ) + 1 ;
                }
                max = Math.max(storage[i][j], max);

            }
        }
        return max;

	*/

	
/*

Maximum Square Matrix With All Zeros

Given an NxM matrix that contains only 0s and 1s, find out the size of the maximum square sub-matrix with all 0s. You need to return the size of the square matrix with all 0s.
Input format :
The first line of the test case contains two integer values, 'N' and 'M', separated by a single space. They represent the 'rows' and 'columns' respectively.

Second-line onwards, the next 'N' lines or rows represent the ith row values.

Each of the ith rows constitutes column values separated by a single space (Either 0 or 1).
Output Format:
Print the size of maximum square sub-matrix.
 Constraints :
0 <= N <= 10^4
0 <= M <= 10^4

Time Limit: 1 sec
Sample Input 1:
3 3
1 1 0
1 1 1
1 1 1
Sample Output 1:
1
Sample Input 2:
4 4
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
Sample Output 2:
4
*/
