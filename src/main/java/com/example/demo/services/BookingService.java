package com.example.demo.services;

import com.example.demo.model.Booking;
import com.example.demo.model.Room;
import com.example.demo.model.User;
import com.example.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService{
    @Autowired
    RoomService roomService;
    @Autowired
    UserService userService;

    @Autowired
    BookingRepository bookingRepository;


    public Booking createBooking(int userId, int roomId, int duration) {
        Booking tempBooking = new Booking();
        Optional<Room> roomTmp = roomService.roomRepository.findById((long) roomId);
        roomTmp.ifPresent(tempBooking::setRoom);
        Optional<User> userTmp = userService.userRepository.findById((long) userId);
        userTmp.ifPresent(tempBooking::setUser);
        Date today = new Date();
        tempBooking.setStartDate(java.time.LocalDate.now());
        tempBooking.setEndDate(new Date(today.getTime() + (1000 * 60 * 60 * 24 * duration)));
        tempBooking.setDurationDay(duration);
        tempBooking.setPayment(duration*tempBooking.room.getPrice());
        bookingRepository.save(tempBooking);
        return tempBooking;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking updateBooking(int bookingId, Booking newBooking) {
        Booking bookingTmp = bookingRepository.findById(Long.valueOf(bookingId)).get();
        Optional<Room> roomTmp = roomService.roomRepository.findById(newBooking.room.getId());
        roomTmp.ifPresent(bookingTmp::setRoom);
        Optional<User> userTmp = userService.userRepository.findById(newBooking.user.getId());
        userTmp.ifPresent(bookingTmp::setUser);
        if(bookingRepository.findById(Long.valueOf(bookingId)).get().getDurationDay() != newBooking.getDurationDay()){
            bookingTmp.setDurationDay(newBooking.getDurationDay());
            Date today = new Date();
            bookingTmp.setEndDate(new Date(today.getTime() + (1000L * 60 * 60 * 24 * newBooking.getDurationDay())));
            bookingTmp.setPayment(newBooking.getDurationDay()*newBooking.room.getPrice());
        }
        bookingRepository.save(bookingTmp);
        return bookingTmp;
    }

    public void deleteBooking(int bookingId) {
        bookingRepository.deleteById((long) bookingId);
    }
}
