public class Player {
    private String name;
    private int number;
    private String position;
    private boolean isFielded;


    public Player(String name,int number, String position, boolean isFielded){
        this.name=name;
        this.number=number;
        this.position=position;
        this.isFielded=isFielded;
    }

    public String getStateAsString(){
        String state;
        if (this.isFielded){
             state= "%s camisa:%d %s em campo\n".formatted(this.name,this.number,this.position);

       }
        else {
             state= "%s camisa:%d %s no banco\n".formatted(this.name,this.number,this.position);
        }
        return state;
    }

    public String getName(){
        return this.name;

    }

    public int getNumber(){
        return this.number;
    }

    public boolean isFielded() {
        return this.isFielded;
    }

    public void substitute(){
        this.isFielded=!this.isFielded;
    }

}
