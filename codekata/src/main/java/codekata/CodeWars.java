package codekata;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeWars {

    public CodeWars() {

    }

    // ADDING BIG NUMBERS * WITH BIGINTEGER * --4kyu
    public String add(String a, String b) {
        BigInteger num1 = new BigInteger(a);
        BigInteger num2 = new BigInteger(b);

        BigInteger total = num1.add(num2);

        return "" + total + "";
    }

    // ADDING BIG NUMBERS * WITHOUT BIGINTEGER * --4kyu
    public String addTwo(String a, String b) {
        // Create a simple calculator

        // Always make sure the second string is the biggest one
        if(a.length() > b.length()) {
            String container = a;
            a = b;
            b = container;
        }

        // This will hold our combined amount
        String total = "";

        // Calculate the lengths of both strings
        int l1 = a.length();
        int l2 = b.length();

        // Reverse Both Strings
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();


        // Calculate sum of current digits and the remainder
        int remainder = 0;

        for(int i = 0; i < l1; i++) {
            int sum = ((a.charAt(i) - '0') +
                    (b.charAt(i) - '0') + remainder);
            total += (char)(sum % 10 + '0');

            remainder = sum / 10;
        }

        // Add remaining digits of the larger array
        for(int j = l1; j < l2; j++) {
            int sum = ((b.charAt(j) - '0') + remainder);
            total += (char)(sum % 10 + '0');
            remainder = sum / 10;
        }

        // Add remainder
        if(remainder > 0) {
            total += (char)(remainder + '0');
        }

        // Reverse array turn it into a string
        total = new StringBuilder(total).reverse().toString();

        // Filters out the zeros from the beginning of the number
        String[] totalChar = total.split("");

        List<String> list = Arrays.asList(totalChar);

        for (String s : list) {
            if (s.equals("0")) {
                list.set(list.indexOf(s), "");
            } else {
                break;
            }
        }

        total = String.join("", list);

        // Return the total amount
        return total;
    }

    // Range Extraction --4kyu
    public String rangeExtraction(int[] numArr) {
        // Create empty string
        StringBuilder formattedString = new StringBuilder();
        // Create values to hold first number and next number
        int firstNum, nextNum;
        int previousNum = numArr[0];
        int counter = 0;
        // Loop over array
        for(int i = 0; i < numArr.length - 1; i++) {
            firstNum = numArr[i];
            nextNum = numArr[i + 1];
            // If next number = first number + 1 continue
            if(nextNum == firstNum + 1) {
                if(nextNum == numArr[numArr.length-1]) {
                    previousNum = numArr[i - counter];
                    formattedString.append(",").append(previousNum).append("-").append(nextNum);
                }
                counter++;
            } else if (nextNum >= firstNum + 2) {

                if (formattedString.toString().equals("")) {

                    if(previousNum == firstNum) {
                        formattedString.append(previousNum);
                    } else {
                        formattedString.append(previousNum).append("-").append(firstNum);
                    }

                } else if (counter == 1) {
                    previousNum = numArr[i - counter];
                    formattedString.append(",").append(previousNum).append(",").append(firstNum);

                } else if (counter == 0) {
                    formattedString.append(",").append(firstNum);

                } else {
                    previousNum = numArr[i - counter];
                    formattedString.append(",").append(previousNum).append("-").append(firstNum);
                }
                counter = 0;
            }
            // If it's in a sequence add a - between first number and next number
        }
        // Return String

        return formattedString.toString();
    }

    // Range Extraction * Simplified * --4kyu
    public String rangeExtraction2(int[] numArr) {
        List<String> ls = new ArrayList<>();
        int consecutiveCounter = 0;
        for (int i = 0; i < numArr.length; ) {
            consecutiveCounter = 0;
            String start = String.valueOf(numArr[i]);
            while (i != numArr.length - 1 && numArr[i + 1] - numArr[i] == 1) {
                consecutiveCounter++;
                i++;
            }
            if (consecutiveCounter > 0) {
                if (consecutiveCounter > 1) start += "-" + (Integer.parseInt(start) + consecutiveCounter);
                else i--;
            }
            ls.add(start);
            i++;
        }

        return String.join(",", ls);
    }
}
