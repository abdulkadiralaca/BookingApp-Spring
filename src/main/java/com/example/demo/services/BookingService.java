package com.example.demo.services;

import com.example.demo.model.Booking;
import com.example.demo.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class BookingService extends Repository {
    public Booking booking = new Booking();
    RoomService roomService = new RoomService();
    UserService userService = new UserService();
    int id = -1;

   /* public BookingService(ArrayList<User> userList, ArrayList<Room> roomList, ArrayList<Hotel> hotelList, ArrayList<Booking> bookingList) {
        super(userList, roomList, hotelList, bookingList);
    }*/

    public Booking createBooking(int userId, int roomId, int duration) {
        Booking tempBooking = new Booking();
        tempBooking.user = userService.getOneUserById(userId);
        tempBooking.room = roomService.getOneRoomById(roomId);
        tempBooking.id = ++id;
        tempBooking.startDate = java.time.LocalDate.now();
        Date today = new Date();
        tempBooking.endDate = new Date(today.getTime() + (1000 * 60 * 60 * 24 * duration));
        tempBooking.durationDay = duration;
        tempBooking.payment = duration*tempBooking.room.price;
        this.bookingList.add(tempBooking);
        return tempBooking;
    }

    public Booking getOneBooking(int bookingId) {
        for(Booking b : this.bookingList){
            if(b.id == bookingId){
                return b;
            }
        }
        return booking;
    }

    public ArrayList<Booking> getAllBookings() {
        return this.bookingList;
    }

    public Booking updateBooking(int bookingId, Booking newBooking) {
        for(int i = 0; i < this.bookingList.size(); i++){
            if(this.bookingList.get(i).id == bookingId){
                this.bookingList.set(i,newBooking);
            }
        }
        return newBooking;
    }

    public void deleteBooking(int bookingId) {
        int id=-1;
        for(int i=0; i<this.bookingList.size(); i++){
            if(bookingId == this.bookingList.get(i).id){
                id = i;
            }
        }
        if(id != -1){
            this.bookingList.remove(id);
        }
    }
}
