// first find c
// then apply recursion to find the next characters & maintain a visited matrix.
// check all the surrounding 8 boxes. here you need to be extra careful about array index out of bound.

import java.util.*;
public class Solution {
	
	int solve(String[] Graph , int N, int M)
	{
		int visited[][] = new int[N][M];
		String str = "CODINGNINJA";

		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(str.charAt(0)==Graph[i].charAt(j)){
					int ans = solveHelper(Graph, i, j, visited, 1, str);
					if(ans==1){return 1;}
				}
			}
		}
		return 0;
		
	}

	int solveHelper(String Graph[], int r, int c, int visited[][], int i, String str){
		if(i>=11){
			return 1;
		}
		if(r<0 || c<0 || r>=Graph.length || c >= Graph[0].length()){
			return 0;
		}

		//up
		if(r-1>=0 && str.charAt(i)==Graph[r-1].charAt(c) && visited[r-1][c]==0){
			visited[r-1][c]=1;
			int ans = solveHelper(Graph, r-1, c, visited, i+1, str);
			if(ans==1){
				return 1;
			}
			else{
				visited[r - 1][c] = 0;
			}
		}
		//upper right diagonal
		if (r - 1 >= 0 &&  c+1< Graph[0].length() && str.charAt(i) == Graph[r - 1].charAt(c+1) && visited[r - 1][c+1] == 0) {
			visited[r - 1][c+1] = 1;
			int ans = solveHelper(Graph, r - 1, c+1, visited, i + 1, str);
			if (ans == 1) {
				return 1;
			} else {
				visited[r - 1][c+1] = 0;
			}
		}

		//right
		if (c + 1 < Graph[0].length() && str.charAt(i) == Graph[r].charAt(c+1) && visited[r][c+1] == 0) {
			visited[r][c + 1] = 1;
			int ans = solveHelper(Graph, r, c + 1, visited, i + 1, str);
			if (ans == 1) {
				return 1;
			} else {
				visited[r][c + 1] = 0;
			}
		}

		//lower right diagonal
		if (c + 1 < Graph[0].length() &&  r+1<Graph.length && str.charAt(i) == Graph[r +1].charAt(c + 1) && visited[r + 1][c + 1] == 0) {
			visited[r+1][c + 1] = 1;
			int ans = solveHelper(Graph, r+1, c + 1, visited, i + 1, str);
			if (ans == 1) {
				return 1;
			} else {
				visited[r+1][c + 1] = 0;
			}
		}
		//down
		if (r+1<Graph.length && str.charAt(i) == Graph[r + 1].charAt(c) && visited[r + 1][c] == 0) {
			visited[r + 1][c] = 1;
			int ans = solveHelper(Graph, r + 1, c, visited, i + 1, str);
			if (ans == 1) {
				return 1;
			} else {
				visited[r + 1][c] = 0;
			}
		}

		//lower left diagonal
		if (r+1<Graph.length && c - 1 >= 0 && str.charAt(i) == Graph[r + 1].charAt(c-1) && visited[r + 1][c-1] == 0) {
			visited[r + 1][c-1] = 1;
			int ans = solveHelper(Graph, r + 1, c-1, visited, i + 1, str);
			if (ans == 1) {
				return 1;
			} else {
				visited[r + 1][c-1] = 0;
			}
		}

		//left
		if (c - 1 >= 0 && str.charAt(i) == Graph[r].charAt(c - 1) && visited[r][c - 1] == 0) {
			visited[r ][c - 1] = 1;
			int ans = solveHelper(Graph, r, c - 1, visited, i + 1, str);
			if (ans == 1) {
				return 1;
			} else {
				visited[r][c - 1] = 0;
			}
		}

		// upper left diagonal
		if (c - 1 >= 0 && r - 1 >= 0 && str.charAt(i) == Graph[r-1].charAt(c - 1) && visited[r-1][c - 1] == 0) {
			visited[r-1][c - 1] = 1;
			int ans = solveHelper(Graph, r-1, c - 1, visited, i + 1, str);
			if (ans == 1) {
				return 1;
			} else {
				visited[r-1][c - 1] = 0;
			}
		}

		return 0;

	}
	
	
}


/*
Coding Ninjas

Given a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in the given matrix which makes the sentence “CODINGNINJA” .
There is a path from any cell to all its neighbouring cells. For a particular cell, neighbouring cells are those cells that share an edge or a corner with the cell.
Input Format :
The first line of input contains two space separated integers N and M, where N is number of rows and M is the number of columns in the matrix. 
Each of the following N lines contain M characters. Please note that characters are not space separated.
Output Format :
Print 1 if there is a path which makes the sentence “CODINGNINJA” else print 0.
Constraints :
1 <= N <= 1000
1 <= M <= 1000
Time Limit: 1 second
Sample Input 1:
2 11
CXDXNXNXNXA
XOXIXGXIXJX
Sample Output 1:
1
*/