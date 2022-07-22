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
public class UserService extends Repository {
    public User user = new User();

    /*public UserService(ArrayList<User> userList, ArrayList<Room> roomList, ArrayList<Hotel> hotelList, ArrayList<Booking> bookingList) {
        super(userList, roomList, hotelList, bookingList);
    }*/

    public List<User> getAllUsers() {
        return userList;
    }

    public User getOneUserById(int userId) {
        for(User u : userList){
            if(u.id == userId){
                return u;
            }
        }
        return user;
    }

    public User updateOneUser(int userId, User newUser){
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).id == userId){
                userList.set(i,newUser);
            }
        }
        return newUser;
    }

    public void deleteById(int userId) {
        int id = -1;
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).id == userId){
               id = i;
            }
        }
        if(id != -1) {
            userList.remove(id);
        }
        else{
            System.out.println("id not found");
        }
    }

    public User saveOneUser(User newUser) {
        userList.add(newUser);
        return newUser;
    }
}
