package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository

public interface UserRepository extends JpaRepository<User,Long>{
    /*public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Room> roomList = new ArrayList<>();
    public static ArrayList<Hotel> hotelList = new ArrayList<>();
    public static ArrayList<Booking> bookingList = new ArrayList<>();*/

   /* public Repository(ArrayList<User> userList, ArrayList<Room> roomList, ArrayList<Hotel> hotelList, ArrayList<Booking> bookingList) {
        this.userList = userList;
        this.roomList = roomList;
        this.hotelList = hotelList;
        this.bookingList = bookingList;
    }*/

}
