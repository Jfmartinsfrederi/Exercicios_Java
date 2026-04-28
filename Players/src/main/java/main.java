import java.util.Scanner;

public class main {
    static void main(String[] args) {
        Team team;
        Player[] auxArray;
        Player player,player2;
        Scanner scanner=new Scanner(System.in);
        String menu= """
                
                1-Mostrar Time
                2-Adicionar Jogador
                3-Remover Jogador
                4-Substituir Jogador
                5-Mudar Capitão
                6-Mostrar Titulares
                7-Mostrar Reservas
                0-Sair
                \n
                """;
        int opc=-1;
        String val1,val2,val3;
        System.out.println("Gerenciamento de time\nEscreva o nome do time:");
        val1=scanner.nextLine();
        System.out.println("Digite o local do time:");
        val2=scanner.nextLine();
        System.out.println("Digite o nome do técnico:");
        val3=scanner.nextLine();
        team=new Team(val1,val2,val3);
        while (opc!=0){
            System.out.println(menu);
            opc=scanner.nextInt();
            scanner.nextLine();
            team.organizeCamp();
            switch (opc){
                case 1: team.showTeam();
                break;
                case 2:
                    System.out.println("Digite o nome do jogador:");
                    val1=scanner.nextLine();
                    System.out.println("Digite o número da sua camisa:");
                    val2=scanner.nextLine();
                    System.out.println("Digite sua posição:");
                    val3=scanner.nextLine();
                    player=new Player(val1,Integer.parseInt(val2),val3,false);
                    team.addPlayer(player);

                    break;
                case 3:
                    System.out.println("Digite o nome do jogador:");
                    val1=scanner.nextLine();
                    System.out.println("Digite o número da sua camisa:");
                    val2=scanner.nextLine();
                    System.out.println("Digite sua posição:");
                    val3=scanner.nextLine();
                    player=new Player(val1,Integer.parseInt(val2),val3,false);
                    team.removePlayer(player);
                    break;
                case 4:
                    System.out.println("Digite o nome do jogador:");
                    val1=scanner.nextLine();
                    System.out.println("Digite o número da sua camisa:");
                    val2=scanner.nextLine();
                    System.out.println("Digite sua posição:");
                    val3=scanner.nextLine();
                    player=new Player(val1,Integer.parseInt(val2),val3,false);
                    System.out.println("Digite o nome do jogador:");
                    val1=scanner.nextLine();
                    System.out.println("Digite o número da sua camisa:");
                    val2=scanner.nextLine();
                    System.out.println("Digite sua posição:");
                    val3=scanner.nextLine();
                    player2=new Player(val1,Integer.parseInt(val2),val3,false);
                    team.substitutePlayer(player,player2);

                    break;
                case 5:
                    System.out.println("Digite o nome do jogador:");
                    val1=scanner.nextLine();
                    System.out.println("Digite o número da sua camisa:");
                    val2=scanner.nextLine();
                    System.out.println("Digite sua posição:");
                    val3=scanner.nextLine();
                    player=new Player(val1,Integer.parseInt(val2),val3,false);
                    team.setCapitan(player);
                    break;
                case 6:
                    auxArray=team.getFielded();
                    team.showArrayPlayers(auxArray);
                    break;
                case 7:
                    auxArray=team.getOutFielded();
                    team.showArrayPlayers(auxArray);

                    break;

                case 0:
                    System.out.println("Encerrando programa");
                    break;


                default:
                    System.out.println("Opção inválida");
            }

        }

    }
}
