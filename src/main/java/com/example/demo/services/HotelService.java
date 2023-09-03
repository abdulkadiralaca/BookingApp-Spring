package com.example.demo.services;

import com.example.demo.model.Hotel;
import com.example.demo.model.User;
import com.example.demo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService{
    @Autowired
    HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }


    public Hotel updateOneHotel(int hotelId, Hotel newHotel) {
        Hotel hotelTmp = hotelRepository.findById(Long.valueOf(hotelId)).get();
        hotelTmp.setName(newHotel.getName());
        hotelTmp.setStars(newHotel.getStars());
        hotelTmp.setCity(newHotel.getCity());
        hotelTmp.setRoomCapacity(newHotel.getRoomCapacity());
        hotelRepository.save(hotelTmp);
        return hotelTmp;
    }


    public void deleteById(int hotelId) {
        hotelRepository.deleteById(Long.valueOf(hotelId));
    }

    public Hotel saveOnehotel(Hotel newHotel) {
        hotelRepository.save(newHotel);
        return newHotel;
    }
}
