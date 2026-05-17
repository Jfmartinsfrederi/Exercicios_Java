package br.edu.ifsp;

public class Game {
    private Player player1;
    private Player player2;
    private Hand[] hands;
    private int numHands;


    public Game(Player player1, Player player2){
        this.player1=player1;
        this.player2=player2;
        this.numHands=0;
        this.hands=new Hand[30];
        this.hands[numHands]=new Hand(player1,player2);



    }

    public void play(){
        String winner;
        if (hands[numHands].isDone()){
            winner=hands[numHands].getWinner();

            if (winner==(player1.getName())) {
                player1.incrementScore();
                System.out.printf("%s Wins\n",player1.getName());
                System.out.println(hands[numHands].getResult());
                hands[++numHands] = new Hand(player1, player2);
            }
            else if (winner==(player2.getName())) {
                player2.incrementScore();
                System.out.printf("%s Wins\n",player2.getName());
                System.out.println(hands[numHands].getResult());
                hands[++numHands] = new Hand(player1, player2);
            }
            else{
                System.out.println("Drawn\n");
                System.out.println(hands[numHands].getResult());
                hands[++numHands] = new Hand(player1, player2);
            }


        }
        else hands[numHands].playRound();

    }

    public boolean isDone(){
        return numHands==30 || player1.getScore()>=12 || player2.getScore()>=12;
    }

    public Player getWinner(){
        if (player1.getScore()>=12) return player1;
        else if (player2.getScore()>=12) return player2;
        else return null;
    }




}
