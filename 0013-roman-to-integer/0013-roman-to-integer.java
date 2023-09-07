import java.util.*;

class Solution {
    /*

    sum
    while i < s.len
        ch = s[i]

        num = 
        if ch is I or X or C
            if s[i + 1] is V X , L C, D M
                num = a - b
        else 
            num = convert(ch)

        sum += num

    */

    private final Map<Character, Integer> map = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );

    public int romanToInt(String s) {
        int n = s.length();
        int i = 0;

        int sum = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if (i + 1 < n) {
                char next = s.charAt(i + 1);
                sum += convert(ch, next);
                if (isAdd(ch, next)) {
                    i ++;
                } 
            } else {
                sum += convert(ch, ' ');
            }
            i ++;
        }

        return sum;
    }

    private int convert(char ch, char next) {
        int num = map.get(ch);
        if (isAdd(ch, next)) {
            return map.get(next) - num;
        }
        return num;
    }

    private boolean isAdd(char ch, char next) {
        if (ch == 'I' && (next == 'V' || next == 'X')) {
            return true;
        } else if (ch == 'X' && (next == 'L' || next == 'C')) {
            return true;
        } else if (ch == 'C' && (next == 'D' || next == 'M')) {
            return true;
        }
        return false;
    }
}