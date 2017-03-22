/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chequesecurity;

import java.util.*;

/**
 * class for Cheque
 *
 * @author Meeth
 */
public class Cheque {

    Scanner sc = new Scanner(System.in);
    private static final String[] specialNames = {
        "",
        " thousand",
        " million"

    };

    private static final String[] tensNames = {
        "",
        " ten",
        " twenty",
        " thirty",
        " forty",
        " fifty",
        " sixty",
        " seventy",
        " eighty",
        " ninety"
    };

    private static final String[] numNames = {
        "",
        " one",
        " two",
        " three",
        " four",
        " five",
        " six",
        " seven",
        " eight",
        " nine",
        " ten",
        " eleven",
        " twelve",
        " thirteen",
        " fourteen",
        " fifteen",
        " sixteen",
        " seventeen",
        " eighteen",
        " nineteen"
    };

    /**
     *
     * @param number
     * @return number in words upto thousand
     */
    public String uptoOneThousand(int number) {
        String current;

        if (number % 100 < 20) {
            current = numNames[number % 100];
            number /= 100;
        } else {
            current = numNames[number % 10];
            number /= 10;

            current = tensNames[number % 10] + current;
            number /= 10;
        }
        if (number == 0) {
            return current;
        }
        return numNames[number] + " hundred" + current;
    }

    /**
     *
     * @param number
     * @return number in words
     */
    public String convert(int number) {

        if (number == 0) {
            return "zero";
        }

        String prefix = "";

        if (number < 0) {
            number = -number;
            prefix = "negative";
        }

        String current = "";
        int place = 0;

        do {
            int n = number % 1000;
            if (n != 0) {
                String s = uptoOneThousand(n);
                current = s + specialNames[place] + current;
            }
            place++;
            number /= 1000;
        } while (number > 0);

        return (prefix + current).trim();
    }

    /**
     * takes the input from user to fill amount on cheque
     *
     * @return amount
     */
    public float input() {
        System.out.println("Please enter a dollar amount: ");
        float amt = sc.nextFloat();
        if (amt > 1000000) {

            System.out.println("amount limit exceeded");

            amt = input();

        }
        return amt;
    }

    /**
     * separates the number and decimal part
     *
     * @param amt
     * @return number
     */
    public int separate(float amt) {

        int number = (int) amt;

        return number;
    }

    /**
     * returns the decimal part
     *
     * @param amt
     * @return decimal part
     */
    public int fraction(float amt) {
        int fraction = (int) (Math.ceil(amt * 100));
        fraction = fraction % 100;
        return fraction;
    }
}
