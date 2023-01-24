/** 
 *  Hotel Booking
 *  
 *  @author PP-Namias
 *  
 *  Licensed under the MIT
 *  
 */ 
/** 
 * @param [bookedList] the booked list.
 * @param [scanner] the scanner for user input.
 * @param [str] the string to check.
 */
/*
 *  Features:
 *      -> Add Room
 *      -> Remove Room
 *      -> View Available Rooms
 *      -> Exit
 *  
 *  [Future Features]
 *  Admin 
 *      -> create Room
 *      -> display Room
 *      -> search Room
 *      -> update Room
 *      -> delete Room
 *  
 *  Public
 *      -> Add Room
 *      -> Purchase Room
 *      -> Remove Room
 *      -> View Room
 *      -> Exit
 *  
 *  System:
 *      -> [Login History]
 *      -> [Product Information]
 *      -> [Product Order History]
 *  
*/ 
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel_Booking {
    public static void main(String[] args) {
        ArrayList<Room> bookedList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("____________________________");
            System.out.println("| Welcome to Hotel Booking |");
            System.out.println("----------------------------");
            System.out.println("[ 1 ] Add Room");
            System.out.println("[ 2 ] Remove Room");
            System.out.println("[ 3 ] View Available Rooms");
            System.out.println("[ 4 ] Exit");
            System.out.print(">>>: ");
            choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addRoom(bookedList, scanner);
                    break;
                case "2":
                    removeRoom(bookedList, scanner);
                    break;
                case "3":
                    viewAvailableRooms(bookedList);
                    break;
                case "4":
                    System.out.println("Thank you");
                    System.exit(0);
            }
        } while (true);
    }

    /**
     * Adds a room to the bookedList.
     * @param bookedList the booked list where the room will be added.
     * @param scanner the scanner for user input.
     */
    private static void addRoom(ArrayList<Room> bookedList, Scanner scanner) {
        int roomNumber;
        boolean isAvailable = false;
        System.out.println("____________");
        System.out.println("| Add Room |");
        System.out.println("------------");
        System.out.print("Enter Room Number: ");
        String temporaryRoomNumber = scanner.nextLine().trim();
        if (isNumber(temporaryRoomNumber)) {
            roomNumber = Integer.parseInt(temporaryRoomNumber);
            System.out.print("Is the room available? (Y | N): ");
            String choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase("Y")) {
                isAvailable = true;
            }
            bookedList.add(new Room(roomNumber, isAvailable)); // add a new room to the list.
        }
        else System.out.println("Please enter a number");
    }

    /**
     * Prints all the available rooms.
     * @param bookedList the booked list.
     */
    private static void viewAvailableRooms(ArrayList<Room> bookedList) {
        if (bookedList.isEmpty()) System.out.println("No Rooms Available");
        else {
            System.out.println("___________________");
            System.out.println("| Available Rooms |");
            System.out.println("-------------------");
            for (Room room : bookedList) {
                if (room.isAvailable()) System.out.println(room);
            }
        }
    }

    /**
     * Removes an available room from the booked list.
     * @param bookedList the booked list where the available rooms are.
     * @param scanner the scanner for user input.
     */
    private static void removeRoom(ArrayList<Room> bookedList, Scanner scanner) {
        System.out.print("Enter room number to remove: ");
        String temporaryRoomNumber = scanner.nextLine().trim();
        if (isNumber(temporaryRoomNumber)) {
            int roomNumber = Integer.parseInt(temporaryRoomNumber);
            // removes the available room from the booked list.
            bookedList.remove(new Room(roomNumber, true));
        }
    }
    /**
     * Checks if a string is a positive number.
     * @param str the string to check.
     * @return true if it is a positive number.
     */
    private static boolean isNumber(String str) {
        return Pattern.compile("^\\d+$").matcher(str).matches();
    }

    static class Room {

        private int roomNumber;
        private boolean isAvailable;

        public Room(int roomNumber, boolean isAvailable) {
            this.roomNumber = roomNumber;
            this.isAvailable = isAvailable;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void setAvailable(boolean available) {
            isAvailable = available;
        }

        @Override
        public String toString() {
            return "Room Number: " + getRoomNumber();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Room room = (Room) o;
            return roomNumber == room.roomNumber && isAvailable == room.isAvailable;
        }

        @Override
        public int hashCode() {
            return Objects.hash(roomNumber, isAvailable);
        }
    }
}