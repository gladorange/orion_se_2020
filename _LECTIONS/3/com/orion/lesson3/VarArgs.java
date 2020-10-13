package com.orion.lesson3;

public class VarArgs {


    public static void main(String[] args) {
        String[] strs = {"one", "two"};
        printString(strs);
        //printString(new String[] {"1","2"});
        printStringVarArg("Печатаю раз два","one", "two");
        printStringVarArg("Печатаю буквы","a", "b","c");
        printStringVarArg("Ничего не печатаю");
    }

    static void  printString(String[] strToPrint) {

        int i = 1;
        for (String s : strToPrint) {
            System.out.println(i++ + ":" + s);
        }
    }

    static void  printStringVarArg(String welcomeText, String ... strToPrint) {

        int i = 1;
        System.out.println(welcomeText);
        for (String s : strToPrint) {
            System.out.println(i++ + ":" + s);
        }
    }
}
