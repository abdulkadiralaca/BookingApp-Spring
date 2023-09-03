package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.model.Room;
import com.example.demo.model.User;
import com.example.demo.services.BookingService;
import com.example.demo.services.HotelService;
import com.example.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/bookings")
@RestController
public class BookingController {
    public BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking createBooking(@RequestParam int userId, @RequestParam int roomId, @RequestParam int duration){
        return bookingService.createBooking(userId, roomId, duration);
    }

    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @PutMapping("/{bookingId}")
    public Booking updateBooking(@PathVariable int bookingId, @RequestBody Booking newBooking){
        return bookingService.updateBooking(bookingId, newBooking);
    }

    @DeleteMapping
    public void deleteBooking(@PathVariable int bookingId){
        bookingService.deleteBooking(bookingId);
    }

}
