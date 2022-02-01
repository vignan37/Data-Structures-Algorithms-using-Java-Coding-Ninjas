import java.util.*;
public class Solution {

	public static void printIntersection(int[] arr1,int[] arr2){
		
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int a1 : arr1){
            if(map.containsKey(a1)){
               map.put(a1,1+map.get(a1)); 
            }
            else{
                map.put(a1,1);
            }
            
        }
        
        for(int a2 : arr2){
            if(map.containsKey(a2) && map.get(a2)>0 ){
                System.out.println(a2);
                map.put(a2,map.get(a2)-1);
            }
        }
        
	}
}
