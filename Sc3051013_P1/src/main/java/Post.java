import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Post {
    private String quote;
    private LocalDate date;
    private int claps;
    private int boos;



    private String userName;

    public Post (UserAccount user, String quote){
        this.quote=quote;
        this.userName=user.getUserName();
        this.claps=0;
        this.boos=0;
        this.date=LocalDate.now();
    }


    public String showPost(){
        return String.format("[%s] %s says %s |Claps:%d| |Boos:%d| ",this.date.format(DateTimeFormatter.ofPattern("dd/MM/aa hh/mm")),this.userName,this.quote,this.claps,this.boos);

    }



    public String getUserName() {
        return userName;
    }

    public String getQuote() {
        return quote;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getClaps() {
        return claps;
    }

    public int getBoos() {
        return boos;
    }
}
