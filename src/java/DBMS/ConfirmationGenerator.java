/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBMS;

import java.util.Random;

/**
 *
 * @author saumiko
 */
public class ConfirmationGenerator {
    public static String getConfirmationString() {
        String BuildChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder randString = new StringBuilder();
        Random rnd = new Random();
        while (randString.length() < 12) {
            int index = (int) (rnd.nextFloat() * BuildChars.length());
            randString.append(BuildChars.charAt(index));
        }
        String finalConfirmation = randString.toString();
        return finalConfirmation;
    }
}
