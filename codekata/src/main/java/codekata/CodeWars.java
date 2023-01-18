package codekata;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class CodeWars {

    public CodeWars() {

    }

    // ADDING BIG NUMBERS * WITH BIGINTEGER*
    public String add(String a, String b) {
        BigInteger num1 = new BigInteger(a);
        BigInteger num2 = new BigInteger(b);

        BigInteger total = num1.add(num2);

        return "" + total + "";
    }

    // ADDING BIG NUMBERS * WITHOUT BIGINTEGER*
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
}
