import java.util.*;

class Solution {
    // a b c b e f
    // set=abc
    // set=ac, left=1
    // set=acb, left=1
    // i=e
    // acbef
    // 6-1+1=6
    
    // public int lengthOfLongestSubstring(String s) {
    //     int max = 0;
    //     List<Character> list = new ArrayList<>();
    //     for(char ch : s.toCharArray()) {
            
    //         int i = list.indexOf(ch);
    //         while(i >= 0) {
    //             for(int j = 0; j <= i; j++) {
    //                 list.remove(0);
    //             }
    //             i = list.indexOf(ch);
    //         }

    //         list.add(ch);

    //         int size = list.size();
    //         if (size > max) {
    //             max = size;
    //         }
    //     }

    //     return max;
    // }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }
        
        return maxLength;
    }
}