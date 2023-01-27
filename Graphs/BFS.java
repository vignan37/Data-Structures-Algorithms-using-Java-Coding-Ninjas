// Caution : While taking input update edges[f][s] & edges[s][f]
// When finding for the neighbours, if found add to queue and instantly mark visited.
// make sure you handle disconnected vertices.

import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		int edges[][]= new int[n][n];

		for(int i=0;i<e;i++){
			int fv = sc.nextInt();
			int sv = sc.nextInt();

			// YOu should update both viseversa indexes in the edges array
			edges[fv][sv]=1;
			edges[sv][fv]=1;
		}
		int visited[]=new int[n];
		
		// Checking for the disconnected components
		for(int i=0;i<n;i++){
			if(visited[i]==0){
				BFS(edges, i, visited);
			}
		}
	}

	public static void BFS(int edges[][], int fv, int visited[]){
		
		 Queue<Integer> q   = new LinkedList<>();
		 q.add(fv);
		 visited[fv]=1;
		 int n=edges.length;
		
		while(!q.isEmpty()){
			int current = q.remove();
			System.out.print(current +" ");
			for(int i=0;i<n;i++){
				// Checking for the neighbour of current and if there and not visited then add to queue and mark visited.
				if(edges[current][i]==1 && visited[i]==0){
					q.add(i);
					visited[i]=1;
				}
			}
		}
	}

}

/*
Given an undirected and disconnected graph G(V, E), print its BFS traversal.
Note:
1. Here you need to consider that you need to print BFS path starting from vertex 0 only. 
2. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
3. E is the number of edges present in graph G.
4. Take graph input in the adjacency matrix.
5. Handle for Disconnected Graphs as well
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains space separated two integers, that denote that there exists an edge between vertex a and b.
Output Format :
Print the BFS Traversal, as described in the task.
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second
Sample Input 1:
4 4
0 1
0 3
1 2
2 3
Sample Output 1:
0 1 3 2
*/
