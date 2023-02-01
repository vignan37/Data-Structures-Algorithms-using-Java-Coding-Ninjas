import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 



public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner s = new Scanner(System.in);
		int n = s.nextInt();
        // total number of edges e
		int e = s.nextInt();
        int edges[][]=new int[n][n];
        for(int i=0;i<e;i++){
            int fv=s.nextInt();
            int sv=s.nextInt();
            edges[fv][sv]=1;
            edges[sv][fv]=1;
        }
        int visited[] = new int[n];
        
        if(n==0){return;}
       
       for(int i=0;i<n;i++){
            if(visited[i]==0){
                ArrayList<Integer> al = new ArrayList<Integer>();
                printGraph(edges,visited,i,al);
                Collections.sort(al);
                
                for(int j=0;j<al.size();j++){
                System.out.print(al.get(j)+" ");   
                }
                System.out.println();
            }
        }
	}

    public static void printGraph(int edges[][], int visited[], int v, ArrayList<Integer> al){
        visited[v]=1;
        al.add(v);
        for(int i=0;i<edges.length;i++){
            if(edges[i][v]==1 && visited[i]==0){
                printGraph(edges,visited,i,al);
            }
        }
    }
    
}
    

/*

All connected components
Send Feedback
Given an undirected graph G(V,E), find and print all the connected components of the given graph G.
Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. You need to take input in main and create a function which should return all the connected components. And then print them in the main, not inside function.
Print different components in new line. And each component should be printed in increasing order (separated by space). Order of different components doesn't matter.
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two space separated integers, that denote that there exists an edge between vertex a and b.
Output Format :
Print different components in new line. And each component should be printed in increasing order of vertices (separated by space). Order of different components doesn't matter.
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Sample Input 1:
4 2
0 1
2 3
Sample Output 1:
0 1 
2 3 
Sample Input 2:
4 3
0 1
1 3 
0 3
Sample Output 2:
0 1 3 
2

*/
