/** 
 * Advance Calculator
 *  
 * @author PP-Namias
 *  
 * Licensed under the MIT
 *  
 */ 
/** 
 * @param [input] The scanner for user input.
 * @param [exit] Used to exit the program.
 * @param [operator] The seleceted operator
 * @param [numStrings] The parameters needed to make the array of numbers 
 * @param [numbers] The parameters needed to validaite the numbers
 * @param [result] The reuslt of the calculations
 */
/*
 * Features:
 *  -> Add multiple numbers
 *  -> loops infinitly
 *  -> Gets the operator (+, -, *, /)
 *  -> View the result
 *  -> Exit
 *  -> Error handling
 * 
 * 
 * Future Features:
 * Make an whole statement for the result and then print it out at the end of the loop
 *  -> Add multiple numbers
 *  -> Make an equation for the result
 *  -> View the result
 *  -> Exit
 * 
 * Example: 
 *  1 + 2 + 3 + 4 + 5 = 15
 *  2 * 5 / 10 + 3 = 3.5
 *  6 - 5 + 4 - 3 + 2 - 1 = 1
 *  1 + 2 * 3 = 7
 * 
 * Make an char that allows the user to input the equation 
 * and then split it up into an array of strings 
 * and then parse it into an array of doubles 
 * and then do the calculations and then print out the result 
 * and then loop it back to the start of the program 
 * and then make an exit statement 
 * and then make an error handling statement 
 * and then make an equation statement
*/  
import java.util.Scanner;

public class AdvancedCalculator {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    boolean exit = false;

    while (!exit) {
      System.out.println("Select an operation (+, -, *, /) or enter 'exit' to quit:");
      String operation = input.nextLine();

      if (operation.equalsIgnoreCase("exit")) {
        exit = true;
      } else if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
        System.out.println("Enter numbers (separated by spaces):");
        String[] numStrings = input.nextLine().split("\\s+");
        double[] numbers = new double[numStrings.length];

        for (int i = 0; i < numStrings.length; i++) {
          numbers[i] = Double.parseDouble(numStrings[i]);
        }

        double result = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
          if (operation.equals("+")) {
            if (i == 1) {
              System.out.print(numbers[0]);
              System.out.print(" + " + numbers[1]);
            }
            else if (i >= 1) {
              System.out.print(" + " + numbers[i]);
            }
            result += numbers[i];
          } else if (operation.equals("-")) {
            if (i == 1) {
              System.out.print(numbers[0]);
              System.out.print(" - " + numbers[1]);
            }
            else if (i >= 1) {
              System.out.print(" - " + numbers[i]);
            }
            result -= numbers[i];
          } else if (operation.equals("*")) {
            if (i == 1) {
              System.out.print(numbers[0]);
              System.out.print(" * " + numbers[1]);
            }
            else if (i >= 1) {
              System.out.print(" * " + numbers[i]);
            }
            result *= numbers[i];
          } else if (operation.equals("/")) {
            if (numbers[i] == 0) {
              System.out.println("Cannot divide by zero");
              break;
            } else {
              if (i == 1) {
                System.out.print(numbers[0]);
                System.out.print(" / " + numbers[1]);
              }
              else if (i >= 1) {
                System.out.print(" / " + numbers[i]);
              }
              result /= numbers[i];
            }
          }
        }

        System.out.println(" = " + result);
      } else {
        System.out.println("Invalid operation");
      }
    }

    input.close();
  }
}
