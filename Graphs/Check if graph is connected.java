import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class Solution {

public static void main(String[] args) throws NumberFormatException,IOException {
    Scanner s = new Scanner(System.in);
    int V = s.nextInt();
    int E = s.nextInt();
    int edges[][]=new int[V][V];
    for(int i=0;i<E;i++){
        int sv=s.nextInt();
        int ev=s.nextInt();
        edges[sv][ev]=1;
        edges[ev][sv]=1;
    }
    boolean ans=isConnected(edges);
    System.out.println(ans);
}

public static boolean isConnected(int edges[][]){

    int n = edges.length;
    if(n==0) return true;

    int visited[] = new int[n];
    Queue<Integer> q = new LinkedList<Integer>();

    q.add(0);
    visited[0]=1;
    while(!q.isEmpty()){
        int current = q.remove();
        for(int i=0;i<n;i++){
            if(edges[i][current]==1 && visited[i]==0){
                q.add(i);
                visited[i]=1;
            }
        }
    }
    boolean ans = true;
    for(int i=0;i<n;i++){
        if(visited[i]==0){
            ans = false;
        }
    }

    return ans;
}
}


