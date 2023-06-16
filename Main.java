import java.util.*;
import java.io.*;

class Admin {
    private static final String file_directory = "/Files/";
    private static ArrayList < ClientManager > clients = new ArrayList < ClientManager > ();
    private String useradmin;
    private String passadmin;
    public Admin(String useradmin, String passadmin) {
        this.useradmin = useradmin;
        this.passadmin = passadmin;
    }
    public String getUseradmin() {
        return useradmin;
    }
    public String getPassadmin() {
        return passadmin;
    }
    public void setPassadmin(String passadmin) {
        this.passadmin = passadmin;
    }
    public void adminlogin() {
        Scanner esc = new Scanner(System.in);
        String tryagain = "No";
        try {
            FileWriter writer = new FileWriter("AdminCredentials.txt");
            writer.write("Username : " + getUseradmin() + '\n' + "Password : " + getPassadmin());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        do {
            System.out.println("\n+===================================+");
            System.out.println("|---------ISUFST BANK SYSTEM--------|");
            System.out.println("|-----WELCOME TO OUR BANK SYSTEM----|");
            System.out.println("+===================================+\n");
            System.out.println("+-----------------------------------+");
            System.out.println("|----|LOG IN YOUR ADMIN ACCOUNT|----|");
            System.out.println("+-----------------------------------+");
            System.out.print("Enter your username : ");
            String username = esc.nextLine();
            System.out.print("Enter your password : ");
            String password = esc.nextLine();
            if (username.equals(getUseradmin()) && password.equals(getPassadmin())) {
                System.out.println("\nLOGGED IN SUCCESSFULLY!");
                adminpage();
                break;
            } else {
                System.out.print("\nIncorrect username or password!\nDo you want to try again? (Yes/No) : ");
                tryagain = esc.nextLine();
            }
        } while (tryagain.equalsIgnoreCase("Yes") || tryagain.equalsIgnoreCase("y"));
    }
    public void adminpage() {
        Scanner esc = new Scanner(System.in);
        int choice;
        try {
            do {
                System.out.println("\n+===================================+");
                System.out.println("|---------ISUFST BANK SYSTEM--------|");
                System.out.println("|-----WELCOME TO OUR BANK SYSTEM----|");
                System.out.println("+===================================+\n");
                System.out.println("+-----------------------------------+");
                System.out.println("|---!WELCOME ADMIN|CHOOSE A TASK!---|");
                System.out.println("+-----------------------------------+");
                System.out.println("|[1] Add Client                     |");
                System.out.println("|[2] List Client                    |");
                System.out.println("|[3] Delete Client                  |");
                System.out.println("|[4] Change Admin Password          |");
                System.out.println("|[5] Go Back To Previous Menu       |");
                System.out.println("|[0] Exit System                    |");
                System.out.println("+-----------------------------------+");
                System.out.print(">>> ");
                choice = esc.nextInt();
                switch (choice) {
                    case 1:
                        addClients();
                        break;
                    case 2:
                        listClients();
                        break;
                    case 3:
                        deleteClient();
                        break;
                    case 4:
                        changeAdminPassword();
                        break;
                    case 5:
                        return;
                    case 0:
                        System.out.println("Thank you for using our system.\nComeback next time!\nExiting System...");
                        System.exit(0);
                        break;
                }
            } while (choice != 0);
        } catch (InputMismatchException i) {
            System.out.println("\nNOTICE : Input number only!\n");
        } catch (Exception e) {
            System.out.println("\nAn Error Occured!\n");
        }
    }
    class ClientManager {
        private String userClient;
        public String getUserClient() {
            return userClient;
        }
        public void setUserClient(String newUserClient) {
            this.userClient = newUserClient;
        }
        private String passClient;
        public String getPassClient() {
            return passClient;
        }
        public void setPassClient(String newPassClient) {
            this.passClient = newPassClient;
        }
        private String lastName;
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String newLastName) {
            this.lastName = newLastName;
        }
        private String firstName;
        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String newFirstName) {
            this.firstName = newFirstName;
        }
        private String middleName;
        public String getMiddleName() {
            return middleName;
        }
        public void setMiddleName(String newMiddleName) {
            this.middleName = newMiddleName;
        }
        private String address;
        public String getAddress() {
            return address;
        }
        public void setAddress(String newAddress) {
            this.address = newAddress;
        }
        private long contactNumber;
        public long getContactNumber() {
            return contactNumber;
        }
        public void setContactNumber(long newContactNumber) {
            this.contactNumber = newContactNumber;
        }
        private int initialBalance;
        public int getInitialBalance() {
            return initialBalance;
        }
        public void setInitialBalance(int newInitialBalance) {
            this.initialBalance = newInitialBalance;
        }
        public ClientManager(String userClient, String passClient, String lastName, String firstName, String middleName, String address, long contactNumber, int initialBalance) {
            this.userClient = userClient;
            this.passClient = passClient;
            this.lastName = lastName;
            this.firstName = firstName;
            this.middleName = middleName;
            this.address = address;
            this.contactNumber = contactNumber;
            this.initialBalance = initialBalance;
        }
        public String toString() {
            return "Username: " + getUserClient() +
                "\nPassword: " + getPassClient() +
                "\nLast Name: " + getLastName() +
                "\nFirst Name: " + getFirstName() +
                "\nMiddle Name: " + getMiddleName() +
                "\nAddress: " + getAddress() +
                "\nContact Number: " + getContactNumber() +
                "\nInitial Balance: " + getInitialBalance();
        }
    }
    public void addClients() {
        Scanner esc = new Scanner(System.in);
        System.out.println("\n+===================================+");
        System.out.println("|---------ISUFST BANK SYSTEM--------|");
        System.out.println("|-----WELCOME TO OUR BANK SYSTEM----|");
        System.out.println("+===================================+\n");
        System.out.println("-------------------------------------");
        System.out.println("|----------|ADD A CLIENT!|-----------|");
        System.out.println("-------------------------------------");
        System.out.print("\nUsername : ");
        String username = esc.nextLine();
        boolean userExists = false;
        for (ClientManager client: clients) {
            if (client.getUserClient().equals(username)) {
                userExists = true;
                break;
            }
        }
        if (userExists) {
            System.out.println("\nUser already exists. Unable to add client.\n");
        } else {
            System.out.print("Password : ");
            String password = esc.nextLine();
            System.out.print("Last Name : ");
            String lastname = esc.nextLine();
            System.out.print("First Name : ");
            String firstname = esc.nextLine();
            System.out.print("Middle Name : ");
            String middlename = esc.nextLine();
            System.out.print("Address : ");
            String address = esc.nextLine();
            System.out.print("Contact Number : ");
            long contactnumber = esc.nextLong();
            System.out.print("Initial Balance : ");
            int initialbalance = esc.nextInt();
            ClientManager cl = new ClientManager(username, password, lastname, firstname, middlename, address, contactnumber, initialbalance);
            clients.add(cl);
            System.out.println("\nClients Added Successfully");
            try {
                FileWriter fw = new FileWriter("/Files/" + username + ".txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Username : " + cl.getUserClient() + '\n');
                bw.write("Password : " + cl.getPassClient() + '\n');
                bw.write("Last Name : " + cl.getLastName() + '\n');
                bw.write("First Name : " + cl.getFirstName() + '\n');
                bw.write("Middle Name : " + cl.getMiddleName() + '\n');
                bw.write("Address : " + cl.getAddress() + '\n');
                bw.write("Contact Number : " + cl.getContactNumber() + '\n');
                bw.write("Initial Balance : " + cl.getInitialBalance() + '\n');
                bw.newLine();
                bw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage() + "\n");
            }
        }
    }
    public void listClients() {
        if (clients.size() > 0) {
            for (int i = 0; i < clients.size(); i++) {
                System.out.println("+-----------------------------------+");
                System.out.println(clients.get(i).toString());
                System.out.println("+-----------------------------------+");
            }
        } else {
            System.out.println("No clients found!\n");
        }
    }
    public void deleteClient() {
        Scanner esc = new Scanner(System.in);
        System.out.print("Enter the username you want to delete : ");
        String username = esc.nextLine();
        boolean clientFound = false;
        for (int i = 0; i < clients.size(); i++) {
            ClientManager client = clients.get(i);
            if (client.getUserClient().equals(username)) {
                clients.remove(i);
                System.out.println("Client with username " + username + " has been deleted.");
                File deleteFile = new File("/Files/" + client.getUserClient() + ".txt");
                deleteFile.delete();
                clientFound = true;
                break;
            }
        }
        if (!clientFound) {
            System.out.println("Client with username " + username + " was not found.");
        }
    }
    public void changeAdminPassword() {
        Scanner esc = new Scanner(System.in);
        System.out.print("Enter your current password: ");
        String currPass = esc.nextLine();
        if (currPass.equals(getPassadmin())) {
            System.out.print("Enter your new password: ");
            String newPass = esc.nextLine();
            setPassadmin(newPass);
            try {
                FileWriter writer = new FileWriter("AdminCredentials.txt");
                writer.write("Username: " + getUseradmin() + "\nPassword: " + getPassadmin());
                writer.close();
                System.out.println("Password updated successfully!");
                System.out.println("Your password is now change to : " + getPassadmin());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("\nYour current password is incorrect!\n");
        }
    }
    public void clientLogin() {
        Scanner esc = new Scanner(System.in);
        String yesNo = "No";
        int choice;
        do {
            System.out.println("\n+===================================+");
            System.out.println("|---------ISUFST BANK SYSTEM--------|");
            System.out.println("|-----WELCOME TO OUR BANK SYSTEM----|");
            System.out.println("+===================================+\n");
            System.out.println("-------------------------------------");
            System.out.println("|----!LOG IN YOUR CLIENT ACCOUNT!---|");
            System.out.println("-------------------------------------");
            System.out.print("\nEnter your username: ");
            String username = esc.nextLine();
            System.out.print("Enter your password: ");
            String password = esc.nextLine();
            try {
                File file = new File(file_directory + username + ".txt");
                Scanner fileScanner = new Scanner(file);
                String clientUser = fileScanner.nextLine().split(": ")[1];
                String clientPass = fileScanner.nextLine().split(": ")[1];
                if (username.equals(clientUser) && password.equals(clientPass)) {
                    System.out.println("\nLOGGED IN SUCCESSFULLY");
                    while (true) {
                        System.out.println("\n+===================================+");
                        System.out.println("|---------ISUFST BANK SYSTEM--------|");
                        System.out.println("|-----WELCOME TO OUR BANK SYSTEM----|");
                        System.out.println("+===================================+\n");
                        System.out.println("+-----------------------------------+");
                        System.out.println("|--|WELCOME CLIENT|CHOOSE A TASK|---|");
                        System.out.println("+-----------------------------------+");
                        System.out.println("|[1] Check Balance                  |");
                        System.out.println("|[2] Withdraw                       |");
                        System.out.println("|[3] Deposit                        |");
                        System.out.println("|[4] Edit Password                  |");
                        System.out.println("|[5] View Profile                   |");
                        System.out.println("|[6] Edit Profile                   |");
                        System.out.println("|[7] Go Back To Previous Menu       |");
                        System.out.println("|[0] Exit System                    |");
                        System.out.println("+-----------------------------------+");
                        System.out.print(">>> ");
                        choice = esc.nextInt();
                        esc.nextLine();
                        switch (choice) {
                            case 1:
                                fileScanner = new Scanner(file);
                                while (fileScanner.hasNextLine()) {
                                    String line = fileScanner.nextLine();
                                    if (line.startsWith("Initial Balance : ")) {
                                        String initialBalance = line.split(": ")[1];
                                        System.out.println("\nHELLO, " + username.toUpperCase());
                                        System.out.println("Your current balance is: " + initialBalance);
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                System.out.print("\nEnter the amount you want to withdraw: ");
                                int amount = esc.nextInt();
                                esc.nextLine();
                                int minWithdrawal = 100;
                                fileScanner = new Scanner(file);
                                while (fileScanner.hasNextLine()) {
                                    String ln = fileScanner.nextLine();
                                    if (ln.startsWith("Initial Balance : ")) {
                                        String initialBalance = ln.split(": ")[1];
                                        int intBal = Integer.parseInt(initialBalance);
                                        if (amount < minWithdrawal) {
                                            System.out.println("\nWithdrawal failed! Please withdraw atleast : " + minWithdrawal);
                                        } else {
                                            if (intBal >= amount) {
                                                int newBal = intBal - amount;
                                                System.out.println("\nWithdraw Successful!");
                                                System.out.println("Your new balance is: " + newBal);
                                                try {
                                                    File tempFile = new File(file_directory + "temp.txt");
                                                    BufferedReader reader = new BufferedReader(new FileReader(file));
                                                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                                                    String line;
                                                    while ((line = reader.readLine()) != null) {
                                                        if (line.startsWith("Initial Balance : ")) {
                                                            writer.write("Initial Balance : " + newBal);
                                                        } else {
                                                            writer.write(line);
                                                        }
                                                        writer.newLine();
                                                    }
                                                    reader.close();
                                                    writer.close();
                                                    file.delete();
                                                    tempFile.renameTo(file);
                                                } catch (IOException e) {
                                                    System.out.println("An error occurred!\n");
                                                }
                                            } else {
                                                System.out.println("Insufficient Balance!\n");
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 3:
                                System.out.print("\nEnter the amount you want to deposit: ");
                                int depositAmount = esc.nextInt();
                                esc.nextLine();
                                int minDeposit = 100;
                                fileScanner = new Scanner(file);
                                while (fileScanner.hasNextLine()) {
                                    String line = fileScanner.nextLine();
                                    if (line.startsWith("Initial Balance : ")) {
                                        String initialBalance = line.split(" : ")[1];
                                        int intBal = Integer.parseInt(initialBalance);
                                        if (depositAmount > minDeposit) {
                                            int newBal = intBal + depositAmount;
                                            System.out.println("\nDeposit Successful!");
                                            System.out.println("Your new balance is: " + newBal);
                                            try {
                                                File tempFile = new File(file_directory + "temp.txt");
                                                BufferedReader reader = new BufferedReader(new FileReader(file));
                                                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                                                String tempLine;
                                                while ((tempLine = reader.readLine()) != null) {
                                                    if (tempLine.startsWith("Initial Balance : ")) {
                                                        writer.write("Initial Balance : " + newBal);
                                                    } else {
                                                        writer.write(tempLine);
                                                    }
                                                    writer.newLine();
                                                }
                                                reader.close();
                                                writer.close();
                                                file.delete();
                                                tempFile.renameTo(file);
                                            } catch (IOException e) {
                                                System.out.println("An error occurred!\n");
                                            }
                                        } else {
                                            System.out.println("\nPlease deposit at least : " + minDeposit + "\n");
                                            break;
                                        }
                                        break;
                                    }
                                }
                                break;
                            case 4:
                                System.out.print("\nEnter your new password: ");
                                String newClientPass = esc.nextLine();
                                try {
                                    File tempFile = new File("/Files/temp.txt");
                                    BufferedReader reader = new BufferedReader(new FileReader(file));
                                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                                    String line;
                                    while ((line = reader.readLine()) != null) {
                                        if (line.startsWith("Password : ")) {
                                            writer.write("Password : " + newClientPass);
                                        } else {
                                            writer.write(line);
                                        }
                                        writer.newLine();
                                    }
                                    reader.close();
                                    writer.close();
                                    file.delete();
                                    tempFile.renameTo(file);
                                    System.out.println("\nPassword updated successfully!");
                                    System.out.println("Your new password is : " + newClientPass);
                                } catch (IOException e) {
                                    System.out.println("An error occurred!\n");
                                }
                                break;
                            case 5:
                                fileScanner = new Scanner(file);
                                while (fileScanner.hasNextLine()) {
                                    String line = fileScanner.nextLine();
                                    if (line.startsWith("Last Name") || line.startsWith("First Name") ||
                                        line.startsWith("Middle Name") || line.startsWith("Address") ||
                                        line.startsWith("Contact Number")) {
                                        System.out.println("+-----------------------------------+");
                                        System.out.println(line);
                                        System.out.println("+-----------------------------------+");
                                    }
                                }
                                break;
                            case 6:
                                try {
                                    File tempFile = new File(file_directory + "temp.txt");
                                    BufferedReader reader = new BufferedReader(new FileReader(file));
                                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                                    String tempLine;
                                    while ((tempLine = reader.readLine()) != null) {
                                        if (tempLine.startsWith("Last Name : ")) {
                                            System.out.println("\nCurrent last name: " + tempLine.split(": ")[1]);
                                            System.out.print("Do you want to edit the last name? (Yes/No): ");
                                            String editChoice = esc.nextLine();
                                            if (editChoice.equalsIgnoreCase("Yes") || editChoice.equalsIgnoreCase("Y")) {
                                                System.out.print("Enter your new last name: ");
                                                String lastName = esc.nextLine();
                                                writer.write("Last Name : " + lastName);
                                            } else {
                                                writer.write(tempLine);
                                            }
                                        } else if (tempLine.startsWith("First Name : ")) {
                                            System.out.println("\nCurrent first name: " + tempLine.split(": ")[1]);
                                            System.out.print("Do you want to edit the first name? (Yes/No): ");
                                            String editChoice = esc.nextLine();
                                            if (editChoice.equalsIgnoreCase("Yes") || editChoice.equalsIgnoreCase("Y")) {
                                                System.out.print("Enter your new first name: ");
                                                String firstName = esc.nextLine();
                                                writer.write("First Name : " + firstName);
                                            } else {
                                                writer.write(tempLine);
                                            }
                                        } else if (tempLine.startsWith("Middle Name : ")) {
                                            System.out.println("\nCurrent middle name: " + tempLine.split(": ")[1]);
                                            System.out.print("Do you want to edit the middle name? (Yes/No): ");
                                            String editChoice = esc.nextLine();
                                            if (editChoice.equalsIgnoreCase("Yes") || editChoice.equalsIgnoreCase("Y")) {
                                                System.out.print("Enter your new middle name: ");
                                                String middleName = esc.nextLine();
                                                writer.write("Middle Name : " + middleName);
                                            } else {
                                                writer.write(tempLine);
                                            }
                                        } else if (tempLine.startsWith("Address : ")) {
                                            System.out.println("\nCurrent address: " + tempLine.split(": ")[1]);
                                            System.out.print("Do you want to edit the address? (Yes/No): ");
                                            String editChoice = esc.nextLine();
                                            if (editChoice.equalsIgnoreCase("Yes") || editChoice.equalsIgnoreCase("Y")) {
                                                System.out.print("Enter your new address: ");
                                                String newAddress = esc.nextLine();
                                                writer.write("Address : " + newAddress);
                                            } else {
                                                writer.write(tempLine);
                                            }
                                        } else if (tempLine.startsWith("Contact Number : ")) {
                                            System.out.println("\nCurrent contact number: " + tempLine.split(": ")[1]);
                                            System.out.print("Do you want to edit the contact number? (Yes/No): ");
                                            String editChoice = esc.nextLine();
                                            if (editChoice.equalsIgnoreCase("Yes") || editChoice.equalsIgnoreCase("Y")) {
                                                System.out.print("Enter your new contact number: ");
                                                String newContactNumber = esc.nextLine();
                                                writer.write("Contact Number : " + newContactNumber);
                                            } else {
                                                writer.write(tempLine);
                                            }
                                        } else {
                                            writer.write(tempLine);
                                        }
                                        writer.newLine();
                                    }
                                    reader.close();
                                    writer.close();
                                    file.delete();
                                    tempFile.renameTo(file);
                                    System.out.println("\nProfile updated successfully!");
                                } catch (IOException e) {
                                    System.out.println("An error occurred!\n");
                                }
                                break;
                            case 7:
                                return;
                            case 0:
                                System.out.println("\nThank you for using our system.\nCome back next time!\nExiting System...");
                                System.exit(0);
                                break;
                            default:
                                System.out.println("\nSelect from the list only!\n");
                                break;
                        }
                    }
                } else {
                    System.out.print("\nInvalid password!\nDo you want to try again? (Yes/No): ");
                    yesNo = esc.nextLine();
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("\nInvalid username or You don't have an account yet.\nPlease contact the administrator!\n");
            }
        } while (yesNo.equalsIgnoreCase("Yes") || yesNo.equalsIgnoreCase("Y"));
    }
}
public class Main {
    private static Admin admin;
    public static void main(String[] args) {
        Scanner esc = new Scanner(System.in);
        int choice;
        try {
            do {
                System.out.println("\n+===================================+");
                System.out.println("|---------ISUFST BANK SYSTEM--------|");
                System.out.println("|-----WELCOME TO OUR BANK SYSTEM----|");
                System.out.println("+===================================+\n");
                System.out.println("+-----------------------------------+");
                System.out.println("|----------!CHOOSE A TASK!----------|");
                System.out.println("+-----------------------------------+");
                System.out.println("|[1] Admin                          |");
                System.out.println("|[2] Client                         |");
                System.out.println("|[0] Exit Sytem                     |");
                System.out.println("+-----------------------------------+");
                System.out.print(">>> ");
                choice = esc.nextInt();
                switch (choice) {
                    case 1:
                        admin.adminlogin();
                        break;
                    case 2:
                        admin.clientLogin();
                        break;
                    case 0:
                        System.out.println("Thank you for using our system.\nComeback next time!\nExiting System...");
                        System.exit(0);
                        break;
                }
            } while (choice != 0);
        } catch (InputMismatchException i) {
            System.out.println("\nNOTICE : Input number only!\n");
            main(args);
        } catch (Exception e) {
            System.out.println("\nAn Error Occured!\n");
        }
    }
}