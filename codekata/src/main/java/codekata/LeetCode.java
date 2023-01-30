package codekata;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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

    // * Runtime: 4ms <---> Memory: 40.4MB * \\
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


    // * Runtime: 1ms <---> Memory: 40.4MB * \\
    public String longestCommonPrefix(String[] strs) {

        // Create a variable to hold the size of the array of strings
        int length = strs.length;

        // If statement to return if the array length is 0 or 1
        if(strs.length == 0) {
            return "";
        } else if(length == 1) {
            return strs[0];
        }

        // Sort the array
        Arrays.sort(strs);

        // Get the minimum length string from first and last
        int end = Math.min(strs[0].length(), strs[length - 1].length());

        // While loop over the first word and last word to get the prefix
        int increment = 0;

        while(increment < end && strs[0].charAt(increment) == strs[length - 1].charAt(increment)) {
            increment++;

        }

        // return prefix
        String prefix = strs[0].substring(0, increment);

        return prefix;
    }

    /// * Runtime: 1ms <---> Memory: 40.1MB * \\
    public boolean isValid(String s) {

        Deque<Character> stackQue = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char exp = s.charAt(i);

            if(exp == '(' || exp == '{' || exp == '[') {
                stackQue.push(exp);
                continue;
            }

            if(stackQue.isEmpty()) {
                return false;
            }

            char closing;
            switch (exp) {
                case ')' -> {
                    closing = stackQue.pop();
                    if (closing == '{' || closing == '[') {
                        return false;
                    }
                }
                case '}' -> {
                    closing = stackQue.pop();
                    if (closing == '(' || closing == '[') {
                        return false;
                    }
                }
                case ']' -> {
                    closing = stackQue.pop();
                    if (closing == '{' || closing == '(') {
                        return false;
                    }
                }
            }
        }

        return stackQue.isEmpty();
    }

    // * Only used for Roman To Integer  * \\
    private int value(char c) {

        // * Enhanced Switch Statement * \\
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
