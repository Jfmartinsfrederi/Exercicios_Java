public class Deck {
    private Card[] deck=new Card[3];
    private int num=2;
    private int i;

    public void oneCard(){
        if (num<3 && num>-1){
            this.deck[num]=new Card();
            if (num<2) num++;
        }

    }

    public Deck(){
        for (i=0;i<=num;i++){
            this.deck[i]=new Card();
        }

    }

    public void getDeck(){
        for (i=0;i<=num;i++){
           this.deck[i].showCard();
        }
    }

    public void giveCard(){
        if (num>-1) this.num--;
        System.out.println(num);

    }


}


