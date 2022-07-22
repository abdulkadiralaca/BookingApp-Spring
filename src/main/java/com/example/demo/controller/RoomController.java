package com.example.demo.controller;

import com.example.demo.model.Hotel;
import com.example.demo.model.Room;
import com.example.demo.model.User;
import com.example.demo.services.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rooms")
@RestController
public class RoomController {

    public RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/{roomId}")
    public Room getOneRoom(@PathVariable int roomId) {
        return roomService.getOneRoomById(roomId);
    }

    @PutMapping("/{roomId}")
    public Room updateOneRoom(@PathVariable int roomId, @RequestBody Room newRoom){
        return roomService.updateOneRoom(roomId, newRoom);
    }
    @DeleteMapping("/{roomId}")
    public void deleteRoom(@PathVariable("roomId") int roomId){
        roomService.deleteById(roomId);
    }

    @PostMapping
    public Room createRoom(@RequestBody Room newRoom, @RequestParam(name = "hotelId") int hotelId) {
        return roomService.saveOneRoom(newRoom, hotelId);
    }
}
