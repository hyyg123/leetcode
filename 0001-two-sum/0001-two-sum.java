class Solution {
    public int[] twoSum(int[] nums, int target) {
        /**
        
        for i in nums


         */

         List<Integer> list = new ArrayList<>();
         for (int i = 0; i < nums.length; i ++) {
             int num = nums[i];
             if (list.contains(num)) {
                 return new int[] { list.indexOf(num), i };
             } 
             list.add(target - num);
         }

         return new int[]{};
    }
}