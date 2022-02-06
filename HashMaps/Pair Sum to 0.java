import java.util.*;

//	Optimised solution
public class Solution {
	public static int PairSum(int[] input, int size) {
		
        HashMap<Integer,Integer> map = new HashMap<>();
        int countPairs =0;
        
        for(int i : input){
            if(map.containsKey(-i)){
                    countPairs = countPairs + map.get(-i);
                    if(map.containsKey(i)){
                        map.put(i,1+map.get(i));
                    }
                else map.put(i,1);
                }
            else if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else{
                map.put(i,1);
            }
            
        }
        return countPairs;
	}
}

// public class Solution {
// 	public static int PairSum(int[] input, int size) {
		
//         HashMap<Integer,Integer> map = new HashMap<>();
        
//         int countPairs =0;
        
//         for(int i : input){
//             if(map.containsKey(i)){
//                 map.put(i,map.get(i)+1);
//             }
//             else map.put(i,1);
//         }
        
//         for(int a : input){
//             if(map.containsKey(-a)){
//                 countPairs = countPairs + map.get(a)*map.get(-a);
//                 map.put(a,0);
//                 map.put(-a,0);
//             }
//         }
//         return countPairs;
// 	}
// }
