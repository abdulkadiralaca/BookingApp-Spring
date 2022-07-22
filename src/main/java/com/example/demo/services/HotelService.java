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
public class HotelService extends Repository {
    public Hotel hotel = new Hotel();

    /*public HotelService(ArrayList<User> userList, ArrayList<Room> roomList, ArrayList<Hotel> hotelList, ArrayList<Booking> bookingList) {
        super(userList, roomList, hotelList, bookingList);
    }*/

    public List<Hotel> getAllHotels() {
        return this.hotelList;
    }

    public Hotel getOneHotelById(int hotelId) {
        for(Hotel h : this.hotelList){
            if(h.id == hotelId){
                return h;
            }
        }
        return hotel;
    }


    public Hotel updateOneHotel(int hotelId, Hotel newHotel) {
        for(int i=0; i<this.hotelList.size(); i++){
            if(hotelId == this.hotelList.get(i).id){
                this.hotelList.set(i,newHotel);
            }
        }
        return newHotel;
    }


    public void deleteById(int hotelId) {
        int id=-1;
        for(int i=0; i<this.hotelList.size(); i++){
            if(hotelId == this.hotelList.get(i).id){
                id = i;
            }
        }
        if(id != -1){
            this.hotelList.remove(id);
        }
    }

    public Hotel saveOnehotel(Hotel newHotel) {
        this.hotelList.add(newHotel);
        return newHotel;
    }
}
