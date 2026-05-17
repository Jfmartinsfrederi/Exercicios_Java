import java.util.Random;

public class Card {
    private int suit, rank;
    private boolean visible;
    private String text;
    private final String[] suits = {"Ouros", "Espadas", "Copas", "Paus"};
    private final String[] cards = {
            "4", "5", "6", "7",
            "Dama", "Valete", "Rei",
            "Ás", "2", "3"
    };
    private final Random rand = new Random();


     public Card (){

         this.suit=rand.nextInt(4);
         this.rank= rand.nextInt(10);
         this.visible= rand.nextBoolean();

    }

    public void showCard(){
       if (this.visible){
           text= """
               %s de %s visível
               """.formatted(cards[this.rank],suits[this.suit]);
       }
       else {
           text= """
               %s de %s oculta
               """.formatted(cards[this.rank],suits[this.suit]);
       }
        System.out.println(text);

    }


}
