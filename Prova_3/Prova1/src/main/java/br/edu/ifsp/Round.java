package br.edu.ifsp;

import br.edu.ifsp.deck.Card;

public class Round {
    private String winner;
    private String result;

    public Round(String player1, Card card1, String player2,Card card2, Card vira){
        if (card1.compareValueTo(card2,vira)>0) {
            this.winner = player1;
            result="%s:%s%s > %s:%s%s vira:%s%s\n".formatted(player1,card1.getRank(),card1.getSuit(),player2,card2.getRank(),card2.getSuit(),vira.getRank(),vira.getSuit());

        }
        else if (card1.compareValueTo(card2,vira)<0) {
            this.winner = player2;
            result="%s:%s%s > %s%s vira:%s%s\n".formatted(player2,card2.getRank(),card2.getSuit(),player1,card1.getRank(),card1.getSuit(),vira.getRank(),vira.getSuit());
        }
        else {
            this.winner = null;
            result="Draw\n";
        }
    }

    public String getWinner() {
        return winner;
    }

    public String getResult(){
        return result;
    }
}
