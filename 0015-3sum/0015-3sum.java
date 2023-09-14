import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        list.sort(Comparator.comparingInt(i -> i));

        Set<List<Integer>> results = new HashSet<>();
        int size = list.size();

        int left = 0;
        while (left < size - 2) {
            int leftValue = list.get(left);

            int center = left + 1;
            int right = size - 1;
            while (center < right) {
                int centerValue = list.get(center);
                int rightValue = list.get(right);

                int sum = leftValue + centerValue + rightValue;
                if (sum == 0) {
                    results.add(List.of(leftValue, centerValue, rightValue));
                    center ++;
                    right --;
                } else if (sum > 0) {
                    right --;
                } else {
                    center ++;
                }
            }

            left ++;
        }

        return results.stream().toList();
    }
}