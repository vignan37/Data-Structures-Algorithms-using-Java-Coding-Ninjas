import java.util.*;
public class Solution {

	public static boolean ratInAMaze(int maze[][]){

		int path[][] = new int[maze.length][maze.length];
		return ratInAMazeHelper(maze, 0, 0, path);
	}

	public static boolean ratInAMazeHelper(int maze[][], int currentRow, int currentCol, int path[][]){

		int n =  maze.length;
        
        //if deadend or invalid move -1 or more than n index or already visited
		
		if(currentRow<0 || currentCol<0 || currentRow>=n || currentCol>=n || maze[currentCol][currentRow] == 0 ||  path[currentRow][currentCol]==1) return false;
        
        //base case if found the end
		if( currentRow==maze.length-1 && currentCol==maze.length-1)
		{
		    return true;
		    
		}
		

		//visited update
		path[currentRow][currentCol] =1;
		
				
		boolean outputRight = ratInAMazeHelper(maze,currentRow+1,currentCol,path);
		boolean outputDown = ratInAMazeHelper(maze,currentRow,currentCol+1,path);
		boolean outputLeft = ratInAMazeHelper(maze,currentRow,currentCol-1,path);
		boolean outputUp = ratInAMazeHelper(maze,currentRow-1,currentCol,path);
		
		if(outputRight){
		    return true;
		}
		
		if(outputDown){
		    return true;
		}
		
		if(outputLeft){
		    return true;
		}
		
		if(outputUp){
		    return true;
		}

		return false;
		
	}
}
/*
Code: Rat In A Maze

You are given a N*N maze with a rat placed at maze[0][0]. Find whether any path exist that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.
Input Format
Line 1: Integer N
Next N Lines: Each line will contain ith row elements (separated by space)
Output Format :
The output line contains true if any path exists for the rat to reach its destination otherwise print false.
Sample Input 1 :
3
1 0 1
1 0 1
1 1 1
Sample Output 1 :
true
*/
