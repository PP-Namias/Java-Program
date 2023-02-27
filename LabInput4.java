/*
 * Write a program to gauge the amount of inflation over the past year.
 * The program asks for the itme name (such as notebook or a printer),
 * price of an item both one yeaar ago and today. 
 * It estimates the inflation rate as the diffreence in price divided by the last year'sprice. 
 * Use LabInput4 as classname and filename
 * 
 * Test Output:
 * Please enter he name of the item: netbook
 * Enter its price last year: 15000
 * Enter its price this year: 13500
 * The inflation rate of notebook: -0.1
 * 
 * ------------------------------
 * Please enter he name of the item: chicken
 * Enter its price last year: 125
 * Enter its price this year: 150
 * The inflation rate of notebook: 0.2
 */
import java.util.Scanner;

public class LabInput4 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String itemName;
    double priceLastYear, priceThisYear, inflationRate;
    System.out.print("Please enter he name of the item: ");
    itemName = input.nextLine();
    System.out.print("Enter its price last year: ");
    priceLastYear = input.nextDouble();
    System.out.print("Enter its price this year: ");
    priceThisYear = input.nextDouble();
    inflationRate = (priceThisYear - priceLastYear) / priceLastYear;
    System.out.println("The inflation rate of " + itemName + ": " + inflationRate);
  }
}