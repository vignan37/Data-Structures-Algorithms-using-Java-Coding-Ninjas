public class Solution {

	public static int countMinStepsToOne(int n) {
		
		int arr[] = new int [n+1];
		for(int i=0;i<n+1;i++){
			arr[i]=-1;
		}

		return countMinStepsToOneHelper(n,arr);
	}

//Iterative dp approach
public static int countMinStepsToOneHelper(int n, int arr[]) {
	
	if(n<=1){
		return 0;
	}

	if(n==2){
		return 1;
	}

	if(n==3){
		return 1;
	}

	arr[0]=0;
	arr[1]=0;
	arr[2]=1;
	arr[3]=1;
	int answer =Integer.MAX_VALUE;

	for(int i=4;i<n+1;i++){
		
		answer = arr[i-1];
		
		if(i%2==0){
			answer= Math.min(answer,arr[i/2]);	
			}
			
		
		if(i%3==0){
			answer= Math.min(answer,arr[i/3]);
			}
		arr[i]= 1+answer;
	}
	return arr[n];

}
}

/* Recursive dp approach

	public static int countMinStepsToOneHelper(int n, int arr[]) {
		
		if(n<=1){
			return 0;
		}
		if(n==2){
			return 1;
		}
		if(n==3){
			return 1;
		}

		if(arr[n]!=-1){
			return arr[n];
		}

		int a= Integer.MAX_VALUE;
		int b= Integer.MAX_VALUE;
		int c= Integer.MAX_VALUE;

		
		a = countMinStepsToOneHelper(n-1,arr);
			

		if(n%2==0){
			
			b = countMinStepsToOneHelper(n/2,arr);
			
			}
			
		
		if(n%3==0){
			
			c = countMinStepsToOneHelper(n/3,arr);
			
			}
		
		int ans = 1+Math.min(a, Math.min(b, c));

		arr[n]=ans;
			
		return ans;

	}

}
*/


/*
Min Steps To 1 Using DP

Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:
1.) Subtract 1 from it. (n = n - ­1) ,
2.) If n is divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If n is divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  
Input format :
The first and the only line of input contains an integer value, 'n'.
Output format :
Print the minimum number of steps.
Constraints :
1 <= n <= 10 ^ 6
Time Limit: 1 sec
Sample Input 1 :
4
Sample Output 1 :
2 
Explanation of Sample Output 1 :
For n = 4
Step 1 :  n = 4 / 2  = 2
Step 2 : n = 2 / 2  =  1 
Sample Input 2 :
7
Sample Output 2 :
3
Explanation of Sample Output 2 :
For n = 7
Step 1 :  n = 7 ­- 1 = 6
Step 2 : n = 6  / 3 = 2 
Step 3 : n = 2 / 2 = 1  */
