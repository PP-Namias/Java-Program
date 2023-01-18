// Java Program to Print Colored Text in Console

// Importing input output classes
import java.io.*;

// Main class
public class Text_Color {
  
  // Declaring ANSI_RESET so that we can reset the color
  public static final String ANSI_RESET = "\u001B[0m";
  
  // Declaring the color
  // Custom declaration
  public static final String ANSI_BLACK   = "\u001B[30m";
  public static final String ANSI_RED     = "\u001B[31m";
  public static final String ANSI_GREEN   = "\u001B[32m";
  public static final String ANSI_YELLOW  = "\u001B[33m";
  public static final String ANSI_BLUE    = "\u001B[34m";
  public static final String ANSI_PURPLE  = "\u001B[35m";
  public static final String ANSI_CYAN    = "\u001B[36m";
  public static final String ANSI_WHITE   = "\u001B[37m";
  
  // Main driver method
  public static void main(String[] args)
  {
      // Printing the text on console prior adding
      // the desired color
      System.out.println(ANSI_YELLOW
                        + "This text is yellow"
                        + ANSI_RESET);

      System.out.println(ANSI_RED
                        + "This text is yellow"
                        + ANSI_RESET);
      System.out.println(ANSI_GREEN
                        + "This text is yellow"
                        + ANSI_RESET);
  }


}