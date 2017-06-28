package com.strings.stringTokens;

/**
 * Created by bharghava on 27/6/17.
 */
import java.io.*;
import java.util.*;

public class stringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s = s.trim();
        String[] parts = s.split("[ !,?._'@]+");
        if(parts.length == 1 && parts[0].equals("")) {
            System.out.println(0);
        } else {
            System.out.println(parts.length);
            for(String i: parts) {
                System.out.println(i);
            }
        }
        scan.close();
    }
}
