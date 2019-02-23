package com.leo.henry.messenger.lecture.collections;

public class TheatreMain {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympic",8,12);
        theatre.getSeats();

        if (theatre.reserveSeat("H11"))
        {
            System.out.println("Please pay ");
        }else System.out.println("Sorry, seat is taken");
        if (theatre.reserveSeat("H11"))
        {
            System.out.println("Please pay ");
        }else System.out.println("Sorry, seat is taken");
    }
}
