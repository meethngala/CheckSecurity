/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chequesecurity;

import java.util.*;

/**
 * this represents the security check for the amount entered on cheque by
 * converting into word equivalent
 *
 * @author Meeth
 * @version 1
 */
public class ChequeSecurity {

    /**
     * class for checking the security
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cheque c = new Cheque();// c the reference of the object of type Cheque
        float amt = c.input();// user enters amount on cheque
        System.out.println("Dollar amount in words: " + c.convert(c.separate(amt)) + "  and " + c.fraction(amt) + "/100");

    }// end of main

}// end of ChequeSecurity
