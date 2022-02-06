import java.util.HashMap;

public class Solution {

	public static String uniqueChar(String str){
		
        HashMap<Character,Integer> h = new HashMap<>();
        
        String n = "";
        
        for(int i=0;i<str.length();i++){
            if(!h.containsKey(str.charAt(i))){
                n = n + str.charAt(i);
                h.put(str.charAt(i),1);
            }
        }
        
        return n;
        
	}
}
