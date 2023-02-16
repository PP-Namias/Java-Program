/** 
 *  Calculator
 *  
 *  @author PP-Namias
 *  
 *  Licensed under the MIT
 *  
 */ 
/** 
 * @param [num1] The parameters needed number 1
 * @param [num2] The parameters needed number 1
 * @param [result] The reuslt of the calculations
 * @param [operator] The seleceted operator
 * @param [input] the scanner for user input.
 */

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double num1, num2, result;
        char operator;

        System.out.println("Enter first number: ");
        num1 = input.nextDouble();

        System.out.println("Enter operator (+, -, *, /): ");
        operator = input.next().charAt(0);

        System.out.println("Enter second number: ");
        num2 = input.nextDouble();

        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + result);
                break;

            case '-':
                result = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + result);
                break;

            case '*':
                result = num1 * num2;
                System.out.println(num1 + " * " + num2 + " = " + result);
                break;

            case '/':
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero");
                } else {
                    result = num1 / num2;
                    System.out.println(num1 + " / " + num2 + " = " + result);
                }
                break;

            default:
                System.out.println("Invalid operator");
                break;
        }

        input.close();
    }
}
