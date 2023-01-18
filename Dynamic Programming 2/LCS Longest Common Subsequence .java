
// for Recursive Dp memorization here we us array size of s1length+1,s2length+1

public class Solution {

	public static int lcs(String s, String t) {

		int arr[][] =new int[s.length()+1][t.length()+1];

		for(int i=0;i<=s.length();i++){
			for(int j=0;j<=t.length();j++){
				arr[i][j] = -1;
			}
		}
		return lcsHelper(s, t,arr,0,0);
    }

	public static int lcsHelper(String s, String t, int arr[][],int i , int j){
		if(i==s.length() || j==t.length()){
			return 0;
		}

		int ans;

		if(s.charAt(i)==t.charAt(j)){
			int smallAns;
			if(arr[i+1][j+1]==-1){
				smallAns =  lcsHelper(s, t,arr,i+1,j+1);
				arr[i+1][j+1]=smallAns;
			}
			else{
				smallAns = arr[i+1][j+1];
			}
			ans=1+smallAns;
		}
		else{	

			int ans1,ans2;

				if(arr[i+1][j]==-1){
					 ans1 =lcsHelper(s,t,arr,i+1,j);
					 arr[i+1][j]=ans1;
				}
				else{
					ans1 = arr[i+1][j];
				}
				
				if(arr[i][j+1]==-1){
					 ans2 =lcsHelper(s,t,arr,i, j+1);
					 arr[i][j+1]=ans2;
				}
				else{
					ans2= arr[i][j+1];
				}
				
				
				ans= Math.max(ans1,ans2);
			}
			
			
		return ans;
}
}

//Recursive approach without splitting and creating new strings, using i and j

/*	public static int lcsHelper(String s, String t, int arr[][],int i , int j){
		if(i>=s.length() || j>=t.length()){
			return 0;
		}
		int ans;
		if(s.charAt(i)==t.charAt(j)){
			ans = 1+ lcsHelper(s, t,arr,i+1,j+1);
			return ans;
		}
		else{	
				int ans1 =lcsHelper(s,t,arr,i+1,j);
		
				int ans2 = lcsHelper(s, t, arr, i, j+1);
			
				ans = Math.max(ans1,ans2);
			
		}
		return ans;
	}

}

*/


/*
Recursive approach will fail as time limit exceeds

public static int lcsHelper(String s, String t){
		if(s.length()==0 || t.length()==0){
			return 0;
		}
		if(s.charAt(0)==t.charAt(0)){
			return 1+ lcsHelper(s.substring(1), t.substring(1));
		}
		else{
			return Math.max(lcsHelper(s.substring(1),t), lcsHelper(s, t.substring(1)));
		}
	}

*/

/*

LCS - Problem

Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length of the 'Longest Common Subsequence'.
For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the same relative order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K.
Example :
Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.
Input format :
The first line of input contains the string 'S' of length 'M'.

The second line of the input contains the string 'T' of length 'N'.
Output format :
Return the length of the Longest Common Subsequence.
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
adebc
dcadb
Sample Output 1 :
3
Explanation of the Sample Output 1 :
Both the strings contain a common subsequence 'adb', which is the longest common subsequence with length 3. 
Sample Input 2 :
ab
defg
Sample Output 2 :
0
Explanation of the Sample Output 2 :
The only subsequence that is common to both the given strings is an empty string("") of length 0.
*/
