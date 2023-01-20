//A very tricky question find how much health needed from right and down and calculate the dp appray.dp[i][j] = Maxof(1,math.min(rightans,downans)-grid[i][j])
// the answer is at 0,0
// in base case we first fill destination with 1 and then fill last col and last row  coz they depend on single value.
// finding max of 1 & min(right, down)-grid[i][j] 

public class Solution{


    public static int getMinimumStrength(int[][] grid) {
         int row=grid.length;
        if (row==0)
            return row;
        
        int col=grid[0].length;
        if (col==0)
            return col;
        
        int[][] dp=new int[row][col];
        
        //basecase
        dp[row-1][col-1]=1;
        
        // base caes 2 Filling last col
        for (int i=col-2;i>=0;i--)
        {
        	dp[row-1][i]=dp[row-1][i+1]-grid[row-1][i];
            
        }

        //base cace 3 filling last row.
        for (int i=row-2;i>=0;i--)
        {
            dp[i][col-1]=dp[i+1][col-1]-grid[i][col-1];
        }
        
        
        for(int i=row-2;i>=0;i--)
        {
            for (int j=col-2;j>=0;j--)
            {                
                int ans1=dp[i+1][j];
                int ans2=dp[i][j+1];
                
                dp[i][j]=Math.max(1,Math.min(ans1,ans2)-grid[i][j]);
            }
        }
        
        return dp[0][0];

    }
}



/* For some reason few test cases are failing, but manuall testing passed. I splited the problem into two dp problems 1 to find the strength needed at each index, 2nd pd to find the best path and update ans.

public class Solution{

    static int ans = 0;

    public static int getMinimumStrength(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        int dp[][] = new int[rows][cols];

        //fill the base case 0th row with min strength need to reach left index + curr index. similarly for cols top index plus curr.

        for(int i=1;i<rows;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        for(int j=1;j<cols;j++){
            dp[0][j]= dp[0][j-1]+grid[0][j];
        }

        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                   
	            	dp[i][j]= grid[i][j] + Math.max(dp[i-1][j],dp[i][j-1]);
	            	
            }
        }
       maxPath(dp,rows-1,cols-1);
       if(ans>0) return 0;
       else return 1-ans;
    }


// this will go throught the path that gives max strength, and updates ans to the lowest value in the path.
    public static int maxPath(int[][] dp,int i,int j){
        if(i>=dp.length || i<=0){
            return Integer.MIN_VALUE;
        }
        if(j>=dp[0].length || j<=0){
            return Integer.MIN_VALUE;
        }

        if(dp[i-1][j]==dp[i][j-1]){
            //go in 2 directions
            if(ans>dp[i][j-1]){
                ans = dp[i][j-1];
            }
            maxPath(dp,i,j-1);
            maxPath(dp,i-1,j);
        }

        if(dp[i-1][j]<dp[i][j-1]){
        //go in dp[i][j-1]
            if(ans>dp[i][j-1]){
                ans = dp[i][j-1];
            }
            return maxPath(dp,i,j-1);
        }
        else{
            //go in dp[i-1][j]
            if(ans>dp[i-1][j]){
                ans=dp[i-1][j];
            }
            return maxPath(dp,i-1,j);
        }
      
    }

    
}
*/


/*
Magic Grid

You are given a magic grid A with R rows and C columns. In the cells of the grid, you will either get magic juice, which increases your strength by |A[i][j]| points, or poison, which takes away |A[i][j]| strength points. If at any point of the journey, the strength points become less than or equal to zero, then you will die.
You have to start from the top-left corner cell (1,1) and reach at the bottom-right corner cell (R,C). From a cell (i,j), you can only move either one cell down or right i.e., to cell (i+1,j) or cell (i,j+1) and you can not move outside the magic grid. You have to find the minimum number of strength points with which you will be able to reach the destination cell.
Input format:
The first line contains the number of test cases T. T cases follow. Each test case consists of R C in the first line followed by the description of the grid in R lines, each containing C integers. Rows are numbered 1 to R from top to bottom and columns are numbered 1 to C from left to right. Cells with A[i][j] < 0 contain poison, others contain magic juice.
Output format:
Output T lines, one for each case containing the minimum strength you should start with from the cell (1,1) to have a positive strength through out his journey to the cell (R,C).
Constraints:
1 ≤ T ≤ 5
2 ≤ R, C ≤ 500
-10^3 ≤ A[i][j] ≤ 10^3
A[1][1] = A[R][C] = 0
Time Limit: 1 second
Sample Input 1:
3
2 3
0 1 -3
1 -2 0
2 2
0 1
2 0
3 4
0 -2 -3 1
-1 4 0 -2

*/
1 -2 -3 0
