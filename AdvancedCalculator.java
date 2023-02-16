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
 *  -> Add multipole numbers
 *  -> loops infinitly
 *  -> Gets the operator (+, -, *, /)
 *  -> View the result
 *  -> Exit
 *  -> Error handling
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
            result += numbers[i];
          } else if (operation.equals("-")) {
            result -= numbers[i];
          } else if (operation.equals("*")) {
            result *= numbers[i];
          } else if (operation.equals("/")) {
            if (numbers[i] == 0) {
              System.out.println("Cannot divide by zero");
              break;
            } else {
              result /= numbers[i];
            }
          }
        }

        System.out.println("Result: " + result);
      } else {
        System.out.println("Invalid operation");
      }
    }

    input.close();
  }
}