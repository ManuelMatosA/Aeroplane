package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Arrays
        boolean[][] plane = new boolean[34][8];
        String[][] passengers = new String[34][8];

        //Variables
        String inputControl;
        String breakPassenger;
        String name = "A";
        String lastName = "A";
        String passport = "A";
        String ticket;
        int firstRow;
        String firstSeat;
        int firstSeatCol = 0;
        int counterFirstClass = 1;
        String password = "A";
        String sentinel = "A";
        String passengerList;
        String showTotalSales;
        String passwordTemporal = "A";
        int totalSales;
        int firstClassSales = 0;
        int economySales = 0;
        int averageSales = 0;
        int countRow = 0;
        int countRowLine = 0;
        int countFirstClassRowLine = 0;
        int leastCountRowLine = 0;
        int leastFirstClassRowLine = 0;
        int mostRow = 0;
        int mostFirstClassRow = 0;
        int mostEconomyRow = 0;
        int leastRow = 0;
        int leastFirstClassRow = 0;
        int leastEconomyRow = 0;
        int countCol = 0;
        int countColLine = 0;
        int leastCountColLine = 0;
        int mostFirstClassCol = 0;
        int leastFirstClassCol = 0;
        int countFirstClassColLine = 0;
        int leastFirstClassColLine = 0;
        int countEconomyRowLine = 0;
        int leastEconomyRowLine = 0;
        int mostCol = 0;
        int leastCol = 0;
        String showMostLeast;
        int mostEconomyCol = 0;
        int leastEconomyCol = 0;
        int countEconomyColLine = 0;
        int leastEconomyColLine = 0;
        int counterPassword = 0;
        int countSalesFirstClass = 0;
        int countSalesEconomy = 0;
        int counterFirstClassSeatsAB = 0;
        int counterFirstClassSeatsCD = 0;
        int counterFirstClassSeatsEF = 0;
        int counterFirstClassSeatsGH = 0;
        int counterEconomySeatsAB = 0;
        int counterEconomySeatsCDEF = 0;
        int counterEconomySeatsGH = 0;
        boolean NoSeatsOccupied = false;
        String showSeat;
        boolean firstClassFull = false;
        boolean economyClassFull = false;
        String elseFirstClass;
        int economyRow;
        int economySeatCol = 50;
        String economySeat;
        String elseEconomyClass;



        //Constants
        final int SEATS_FIRST_CLASS = 80;
        final int SEATS_ECONOMY = 192;
        final int PLANE_ARRAY_COLUMN_NUMBER = 8;
        final int FIRST_CLASS_NUMBER_OF_SEATS = 10;


        //Fields
        Scanner in = new Scanner( System.in );

        for (int x = 0; x < passengers.length; x++) {
            for (int y = 0; y < passengers[x].length; y++) {
                passengers[x][y] = " ";
            }
        }

        do {
            //Greeting
            System.out.println( "Welcome to the Aero Ticket 2000" );
            System.out.println( "================================" );
            System.out.println();

            System.out.println( "################################################################################################" );
            System.out.println( "This system is designed to book plane tickets as a passenger, and manage sales as a staff member");
            System.out.println( "################################################################################################" );
            System.out.println();

            System.out.println( "=======================================================================" );
            System.out.println( "Do you want to reserve a seat in our plane? Or are you a staff member?|\nType \"passenger\" if you're a PASSENGER                                |\nand \"staff\" for STAFF.                                                |" );
            System.out.println( "=======================================================================" );
            System.out.println();
            System.out.print( "#" );
            inputControl = in.nextLine();

            switch (inputControl) {
                case "passenger":

                    System.out.println( "Welcome to North West Airlines automated reservation system!" );
                    System.out.println( "============================================================" );
                    System.out.println();
                    System.out.println( "****************************************************");
                    System.out.println( "*                 Tickets are:                     *");
                    System.out.println( "*               100£ for economy                   *");
                    System.out.println( "*             300£ for first class                 *");
                    System.out.println( "*   Would you like to book in our next flight?     *");
                    System.out.println( "* Enter YES to continue or something else to exit. *");
                    System.out.println( "****************************************************");
                    System.out.println();
                    System.out.print( "#" );
                    breakPassenger = in.nextLine();


                    if (!breakPassenger.equalsIgnoreCase( "Yes" )) {
                        System.out.println();
                        System.out.println();
                        System.out.println( "The program is now exiting to the main menu!!!" );
                        System.out.println( "==============================================" );
                        System.out.println();
                        System.out.println();
                        break;
                    }

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
                            System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                            System.out.println( "You have not entered a correct input" );
                            System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                        }
                    }

                    System.out.println(  );
                    System.out.println( "Which class would you like to buy?" );
                    System.out.println( "==================================" );
                    System.out.print( "#" );
                    ticket = in.nextLine();

                    switch (ticket) {
                        case "first class":

                            for (int x = 0; x < FIRST_CLASS_NUMBER_OF_SEATS; x++) {
                                for (int y = 0; y < plane[x].length; y++) {
                                    if (!plane[x][y]) {
                                        break;
                                    } else {
                                        firstClassFull = true;
                                    }
                                }
                            }

                            if (firstClassFull && !economyClassFull) {
                                System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                System.out.println( "First class is currently full." );
                                System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );

                                System.out.println( "Would you like to book in economy?" );
                                System.out.println( "==================================" );
                                System.out.print( "#" );
                                elseFirstClass = in.nextLine();

                                if (!elseFirstClass.equalsIgnoreCase( "Yes" )) {
                                    System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                    System.out.println( "Next flight leaves in 3 hours." );
                                    System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                    System.out.println();
                                    System.out.println();
                                    System.out.println( "The program is now exiting to the main menu!!!" );
                                    System.out.println( "==============================================" );
                                    System.out.println();
                                    System.out.println();
                                    break;
                                } else {
                                    do {
                                        System.out.println( "****************************************************" );
                                        System.out.println( "*         Which row would you like to book?        *" );
                                        System.out.println( "*             We offer seats from row:             *" );
                                        System.out.println( "*                   11 TO 34                       *" );
                                        System.out.println( "*            For our economy passengers.           *" );
                                        System.out.println( "****************************************************" );
                                        System.out.print( "#" );
                                        economyRow = in.nextInt();
                                        economyRow--;
                                        if (economyRow < 11) {
                                            System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                            System.out.println( "You have not entered a correct input" );
                                            System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                        }
                                    } while (economyRow < 11);

                                    do {
                                    System.out.println( "****************************************************" );
                                    System.out.println( "*        Which seat would you like to book?        *" );
                                    System.out.println( "*  We offer seats in the following configuration:  *" );
                                    System.out.println( "*               A|B C|D|E|F G|H                    *" );
                                    System.out.println( "*  Please, input the letter of your desired seat.  *" );
                                    System.out.println( "****************************************************" );
                                    System.out.print( "#" );
                                    economySeat = in.nextLine();
                                        if (!economySeat.equalsIgnoreCase( "A" ) || !economySeat.equalsIgnoreCase( "B" ) || !economySeat.equalsIgnoreCase( "C" ) || !economySeat.equalsIgnoreCase( "D" ) || !economySeat.equalsIgnoreCase( "E" ) || !economySeat.equalsIgnoreCase( "F" ) || !economySeat.equalsIgnoreCase( "G" ) || !economySeat.equalsIgnoreCase( "H" )) {
                                            System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                            System.out.println( "You have not entered a correct input" );
                                            System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                        }
                                    } while (economySeat.equalsIgnoreCase( "A" ) || economySeat.equalsIgnoreCase( "B" ) || economySeat.equalsIgnoreCase( "C" ) || economySeat.equalsIgnoreCase( "D" ) || economySeat.equalsIgnoreCase( "E" ) || economySeat.equalsIgnoreCase( "F" ) || economySeat.equalsIgnoreCase( "G" ) || economySeat.equalsIgnoreCase( "H" ));


                                    if (economySeat.equalsIgnoreCase( "A" ))
                                        economySeatCol = 0;

                                    if (economySeat.equalsIgnoreCase( "B" ))
                                        economySeatCol = 1;

                                    if (economySeat.equalsIgnoreCase( "C" ))
                                        economySeatCol = 2;

                                    if (economySeat.equalsIgnoreCase( "D" ))
                                        economySeatCol = 3;

                                    if (economySeat.equalsIgnoreCase( "E" ))
                                        economySeatCol = 4;

                                    if (economySeat.equalsIgnoreCase( "F" ))
                                        economySeatCol = 5;

                                    if (economySeat.equalsIgnoreCase( "G" ))
                                        economySeatCol = 6;

                                    if (economySeat.equalsIgnoreCase( "H" ))
                                        economySeatCol = 7;

                                    if (plane[economyRow][economySeatCol]) {
                                        System.out.println( "~~~~~~~~~~~~~~~~~~" );
                                        System.out.println( "Seat already taken" );
                                        System.out.println( "~~~~~~~~~~~~~~~~~~" );
                                    } else {
                                        plane[economyRow][economySeatCol] = true;
                                        passengers[economyRow][economySeatCol] = lastName + ", " + name + ". Passport Number: " + passport + ", Reservation Number: " + counterFirstClass + ", located in first class: Seat " + economySeat + " in row " + economyRow + ".";
                                        System.out.println( "BOARDING PASS" );
                                        System.out.println( "=============" );
                                        System.out.println( passengers[economyRow][economySeatCol] );
                                        countSalesEconomy++;
                                    }
                                    break;
                                }
                            }
                            if (firstClassFull && economyClassFull) {
                                System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                System.out.println( "Next flight leaves in 3 hours." );
                                System.out.println( "------------------------------" );
                                System.out.println( "      No seats available.     " );
                                System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                System.out.println();
                                System.out.println();
                                System.out.println( "The program is now exiting to the main menu!!!" );
                                System.out.println( "==============================================" );
                                System.out.println();
                                System.out.println();
                                break;
                            }

                            do {
                                System.out.println( "****************************************************" );
                                System.out.println( "*         Which row would you like to book?        *" );
                                System.out.println( "*             We offer seats from row:             *" );
                                System.out.println( "*                    1 TO 10                       *" );
                                System.out.println( "*      For our premium First Class passengers.     *" );
                                System.out.println( "****************************************************" );
                                System.out.print( "#" );
                                firstRow = in.nextInt();
                                firstRow--;
                                if (firstRow >= 10) {
                                    System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                    System.out.println( "You have not entered a correct input" );
                                    System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                }
                            } while (firstRow >= 10);


                            do {
                                System.out.println( "****************************************************" );
                                System.out.println( "*        Which seat would you like to book?        *" );
                                System.out.println( "*  We offer seats in the following configuration:  *" );
                                System.out.println( "*              A|B C|D E|F G|H                     *" );
                                System.out.println( "*  Please, input the letter of your desired seat.  *" );
                                System.out.println( "****************************************************" );
                                System.out.print( "#" );
                                firstSeat = in.nextLine();
                                if (!economySeat.equalsIgnoreCase( "A" ) || !economySeat.equalsIgnoreCase( "B" ) || !economySeat.equalsIgnoreCase( "C" ) || !economySeat.equalsIgnoreCase( "D" ) || !economySeat.equalsIgnoreCase( "E" ) || !economySeat.equalsIgnoreCase( "F" ) || !economySeat.equalsIgnoreCase( "G" ) || !economySeat.equalsIgnoreCase( "H" )) {
                                    System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                    System.out.println( "You have not entered a correct input" );
                                    System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                }
                            } while (economySeat.equalsIgnoreCase( "A" ) || economySeat.equalsIgnoreCase( "B" ) || economySeat.equalsIgnoreCase( "C" ) || economySeat.equalsIgnoreCase( "D" ) || economySeat.equalsIgnoreCase( "E" ) || economySeat.equalsIgnoreCase( "F" ) || economySeat.equalsIgnoreCase( "G" ) || economySeat.equalsIgnoreCase( "H" ));


                            if (firstSeat.equalsIgnoreCase( "A" ))
                                firstSeatCol = 0;

                            if (firstSeat.equalsIgnoreCase( "B" ))
                                firstSeatCol = 1;

                            if (firstSeat.equalsIgnoreCase( "C" ))
                                firstSeatCol = 2;

                            if (firstSeat.equalsIgnoreCase( "D" ))
                                firstSeatCol = 3;

                            if (firstSeat.equalsIgnoreCase( "E" ))
                                firstSeatCol = 4;

                            if (firstSeat.equalsIgnoreCase( "F" ))
                                firstSeatCol = 5;

                            if (firstSeat.equalsIgnoreCase( "G" ))
                                firstSeatCol = 6;

                            if (firstSeat.equalsIgnoreCase( "H" ))
                                firstSeatCol = 7;


                            if (plane[firstRow][firstSeatCol]) {
                                System.out.println( "~~~~~~~~~~~~~~~~~~" );
                                System.out.println( "Seat already taken" );
                                System.out.println( "~~~~~~~~~~~~~~~~~~" );
                            } else {
                                plane[firstRow][firstSeatCol] = true;
                                passengers[firstRow][firstSeatCol] = lastName + ", " + name + ". Passport Number: " + passport + ", Reservation Number: " + counterFirstClass + ", located in first class: Seat " + firstSeat + " in row " + firstRow + ".";
                                System.out.println( "BOARDING PASS" );
                                System.out.println( passengers[firstRow][firstSeatCol] );
                                countSalesFirstClass++;
                            }
                            break;

                        case "economy":

                            for (int x = FIRST_CLASS_NUMBER_OF_SEATS; x < plane.length; x++) {
                                for (int y = 0; y < plane[x].length; y++) {
                                    if (!plane[x][y]) {
                                        break;
                                    } else {
                                        economyClassFull = true;
                                    }
                                }
                            }

                            if (firstClassFull && !economyClassFull) {
                                System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                System.out.println( "Economy is currently full." );
                                System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~" );

                                System.out.println( "Would you like to book in first class?" );
                                System.out.println( "======================================" );
                                System.out.print( "#" );
                                elseEconomyClass = in.nextLine();

                                if (!elseEconomyClass.equalsIgnoreCase( "Yes" )) {
                                    System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                    System.out.println( "Next flight leaves in 3 hours." );
                                    System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                    System.out.println();
                                    System.out.println();
                                    System.out.println( "The program is now exiting to the main menu!!!" );
                                    System.out.println( "==============================================" );
                                    System.out.println();
                                    System.out.println();
                                    break;
                                } else {
                                    do {
                                        System.out.println( "****************************************************" );
                                        System.out.println( "*         Which row would you like to book?        *" );
                                        System.out.println( "*             We offer seats from row:             *" );
                                        System.out.println( "*                    1 TO 10                       *" );
                                        System.out.println( "*      For our premium First Class passengers.     *" );
                                        System.out.println( "****************************************************" );
                                        System.out.print( "#" );
                                        firstRow = in.nextInt();
                                        firstRow--;
                                        if (firstRow >= 10) {
                                            System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                            System.out.println( "You have not entered a correct input" );
                                            System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                        }
                                    } while (firstRow >= 10);


                                    do {
                                        System.out.println( "****************************************************" );
                                        System.out.println( "*        Which seat would you like to book?        *" );
                                        System.out.println( "*  We offer seats in the following configuration:  *" );
                                        System.out.println( "*              A|B C|D E|F G|H                     *" );
                                        System.out.println( "*  Please, input the letter of your desired seat.  *" );
                                        System.out.println( "****************************************************" );
                                        System.out.print( "#" );
                                        firstSeat = in.nextLine();
                                        if (!firstSeat.equalsIgnoreCase( "A" ) || !firstSeat.equalsIgnoreCase( "B" ) || !firstSeat.equalsIgnoreCase( "C" ) || !firstSeat.equalsIgnoreCase( "D" ) || !firstSeat.equalsIgnoreCase( "E" ) || !firstSeat.equalsIgnoreCase( "F" ) || !firstSeat.equalsIgnoreCase( "G" ) || !firstSeat.equalsIgnoreCase( "H" )) {
                                            System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                            System.out.println( "You have not entered a correct input" );
                                            System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                        }
                                    } while (firstSeat.equalsIgnoreCase( "A" ) || firstSeat.equalsIgnoreCase( "B" ) || firstSeat.equalsIgnoreCase( "C" ) || firstSeat.equalsIgnoreCase( "D" ) || firstSeat.equalsIgnoreCase( "E" ) || firstSeat.equalsIgnoreCase( "F" ) || firstSeat.equalsIgnoreCase( "G" ) || firstSeat.equalsIgnoreCase( "H" ));

                                    if (firstSeat.equalsIgnoreCase( "A" )) {
                                        firstSeatCol = 0;
                                    } else if (firstSeat.equalsIgnoreCase( "B" )) {
                                        firstSeatCol = 1;
                                    } else if (firstSeat.equalsIgnoreCase( "C" )) {
                                        firstSeatCol = 2;
                                    } else if (firstSeat.equalsIgnoreCase( "D" )) {
                                        firstSeatCol = 3;
                                    } else if (firstSeat.equalsIgnoreCase( "E" )) {
                                        firstSeatCol = 4;
                                    } else if (firstSeat.equalsIgnoreCase( "F" )) {
                                        firstSeatCol = 5;
                                    } else if (firstSeat.equalsIgnoreCase( "G" )) {
                                        firstSeatCol = 6;
                                    } else if (firstSeat.equalsIgnoreCase( "H" )) {
                                        firstSeatCol = 7;
                                    }

                                    if (plane[firstRow][firstSeatCol]) {
                                        System.out.println( "~~~~~~~~~~~~~~~~~~" );
                                        System.out.println( "Seat already taken" );
                                        System.out.println( "~~~~~~~~~~~~~~~~~~" );
                                    } else {
                                        plane[firstRow][firstSeatCol] = true;
                                        passengers[firstRow][firstSeatCol] = lastName + ", " + name + ". Passport Number: " + passport + ", Reservation Number: " + counterFirstClass + ", located in first class: Seat " + firstSeat + " in row " + firstRow + ".";
                                        System.out.println( "BOARDING PASS" );
                                        System.out.println( passengers[firstRow][firstSeatCol] );
                                        countSalesFirstClass++;
                                    }
                                    break;
                                }
                            }
                            if (firstClassFull && economyClassFull) {
                                System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                System.out.println( "Next flight leaves in 3 hours." );
                                System.out.println( "------------------------------" );
                                System.out.println( "      No seats available.     " );
                                System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                System.out.println();
                                System.out.println();
                                System.out.println( "The program is now exiting to the main menu!!!" );
                                System.out.println( "==============================================" );
                                System.out.println();
                                System.out.println();
                                break;
                            }

                            do {
                                System.out.println( "****************************************************" );
                                System.out.println( "*         Which row would you like to book?        *" );
                                System.out.println( "*             We offer seats from row:             *" );
                                System.out.println( "*                   11 TO 34                       *" );
                                System.out.println( "*            For our economy passengers.           *" );
                                System.out.println( "****************************************************" );
                                System.out.print( "#" );
                                economyRow = in.nextInt();
                                economyRow--;
                                if (economyRow < 11) {
                                    System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                    System.out.println( "You have not entered a correct input" );
                                    System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                }
                            } while (economyRow < 11);


                            do {
                                System.out.println( "****************************************************" );
                                System.out.println( "*        Which seat would you like to book?        *" );
                                System.out.println( "*  We offer seats in the following configuration:  *" );
                                System.out.println( "*               A|B C|D|E|F G|H                    *" );
                                System.out.println( "*  Please, input the letter of your desired seat.  *" );
                                System.out.println( "****************************************************" );
                                System.out.print( "#" );
                                economySeat = in.nextLine();
                                if (!economySeat.equalsIgnoreCase( "A" ) || !economySeat.equalsIgnoreCase( "B" ) || !economySeat.equalsIgnoreCase( "C" ) || !economySeat.equalsIgnoreCase( "D" ) || !economySeat.equalsIgnoreCase( "E" ) || !economySeat.equalsIgnoreCase( "F" ) || !economySeat.equalsIgnoreCase( "G" ) || !economySeat.equalsIgnoreCase( "H" )) {
                                    System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                    System.out.println( "You have not entered a correct input" );
                                    System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                }
                            } while (economySeat.equalsIgnoreCase( "A" ) || economySeat.equalsIgnoreCase( "B" ) || economySeat.equalsIgnoreCase( "C" ) || economySeat.equalsIgnoreCase( "D" ) || economySeat.equalsIgnoreCase( "E" ) || economySeat.equalsIgnoreCase( "F" ) || economySeat.equalsIgnoreCase( "G" ) || economySeat.equalsIgnoreCase( "H" ));

                            if (economySeat.equalsIgnoreCase( "A" )) {
                                economySeatCol = 0;
                            }
                            if (economySeat.equalsIgnoreCase( "B" )) {
                                economySeatCol = 1;
                            }
                            if (economySeat.equalsIgnoreCase( "C" )) {
                                economySeatCol = 2;
                            }
                            if (economySeat.equalsIgnoreCase( "D" )) {
                                economySeatCol = 3;
                            }
                            if (economySeat.equalsIgnoreCase( "E" )) {
                                economySeatCol = 4;
                            }
                            if (economySeat.equalsIgnoreCase( "F" )) {
                                economySeatCol = 5;
                            }
                            if (economySeat.equalsIgnoreCase( "G" )) {
                                economySeatCol = 6;
                            }
                            if (economySeat.equalsIgnoreCase( "H" )) {
                                economySeatCol = 7;
                            }

                            if (plane[economyRow][economySeatCol]) {
                                System.out.println( "~~~~~~~~~~~~~~~~~~" );
                                System.out.println( "Seat already taken" );
                                System.out.println( "~~~~~~~~~~~~~~~~~~" );
                            } else {
                                plane[economyRow][economySeatCol] = true;
                                passengers[economyRow][economySeatCol] = lastName + ", " + name + ". Passport Number: " + passport + ", Reservation Number: " + counterFirstClass + ", located in first class: Seat " + economySeat + " in row " + economyRow + ".";
                                System.out.println( "BOARDING PASS" );
                                System.out.println( "=============" );
                                System.out.println( passengers[economyRow][economySeatCol] );
                                countSalesEconomy++;
                            }
                            break;
                    }

                        case "staff":

                            if (counterPassword == 0) {
                                while (!passwordTemporal.matches( "\\d{4}" )) {
                                    System.out.println( "Welcome! Please create a 4 digit staff password." );
                                    System.out.println( "================================================" );
                                    System.out.print( "#" );
                                    passwordTemporal = in.nextLine();
                                    System.out.println();
                                    if (!passwordTemporal.matches( "\\d{4}" )) {
                                        System.out.println( "~~~~~~~~~~~~~~~~~~~" );
                                        System.out.println( "INVALID PASSWORD!!!" );
                                        System.out.println( "~~~~~~~~~~~~~~~~~~~" );
                                        System.out.println();
                                    }
                                }
                            }
                            counterPassword++;

                            if (counterPassword > 0) {
                                while (!password.equals( passwordTemporal )) {
                                    System.out.println( "Please, enter your staff password." );
                                    System.out.println( "==================================" );
                                    System.out.print( "#" );
                                    password = in.nextLine();
                                    if (!password.equals( passwordTemporal )) {
                                        System.out.println( "~~~~~~~~~~~~~~~~~" );
                                        System.out.println( "WRONG PASSWORD!!!" );
                                        System.out.println( "~~~~~~~~~~~~~~~~~" );
                                        System.out.println();
                                    }
                                }
                            }

                            password = "B";

                            System.out.println();
                            System.out.println( "################################################################################################################" );
                            System.out.println( "Do you want to stop selling tickets? If so type \"Exit Program\", type something else if you don't want to quit." );
                            System.out.println( "################################################################################################################" );
                            System.out.print( "#" );
                            sentinel = in.nextLine();
                            System.out.println();

                            if (counterPassword == 1) {
                                System.out.println( "##############################################################################################################################" );
                                System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~HOW TO USE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                System.out.println( "Type Yes if you want to perform the prompted action.        Or something else if you don't want to perform the prompted action." );
                                System.out.println( "##############################################################################################################################" );
                                System.out.println();
                            }

                            System.out.println( "=================================================" );
                            System.out.println( "Do you want to see all of the current passengers?" );
                            System.out.println( "=================================================" );
                            System.out.print( "#" );
                            passengerList = in.nextLine();
                            System.out.println();

                            if (passengerList.equalsIgnoreCase( "Yes" )) {
                                for (String[] passenger : passengers) {
                                    for (int col = 0; col < passengers[0].length; col++) {
                                        if (!passenger[col].equals( " " )) {
                                            System.out.println( passenger[col] );
                                        }


                                    }
                                }
                                for (String[] passenger : passengers) {
                                    for (int col = 0; col < passengers[0].length; col++) {
                                        if (passenger[col].equals( " " )) {
                                            NoSeatsOccupied = true;
                                        }
                                    }
                                }

                                if (NoSeatsOccupied) {
                                    System.out.println( "~~~~~~~~~~~~~~" );
                                    System.out.println( "Plane isn't full" );
                                    System.out.println( "~~~~~~~~~~~~~~" );
                                    System.out.println();
                                }
                            }

                            System.out.println( "======================================================" );
                            System.out.println( "Do you want to see the total AND the average of sales?" );
                            System.out.println( "======================================================" );
                            System.out.print( "#" );
                            showTotalSales = in.nextLine();
                            System.out.println();

                            if (showTotalSales.equalsIgnoreCase( "Yes" )) {
                                totalSales = firstClassSales + economySales;
                                if (countSalesFirstClass > 0 && countSalesEconomy > 0) {
                                    averageSales = (countSalesFirstClass + countSalesEconomy) / (SEATS_FIRST_CLASS + SEATS_ECONOMY);
                                }
                                System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                System.out.println( "Total sales made in this flight so far: " + totalSales + "£." );
                                System.out.println( "-----------------------------------------------------------" );
                                System.out.println( "Average of seats sold: " + averageSales + "%." );
                                System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                                System.out.println();
                            }

                            System.out.println( "==========================================================" );
                            System.out.println( "Do you want to see the most and least sold rows and seats?" );
                            System.out.println( "==========================================================" );
                            System.out.print( "#" );
                            showMostLeast = in.nextLine();
                            System.out.println();

                            if (showMostLeast.equalsIgnoreCase( "Yes" )) {
                                for (int row = 0; row < plane.length; row++) {
                                    for (int col = 0; col < plane[row].length; col++) {
                                        if (plane[row][col]) {
                                            countRow++;
                                            if (countRow == 0) {
                                                mostRow = countRow;
                                                leastRow = countRow;
                                                countRowLine = row;
                                                leastCountRowLine = row;
                                            } else {
                                                if (countRow > mostRow) {
                                                    mostRow = countRow;
                                                    countRowLine = row;
                                                }

                                                if (countRow < leastRow) {
                                                    leastRow = countRow;
                                                    leastCountRowLine = row;
                                                }
                                            }
                                        }
                                    }
                                }

                                System.out.println( "=====================================================================================================" );
                                System.out.println( "The row with the most passengers is row " + countRowLine + " with " + mostRow + " passengers" );
                                System.out.println( "-----------------------------------------------------------------------------------------------------" );
                                System.out.println( "The row with the least passengers is row " + leastCountRowLine + " with " + leastRow + " passengers" );
                                System.out.println( "=====================================================================================================" );
                                int col = 0;
                                while (col < PLANE_ARRAY_COLUMN_NUMBER) {
                                    for (boolean[] booleans : plane) {
                                        if (booleans[col]) {
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

                                System.out.println( "The column of seats with the most passengers is row " + countColLine + " with " + mostCol + " passengers" );
                                System.out.println( "-----------------------------------------------------------------------------------------------------" );
                                System.out.println( "The column of seats with the least passengers is row " + leastCountColLine + " with " + leastCol + " passengers" );
                                System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~FIRST CLASS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );

                                countRow = 0;
                                for (int row = 0; row < FIRST_CLASS_NUMBER_OF_SEATS; row++) {
                                    for (int col1 = 0; col1 < plane[row].length; col1++) {
                                        if (plane[row][col1]) {
                                            countRow++;
                                            if (countRow == 0) {
                                                mostFirstClassRow = countRow;
                                                leastFirstClassRow = countRow;
                                                countFirstClassRowLine = row;
                                                leastFirstClassRowLine = row;
                                            } else {
                                                if (countRow > mostFirstClassRow) {
                                                    mostFirstClassRow = countRow;
                                                    countFirstClassRowLine = row;
                                                }

                                                if (countRow < leastFirstClassRow) {
                                                    leastFirstClassRow = countRow;
                                                    leastFirstClassRowLine = row;
                                                }
                                            }
                                        }
                                    }
                                }
                                System.out.println( "The row with the most passengers in first class is row " + countFirstClassRowLine + " with " + mostFirstClassRow + " passengers" );
                                System.out.println( "-----------------------------------------------------------------------------------------------------" );
                                System.out.println( "The row with the least passengers in first class is row " + leastFirstClassRowLine + " with " + leastFirstClassRow + " passengers" );
                                System.out.println( "=====================================================================================================" );

                                int col1 = 0;
                                countCol = 0;
                                while (col1 < PLANE_ARRAY_COLUMN_NUMBER) {
                                    for (int row = 0; row < 10; row++) {
                                        if (plane[row][col1]) {
                                            countCol++;
                                            if (countCol == 0) {
                                                mostFirstClassCol = countCol;
                                                leastFirstClassCol = countCol;
                                                countFirstClassColLine = col1;
                                                leastFirstClassColLine = col1;

                                            } else {
                                                if (countCol > mostFirstClassCol) {
                                                    mostFirstClassCol = countCol;
                                                    countFirstClassColLine = col1;
                                                }

                                                if (countCol < leastFirstClassCol) {
                                                    leastFirstClassCol = countCol;
                                                    leastFirstClassColLine = col1;
                                                }
                                            }
                                        }
                                    }
                                    col1++;
                                }
                                System.out.println( "The column of seats with the most passengers in first class is row " + countFirstClassColLine + " with " + mostFirstClassCol + " passengers" );
                                System.out.println( "-----------------------------------------------------------------------------------------------------" );
                                System.out.println( "The column of seats with the least passengers in first class is row " + leastFirstClassColLine + " with " + leastFirstClassCol + " passengers" );
                                System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ECONOMY~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );

                                countRow = 0;
                                for (int row = FIRST_CLASS_NUMBER_OF_SEATS; row < plane.length; row++) {
                                    for (int col2 = 0; col2 < plane[row].length; col2++) {
                                        if (plane[row][col2]) {
                                            countRow++;
                                            if (countRow == 0) {
                                                mostEconomyRow = countRow;
                                                leastEconomyRow = countRow;
                                                countEconomyRowLine = row;
                                                leastEconomyRowLine = row;
                                            } else {
                                                if (countRow > mostEconomyRow) {
                                                    mostEconomyRow = countRow;
                                                    countEconomyRowLine = row;
                                                }

                                                if (countRow < leastEconomyRow) {
                                                    leastEconomyRow = countRow;
                                                    leastEconomyRowLine = row;
                                                }
                                            }
                                        }
                                    }
                                }
                                System.out.println( "The row with the most passengers in economy is row " + countEconomyRowLine + " with " + mostEconomyRow + " passengers" );
                                System.out.println( "-----------------------------------------------------------------------------------------------------" );
                                System.out.println( "The row with the least passengers in economy is row " + leastEconomyRowLine + " with " + leastEconomyRow + " passengers" );
                                System.out.println( "=====================================================================================================" );

                                int col3 = 0;
                                countCol = 0;
                                while (col3 < PLANE_ARRAY_COLUMN_NUMBER) {
                                    for (int row = FIRST_CLASS_NUMBER_OF_SEATS; row < plane.length; row++) {
                                        if (plane[row][col3]) {
                                            countCol++;
                                            if (countCol == 0) {
                                                mostEconomyCol = countCol;
                                                leastEconomyCol = countCol;
                                                countEconomyColLine = col3;
                                                leastEconomyColLine = col3;
                                            } else {
                                                if (countCol > mostEconomyCol) {
                                                    mostFirstClassCol = countCol;
                                                    countFirstClassColLine = col3;
                                                }

                                                if (countCol < leastEconomyCol) {
                                                    leastFirstClassCol = countCol;
                                                    leastFirstClassColLine = col3;
                                                }
                                            }
                                        }
                                    }
                                    col3++;
                                }
                                System.out.println( "The column of seats with the most passengers in economy is row " + countEconomyColLine + " with " + mostEconomyCol + " passengers" );
                                System.out.println( "-----------------------------------------------------------------------------------------------------" );
                                System.out.println( "The column of seats with the least passengers in economy is row " + leastEconomyColLine + " with " + leastEconomyCol + " passengers" );
                                System.out.println( "=====================================================================================================" );
                                System.out.println();
                            }

                            System.out.println( "=========================================" );
                            System.out.println( "Do you want to see the consecutive seats?" );
                            System.out.println( "=========================================" );
                            System.out.print( "#" );
                            showSeat = in.nextLine();
                            System.out.println();

                            if (showSeat.equalsIgnoreCase( "Yes" )) {
                                for (int x = 0; x < FIRST_CLASS_NUMBER_OF_SEATS; x++) {
                                    if (plane[x][0] && plane[x][1]) {
                                        counterFirstClassSeatsAB++;
                                    }

                                    if (plane[x][2] && plane[x][3]) {
                                        counterFirstClassSeatsCD++;
                                    }

                                    if (plane[x][4] && plane[x][5]) {
                                        counterFirstClassSeatsEF++;
                                    }

                                    if (plane[x][6] && plane[x][7]) {
                                        counterFirstClassSeatsGH++;
                                    }
                                }

                                if (counterFirstClassSeatsAB > 0 && counterFirstClassSeatsAB > counterFirstClassSeatsCD && counterFirstClassSeatsAB > counterFirstClassSeatsEF && counterFirstClassSeatsAB > counterFirstClassSeatsGH) {

                                    System.out.println( "===================================================" );
                                    System.out.println( "Seats A|B were the most booked seats in first class" );
                                    System.out.println( "===================================================" );

                                } else if (counterFirstClassSeatsCD > 0 && counterFirstClassSeatsCD > counterFirstClassSeatsAB && counterFirstClassSeatsCD > counterFirstClassSeatsEF && counterFirstClassSeatsCD > counterFirstClassSeatsGH) {

                                    System.out.println( "===================================================" );
                                    System.out.println( "Seats C|D|E|F were the most booked seats in first class" );
                                    System.out.println( "===================================================" );

                                } else if (counterFirstClassSeatsGH > 0 && counterFirstClassSeatsGH > counterFirstClassSeatsAB && counterFirstClassSeatsGH > counterFirstClassSeatsCD && counterFirstClassSeatsGH > counterFirstClassSeatsEF) {

                                    System.out.println( "===================================================" );
                                    System.out.println( "Seats G|H were the most booked seats in first class" );
                                    System.out.println( "===================================================" );

                                } else {

                                    System.out.println( "================================================" );
                                    System.out.println( "No pair of seats in first class are reserved yet" );
                                    System.out.println( "================================================" );

                                }

                                for (int x = FIRST_CLASS_NUMBER_OF_SEATS; x < plane.length; x++) {
                                    if (plane[x][0] && plane[x][1]) {
                                        counterEconomySeatsAB++;
                                    }

                                    if (plane[x][2] && plane[x][3] && plane[x][4] && plane[x][5]) {
                                        counterEconomySeatsCDEF++;
                                    }

                                    if (plane[x][6] && plane[x][7]) {
                                        counterEconomySeatsGH++;
                                    }
                                }

                                System.out.println();

                                if (counterEconomySeatsAB > 0 && counterEconomySeatsAB > counterEconomySeatsCDEF && counterEconomySeatsAB > counterEconomySeatsGH) {

                                    System.out.println( "===============================================" );
                                    System.out.println( "Seats A|B were the most booked seats in economy" );
                                    System.out.println( "===============================================" );

                                } else if (counterEconomySeatsCDEF > 0 && counterEconomySeatsCDEF > counterEconomySeatsAB && counterEconomySeatsCDEF > counterFirstClassSeatsGH) {

                                    System.out.println( "===================================================" );
                                    System.out.println( "Seats C|D|E|F were the most booked seats in economy" );
                                    System.out.println( "===================================================" );

                                } else if (counterEconomySeatsGH > 0 && counterEconomySeatsGH > counterEconomySeatsAB && counterFirstClassSeatsGH > counterEconomySeatsCDEF) {

                                    System.out.println( "===============================================" );
                                    System.out.println( "Seats G|H were the most booked seats in economy" );
                                    System.out.println( "===============================================" );

                                } else {

                                    System.out.println( "============================================" );
                                    System.out.println( "No pair of seats in economy are reserved yet" );
                                    System.out.println( "============================================" );

                                }
                            }


                            if (!sentinel.equalsIgnoreCase( "Exit Program" )) {
                                System.out.println();
                                System.out.println();
                                System.out.println( "The program is now exiting to the main menu!!!" );
                                System.out.println( "==============================================" );
                                System.out.println();
                                System.out.println();
                            }

                            break;
                        default:
                            System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                            System.out.println( "You have not entered a correct input" );
                            System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                            break;

            }
        } while (!sentinel.equalsIgnoreCase( "Exit Program" ));

        if (sentinel.equalsIgnoreCase("Exit Program")) {
            System.out.println();
            System.out.println("---------------------------------");
            System.out.println("Thank you for using our program! |");
            System.out.println("---------------------------------");
            System.out.println("Exiting...");
        }
    }
}
