package com.example.demo.services;

import com.example.demo.model.Booking;
import com.example.demo.model.Hotel;
import com.example.demo.model.Room;
import com.example.demo.model.User;
import com.example.demo.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService extends Repository {
    public Room room = new Room();
    HotelService hotelService = new HotelService();

    /*public RoomService(ArrayList<User> userList, ArrayList<Room> roomList, ArrayList<Hotel> hotelList, ArrayList<Booking> bookingList) {
        super(userList, roomList, hotelList, bookingList);
    }*/

    public List<Room> getAllRooms() {
        return this.roomList;
    }

    public Room getOneRoomById(int roomId) {
        for(Room r : this.roomList){
            if(r.id == roomId){
                return r;
            }
        }
        return room;
    }
    public Room updateOneRoom(int roomId, Room newRoom) {
        for(int i=0; i<this.roomList.size(); i++){
            if(roomId == this.roomList.get(i).id){
                this.roomList.set(i,newRoom);
            }
        }
        return newRoom;
    }


    public void deleteById(int roomId) {
        int id=-1;
        for(int i=0; i<this.roomList.size(); i++){
            if(roomId == this.roomList.get(i).id){
                id = i;
            }
        }
        if(id != -1){
            this.roomList.remove(id);
        }
    }

    public Room saveOneRoom(Room newRoom, int hotelId) {
        Hotel tempHotel = hotelService.getOneHotelById(hotelId);
//        for(Hotel h : this.hotelList){
//            System.out.println(h.name);
//            if(h.id == hotelId){
//                System.out.println("ı found a hotel : "+ h.name);
//                tempHotel = h;
//            }
//        }
        newRoom.hotel = tempHotel;
        this.roomList.add(newRoom);
        return newRoom;
    }
}
