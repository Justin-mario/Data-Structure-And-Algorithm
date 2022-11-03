package com.company;

import java.util.LinkedList;

public class CheckPalindrome {

    public static boolean checkForPalindrome(String string){

        LinkedList<Character> stack = new LinkedList<> ();
        StringBuilder stringNoPunctuation = new StringBuilder (string.length ());
        String lowerCase = string.toLowerCase ();

//        for (int i = 0; i < lowerCase.length (); i++) {
//            char c = lowerCase.charAt ( i );
//            if (c >= 'a' && c <= 'z'){
//                stringNoPunctuation.append ( c );
//                stack.push ( c );
//            }
//        }
//
//        StringBuilder reversedString = new StringBuilder (stack.size ());
//            while(!stack.isEmpty ()){
//                reversedString.append ( stack.pop () );
//            }



        for (int i = 0; i < lowerCase.length (); i++) {
            char c = lowerCase.charAt ( i );
            if (c >= 'a' && c <= 'z'){
                stringNoPunctuation.append ( c );
            }
        }

        StringBuilder reversedString = new StringBuilder (stringNoPunctuation.length ());
        for (int i = stringNoPunctuation.length () - 1; i >= 0; i--) {
            char c = stringNoPunctuation.charAt ( i );
            if (c >= 'a' && c <= 'z'){
               reversedString.append (  c);

            }
        }


        return reversedString.toString () .equals (stringNoPunctuation.toString () );
    }
}
