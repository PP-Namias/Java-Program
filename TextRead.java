/** 
 *  Text Reader in java
 *  Question of "era ;-;#4892" 
 * 
 *  @author PP-Namias
 *  Licensed under the MIT
 */ 
/*
 * Write a program that reads a TEXT file and displays the words of that file as a list in Java.
 * First, display all words. 
 * Then display them in reverse order. 
 * Then display them with all plurals (ending in "s") capitalized. 
 * Then display them with all plural words removed 
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TextRead {
  public static void main(String[] args) throws IOException {
    // File to be read
    File file = new File("file.txt");

    // Use Scanner to read the file
    Scanner scanner = new Scanner(file);

    // Create a list to store the words
    ArrayList<String> words = new ArrayList<>();

    // Create a list to store the removed words
    ArrayList<String> removedWords = new ArrayList<>();

    // Use a while loop to read through the file
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      // Split the line by spaces
      String[] lineWords = line.split(" ");

      // Add each word to the list
      for (String word : lineWords) {
        words.add(word);
      }
    }

    // Close the scanner
    scanner.close();

    // Display the words
    System.out.println("Original order: ");
    for (String word : words) {
      System.out.println(word);
    }

    // Display the words in reverse order
    System.out.println("\nReverse order: ");
    for (int i = words.size() - 1; i >= 0; i--) {
      System.out.println(words.get(i));
    }

    // capitalize the plural words
    for (int i = 0; i < words.size(); i++) {
      String word = words.get(i);
      if (word.endsWith("s")) {
        word = word.substring(0,1).toUpperCase() + word.substring(1).toUpperCase();
        words.set(i, word);
      }
    }

    // Display the words with all plural words capitalized
    System.out.println("\nPlurals capitalized: ");
    for (String word : words) {
      System.out.println(word);
    }

    // Remove all words that end with "s" and add them to the removedWords list
    for (int i = 0; i < words.size(); i++) {
      String word = words.get(i);
      if (word.endsWith("S")) {
        removedWords.add(word);
        words.remove(i);
        i--;
      }
    }

    // Display the words with all plural words removed
    System.out.println("\nPlurals removed: ");
    for (String word : words) {
      System.out.println(word);
    }

    // Display the removed words
    System.out.println("\nRemoved Words: ");
    for (String word : removedWords) {
      System.out.println(word);
    }
  }
}
