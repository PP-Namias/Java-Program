/**
 * LabInput1.java
 * Time Converter Activity #1
 * @author PP-Namias
 * Licensed under MIT License
 */
/** 
 * @param [input] the scanner for user input.
 * @param [seconds] The number of seconds input.
 * @param [hours] the number of hours.
 * @param [minutes] the number of minutes.
 * @param [secondsRemainder] the number of seconds remainder.
 * @param [exit] the boolean to check if the program will exit.
 */
/*
 * Write a program that accepts input to varible seconds.
 * The program will then output the equivalent time in hours:minutes:seconds format.
 * use labInput1 as classname and filename.
 * 
 * Test ouput:
 *    Please enter number of seconds: 4870
 *    4870 seconds = 1:21:10
 */
import java.util.Scanner;

    public class LabInput1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int seconds, hours, minutes, secondsRemainder;
        boolean exit = false;

        while (!exit) {
            try {
                System.out.print("Please enter number of seconds or enter '0' to quit: ");
                seconds = input.nextInt();
                if (seconds == 0) {
                    System.out.print("Exiting the program! Thank you for using this program!");
                    exit = true;
                }
                else {
                    hours = seconds / 3600;
                    minutes = (seconds % 3600) / 60;
                    secondsRemainder = (seconds % 3600) % 60;
                    System.out.println(seconds + " seconds = " + hours + ":" + minutes + ":" + secondsRemainder);
                }
            } catch (Exception e) {
                System.out.println("Please enter the correct input.");
            }
        }
        input.close();
    }
}
