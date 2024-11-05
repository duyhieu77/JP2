package Entity;

import java.time.LocalDateTime;

public class Booking {
    private int id;
    private String room_id;
    private String cus_id;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public Booking(int id, String room_id, String cus_id, LocalDateTime checkIn, LocalDateTime checkOut) {
        this.id = id;
        this.room_id = room_id;
        this.cus_id = cus_id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }
}
