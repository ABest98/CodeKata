package codekata;

import java.util.Arrays;

public class ApplicationCLI {

    public ApplicationCLI() {

    }

    public void run() {
        CodeWars codeWars = new CodeWars();
        LeetCode leetCode = new LeetCode();

        String num1 = "63829983432984289347293874";
        String num2 = "90938498237058927340892374089";
        int[] numArr = {-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20};
        int[] twoSumArr = {2,7,11,15};
        int sumTarget = 9;
        String romanNumeral = "MCMXCIV";
        String[] strs = {"flower","flow","flight"};
        String parentheses = "()[]{}";

        System.out.println(codeWars.add(num1, num2));
        System.out.println(codeWars.addTwo(num1, num2));
        System.out.println(codeWars.rangeExtraction(numArr));
        System.out.println(codeWars.rangeExtraction2(numArr));
        System.out.println(Arrays.toString(leetCode.twoSum(twoSumArr, sumTarget)));
        System.out.println(leetCode.romanToInteger(romanNumeral));
        System.out.println(leetCode.longestCommonPrefix(strs));
        System.out.println(leetCode.isValid(parentheses));
    }

    public static void main(String[] args) {
        ApplicationCLI cli = new ApplicationCLI();
        cli.run();
    }
}

