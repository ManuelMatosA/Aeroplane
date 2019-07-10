package com.company;


//Namespace


//Imports
import java.util.Scanner;

/**
 * Main Class
 */
public class Gabo {

    /**
     * (Arithmetic) Write an application that asks the user to enter two integers, obtains them from the user and prints their sum, product,
     * difference and quotient (division). Use the techniques shown in Fig. 2.7.
     * @param args
     */

    static final String SUM = "+";
    static final String REST = "-";
    static final String MUL = "*";
    static final String DIV = "/";
    static final String COS = "%";

    //Fields
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {



        //Variables
        int number1;
        int number2;
        int result;

        //Input numbers
        askForNumber();
        number1 = input.nextInt();

        askForNumber();
        number2 = input.nextInt();

        //Calculate sum operation
        result = calculateResult(number1, number2, SUM);
        System.out.println("The Sum is ["+result+"]: ");

        //Calculate res operation
        result = calculateResult(number1, number2, REST);
        System.out.println("The rest is ["+result+"]: ");

        //Calculate mul operation
        result = calculateResult(number1, number2, MUL);
        System.out.println("The mul is ["+result+"]: ");

        //Calculate div operation
        result = calculateResult(number1, number2, DIV);
        System.out.println("The div is ["+result+"]: ");

        //Calculate cos operation
        result = calculateResult(number1, number2, COS);
        System.out.println("The cos is ["+result+"]: ");

    }


    private static void askForNumber() {
        System.out.println("Enter a number");

    }

    private static int calculateResult(int number1, int number2, String operation) {
        int result = 0;

        if (operation.equals(SUM)){
            result = number1 + number2;
        }
        else if (operation.equals(REST)){
            result = number1 - number2;
        }
        else if (operation.equals(MUL)){
            result = number1 * number2;
        }
        else if (operation.equals(DIV)){
            result = number1 / number2;
        }
        else if (operation.equals(COS)){
            result = number1 % number2;
        }

        return result;
    }




}