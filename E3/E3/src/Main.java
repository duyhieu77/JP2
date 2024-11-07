import Entity.Booking;
import Entity.Customer;
import Entity.Room;
import Entity.RoomType;
import Service.BookingService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("RS001", RoomType.Single, 8));
        rooms.add(new Room("RD001", RoomType.Double, 12));
        rooms.add(new Room("RQ002", RoomType.Queen, 35));
        rooms.add(new Room("RT001", RoomType.Triple, 12.5));
        rooms.add(new Room("RQ001", RoomType.Quad, 20.5));

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Mr.Linus Tovaldo", "84125325346457"));
        customers.add(new Customer(2, "Mr.Bill", "91124235346467"));
        customers.add(new Customer(3, "Mr.Turing", "911423534646"));

        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking(1, "RS001", "1", LocalDateTime.parse("2023-03-15T09:30:15"), LocalDateTime.parse("2023-03-16T12:30:45")));
        bookings.add(new Booking(2, "RS001", "2", LocalDateTime.parse("2023-06-09T19:30:25"), LocalDateTime.parse("2023-06-10T11:25:15")));
        bookings.add(new Booking(3, "RD001", "2", LocalDateTime.parse("2023-03-11T10:10:05"), LocalDateTime.parse("2023-03-13T11:05:10")));
        bookings.add(new Booking(4, "RT001", "3", LocalDateTime.parse("2023-11-11T11:11:15"), LocalDateTime.parse("2023-11-13T11:15:15")));
        bookings.add(new Booking(5, "RT001", "1", LocalDateTime.parse("2023-10-25T09:20:25"), LocalDateTime.parse("2023-10-26T12:25:30")));
        bookings.add(new Booking(6, "RQ001", "1", LocalDateTime.parse("2023-08-18T18:25:35"), LocalDateTime.parse("2023-08-19T11:35:20")));

        Scanner scanner = new Scanner(System.in);
        BookingService bookingService = new BookingService(bookings, rooms, customers);

        while (true) {
            System.out.println("Make your choices: ");
            System.out.println("1. Booking");
            System.out.println("2. Display booking information");
            System.out.println("3. Revenue statistics by room type");
            System.out.println("4. Display the room type with the highest revenue in 2023");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Customer Name: ");
                    String cusName = scanner.nextLine();
                    System.out.println("Enter Customer Phone: ");
                    String cusPhone = scanner.nextLine();
                    System.out.println("Select Room Type (Single, Double, Queen, Triple, Quad): ");
                    RoomType roomType = RoomType.valueOf(scanner.nextLine());

                    System.out.println("Enter Check-in Time (yyyy-MM-dd'T'HH:mm): ");
                    LocalDateTime checkIn = LocalDateTime.parse(scanner.nextLine());
                    System.out.println("Enter Check-out Time (yyyy-MM-dd'T'HH:mm): ");
                    LocalDateTime checkOut = LocalDateTime.parse(scanner.nextLine());

                    Booking newBooking = bookingService.bookRoom(cusName, cusPhone, roomType, checkIn, checkOut);
                    System.out.println("Booking successful: " + newBooking);
                    break;

                case 2:
                    System.out.println("Enter Room ID: ");
                    String roomId = scanner.nextLine();
                    System.out.println("Enter Customer Phone: ");
                    String bCusPhone = scanner.nextLine();
                    Booking booking = bookingService.getBookingInfo(roomId, bCusPhone);
                    System.out.println(booking != null ? booking : "Room Not found");
                    break;

                case 3:
                    System.out.println("Enter Room Type Single, Double, Queen, Triple, Quad: ");
                    RoomType revenueRoomType = RoomType.valueOf(scanner.nextLine());
                    double totalRevenue = bookingService.RevenueByRoomType(revenueRoomType);
                    System.out.println("Total Revenue for " + revenueRoomType + ": " + totalRevenue);
                    break;

                case 4:
                    RoomType highestRevenueRoom = bookingService.RoomTypeWithHighestRevenue2023();
                    System.out.println("Room type with highest revenue in 2023: " + highestRevenueRoom);
                    break;

                case 0:
                    System.out.println("Exit");
                    scanner.close();
                    return;

                default:
                    System.out.println("Error, try again");
            }
        }
    }
}