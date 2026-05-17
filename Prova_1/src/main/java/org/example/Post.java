package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private Useraccont useraccont;
    private String quote;
    private LocalDateTime timestamp;
    private int clap;
    private int boo;

    public Post(Useraccont user, String quote){
        this.useraccont=user;
        this.quote=quote;
        this.timestamp=LocalDateTime.now();


    }



    public String getAsString(){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yy - hh/mm");
        return String.format("[%s] %s says \"%s\" | Claps: %d | Boos: %d", formatter.format(timestamp), useraccont.getUserName(),quote,clap,boo);

    }

    public void clap(){
        clap++;

    }

    public void boo(){
        boo++;

    }




    public String getQuote() {
        return quote;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getClap() {
        return clap;
    }

    public int getBoo() {
        return boo;
    }

    public String getUserName(){
        return useraccont.getUserName();
    }

}
