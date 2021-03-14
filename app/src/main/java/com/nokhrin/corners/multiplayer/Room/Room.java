package com.nokhrin.corners.multiplayer.Room;

//this for save in database
public class Room {
    public String close;
    public String messageMoveTo;
    public String player1;
    public String player2;

    public Room() {
    }

    public Room(String close, String messageMoveTo, String player1, String player2) {
        this.close = close;
        this.messageMoveTo = messageMoveTo;
        this.player1 = player1;
        this.player2 = player2;
    }
}
