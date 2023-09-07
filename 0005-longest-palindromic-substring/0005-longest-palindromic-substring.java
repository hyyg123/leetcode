class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length < 2) {
            return s;
        }

        int max = 0;
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i < chars.length; i ++) {
            // 홀수
            int left = i - 1;
            int right = i + 1;
            int cnt = 1;
            while(left >= 0 && right < chars.length && chars[left] == chars[right]) {
                cnt += 2;
                left --;
                right ++;
            }

            if (cnt > max) {
                maxLeft = left + 1;
                maxRight = right - 1;
                max = cnt;
                // System.out.println("l="+maxLeft+"r"+maxRight);
            }

            // 짝수
            left = i;
            right = i + 1;
            cnt = 0;
            while(left >= 0 && right < chars.length && chars[left] == chars[right]) {
                cnt += 2;
                left --;
                right ++;
            }
            if (cnt > max) {
                maxLeft = left + 1;
                maxRight = right - 1;
                max = cnt;
                // System.out.println("l="+maxLeft+"r"+maxRight);
            }
        }

        return s.substring(maxLeft, maxRight + 1);
    }
    public String longestPalindrome2(String s) {
        /*
            int index = 0;
            for i -> s.len ~ 2
                int l=index, r=i;
                while s.charAt(index) ==  s.charAt(i)
                    l ++;
                    r ++;
                if allMatch
                    return s.sub(index, i)
                else if (index )
                    index ++
        */

        for (int len = s.length(); len > 1; len --) {
            for (int index = 0; index < s.length() - len + 1; index ++) {
                int left = index;
                int right = index + len - 1;

                int cnt = 0;
                while (s.charAt(left) == s.charAt(right) && right - left >= 0) {
                    cnt ++;
                    left ++;
                    right --;
                }

                // 0 1 2 -> 3/2 = 1 -> 2 time
                // 0 1 -> 2/2 = 1 -> 1 time
                if (cnt == (len / 2 + len % 2)) {
                    return s.substring(index, index + len);
                }
            }
        }

        return String.valueOf(s.charAt(0));
    }
}