package com.example.demo.services;

import com.example.demo.model.Hotel;
import com.example.demo.model.Room;
import com.example.demo.model.User;
import com.example.demo.repository.RoomRepository;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService{
    @Autowired
    HotelService hotelService;
    @Autowired
    RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room updateOneRoom(int roomId, Room newRoom) {
        Room roomTmp = roomRepository.findById(Long.valueOf(roomId)).get();
        roomTmp.setHotel(newRoom.getHotel());
        roomTmp.setRoomNumber(newRoom.getBedCapacity());
        roomTmp.setPrice(newRoom.getPrice());
        roomRepository.save(roomTmp);
        return roomTmp;
    }


    public void deleteById(int roomId) {
        roomRepository.deleteById(Long.valueOf(roomId));
    }

    public Room saveOneRoom(Room newRoom, int hotelId) {
        Hotel hotel = hotelService.hotelRepository.findById(Long.valueOf(hotelId)).get();
        newRoom.setHotel(hotel);
        roomRepository.save(newRoom);
        return newRoom;
    }
}
