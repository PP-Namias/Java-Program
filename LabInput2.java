/**
 * LabInput2.java
 * Time Interpreter Activity #2
 * @author PP-Namias
 * Licensed under MIT License
 */
/** 
 * @param [input] the scanner for user input.
 * @param [num] the number that indicates the number of that needs to be interperted.
 * @param [hundreds] the number of hundreds.
 * @param [tens] the number of tens.
 * @param [ones] the number of ones.
 * @param [exit] the boolean to check if the program will exit.
 */
/*
 * Write a program that inputs a three-digit value into variable num
 * and then display each digit with the corresponding place value. A
 * sample output is given below. Use LabInput2 as classname and filename 
 * 
 * Test output:
 *    Please enter a three-digit integer: 487
 *    The value of num = 487
 *    4 hundreds 8 tens and 7 ones
 */
import java.util.Scanner;

public class LabInput2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num, hundreds, tens, ones;
    boolean exit = false;

    while (!exit) {
      try {
        System.out.print("Please enter a three-digit integer or enter '0' to quit: ");
        num = input.nextInt();
        if (num == 0) {
          System.out.print("Exiting the program! Thank you for using this program!");
          exit = true;
        }
        else {
          hundreds = num / 100;
          tens = (num % 100) / 10;
          ones = (num % 100) % 10;
          System.out.println("The value of num = " + num);
          System.out.println(hundreds + " hundreds " + tens + " tens and " + ones + " ones");
        }
      } catch (Exception e) {
        System.out.println("Please enter the correct input.");
      }
    }
  input.close();
  }
}