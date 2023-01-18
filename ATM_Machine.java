/*
 * ATM_Machine
 * Copyright (c) 2023
 * 
 * Licensed under the MIT
 * 
 * Permission is hereby granted, free of charge
 * 
 */

// import a library we need for this code project
import java.util.*;

public class ATM_Machine {
    public static void main(String[] args){
        try (Scanner input = new Scanner(System.in)) {
            // Initializing Variable of Password and Balance
            int password = 123456;
            int balance = 50000;

            // Welcome message
            System.out.println("\t\tWelcome to the ATM Machine".toUpperCase());
            System.out.println("------------------------------------------");

            // Get the password of the user
            System.out.print("Enter your PIN Password: ");
            int pass = input.nextInt();
            System.out.println("------------------------------------------");

            // MAIN-ELSE STATEMENT STARTS HERE

            // The "IF" of "MAIN IF-ELSE STATEMENT"
            if(pass == password){
                // Main Page
                System.out.println("Good Day Mr. Jhon Keneth Namias");
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("------------------------------------------");

                // Get the function of the user to be process
                System.out.print("Enter a function: ");
                int choice = input.nextInt();

                // Switch Case for the function of the user chose above
                switch (choice) {
                    // Case 1 for Check Balance
                    case 1: {
                        System.out.print("\nYour Balance is " + balance + " Pesos");

                        /*
                         * The program will ask the user if he/she wants to withdraw after
                         * checking the balance *
                        */
                        System.out.print("\n\n\t\tDo you want to withdraw: ");
                        String x = input.next();

                        //  If-Else for the user if he/she wants to withdraw
                        if (x.startsWith("y") || x.startsWith("Y")) {

                            // get the amount that you want to withdraw in your back account
                            System.out.print("\nEnter amount: ");
                            int amount = input.nextInt();

                            /*
                             * create a new varible na kung ilan na lang ang
                             * matitira kapag nagwithdraw
                            */
                            int newBalance = balance - amount;

                            // Message to show after withdraw
                            System.out.print("\n\t\tWithdraw Succesfully!");
                            System.out.println("\n\nYour new balance is " + newBalance);
                            System.out.println("------------------------------------------");

                            // use "break" to stop the program after withdraw
                            break;
                        } else {
                            /*
                             * else if the user don't want to withdraw after
                             * checking the balance
                            */
                            System.out.print("\n\t\tThank you for checking!");
                            System.out.print("\n------------------------------------------");

                            // use "break" to stop the program after withdraw
                            break;
                        }
                    }
                    case 2: {
                        // get the amount that you want to withdraw in your back account
                        System.out.print("\nEnter amount: ");
                        int amount = input.nextInt();

                        /*
                         * create a new varible na kung ilan na lang ang
                         * matitira after withdraw
                        */
                        int newBalance = balance - amount;

                        // Message to show after withdraw
                        System.out.print("\n\t\tWithdraw Succesfully!");

                        // print the new balance of your account
                        System.out.println("\n\nYour new balance is " + newBalance);
                        System.out.println("------------------------------------------");

                        // use "break" to stop the program after withdraw
                        break;
                    }
                    case 3: {
                        /*
                         * Ask the user if how much he/she wants to
                         * add money in his/her account
                        */
                        System.out.print("\nEnter amount to be added in your account: ");
                        int deposit = input.nextInt();

                        /*
                         * create a new variable na kung ilan na ang balance
                         * kapag naidagdag na ang "deposit" sa "balance"
                        */
                        int newAm = balance + deposit;

                        // Message to show after deposit
                        System.out.println("\n\t\tDeposit Succesfully!");
                        System.out.println("\nYour new balance is " + newAm);
                        System.out.println("------------------------------------------");

                        // use "break" to stop the program after deposit
                        break;
                    }
                }
            // The "ELSE" from "MAIN IF-ELSE STATEMENT"
            }

            else{
                // If the password is wrong, the program will stop
                System.out.print("You entered a wrong password, try again");
            }
        }

    }
}