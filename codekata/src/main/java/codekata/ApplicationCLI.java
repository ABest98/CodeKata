package codekata;

import java.math.BigInteger;

public class ApplicationCLI {

    public ApplicationCLI() {

    }

    public void run() {
        CodeWars codeWars = new CodeWars();

        String num1 = "63829983432984289347293874";
        String num2 = "90938498237058927340892374089";

        System.out.println(codeWars.add(num1, num2));
        System.out.println(codeWars.addTwo(num1, num2));
    }

    // ADDING BIG NUMBERS * WITH BIGINTEGER*
    private static String add(String a, String b) {
        BigInteger num1 = new BigInteger(a);
        BigInteger num2 = new BigInteger(b);

        BigInteger total = num1.add(num2);

        return "" + total + "";
    }




    public static void main(String[] args) {
        ApplicationCLI cli = new ApplicationCLI();
        cli.run();
    }
}

