// Caution : While taking input update edges[f][s] & edges[s][f]
// BFS : When finding for the neighbours, if found add to queue and instantly mark visited.
//DFS : print and add to visited
// make sure you handle disconnected vertices.

import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

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
		
		System.out.print("BFS : ");
		// Checking for the disconnected components
		for(int i=0;i<n;i++){
			if(visited[i]==0){
				BFS(edges, i, visited);
			}
		}
		System.out.println();
		
		int visited2[] = new int[n];
		System.out.print("DFS : ");
		for(int i=0;i<n;i++){
			if(visited2[i]==0){
				DFS(edges, i, visited2);
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
	
	public static void DFS(int edges[][], int fv, int visited2[]){
	    System.out.print(fv + " ");
	    visited2[fv]=1;
	    
	    for(int i=0;i<edges.length;i++){
	        if(visited2[i] ==0 && edges[fv][i]==1){
	            DFS(edges,i,visited2);
	        }
	    }
	}

}
