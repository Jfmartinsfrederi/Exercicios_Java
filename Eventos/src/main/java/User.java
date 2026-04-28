import java.time.LocalDateTime;

public class User {
    private String name;
    private String email;

    private Event[] events;
    private int numEvents;

    private User[] followers;
    private int numFollowers;

    private User[] following;
    private int numFollowing;

    private Event[] timeline;
    private int numtimeline;

    private User[] blockedUsers;
    private int numBlockedUsers;


    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.events = new Event[100];
        this.numEvents = 0;
        this.followers = new User[100];
        this.numFollowers = 0;
        this.following = new User[100];
        this.numFollowing = 0;
        this.timeline = new Event[10];
        this.numtimeline = 0;
        this.blockedUsers = new User[100];
        this.numBlockedUsers = 0;
    }

    public void publish(String title, String description ,LocalDateTime eventDate){
        int index;
        index=verifyEvents(eventDate);
        if (index>0) return;
        Event event = new Event(title, description, eventDate, this);
        events[numEvents++]=event;
        for (int i = 0; i < numFollowers; i++) {
            followers[i].updateTimeline(event);

        }


    }

    public void editEvent(int index, String newTitle, String newDescription, LocalDateTime newDate){
        if (newDate.isBefore(LocalDateTime.now())) return;
        if (verifyEvents(newDate)>0) return;
        events[index]=new Event(newTitle,newDescription,newDate,this);
    }

    public void follow(User user){
        if (verifyFollowing(user)>0) return;
        following[numFollowing++]=user;
        user.followers[user.numFollowers++]=this;

    }

    public void block(User user){
        int index=verifyFollowers(user);
        if (index<0) return;
        followers[index]=followers[numFollowers-1];
        followers[numFollowers-1]=null;
        numFollowers--;
        blockedUsers[numBlockedUsers++]=user;

    }




    private void updateTimeline(Event event){
        timeline[numtimeline%10]=event;
        numtimeline++;

    }

    public void removePastEvents(){
        for (int i = 0; i < Math.min(numtimeline, 10); i++) {
            if (timeline[i].getEventDate().isBefore(LocalDateTime.now())){
                for (int j = i; j <numtimeline-1 ; j++) {
                    timeline[j]=timeline[j+1];

                }
                numtimeline--;
            }

        }
    }

    public void sortTimelineByDate(){
        Event aux;
        for (int i = 0; i < Math.min(numtimeline, 10); i++) {
            for (int j = 0; j < Math.min(numtimeline, 10); j++) {
                if (timeline[i].getEventDate().isBefore(timeline[j].getEventDate())){
                    aux=timeline[j];
                    timeline[j]=timeline[i];
                    timeline[i]=aux;

                }


            }

        }
    }


    public void confirm(int index){
        if (timelineExists(index)) return;
        if (indexOutTimeline(index)) return;
        if (isPastEvent(index)) return;

        timeline[index].confirm(this);

    }

    public void cancel(int index){
        if (timelineExists(index)) return;
        if (indexOutTimeline(index)) return;
        if (isPastEvent(index)) return;

        timeline[index].cancel(this);

    }

    private boolean timelineExists(int index) {
        return timeline[index] == null;
    }

    private int verifyFollowing(User user){
        for (int i = 0; i < numFollowing; i++) {
            if (following[i].equals(user)) return i;

        }
        return -1;
    }

    private int verifyFollowers(User user){
        for (int i = 0; i < numFollowers; i++) {
            if (followers[i].equals(user)) return i;

        }
        return -1;

    }

    private int verifyEvents(LocalDateTime eventDate){
        for (int i = 0; i < numEvents; i++) {
            if (events[i].getEventDate().equals(eventDate)) return i;

        }
        return -1;

    }

    private boolean isPastEvent(int index) {
        return timeline[index].getEventDate().isBefore(LocalDateTime.now());
    }

    private boolean indexOutTimeline(int index) {
        return index < 0 || index > Math.min(numtimeline, 10);
    }

    public String showTimeline(){
        StringBuilder builder=new StringBuilder("Timeline:\n");
        for (int i = 0; i < Math.min(numtimeline, 10); i++) {
            builder.append(timeline[i].showEvent());

        }
        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


}
