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

    public int romanToInteger(String s) {

        int total = 0;

        for(int i = 0; i < s.length(); i++) {
            int s1 = value(s.charAt(i));

            if(i + 1 < s.length()) {
                int s2 = value(s.charAt(i + 1));

                if(s1 >= s2) {
                    total += s1;
                } else {
                    total -= s1;
                }
            } else {
                total += s1;
            }
        }

        return total;
    }

    // * Only used for Roman To Integer  * \\
    private int value(char c) {

        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
