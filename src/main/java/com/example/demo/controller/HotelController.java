package com.example.demo.controller;

import com.example.demo.model.Hotel;
import com.example.demo.model.User;
import com.example.demo.services.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/hotels")
@RestController
public class HotelController {
    public HotelService hotelService;

    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getAllHotels(){
        return hotelService.getAllHotels();
    }

    @GetMapping("/{hotelId}")
    public Hotel getOneHotel(@PathVariable int hotelId) {
        return hotelService.getOneHotelById(hotelId);
    }

    @PutMapping("/{hotelId}")
    public Hotel updateOneHotel(@PathVariable int hotelId, @RequestBody Hotel newHotel){
        return hotelService.updateOneHotel(hotelId, newHotel);
    }
    @DeleteMapping("/{hotelId}")
    public void deleteHotel(@PathVariable("hotelId") int hotelId){
        hotelService.deleteById(hotelId);

    }

    @PostMapping
    public Hotel createHotel(@RequestBody Hotel newHotel) {
        return hotelService.saveOnehotel(newHotel);
    }
}
