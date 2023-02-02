// just find the number of components in the graph. every time we notice a non visited vertex we ans++

import java.util.*;

public class Solution {

	public static int numConnected(int[][] edges, int n) {
        
		if(edges.length==0 || n==0){
			return n;
		}

		int visited[] = new int[n];
		int ans =0;

		for(int i=0;i<n;i++){
			if(visited[i]==0){
				BFS(edges,visited,i,n);
				ans++;
			}
		}
		return ans;
		}

		public static void BFS(int edges[][], int visited[], int v, int n) {
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(v);
			visited[v] = 1;

			while (!q.isEmpty()) {
				int curr = q.remove();
				for (int i = 0; i < n; i++) {
					if (edges[i][curr] == 1 && visited[i] == 0) {
						q.add(i);
						visited[i] = 1;
					}
				}
			}
		}


}


/*

Islands

An island is a small piece of land surrounded by water . A group of islands is said to be connected if we can reach from any given island to any other island in the same group . Given V islands (numbered from 0 to V-1) and E connections or edges between islands. Can you count the number of connected groups of islands.
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b. 
Output Format :
Print the count the number of connected groups of islands
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V-1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second
Sample Input 1:
5 8
0 1
0 4
1 2
2 0
2 4
3 0
3 2
4 3
Sample Output 1:
1 

*/
