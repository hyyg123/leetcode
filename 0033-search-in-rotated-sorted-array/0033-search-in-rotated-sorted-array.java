class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        return search(nums, target, len / 2, 0, len - 1);

    }

    private int search(int nums[], int target, int rootIndex, int startIndex, int endIndex) {
        int rootValue = nums[rootIndex];
        int startValue = nums[startIndex];
        int endValue = nums[endIndex];
        
        if (startIndex == rootIndex || endIndex == rootIndex) {
            if (target == startValue) {
                return startIndex;
            }
            if (target == endValue) {
                return endIndex;
            }
            return -1;
        }
        

        // System.out.println("index:start=" + startIndex + ",root=" + rootIndex + ",end=" + endIndex);
        // System.out.println("value:start=" + startValue + ",root=" + rootValue + ",end=" + endValue);

        if (target == rootValue) {
            return rootIndex;
        } else if (target == startValue) {
            return startIndex;
        } else if (target == endValue) {
            return endIndex;
        }

        /*
            [1,2,3,4,5,6,0] -> 1 4 0
            [2,3,4,5,6,0,1] -> 2 5 1
            [3,4,5,6,0,1,2] -> 3 6 2
            [4,5,6,0,1,2,3] -> 4 0 3
            [5,6,0,1,2,3,4] -> 5 1 4
            [6,0,1,2,3,4,5] -> 6 2 5

            targets=[0,2,4,6]

            target=0
            1 3 5 -> -1
            3 5 1 -> right
            5 1 3 -> left
            target=2
            1 3 5 -> left
            3 5 1 -> right
            5 1 3 -> right
            target=4
            1 3 5 -> right
            3 5 1 -> left
            5 1 3 -> -1
            target=6
            1 3 5 -> -1
            3 5 1 -> right
            5 1 3 -> left

            4 7 2 == 3 5 1
            9 3 8 == 5 1 3
        */

        boolean left = false;
        boolean right = false;
        if (startValue < rootValue && rootValue < endValue) {
            if (startValue < target && target < rootValue) {
                left = true;
            } else if (rootValue < target && target < endValue) {
                right = true;
            }
        } else if (endValue < startValue && startValue < rootValue) {
            if (startValue < target && target < rootValue) {
                left = true;
            } else {
                right = true;
            }
        } else if (rootValue < endValue && endValue < startValue) {
            if (rootValue < target && target < endValue) {
                right = true;
            } else {
                left = true;
            }
        }

        // System.out.println("right=" + right + ",left=" + left);

        int result = -1;
        if (right) {
            int nextStartIndex = rootIndex;
            int nextEndIndex = endIndex;
            int nextRootIndex = rootIndex + ((endIndex - rootIndex) / 2);
            result = search(nums, target, nextRootIndex, nextStartIndex, nextEndIndex);
        } else if (left) {
            int nextStartIndex = startIndex;
            int nextEndIndex = rootIndex;
            int nextRootIndex = startIndex + ((rootIndex - startIndex) / 2);
            result = search(nums, target, nextRootIndex, nextStartIndex, nextEndIndex);
        }

        return result;
    }
}