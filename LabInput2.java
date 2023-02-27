/*
 * Write a program that inputs a three-digit value into variable num
 * and then display each digit with the correspobding place value. A
 * sample output is given below. Use LabInput2 as classname and filename 
 * 
 * Test output:
 * Please enter a three-digit integer: 487
 * The value of num = 487
 * 4 hundreds 8 tens and 7 ones
 */
import java.util.Scanner;

public class LabInput2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num, hundreds, tens, ones;
    System.out.print("Please enter a three-digit integer: ");
    num = input.nextInt();
    hundreds = num / 100;
    tens = (num % 100) / 10;
    ones = (num % 100) % 10;
    System.out.println("The value of num = " + num);
    System.out.println(hundreds + " hundreds " + tens + " tens and " + ones + " ones");
  }
}