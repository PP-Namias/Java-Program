/*
 *  Programmer : @PP-Namias
 *  
 *  Features:
 *      -> Add Products
 *      -> Purchase products
 *      -> Remove Purchased Products
 *      -> View Purchased Products
 *      -> Exit
*/
/** 
 *  @param [prameters] The parameters needed to create the application
 *      -> [products] the product list.
 *      -> [productName] the product name input.
 *      -> [purchasedList] the purchased list where all the purchased products will be added.
 *      -> [purchasedProducts] the purchased products list.
 *      -> [sc] the scanner for user input.
 *      -> [str] the string to check.
 *  
 *  @return the product if found. else empty product.
 */
/*
 *  [Future Features]
 *  Admin 
 *      -> create products
 *      -> display products
 *      -> search products
 *      -> update products
 *      -> delete products
 *      -> place_order products
 *  
 *  Public
 *      -> Add Products
 *      -> Purchase products
 *      -> Remove Purchased Products
 *      -> View Purchased Products
 *      -> Exit
 *  
 *  System:
 *      -> [Login History]
 *      -> [Product Information]
 *      -> [Product Order History]
 *  
*/  



/*
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
                default: System.out.println ("\baaaaa"); break;
            }
        } while (ch != 7);
    }
}
 */


import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Point_of_Sale {

    public static void main(String[] args) {
        ArrayList<Product> productsList = new ArrayList<>();
        ArrayList<Product> purchasedList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("------------------------");
            System.out.println("| Point of Sale System |");
            System.out.println("------------------------");
            System.out.println("[ 1 ] Add Products");
            System.out.println("[ 2 ] Purchase products");
            System.out.println("[ 3 ] Remove Purchased Products");
            System.out.println("[ 4 ] View Purchased Products");
            System.out.println("[ 5 ] Exit");
            System.out.print(">>>: ");
            choice = scanner.nextLine().trim().toUpperCase();
            switch (choice) {
                case "1":
                    addProduct(productsList, scanner);
                    break;
                case "2":
                    purchaseProducts(productsList, purchasedList, scanner);
                    break;
                case "3":
                    removePurchasedProduct(purchasedList, scanner);
                    break;
                case "4":
                    viewPurchasedProducts(purchasedList);
                    break;
                case "5":
                    System.out.println("Thank you");
                    System.exit(0);
            }
        } while (true);
    }

    /**
     * Adds a product to the list (not yet purchased).
     * @param products the product list.
     * @param sc the scanner for user input.
     */
    private static void addProduct(ArrayList<Product> products, Scanner sc) {
        int quantity;
        String productName;
        double productPrice;

        System.out.println("---------------");
        System.out.println("| Add Product |");
        System.out.println("---------------");

        System.out.print("Enter product name: ");
        productName = sc.nextLine().trim();
        System.out.printf("Enter %s price: ", productName);
        String temporaryPrice = sc.nextLine().trim();

        if (isDecimalNumber(temporaryPrice) || isWholeNumber(temporaryPrice)) {
            productPrice = Double.parseDouble(temporaryPrice);
            System.out.printf("Enter %s quantity: ", productName);
            String temporaryQuantity = sc.nextLine().trim();
            if (isWholeNumber(temporaryQuantity)) {
                quantity = Integer.parseInt(temporaryQuantity);
                products.add(new Product(productName, productPrice, quantity));
            } else System.out.printf("%s quantity should be a whole number%n", productName);
        } else System.out.printf("%s price should be a number%n", productName);
    }

    /**
     * Purchase products.
     * @param products the products list.
     * @param purchasedList the purchased list where all the purchased products will be added.
     * @param sc the scanner for user input.
     */
    private static void purchaseProducts(
            ArrayList<Product> products,
            ArrayList<Product> purchasedList,
            Scanner sc
    ) {
        System.out.print("How many products you want to purchase?: ");
        String temporaryCount = sc.nextLine().trim();
        if (isWholeNumber(temporaryCount)) {
            int numberOfPurchase = Integer.parseInt(temporaryCount);
            for (int i = 1; i <= numberOfPurchase; i++) {
                viewProducts(products);
                System.out.print("Enter product name to purchase: ");
                String productName = sc.nextLine().trim();
                if (doesProductExists(products, productName)) {

                    System.out.printf("How many %s you want to purchase?: ", productName);
                    String temporaryQuantity = sc.nextLine().trim();
                    if (isWholeNumber(temporaryQuantity)) {

                        Product chosenProduct = getProductByName(products, productName);

                        int purchaseProductQuantity = Integer.parseInt(temporaryQuantity);

                        // checks if the quantity to purchase is feasible
                        if (purchaseProductQuantity <= chosenProduct.getQuantity()) {

                            boolean isProductAlreadyAdded = doesProductExists(purchasedList, productName);

                            // if existing product, modify the quantity, else add new product.
                            if (isProductAlreadyAdded) {
                                int indexOfCurrentProduct = purchasedList.indexOf(chosenProduct);

                                Product existingPurchasedProduct = purchasedList.get(indexOfCurrentProduct);
                                purchasedList
                                        .get(indexOfCurrentProduct)
                                        .setQuantity(existingPurchasedProduct.getQuantity() + purchaseProductQuantity);
                                // gets the product in the products list and modifies the product quantity.

                                products.get(indexOfCurrentProduct)
                                        .setQuantity(chosenProduct.getQuantity() - purchaseProductQuantity);
                            } else {
                                // gets the index of the chosen product from the products list.
                                int productIndex = products.indexOf(chosenProduct);

                                // gets the product in the products list and modifies the product quantity.
                                products.get(productIndex)
                                        .setQuantity(chosenProduct.getQuantity() - purchaseProductQuantity);

                                // add the product to the purchased products list.
                                purchasedList.add(new Product(chosenProduct.getName(), chosenProduct.getPrice(), purchaseProductQuantity));
                            }
                            System.out.println("Purchased Successfully");
                        } else System.out.println("Cannot purchase product, product not enough");

                    } else System.out.println("Not a number");

                } else System.out.printf("Product: %s does not exist in the products list%n", productName);
            }
        } else System.out.println("Invalid purchase count");
    }

    /**
     * Removes a product from the purchased list.
     * @param purchasedProductsList the purchased products list.
     * @param sc the scanner of user input.
     */
    private static void removePurchasedProduct(ArrayList<Product> purchasedProductsList, Scanner sc) {
        if (purchasedProductsList.isEmpty()) System.out.println("No Products Available");
        else {
            System.out.print("Enter product name to remove: ");
            String productName = sc.nextLine().trim();

            // true if the product name is purchased.
            boolean isPurchased = doesProductExists(purchasedProductsList, productName);

            if (isPurchased) {
                Product purchasedProduct = getProductByName(purchasedProductsList, productName);

                System.out.printf("How many %s you want to remove?: ", purchasedProduct.getName());

                String temporaryCount = sc.nextLine().trim();

                if (isWholeNumber(temporaryCount)) {
                    // index of the product in the list of purchased product.
                    int quantityToRemove = Integer.parseInt(temporaryCount);
                    if (quantityToRemove == purchasedProduct.getQuantity()) {
                        purchasedProductsList.remove(purchasedProduct);
                        System.out.printf("Removed all %s in the purchased products list", purchasedProduct.getName());
                    } else if (quantityToRemove <= purchasedProduct.getQuantity()) {
                        int purchaseProductIndex = purchasedProductsList.indexOf(purchasedProduct);

                        // sets the new quantity of the product based on the quantity to be removed.
                        purchasedProductsList
                                .get(purchaseProductIndex)
                                .setQuantity(purchasedProduct.getQuantity() - quantityToRemove);

                        System.out.printf("Removed %d %s in your purchased products list", quantityToRemove, purchasedProduct.getName());
                    } else System.out.println("Invalid quantity");

                } else System.out.println("Invalid count");

            } else System.out.printf("Product: %s is not in your purchased list%n", productName);
        }
    }

    /**
     * Prints all the available products to be purchased.
     * @param products the products list.
     */
    private static void viewProducts(ArrayList<Product> products) {
        if (products.isEmpty()) System.out.println("No Products Available");
        else {
            System.out.println("----------------------");
            System.out.println("| Available Products |");
            System.out.println("----------------------");
            for (Product availableProduct : products) {
                System.out.println(availableProduct); // prints the product and invokes the toString method in Product class
            }
        }
    }

    /**
     * Prints all the purchased products.
     * @param purchasedProducts the purchased products list.
     */
    private static void viewPurchasedProducts(ArrayList<Product> purchasedProducts) {
        if (purchasedProducts.isEmpty()) {
            System.out.println("No Purchased Products");
        } else {
            double sum = 0.0;
            System.out.println("----------------------");
            System.out.println("| Purchased Products |");
            System.out.println("----------------------");
            for (Product purchasedProduct : purchasedProducts) {
                sum += purchasedProduct.getPrice() * purchasedProduct.getQuantity();
                System.out.println(purchasedProduct); // prints the product and invokes the toString method in Product class
            }
            System.out.println("Sum: " + sum);
        }
    }

    /**
     * Checks if the product name input is a name of a product in the products list.
     * @param products the products list.
     * @param productName the product name input.
     * @return true if the product name is a product in the products list.
     */
    private static boolean doesProductExists(ArrayList<Product> products, String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) return true;
        }
        return false;
    }

    /**
     * Get a product in the list by using the product name.
     * @param productsList the list containing products.
     * @param productName the product name to find.
     * @return the product if found. else empty product.
     */
    private static Product getProductByName(ArrayList<Product> productsList, String productName) {
        for (Product product : productsList) {
            if (product.getName().equalsIgnoreCase(productName)) return product;
        }

        return new Product();
    }

    /**
     * Class for making products.
     */
    static class Product {
        private String name;
        private double price;
        private int quantity;

        public Product() {
            this.name = "product name";
            this.price = 0.0;
            this.quantity = 0;
        }

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return quantity == product.quantity && Double.compare(product.price, price) == 0 && name.equals(product.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(quantity, name, price);
        }

        @Override
        public String toString() {
            return "Name : " + getName()  + "\n" +
                   "Price: " + getPrice() + "\n" +
                   "Quantity: " + getQuantity() + "\n";
        }
    }

    /**
     * Checks if a string is a positive whole number.
     * @param str the string to check.
     * @return true if it is a positive number.
     */
    private static boolean isWholeNumber(String str) {
        return Pattern.compile("^\\d+$").matcher(str).matches();
    }

    /**
     * Checks if a string is a positive decimal number.
     * @param str the string to check.
     * @return true if it is a decimal number.
     */
    private static boolean isDecimalNumber(String str) {
        return Pattern.compile("^\\d+.\\d+$").matcher(str).matches();
    }

}
