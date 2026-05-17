import java.util.Random;

public class Team {
    private int size=0;
    private Player[] team=new Player[18];
    private String name;
    private String baseLocation;
    private String coachName;
    private String capitan;
    private int inCamp=0;
    private final String[][] possiblePlayers = PlayersData.PLAYERS;

    public Team(String name, String baseLocation, String coachName){
        Random rand=new Random();
        this.name=name;
        this.baseLocation=baseLocation;
        this.coachName=coachName;
        int i=0,num;
        while (i<18){
            num= rand.nextInt(50);
            Player player;
            if (i<11){
                player=new Player(possiblePlayers[num][0],Integer.parseInt(possiblePlayers[num][1]),possiblePlayers[num][2], true);
            }
            else {
                player=new Player(possiblePlayers[num][0],Integer.parseInt(possiblePlayers[num][1]),possiblePlayers[num][2], false);
            }
            int flag=verifyPlayer(player);
            if (flag==-1) {
                team[i]=player;
                size++;
                i++;
                if (player.isFielded()){
                    inCamp++;
                }
            }
            player=null;


        }
        }




    public void addPlayer(Player player){
        int flag=verifyPlayer(player);
        if (size<18 && flag==-1){
            team[size]=player;
            size++;
        }

    }
    public void removePlayer(Player player){
        int flag=verifyPlayer(player),i;
        if (team[flag].isFielded()) inCamp--;
        if (flag!=-1){
            for (i=flag;i<size-1;i++) team[i]=team[i+1];


        }

        size--;
    }

    public void substitutePlayer(Player substituido, Player starter){
        int flagSub, flagStr;
        flagSub=verifyPlayer(substituido);
        if (flagSub!=-1){
            flagStr =verifyPlayer(starter);
            if (flagSub!=-1){
                if (team[flagSub].isFielded()){
                    if (!team[flagStr].isFielded()){
                        team[flagSub].substitute();
                        team[flagStr].substitute();


                    }
                }
            }
        }

    }

    public void setCapitan(Player player){
        int flag =verifyPlayer(player);

        if (flag !=-1){
            capitan= team[flag].getName();
        }
    }

    public Player[] getFielded(){
        int i,k=0;
        Player[] fielded=new Player[11];
        for (i=0;i<size;i++){
            if (team[i].isFielded()) {
                fielded[k] = team[i];
                k++;
            }

        }
        return fielded;
    }

    public Player[] getOutFielded(){
        int i,k=0;
        Player[] outfielded =new Player[7];
        for (i=0;i<size;i++){
            if (!team[i].isFielded()) {
                outfielded[k] = team[i];
                k++;
            }

        }
        return outfielded;
    }



    public void organizeCamp(){
        int i;
        for (i=0;i<size && inCamp<11;i++){
            if (!team[i].isFielded()){
                team[i].substitute();
                inCamp++;
                }

            }
        }






    private int verifyPlayer(Player player){
        int i;
        for (i=0;i< size;i++){
            if (player.getName()==team[i].getName()) return i;
            if (player.getNumber()==team[i].getNumber()) return i;
        }
        return -1;

    }

    public void showTeam(){
        int i;
        for (i=0;i< size && i<team.length;i++){
            System.out.println(team[i].getStateAsString());
        }
    }

    public void showArrayPlayers(Player[] players){
        int i;
        for (i=0;i<players.length;i++){
            System.out.println(players[i].getStateAsString());
        }
    }







}
