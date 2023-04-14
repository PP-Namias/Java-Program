/*
 * make an grade calculator that takes in the grade and the weight of the grade
 * and then calculates the final grade
 * use grading system A,B,C,D,F
 */
import java.util.Scanner;
public class testtt {
  public static void main (String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the grade and the weight of the grade");
    double grade = input.nextDouble();
    double weight = input.nextDouble();
    double finalGrade = grade * weight;
    System.out.println("The final grade is " + finalGrade);
    if (finalGrade >= 90) {
      System.out.println("The grade is A");
    }
    else if (finalGrade >= 80) {
      System.out.println("The grade is B");
    }
    else if (finalGrade >= 70) {
      System.out.println("The grade is C");
    }
    else if (finalGrade >= 60) {
      System.out.println("The grade is D");
    }
    else {
      System.out.println("The grade is F");
    }
  }
}
