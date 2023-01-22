package codekata;

public class LeetCode {

    public LeetCode() {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        for (int j : nums) {
            for (int num : nums) {
                if (j == num) {
                    continue;
                }
                if (j + num == target) {
                    output[0] = j;
                    output[1] = num;
                }
            }
        }
        return output;
    }
}
