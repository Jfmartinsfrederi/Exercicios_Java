package br.edu.ifsp;

import br.edu.ifsp.deck.Card;

import java.util.Random;

public class Player {
    private String name;
    private int score;

    private Card[] cards;
    private int numCards;

    public Player(String name){
        this.name=name;
        this.score=0;
        this.cards=new Card[2];
        this.numCards=0;
    }

    public Card chooseCard(){
        return this.cards[numCards++%3];
    }

    public void incrementScore(){
        this.score++;
    }



    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Card[] getCards() {
        return cards;
    }
}
