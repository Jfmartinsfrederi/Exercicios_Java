public class Deck {
    private int tam=52;
    private Card[] deck=new Card[tam];

    public Deck(){
        int i,j,k=0;
        for (i=0;i<4;i++){
            for (j=0;j<13;j++){
                this.deck[k]= new Card(i,j);
                k++;
            }
        }
        tam=52;
    }

    public void showDeck(){
        int i;
        for (i=0;i<tam;i++){
            this.deck[i].showCard();
        }
    }

    public void drawCard(int times){
        if (times<tam){
            tam-=times;

        }
    }


}
