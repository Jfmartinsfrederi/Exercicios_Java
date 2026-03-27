import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    static void main(String[] args) {
        Schedule schedule=new Schedule(LocalDate.now(), LocalTime.of(12,45), LocalTime.of(17,25));
        Meeting meeting=new Meeting("1223",LocalTime.of(12,55),LocalTime.of(13,25));
        Meeting meeting2=new Meeting("1223",LocalTime.of(14,55),LocalTime.of(15,55));
        Meeting meeting3=new Meeting("1223",LocalTime.of(11,55),LocalTime.of(13,25));
        Meeting meeting4=new Meeting("1223",LocalTime.of(12,55),LocalTime.of(18,25));
        Meeting meeting5=new Meeting("1223",LocalTime.of(16,30),LocalTime.of(17,00));
        Meeting meeting6=new Meeting("1223",LocalTime.of(12,55),LocalTime.of(13,25));
        schedule.addMeting(meeting);
        schedule.addMeting(meeting2);
        schedule.addMeting(meeting3);
        schedule.addMeting(meeting4);
        schedule.addMeting(meeting5);
        schedule.removeMeeting(meeting5);


        System.out.println( schedule.scheduleAsString());
        System.out.printf("%.2f%%",schedule.percentageSpentInMeetings());

    }
}
