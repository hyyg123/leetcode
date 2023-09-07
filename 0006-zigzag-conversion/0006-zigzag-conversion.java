import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String convert(String s, int numRows) {
        /*
            List<List> list

            int step = 1;
            int index = 0;
            for i ~ s.len
                list.get(index).add(s[i])
                if index == numRows - 1
                    step = -1
                else if index == 0
                    step = 1

                index += step

            return 
        */

        Map<Integer, List<Character>> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int step = 1;
        int index = 0;
        for (int i = 0; i < chars.length; i ++) {
            List<Character> list = map.computeIfAbsent(index, (key) -> new ArrayList<>());
            list.add(chars[i]);

            if (numRows == 1) {
                step = 0;
            } else if (index == numRows - 1) {
                step = -1;
            } else if (index == 0) {
                step = 1;
            }

            index += step;
        }

        StringBuilder sb = new StringBuilder();
        int size = map.keySet().size();
        for (int i = 0; i < size; i++) {
            map.get(i).forEach(ch -> sb.append(String.valueOf(ch)));
        }

        return sb.toString();
    }
}