class Solution {
    /**
    
    x = 12121

    x % 10 = 1
    x / 10 = 2
    12121


    
     */
    public boolean isPalindrome(int x) {
        int result = 0;
        int next = x;
        while (next > 0) {
            result = result * 10 + (next % 10);
            next = next / 10;
        }
        return result == x;
    }
}