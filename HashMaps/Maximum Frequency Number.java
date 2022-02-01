import java.util.*;
public class Solution {

    public static int maxFrequencyNumber(int[] arr){ 
        
        int maxFreq = 0;
        int maxFreqValue=0;
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i : arr) {
			if(map.containsKey(i)) {
				map.put(i, 1+map.get(i) );
                
                // If 2 numbers have same freq then return first is cause test case fail, so itereate again
                
//                 if(maxFreq<map.get(i)){
//                     maxFreqValue = i;
//                     maxFreq = map.get(i);}
//
			}
            else {
				map.put(i, 1);
                // if(maxFreqValue<1){
                //     maxFreqValue = i;
                //     maxFreq = 1;
                // }
			}
        }
        
        for(int a : arr){
            if(maxFreq < map.get(a)){
                maxFreqValue = a;
                maxFreq = map.get(a);
            }
        }
        
        return maxFreqValue;
    
    }
}


/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
