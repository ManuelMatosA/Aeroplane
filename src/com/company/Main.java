package com.company;

import java.util.Scanner;

public class Main {

    private static boolean[][] plane = new boolean[34][8];
    private static String[][] passengers = new String[34][8];

    private static final int PLANE_ARRAY_COLUMN_NUMBER = 8;
    private static final int FIRST_CLASS_NUMBER_OF_SEATS = 10;

    private static int countSalesFirstClass = 0;
    private static int countSalesEconomy = 0;
    private static int firstClassSales = 0;
    private static int economySales = 0;
    private static String name = "A";
    private static String lastName = "A";
    private static String passport = "A";
    private static int counterSeatsAB = 0;
    private static int counterSeatsCD = 0;
    private static int counterSeatsEF = 0;
    private static int counterSeatsCDEF = 0;
    private static int counterSeatsGH = 0;

    //Fields
    private static Scanner in = new Scanner( System.in );


    public static void main(String[] args) {

        //Arrays


        //Variables
        String inputControl;
        String breakPassenger;

        String ticket;
        String password = "A";
        String sentinel = "A";
        String passengerList;
        String showTotalSales;
        String passwordTemporal = "A";
        int totalSales;
        int averageSales = 0;
        String showMostLeast;
        int counterPassword = 0;
        boolean NoSeatsOccupied = false;
        String showSeat;
        boolean firstClassFull = false;
        boolean economyClassFull = false;
        String elseFirstClass;
        String elseEconomyClass;


        //Constants
        final int SEATS_FIRST_CLASS = 80;
        final int SEATS_ECONOMY = 192;


        //Pasa todos los elementos del array de Strings
        for (int x = 0; x < passengers.length; x++) {
            for (int y = 0; y < passengers[x].length; y++) {
                passengers[x][y] = " ";
            }
        }

        do {
            //Greetings
            System.out.println( "Welcome to the Aero Ticket 2000" );
            System.out.println( "================================" );
            System.out.println();

            System.out.println( "################################################################################################" );
            System.out.println( "This system is designed to book plane tickets as a passenger, and manage sales as a staff member" );
            System.out.println( "################################################################################################" );
            System.out.println();

            staffHeader( "Do you want to reserve a seat in our plane? Or are you a staff member?|\nType \"passenger\" if you're a PASSENGER                                |\nand \"staff\" for STAFF.                                                |" );
            inputControl = in.nextLine();

            //First Switch Staff-Passenger
            switch (inputControl) {
                case "passenger":

                    System.out.println( "Welcome to North West Airlines automated reservation system!" );
                    System.out.println( "============================================================" );
                    System.out.println();
                    System.out.println( "****************************************************" );
                    System.out.println( "*                 Tickets are:                     *" );
                    System.out.println( "*               100£ for economy                   *" );
                    System.out.println( "*             300£ for first class                 *" );
                    System.out.println( "*   Would you like to book in our next flight?     *" );
                    System.out.println( "* Enter YES to continue or something else to exit. *" );
                    System.out.println( "****************************************************" );
                    System.out.println();
                    System.out.print( "#" );
                    breakPassenger = in.nextLine();


                    //If user doesn't want to buy a plane ticket
                    if (!breakPassenger.equalsIgnoreCase( "Yes" )) {
                        exiting();
                        break;
                    }

                    //Validate Input
                    while (!lastName.matches( "[a-zA-z]+([ '-][a-zA-Z]+)*" ) || !passport.matches( "\\d{6}" ) || !name.matches( "[A-Z][a-zA-Z]*" )) {
                        System.out.println( "Enter your first name:" );
                        System.out.print( "#" );
                        name = in.nextLine();
                        System.out.println( "Enter your last name:" );
                        System.out.print( "#" );
                        lastName = in.nextLine();
                        System.out.println( "Enter your passport number:" );
                        System.out.print( "#" );
                        passport = in.nextLine();
                        if (!lastName.matches( "[a-zA-z]+([ '-][a-zA-Z]+)*" ) || !passport.matches( "\\d{6}" ) || !name.matches( "[A-Z][a-zA-Z]*" )) { //NOTE!!!
                            inputWrong();
                        }
                    }

                    //Second switch first class-economy
                    System.out.println();
                    System.out.println( "Which class would you like to buy?" );
                    System.out.println( "==================================" );
                    System.out.print( "#" );
                    ticket = in.nextLine();

                    switch (ticket) {
                        case "first class":

                            //Checks if first class is full
                            for (int x = 0; x < FIRST_CLASS_NUMBER_OF_SEATS; x++) {
                                for (int y = 0; y < plane[x].length; y++) {
                                    if (!plane[x][y]) {
                                        break;
                                    } else {
                                        firstClassFull = true;
                                    }
                                }
                            }

                            //If first class is full but economy isn't
                            if (firstClassFull && !economyClassFull) {
                                planeMessages("First class is currently full.");

                                System.out.println( "Would you like to book in economy?" );
                                System.out.println( "==================================" );
                                System.out.print( "#" );
                                elseFirstClass = in.nextLine();

                                //If user doesN'T want to book in economy
                                if (!elseFirstClass.equalsIgnoreCase( "Yes" )) {
                                    planeMessages("Next flight leaves in 3 hours.");
                                    exiting();
                                    break;
                                    //If user does want to book in economy
                                } else {
                                    economy();
                                }
                                break;
                            }

                            //If both are full break
                            if (firstClassFull && economyClassFull) {
                                planeMessages("Next flight leaves in 3 hours.");
                                planeMessages("      No seats available.     ");
                                exiting();
                                break;
                            }

                            firstClass();
                            break;
                        case "economy":

                            //Checks if first class is full
                            for (int x = FIRST_CLASS_NUMBER_OF_SEATS; x < plane.length; x++) {
                                for (int y = 0; y < plane[x].length; y++) {
                                    if (!plane[x][y]) {
                                        break;
                                    } else {
                                        economyClassFull = true;
                                    }
                                }
                            }

                            //If economy is full but first class isn't
                            if (!firstClassFull && economyClassFull) {
                                planeMessages("Economy is currently full.");

                                System.out.println( "Would you like to book in first class?" );
                                System.out.println( "======================================" );
                                System.out.print( "#" );
                                elseEconomyClass = in.nextLine();

                                //If user doesN'T want to book in first class
                                if (!elseEconomyClass.equalsIgnoreCase( "Yes" )) {
                                    planeMessages("Next flight leaves in 3 hours.");
                                    exiting();
                                    break;
                                    //If user does want to book in first class
                                } else {
                                    firstClass();
                                    break;
                                }
                            }

                            //If both are full
                            if (firstClassFull && economyClassFull) {
                                planeMessages("Next flight leaves in 3 hours.");
                                planeMessages("      No seats available.     ");
                                exiting();
                                break;
                            }

                            economy();
                            break;

                        default:
                            inputWrong();
                            break;
                    }
                    break;
                case "staff":

                    //Creates Password
                    if (counterPassword == 0) {
                        while (!passwordTemporal.matches( "\\d{4}" )) {
                            System.out.println( "Welcome! Please create a 4 digit staff password." );
                            System.out.println( "================================================" );
                            System.out.print( "#" );
                            passwordTemporal = in.nextLine();
                            System.out.println();
                            if (!passwordTemporal.matches( "\\d{4}" )) {
                                planeMessages("INVALID PASSWORD!!!");
                                System.out.println();
                            }
                        }
                    }
                    //Avoid recreating password
                    counterPassword++;

                    //Validates Password
                    if (counterPassword > 0) {
                        while (!password.equals( passwordTemporal )) {
                            System.out.println( "Please, enter your staff password." );
                            System.out.println( "==================================" );
                            System.out.print( "#" );
                            password = in.nextLine();
                            if (!password.equals( passwordTemporal )) {
                                planeMessages("WRONG PASSWORD!!!");
                                System.out.println();
                            }
                        }
                    }

                    //Resets Password
                    password = "B";

                    System.out.println();
                    System.out.println( "################################################################################################################" );
                    System.out.println( "Do you want to stop selling tickets? If so type \"Exit Program\", type something else if you don't want to quit." );
                    System.out.println( "################################################################################################################" );
                    System.out.print( "#" );
                    sentinel = in.nextLine();
                    System.out.println();

                    //Only prints the first time it's being used
                    if (counterPassword == 1) {
                        System.out.println( "##############################################################################################################################" );
                        System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~HOW TO USE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                        System.out.println( "Type Yes if you want to perform the prompted action.        Or something else if you don't want to perform the prompted action." );
                        System.out.println( "##############################################################################################################################" );
                        System.out.println();
                    }

                    staffHeader( "Do you want to see all of the current passengers?" );
                    passengerList = in.nextLine();
                    System.out.println();

                    //Prints all passengers
                    if (passengerList.equalsIgnoreCase( "Yes" )) {
                        for (String[] passenger : passengers) {
                            for (int col = 0; col < passengers[0].length; col++) {
                                if (!passenger[col].equals( " " )) {
                                    System.out.println( passenger[col] );
                                }
                            }
                        }
                        //Checks if plane is full
                        for (String[] passenger : passengers) {
                            for (int col = 0; col < passengers[0].length; col++) {
                                if (passenger[col].equals( " " )) {
                                    NoSeatsOccupied = true;
                                }
                            }
                        }

                        //Prints This if the plane is not yet full
                        if (NoSeatsOccupied) {
                            planeMessages("Plane isn't full");
                            System.out.println();
                        }
                    }

                    staffHeader( "Do you want to see the total AND the average of sales?" );
                    showTotalSales = in.nextLine();
                    System.out.println();

                    if (showTotalSales.equalsIgnoreCase( "Yes" )) {
                        //Calculates total
                        totalSales = firstClassSales + economySales;
                        //Calculates average and avoids dividing by 0
                        if (countSalesFirstClass > 0 && countSalesEconomy > 0) {
                            averageSales = (countSalesFirstClass + countSalesEconomy) / (SEATS_FIRST_CLASS + SEATS_ECONOMY) * 100;
                        }
                        planeMessages("Total sales made in this flight so far: " + totalSales + "£.");
                        planeMessages("Average of seats sold: " + averageSales + "%.");
                        System.out.println();
                    }

                    staffHeader( "Do you want to see the most and least sold rows and seats?" );
                    showMostLeast = in.nextLine();
                    System.out.println();

                    if (showMostLeast.equalsIgnoreCase( "Yes" )) {

                        row( 0, plane.length, "all the seats" );
                        col( 0, plane.length, "all the seats" );

                        System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~FIRST CLASS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );

                        row( 0, FIRST_CLASS_NUMBER_OF_SEATS, "first class" );
                        col( 0, FIRST_CLASS_NUMBER_OF_SEATS, "first class" );

                        System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ECONOMY~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );

                        row( FIRST_CLASS_NUMBER_OF_SEATS, plane.length, "economy" );
                        col( FIRST_CLASS_NUMBER_OF_SEATS, plane.length, "economy" );

                    }

                    staffHeader( "Do you want to see the consecutive seats?" );
                    showSeat = in.nextLine();

                    if (showSeat.equalsIgnoreCase( "Yes" )) {
                        findConsecutive( 0, FIRST_CLASS_NUMBER_OF_SEATS, "first class" );
                        findConsecutive( FIRST_CLASS_NUMBER_OF_SEATS, plane.length, "economy" );

                    }

                    if (!sentinel.equalsIgnoreCase( "Exit Program" )) {
                        exiting();
                    }
                    break;
                default:
                    inputWrong();
                    break;
            }
        } while (!sentinel.equalsIgnoreCase( "Exit Program" ));

        if (sentinel.equalsIgnoreCase( "Exit Program" )) {
            System.out.println();
            System.out.println( "---------------------------------" );
            System.out.println( "Thank you for using our program! |" );
            System.out.println( "---------------------------------" );
            System.out.println( "Exiting..." );
        }
    }

    private static void planeMessages(String message) {
        System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
        System.out.println( message );
        System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
    }

    private static void staffHeader(String message) {
        System.out.println( "=========================================" );
        System.out.println( message );
        System.out.println( "=========================================" );
        System.out.print( "#" );
    }

    private static void inputWrong() {
        System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
        System.out.println( "You have not entered a correct input" );
        System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
    }

    private static void exiting() {
        System.out.println();
        System.out.println();
        System.out.println( "The program is now exiting to the main menu!!!" );
        System.out.println( "==============================================" );
        System.out.println();
        System.out.println();
    }

    private static int fromLetterToNumber(String seat) {
        int seatCol = 50;

        if (seat.equalsIgnoreCase( "A" )) {
            seatCol = 0;
        } else if (seat.equalsIgnoreCase( "B" )) {
            seatCol = 1;
        } else if (seat.equalsIgnoreCase( "C" )) {
            seatCol = 2;
        } else if (seat.equalsIgnoreCase( "D" )) {
            seatCol = 3;
        } else if (seat.equalsIgnoreCase( "E" )) {
            seatCol = 4;
        } else if (seat.equalsIgnoreCase( "F" )) {
            seatCol = 5;
        } else if (seat.equalsIgnoreCase( "G" )) {
            seatCol = 6;
        } else if (seat.equalsIgnoreCase( "H" )) {
            seatCol = 7;
        }
        return seatCol;
    }

    private static void row(int startingSeatClass, int endingSeatClass, String theClass) {
        int countRow = 0;
        int countRowLine = 0;
        int leastRowLine = 0;
        int mostRow = 0;
        int leastRow = 0;
        for (int row = startingSeatClass; row < endingSeatClass; row++) {
            for (int col = 0; col < plane[row].length; col++) {
                if (plane[row][col]) {
                    countRow++;
                    if (countRow == 0) {
                        mostRow = countRow;
                        leastRow = countRow;
                        countRowLine = row;
                        leastRowLine = row;
                    } else {
                        if (countRow > mostRow) {
                            mostRow = countRow;
                            countRowLine = row;
                        }

                        if (countRow < leastRow) {
                            leastRow = countRow;
                            leastRowLine = row;
                        }
                    }
                }
            }
        }
        System.out.println( "The row with the most passengers in" + theClass + "is row " + countRowLine + " with " + mostRow + " passengers" );
        System.out.println( "-----------------------------------------------------------------------------------------------------" );
        System.out.println( "The row with the least passengers in" + theClass + "is row " + leastRowLine + " with " + leastRow + " passengers" );
        System.out.println( "=====================================================================================================" );
    }

    private static void col(int startingSeat, int endingSeat, String theClass) {
        int col = 0;
        int countCol = 0;
        int mostCol = 0;
        int leastCol = 0;
        int countColLine = 0;
        int leastCountColLine = 0;
        while (col < PLANE_ARRAY_COLUMN_NUMBER) {
            for (int row = startingSeat; row < endingSeat; row++) {
                if (plane[row][col]) {
                    countCol++;
                    if (countCol == 0) {
                        mostCol = countCol;
                        leastCol = countCol;
                        countColLine = col;
                        leastCountColLine = col;

                    } else {
                        if (countCol > mostCol) {
                            mostCol = countCol;
                            countColLine = col;
                        }

                        if (countCol < leastCol) {
                            leastCol = countCol;
                            leastCountColLine = col;
                        }
                    }
                }
            }
            col++;
        }

        System.out.println( "The column of seats with the most passengers in " + theClass + " is col " + countColLine + " with " + mostCol + " passengers" );
        System.out.println( "-----------------------------------------------------------------------------------------------------" );
        System.out.println( "The column of seats with the least passengers in " + theClass + " is col " + leastCountColLine + " with " + leastCol + " passengers" );
    }

    private static void PrintSeatHeader(String theClass) {
        System.out.println( "****************************************************" );
        System.out.println( "*        Which seat would you like to book?        *" );
        System.out.println( "*  We offer seats in the following configuration:  *" );
        System.out.println( "*              A|B " + theClass + " G|H                     *" );
        System.out.println( "*  Please, input the letter of your desired seat.  *" );
        System.out.println( "****************************************************" );
    }

    private static void PrintRowHeader(String theClass, String fromTo) {
        System.out.println( "****************************************************" );
        System.out.println( "*         Which row would you like to book?        *" );
        System.out.println( "*             We offer seats from row:             *" );
        System.out.println( "*                   " + fromTo + "                       *" );
        System.out.println( "*            For our "+ theClass + " passengers.           *" );
        System.out.println( "****************************************************" );
    }

    private static void seatTaken() {
        System.out.println( "~~~~~~~~~~~~~~~~~~" );
        System.out.println( "Seat already taken" );
        System.out.println( "~~~~~~~~~~~~~~~~~~" );
    }

    private static void economy() {
        int economyRow;
        String economySeat;
        int economySeatCol;

        do {
            PrintRowHeader("economy", "11 TO 34");
            System.out.print( "#" );
            economyRow = in.nextInt();
            in.nextLine();
            economyRow--;
            if (economyRow <= 10) {
                inputWrong();
            }
        } while (economyRow <= 10);

        do {
            PrintSeatHeader("C|D|E|F");
            System.out.print( "#" );
            economySeat = in.nextLine();
            if (!economySeat.matches( "A|B|C|D|E|F|G|H" )) {
                inputWrong();
            }
        } while (!economySeat.matches( "A|B|C|D|E|F|G|H" ));


        //Assigns the letter typed into it's correspondent number variable
        economySeatCol = fromLetterToNumber( economySeat );

        if (plane[economyRow][economySeatCol]) {
            seatTaken();
        } else {
            plane[economyRow][economySeatCol] = true;
            passengers[economyRow][economySeatCol] = lastName + ", " + name + ". Passport Number: " + passport + ", Reservation Number: " + countSalesEconomy + ", located in first class: Seat " + economySeat + " in row " + (economyRow + 1) + ".";
            System.out.println( "BOARDING PASS" );
            System.out.println( "=============" );
            System.out.println( passengers[economyRow][economySeatCol] );
            countSalesEconomy++;
            economySales += 100;
            System.out.println();
            System.out.println();
        }
    }

    private static void firstClass() {
        int firstRow;
        String firstSeat ;
        int firstSeatCol;

        do {
            PrintRowHeader("premium first class", "1 TO 10");
            System.out.print( "#" );
            firstRow = in.nextInt();
            in.nextLine();
            firstRow--;
            if (firstRow >= 10) {
                inputWrong();
            }
        } while (firstRow >= 10);


        do {
            PrintSeatHeader("C|D E|F");
            System.out.print( "#" );
            firstSeat = in.nextLine();
            if (!firstSeat.matches( "A|B|C|D|E|F|G|H" )) {
                inputWrong();
            }
        } while (!firstSeat.matches( "A|B|C|D|E|F|G|H" ));

        //Assigns the letter typed into it's correspondent number variable
        firstSeatCol = fromLetterToNumber( firstSeat );

        //Print if seat is taken
        if (plane[firstRow][firstSeatCol]) {
           seatTaken();
            //Else Book seat
        } else {
            plane[firstRow][firstSeatCol] = true;
            passengers[firstRow][firstSeatCol] = lastName + ", " + name + ". Passport Number: " + passport + ", Reservation Number: " + countSalesFirstClass + ", located in first class: Seat " + firstSeat + " in row " + (firstRow + 1) + ".";
            System.out.println( "BOARDING PASS" );
            System.out.println( passengers[firstRow][firstSeatCol] );
            countSalesFirstClass++;
            firstClassSales += 300;
            System.out.println();
            System.out.println();
        }
    }
    private static void findConsecutive(int startingPoint, int endingPoint, String theClass) {
        counterSeatsAB = 0;
        counterSeatsCD = 0;
        counterSeatsEF = 0;
        counterSeatsCDEF = 0;
        counterSeatsGH = 0;

        for (int x = startingPoint; x < endingPoint; x++) {
            if (plane[x][0] && plane[x][1]) {
                counterSeatsAB++;
            }

            if (theClass.equals( "economy" )) {
                if (plane[x][2] && plane[x][3] && plane[x][4] && plane[x][5]) {
                    counterSeatsCDEF++;
                }
            } else {
                if (plane[x][2] && plane[x][3]) {
                    counterSeatsCD++;
                }

                if (plane[x][4] && plane[x][5]) {
                    counterSeatsEF++;
                }
            }

            if (plane[x][6] && plane[x][7]) {
                counterSeatsGH++;
            }
        }

        if (theClass.equals( "economy" )) {
            if (counterSeatsAB > 0 && counterSeatsAB > counterSeatsCDEF && counterSeatsAB > counterSeatsGH) {

                System.out.println( "===============================================" );
                System.out.println( "Seats A|B were the most booked seats in economy" );
                System.out.println( "===============================================" );

            } else if (counterSeatsCDEF > 0 && counterSeatsCDEF > counterSeatsAB && counterSeatsCDEF > counterSeatsGH) {

                System.out.println( "===================================================" );
                System.out.println( "Seats C|D|E|F were the most booked seats in economy" );
                System.out.println( "===================================================" );

            } else if (counterSeatsGH > 0 && counterSeatsGH > counterSeatsAB && counterSeatsGH > counterSeatsCDEF) {

                System.out.println( "===============================================" );
                System.out.println( "Seats G|H were the most booked seats in economy" );
                System.out.println( "===============================================" );

            } else {

                System.out.println( "============================================" );
                System.out.println( "No pair of seats in economy are reserved yet" );
                System.out.println( "============================================" );

            }
        } else {
            if (counterSeatsAB > 0 && counterSeatsAB > counterSeatsCD && counterSeatsAB > counterSeatsEF && counterSeatsAB > counterSeatsGH) {

                System.out.println( "===================================================" );
                System.out.println( "Seats A|B were the most booked seats in first class" );
                System.out.println( "===================================================" );

            } else if (counterSeatsCD > 0 && counterSeatsCD > counterSeatsAB && counterSeatsCD > counterSeatsEF && counterSeatsCD > counterSeatsGH) {

                System.out.println( "===================================================" );
                System.out.println( "Seats C|D|E|F were the most booked seats in first class" );
                System.out.println( "===================================================" );

            } else if (counterSeatsGH > 0 && counterSeatsGH > counterSeatsAB && counterSeatsGH > counterSeatsCD && counterSeatsGH > counterSeatsEF) {

                System.out.println( "===================================================" );
                System.out.println( "Seats G|H were the most booked seats in first class" );
                System.out.println( "===================================================" );

            } else {

                System.out.println( "================================================" );
                System.out.println( "No pair of seats in first class are reserved yet" );
                System.out.println( "================================================" );

            }
        }
        System.out.println(  );
    }
}
