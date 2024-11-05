import Entity.Booking;
import Entity.Customer;
import Entity.Room;
import Entity.RoomType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("RS001", RoomType.Single,8));
        rooms.add(new Room("RD001", RoomType.Double,12));
        rooms.add(new Room("RQ002", RoomType.Queen,35));
        rooms.add(new Room("RT001", RoomType.Triple,12.5));
        rooms.add(new Room("RQ001", RoomType.Quad,20.5));

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(001, "Mr.Linus Tovaldo", "84125325346457"));
        customers.add(new Customer(002, "Mr.Bill", "91124235346467"));
        customers.add(new Customer(003, "Mr.Turing", "911423534646"));

        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking(1, "RS001", "001", LocalDateTime.parse("2023-03-15T09:30:15"), LocalDateTime.parse("2023-03-16T12:30:45")));
        bookings.add(new Booking(2, "RS001", "002", LocalDateTime.parse("2023-06-09T19:30:25"), LocalDateTime.parse("2023-06-10T11:25:15")));
        bookings.add(new Booking(3, "RD001", "002", LocalDateTime.parse("2023-03-11T10:10:05"), LocalDateTime.parse("2023-03-13T11:05:10")));
        bookings.add(new Booking(4, "RT001", "003", LocalDateTime.parse("2023-11-11T11:11:15"), LocalDateTime.parse("2023-11-13T11:15:15")));
        bookings.add(new Booking(5, "RT001", "001", LocalDateTime.parse("2023-10-25T09:20:25"), LocalDateTime.parse("2023-10-26T12:25:30")));
        bookings.add(new Booking(6, "RQ001", "001", LocalDateTime.parse("2023-08-18T18:25:35"), LocalDateTime.parse("2023-08-19T11:35:20")));


    }
}