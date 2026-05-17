import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {
    private LocalDate day;
    private LocalTime startTime;
    private LocalTime endTime;
    private Meeting[] meetings;
    private int numberMeetings;

    public Schedule(LocalDate day, LocalTime startTime, LocalTime endTime){
        this.day=day;
        this.startTime=startTime;
        this.endTime=endTime;
        this.meetings=new Meeting[100];
        this.numberMeetings=0;


    }

    public void addMeting(Meeting meeting){
        if (outTimeMeeting(meeting)) return;
        if (searchMeeting(meeting)>=0) return;
        meetings[numberMeetings++]=meeting;

    }

    public void removeMeeting(Meeting meeting){
        int i=searchMeeting(meeting);
        if (i>=0){
            meetings[i]=meetings[numberMeetings-1];
            numberMeetings--;
        }


    }

    public double percentageSpentInMeetings(){
        double timeMeeting=0;
        double timeNoMeeting;
        timeNoMeeting= Duration.between(startTime,endTime).toMinutes();
        for (int i = 0; i < numberMeetings; i++) {
            timeMeeting+=meetings[i].durationInMinutes();

        }

        return (timeMeeting/timeNoMeeting)*100;




    }


    private int searchMeeting(Meeting meeting){
        for (int i = 0; i < numberMeetings; i++) {
            if (meetings[i].getStartTime().equals(meeting.getStartTime())) return i;
            if (meetings[i].getEndTime().equals(meeting.getEndTime())) return i;

        }
        return -1;

    }

    private boolean outTimeMeeting(Meeting meeting) {
        if (meeting.getStartTime().isBefore(startTime)) return true;
        if (meeting.getEndTime().isAfter(endTime)) return true;
        for (int i = 0; i < numberMeetings; i++) {
            if (meetings[i].getStartTime().isAfter(meeting.getStartTime())){
                if (meetings[i].getEndTime().isBefore(meeting.getEndTime())) return true;
            }

        }
        return false;
    }

    public String scheduleAsString(){
        StringBuilder builder=new StringBuilder("Schedule:\n");
        builder.append(day+" ");
        builder.append(startTime+" ");
        builder.append(endTime+"\n");
        for (int i = 0; i < numberMeetings; i++) {
            builder.append(meetings[i].getStartTime()+" ");
            builder.append(meetings[i].getEndTime()+" ");
            builder.append(meetings[i].durationInMinutes()+"minutes Description: ");
            builder.append(meetings[i].getDescription()+"\n");

        }

        return builder.toString();
    }



}
