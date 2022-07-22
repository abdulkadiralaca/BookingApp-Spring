package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Booking {
    public int id;
    public User user;
    public Room room;
    public LocalDate startDate;
    public Date endDate; //
    public int durationDay;

    public int payment;
}
