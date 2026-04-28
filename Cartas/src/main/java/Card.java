import java.util.Random;

public class Card {
    private static final String[] SUITS = {"Copas", "Ouros", "Espadas", "Paus"};

    private static final String[] RANKS = {
            "Ás","2","3","4","5","6","7",
            "8","9","10","Valete","Dama","Rei"
    };
    private String suit;
    private String rank;
    private boolean visible;
    Random rand=new Random();

    public Card(int i, int j){

        this.suit=SUITS[i];
        this.rank=RANKS[j];
        this.visible= true;
    }
    public void showCard(){
        if (this.visible) System.out.printf("%s de %s visivel",this.rank,this.suit);

        System.out.println();


    }

}
