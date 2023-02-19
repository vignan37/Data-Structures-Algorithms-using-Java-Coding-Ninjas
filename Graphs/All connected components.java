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
    
