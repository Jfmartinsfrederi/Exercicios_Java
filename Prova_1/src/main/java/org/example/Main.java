package org.example;

public class Main {
    public static void main(String[] args) {
        final Useraccont factory =new Useraccont("bigodon","123");
        final Useraccont guilherme= new Useraccont("Bigodin","1234");
        final Useraccont mary= new Useraccont("Mary","12345");

        factory.acceptFollower(guilherme);
        factory.publish("bigos");
        System.out.println(guilherme.timeLIneAsString());
        System.out.println(factory.myPostsAsString());
        factory.clapPost(0);
        guilherme.clapPost(0);
        factory.clapPost(0);
        System.out.println(guilherme.timeLIneAsString());
        System.out.println(factory.myPostsAsString());


    }
}