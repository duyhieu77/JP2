package Service;

import Entity.Booking;
import Entity.Customer;
import Entity.Room;
import Entity.RoomType;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingService {
    private List<Booking> bookings;
    private Map<String, Room> roomMap;
    private Map<Integer, Customer> customerMap;

    public BookingService(List<Booking> bookings, List<Room> rooms, List<Customer> customers) {
        this.bookings = bookings;
        this.roomMap = new HashMap<>();
        rooms.forEach(room -> roomMap.put(room.getId(), room));
        this.customerMap = new HashMap<>();
        customers.forEach(customer -> customerMap.put(customer.getId(), customer));
    }

    public Booking bookRoom(String cusName, String cusPhone, RoomType roomType, LocalDateTime checkIn, LocalDateTime checkOut) {
        Room room = roomMap.values().stream()
                .filter(r -> r.getRoomType() == roomType && isRoomAvailable(r.getId(), checkIn, checkOut))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No available room found"));

        Customer customer = customerMap.values().stream()
                .filter(c -> c.getCus_phone().equals(cusPhone))
                .findFirst()
                .orElseGet(() -> {
                    Customer newCustomer = new Customer(customerMap.size() + 1, cusName, cusPhone);
                    customerMap.put(newCustomer.getId(), newCustomer);
                    return newCustomer;
                });

        Booking newBooking = new Booking(bookings.size() + 1, room.getId(), String.valueOf(customer.getId()), checkIn, checkOut);
        bookings.add(newBooking);
        return newBooking;
    }

    private boolean isRoomAvailable(String roomId, LocalDateTime checkIn, LocalDateTime checkOut) {
        return bookings.stream()
                .noneMatch(b -> b.getRoomId().equals(roomId) && checkIn.isBefore(b.getCheckOut()) && checkOut.isAfter(b.getCheckIn()));
    }

    public Booking getBookingInfo(String roomId, String cusPhone) {
        return bookings.stream()
                .filter(b -> b.getRoomId().equals(roomId))
                .filter(b -> {
                    Customer customer = customerMap.get(Integer.parseInt(b.getCustomerId()));
                    return customer != null && customer.getCus_phone().equals(cusPhone);
                })
                .findFirst()
                .orElse(null);
    }

    public double RevenueByRoomType(RoomType roomType) {
        return bookings.stream()
                .filter(b -> roomMap.get(b.getRoomId()).getRoomType() == roomType)
                .mapToDouble(b -> {
                    Room room = roomMap.get(b.getRoomId());
                    long hoursBooked = Duration.between(b.getCheckIn(), b.getCheckOut()).toHours();
                    return hoursBooked * room.getPricePerHour();
                })
                .sum();
    }

    public RoomType RoomTypeWithHighestRevenue2023() {
        return bookings.stream()
                .filter(b -> b.getCheckIn().getYear() == 2023)
                .map(b -> roomMap.get(b.getRoomId()))
                .collect(HashMap<RoomType, Double>::new,
                        (map, room) -> {
                            long hoursBooked = Duration.between(bookings.getFirst().getCheckIn(),bookings.getFirst().getCheckOut()).toHours();
                            map.merge(room.getRoomType(), hoursBooked * room.getPricePerHour(), Double::sum);
                        },
                        HashMap::putAll)
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}