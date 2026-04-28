import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

public class Event {
    private String title;
    private String description;
    private LocalDateTime eventDate;
    private LocalDateTime createdAt;
    private User creator;



    private User[] confirmateds;
    private int confirmations;

    private User[] cancelateds;
    private int cancelations;




    public Event(String title, String description ,LocalDateTime eventDate, User creator){
        this.title=title;
        this.description=description;
        this.eventDate=eventDate;
        this.creator=creator;
        this.createdAt=LocalDateTime.now();
        this.confirmateds=new User[100];
        this.confirmations=0;
        this.cancelateds=new User[100];
        this.cancelations=0;

    }



    public void confirm(User user){
        int index;
        index=verificateConfirm(user);
        if (index<0) {
            confirmateds[confirmations++] = user;
        }
        index=verificateCancel(user);
        if (index>=0){
            cancelateds[index]=cancelateds[cancelations-1];
            cancelateds[cancelations-1]=null;
            cancelations--;

        }



    }

    public void cancel(User user){
        int index;
        index=verificateCancel(user);
        if (index<0) {
            cancelateds[cancelations++] = user;
        }
        index=verificateConfirm(user);
        if (index>=0){
            confirmateds[index]=confirmateds[confirmations-1];
            confirmateds[confirmations-1]=null;
            confirmations--;

        }

    }


    public String showEvent(){
        String event;
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");


        event= """ 
                %s %s created "%s"
                Description: %s
                Created at: %s
                Confirmations: %s %s
                Cancellations: %s %s
                Status: %s\n
                """.formatted(this.getEventDate().format(formatter),this.getCreator().getName(),this.getTitle(),this.getDescription(),this.createdAt.format(formatter),this.getConfirmations(),this.getConfirmateds(),this.getCancelations(),this.getCancelateds(),this.getStatus());
        return event;
    }


    private int verificateConfirm(User user){
        for (int i = 0; i < confirmations; i++) {
            if (user.equals(confirmateds[i])) return i;

        }
        return -1;
    }

    private int verificateCancel(User user){
        for (int i = 0; i < cancelations; i++) {
            if (user.equals(cancelateds[i])) return i;

        }
        return -1;
    }

    public int getConfirmations() {
        return confirmations;
    }

    public String getConfirmateds() {
        StringJoiner joiner= new StringJoiner(",","Confirmateds:","");
        for (int i = 0; i < confirmations; i++) {
            joiner.add(confirmateds[i].getName());
        }
        return joiner.toString();
    }



    public int getCancelations() {
        return cancelations;
    }

    public String getCancelateds() {
        StringJoiner joiner= new StringJoiner(",","Cancelateds:","");
        for (int i = 0; i < cancelations; i++) {
            joiner.add(cancelateds[i].getName());
        }
        return joiner.toString();
    }

    public String getStatus(){
        if (this.getEventDate().isBefore(LocalDateTime.now())) return "Past";
        else return "Upcoming";
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User getCreator() {
        return creator;
    }

}
