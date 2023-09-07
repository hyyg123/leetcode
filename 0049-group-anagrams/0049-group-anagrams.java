import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
            [eat tea tan ate nat bat]
            Map (key=정렬된값,value=List모음)
         */

        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
             String sorted = str.chars()
                .sorted()
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
            List<String> list = map.getOrDefault(sorted, new ArrayList<>());
            list.add(str);
            map.put(sorted, list);
         }

        return map.keySet().stream()
            .map(key -> map.get(key))
            .collect(Collectors.toList());
    }
}