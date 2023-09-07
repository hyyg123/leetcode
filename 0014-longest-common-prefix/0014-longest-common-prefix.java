class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        String first = strs[0];
        int len = first.length();
        for (int i = 0; i < len; i++) {
            char c = first.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                String str = strs[j];
                if (i >= str.length() || c != str.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}