package br.edu.ifsp;

import br.edu.ifsp.deck.Card;
import br.edu.ifsp.deck.Deck;

public class Hand {
    private Deck deck;
    private Card vira;
    private Player player1;
    private Player player2;

    private Round[] rounds;
    private int numRounds;

    public Hand(Player player1, Player player2){
        this.player1=player1;
        this.player2=player2;
        this.deck= new Deck();
        this.deck.shuffle();
        this.vira=deck.takeOne();
        player1.setCards(deck.take(3));
        player2.setCards(deck.take(3));
        this.rounds=new Round[3];
        this.numRounds=0;

    }

    public void playRound(){
        Round round=new Round(player1.getName(), player1.chooseCard(), player2.getName(), player2.chooseCard(),this.vira);
        //System.out.println(round.getWinner());
        rounds[numRounds++]=round;

    }

    public boolean isDone(){
        return numRounds==3;
    }

    public String getWinner(){
        int play1=0,play2=0;
        for (int i = 0; i < numRounds; i++) {

            switch (i){
                case 0:
                    if (rounds[i].getWinner()==(player1.getName())) play1++;
                    else if (rounds[i].getWinner()==(player2.getName())) play2++;
                    else {
                        if (rounds[i + 1].getWinner()==(player1.getName())) return player1.getName();
                        else if (rounds[i + 1].getWinner()==(player2.getName())) return player2.getName();


                    }
                    break;
                case 1:
                    if (rounds[i].getWinner()==player1.getName()) play1++;
                    else if (rounds[i].getWinner()==(player2.getName())) play2++;
                    else {
                        if (rounds[i - 1].getWinner()==(player1.getName())) return player1.getName();
                        else if (rounds[i - 1].getWinner()==(player2.getName())) return player2.getName();
                        }
                    break;
                case 2:
                    if (rounds[i].getWinner()==(player1.getName())) play1++;
                    else if (rounds[i].getWinner()==(player2.getName())) play2++;
                    else {
                        if (rounds[i - 2].getWinner()==(player1.getName())) return player1.getName();
                        else if (rounds[i - 2].getWinner()==(player2.getName())) return player2.getName();
                    }
                    break;
                    default: break;
            }


        }
        if (play1>play2) return player1.getName();
        else if (play1<play2)  return player2.getName();
        else return null;



    }

    public String getResult(){
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < numRounds; i++) {
            builder.append(rounds[i].getResult());


        }
        return builder.toString();
    }







}




