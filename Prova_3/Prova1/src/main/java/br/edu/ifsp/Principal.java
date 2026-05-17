package br.edu.ifsp;

public class Principal {
    public static void main(String[] args) {
        Player player1,player2;
        player1=new Player("Pingu");
        player2=new Player("Pocoyo");
        Game game=new Game(player1,player2);
        int i=0;
       while (!game.isDone()) {
           game.play();
           i++;
       }
        System.out.println(game.getWinner().getName());
        System.out.println(i);

        System.out.println("Finished");

    }

}


