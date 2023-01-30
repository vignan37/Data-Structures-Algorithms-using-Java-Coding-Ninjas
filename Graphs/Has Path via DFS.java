// make sue you return at recursive call
// if you reach the vertex then it has path.

import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
        
		//taking input
		Scanner sc =new Scanner(System.in);

		int n = sc.nextInt();
		int e = sc.nextInt();
		int edges[][] = new int[n][n];
		for(int i=0;i<e;i++){
			int fv = sc.nextInt();
			int sv = sc.nextInt();
			edges[fv][sv]=1;
			edges[sv][fv]=1;
		}
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();

		int visited[] = new int[n];
		boolean answer = DFSHasPath(edges, visited, n, v1, v2);
		System.out.print(answer);

	}

	public static boolean DFSHasPath(int edges[][], int visited[], int n, int v1, int v2){
		if(v1==v2){
			return true;
		}
		visited[v1] =1;
		for(int i=0;i<n;i++){
			if(edges[v1][i]==1 && visited[i]==0){
				return DFSHasPath(edges, visited, n, i, v2);
			}
		}
		return false;

	}

}
