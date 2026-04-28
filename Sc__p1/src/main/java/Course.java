import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Course {
    private int id;
    private LocalTime startTime;
    private LocalTime endTime;
    private String name;
    private String code;
    private  String professor;
    private DayOfWeek dayOfWeek;
    private Room room;
    private static int ids=1;

    public enum Room {C102, C104, C105, C106, C107, C209}

    public Course( LocalTime startTime, LocalTime endTime, String name, String code, String professor, DayOfWeek dayOfWeek, Room room) {
        this.id=ids++;
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
        this.code = code;
        this.professor = professor;
        this.dayOfWeek = dayOfWeek;
        this.room = room;

    }



    public String getStateAsString(){
        return String.format("|id=%d|%s(%s)|%s|Start=%s|End=%s|%s|Room=%s\n",this.getId(),this.getName(),this.getCode(),this.getDayOfWeek(),this.getStartTime().format(DateTimeFormatter.ofPattern("hh:mm")),this.getEndTime().format(DateTimeFormatter.ofPattern("hh:mm")),this.getProfessor(),this.getRoom());
    }

    public int getId() {
        return id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getProfessor() {
        return professor;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public Room getRoom() {
        return room;
    }
}
