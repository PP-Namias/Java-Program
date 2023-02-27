/**
 * Seconds Converter Activity #1
 * @author PP-Namias
 * Licensed under MIT License
 */

/*
 * Write a program that accepts input to varible seconds.
 * The program will then output the equivalent time in hours:minutes:seconds format.
 * use labInput1 as classname and filename.
 * 
 * Test ouput:
 * Please enter number of seconds: 4870
 * 4870 seconds = 1:21:10
 */
import java.util.Scanner;

public class LabInput1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int seconds, hours, minutes, secondsRemainder;
    System.out.print("Please enter number of seconds: ");
    seconds = input.nextInt();
    hours = seconds / 3600;
    minutes = (seconds % 3600) / 60;
    secondsRemainder = (seconds % 3600) % 60;
    System.out.println(seconds + " seconds = " + hours + ":" + minutes + ":" + secondsRemainder);
  }
}