import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Deck deck=new Deck();
        int opc=-1;
        Scanner scanner=new Scanner(System.in);
        String menu= """
                1- Ver Baralho
                2- Trocar Baralho
                3- Trocar última carta
                4- Tirar ultima carta
                0- Sair
                """;
        while (opc!=0){
            System.out.println(menu);
            opc=scanner.nextInt();

            switch (opc){
                case 1: deck.getDeck();
                break;
                case 2: deck=new Deck();
                break;
                case 3: deck.oneCard();
                break;
                case 4: deck.giveCard();
                break;

                case 0:
                    System.out.println("Encerrando programa");
                    break;
                default:
                    System.out.println("Inválido");
            }
        }






    }
}


/*EXERCÍCIO
Crie uma classe Card que represente uma carta de baralho. Essa classe deve ter como atributos o
naipe (suit), o valor (rank) e um booleano para indicar se ela está visível ou encoberta. Crie um
método na classe Card para representar o estado do objeto com uma String. Na sequência, crie
uma classe que represente um baralho (Deck) completo, mas sem curingas. A classe Deck deve ter
métodos para pegar um carta por vez ou várias cartas ao mesmo tempo. Ao distribuir uma carta,
ela deixa de fazer parte do baralho.*/