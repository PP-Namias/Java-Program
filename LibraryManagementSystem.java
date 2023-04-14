/*
 * package librarysystem;
import java.util.ArrayList;
import java.util.Scanner;
public class Librarysorter extends Libraryinfo{



  public static void main(String[] args) {
    stock = new ArrayList<>();
    borrowers = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int choice = 0;

    do {

      System.out.println("Welcome To Libray Management System");
      System.out.println("What Do You Want To Do? ");
      System.out.println("");
      System.out.println("1. Register a new borrower");
      System.out.println("2. Add a new book to the stock");
      System.out.println("3. Borrow a book");
      System.out.println("4. Return a book");
      System.out.println("5. Produce a list of books available");
      System.out.println("6. Produce a list of borrowed books");
      System.out.println("7. Borrower can view borrowed book/s");
      System.out.println("0. Exit");
        System.out.println(" ");
      System.out.print("Enter choice: ");
      choice = sc.nextInt();
      sc.nextLine();

      switch (choice) {
        case 1:
          registerBorrower();
          break;
        case 2:
          addBook();
          break;
        case 3:
          borrowBook();
          break;
        case 4:
          returnBook();
          break;
        case 5:
          printAvailableBooks();
          break;
        case 6:
          printBorrowedBooks();
          break;
        case 7:
          viewBorrowedBooks();
          break;
      }
    } while (choice != 0);
  }
}

 */
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LibraryManagementSystem { 
   
  static ArrayList<Book> stock;
  static ArrayList<Borrower> borrowers;   
    
  static class Book {
   String title;
  private boolean availability;

  Book(String title) {
    this.title = title;
    this.availability = true;
  }

  public String getTitle() {
    return title;
  }

  public boolean isAvailable() {
    return availability;
  }

  public void setAvailability(boolean availability) {
    this.availability = availability;
  }
} 
  
   static class Borrower {
  private String name;
  private ArrayList<Book> borrowedBooks;

  Borrower(String name) {
    this.name = name;
    this.borrowedBooks = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public ArrayList<Book> getBorrowedBooks() {
    return borrowedBooks;
  }

  public void borrowBook(Book book) {
    this.borrowedBooks.add(book);
  }

  public void returnBook(Book book) {
    this.borrowedBooks.remove(book);
  }
} 
     
 public static void registerBorrower() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter borrower name: ");
    String name = sc.nextLine();

     borrowers.add(new Borrower( name));
    System.out.println("Borrower registered successfully.");
  } 
 
  public static void addBook() {
    Scanner sc = new Scanner(System.in);
 
    System.out.print("Enter title: ");
    String title = sc.nextLine();

    stock.add(new Book(title));
    System.out.println("Book added to stock successfully.");
  } 
  
  public static void borrowBook() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter borrower Name: ");
     String name = sc.nextLine();
    System.out.print("Enter the Title of the Book: ");
     String title = sc.nextLine();

    Borrower borrower = null;
    Book book = null;

    for (Borrower b : borrowers) {
      if (name.equals(b.getName())) {
        borrower = b;
        break;
      }
    } 
    if (borrower == null) {
      System.out.println("Borrower not found.");
      return;
    }

    for (Book b : stock) {
      if (b.getTitle().equals(title) && b.isAvailable()) {
        book = b;
        break;
      }
    }

    if (book == null) {
      System.out.println("Book not found or not available.");
      return;
    }

    borrower.borrowBook(book);
    book.setAvailability(false);
    System.out.println("Book borrowed successfully.");
  } 
  
   public static void returnBook() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter borrower Name: ");
    String name= sc.nextLine();
    
    System.out.print("Enter the Title of the Book: ");
    String title = sc.nextLine();

    Borrower borrower = null;
    Book book = null;

    for (Borrower b : borrowers) {
      if (b.getName().equals(name)) {
        borrower = b;
        break;
      }
    }

    if (borrower == null) {
      System.out.println("Borrower not found.");
      return;
    }

    for (Book b : borrower.getBorrowedBooks()) {
      if (b.getTitle().equals(title)) {
        book = b;
        break;
      }
    }

    if (book == null) {
      System.out.println("Book not found or not borrowed by this borrower.");
      return;
    }

    borrower.returnBook(book);
    book.setAvailability(true);
    System.out.println("Book returned successfully.");
  } 
   
    public static void printAvailableBooks() {
    System.out.println("\nList of available books:");
    for (Book book : stock) {
      if (book.isAvailable()) {
        System.out.println(book.title);
      }
    }
   } 
     public static void printBorrowedBooks() {
    System.out.println("\nList of borrowed books:");
    for (Book book : stock) {
      if (!book.isAvailable()) {
        System.out.println(book.title);
      }
    }
  } 
     
       public static void viewBorrowedBooks() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter borrower Name: ");
    String name = sc.nextLine();

    Borrower borrower = null;
    for (Borrower b : borrowers) {
      if (b.getName().equals(name)) {
        borrower = b;
        break;
      }
    }

    if (borrower == null) {
      System.out.println("Borrower not found.");
      return;
    }

    System.out.println("\nBorrowed books by " + borrower.getName() + ":");
    for (Book book : borrower.getBorrowedBooks()) {
      System.out.println(book.title);
    }
  }
}
  
class Bk {
  private String title;
  private boolean isAvailable;

  public Bk(String ISBN, String title, String author, int publicationYear) {
    
    this.title = title;
  
    this.isAvailable = true;
  }
 
  public String getTitle() {
    return title;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailability(boolean availability) {
    isAvailable = availability;
  }

  @Override
  public String toString() {
    return "Book{" +    
        ", title='" + title + '\'' + 
        ", isAvailable=" + isAvailable +
        '}';
  }
}

class Br {;
  private String name;
  private List<Book> borrowedBooks;

  public Br( String name) {
    this.name = name;
    this.borrowedBooks = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public List<Book> getBorrowedBooks() {
    return borrowedBooks;
  }

  public void borrowBook(Book book) {
    borrowedBooks.add(book);
  }

  public void returnBook(Book book) {
    borrowedBooks.remove(book);
  }

  @Override
  public String toString() {
    return "Borrower{" +
        ", name='" + name + '\'' +
        '}';
  }
}