/**
 * LabInput4.java
 * Inflation Rate Calculator Activity #4
 * @author PP-Namias
 * Licensed under MIT License
 */
/** 
 * @param [input] the scanner for user input.
 * @param [itemName] the name of the item.
 * @param [priceLastYear] the price of the last year
 * @param [priceThisYear] the price of this year
 * @param [inflationRate] the inflation rate
 * @param [exit] the boolean to check if the program will exit.
 */
/*
 * Write a program to gauge the amount of inflation over the past year.
 * The program asks for the item name (such as notebook or a printer),
 * price of an item both one yeaar ago and today. 
 * It estimates the inflation rate as the diffreence in price divided by the last year's price. 
 * Use LabInput4 as classname and filename
 * 
 * Test Output:
 *    Please enter the name of the item: netbook
 *    Enter its price last year: 15000
 *    Enter its price this year: 13500
 *    The inflation rate of notebook: -0.1
 *  
 *    -----------------------------------------
 *    Please enter the name of the item: chicken
 *    Enter its price last year: 125
 *    Enter its price this year: 150
 *    The inflation rate of notebook: 0.2
 */
import java.util.Scanner;

public class LabInput4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String itemName;
        double priceLastYear, priceThisYear, inflationRate;
        boolean exit = false;
        while (!exit) {
            try {
                System.out.print("Please enter the name of the item or enter 'exit' to quit: ");
                itemName = input.nextLine();
                if (itemName.equalsIgnoreCase("exit")) {
                    System.out.print("Exiting the program! Thank you for using this program!");
                    exit = true;
                }
                else {
                    System.out.print("Enter its price last year: ");
                    priceLastYear = input.nextDouble();
                    System.out.print("Enter its price this year: ");
                    priceThisYear = input.nextDouble();
                    input.nextLine(); // consume the remaining newline character in the buffer
                    inflationRate = (priceThisYear - priceLastYear) / priceLastYear;
                    System.out.println("The inflation rate of " + itemName + ": " + inflationRate);
                    System.out.println("-----------------------------------------");
                    System.out.println("");
                }
            } catch (Exception e) {
                System.out.println("Please enter the correct input.");
            }
        }
    input.close();
    }
}