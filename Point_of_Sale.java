/*
 * Programmer : @PP-Namias
 * 
 * Item_Num, Item_Name, Category_Num, Category_Name, Price
 */

import java.util.Scanner;  

public class Point_of_Sale {
  public static void main (String[] args) {
    System.out.println ("Point of Sale");
    System.out.println ("Made by: @PP-Namias");

    int ch;
    Scanner myObj = new Scanner(System.in);  
    
    do{      
      System.out.println ("1. Create Products");
      System.out.println ("2. Display Products");
      System.out.println ("3. Search Products");
      System.out.println ("4. Modify Products");
      System.out.println ("5. Delete Products");
      System.out.println ("6. Place an Order");
      System.out.println ("7. Exit");

      System.out.println ("\nEnter Your Choice: ");
      ch = myObj.nextInt();
      myObj.close();
      
      switch(ch) {
        case 1: System.out.println ("create"); break;
        case 2: System.out.println ("display"); break;
        case 3: System.out.println ("search"); break;
        case 4: System.out.println ("update"); break;
        case 5: System.out.println ("delete"); break;
        case 6: System.out.println ("place_order"); break;
        case 7: System.out.println ("exit"); break;
        default: System.out.println ("\b"); break;
      }
    } while (ch != 7);
  }
}
