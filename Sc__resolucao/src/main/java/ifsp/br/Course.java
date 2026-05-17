package ifsp.br;


import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class Course {
    enum Room {C102,C104,C105,C106,C107,C209}
    private static int idCount=1;
    private int id;
    private LocalTime startTime;
    private LocalTime endTime;
    private String name;
    private String code;
    private String professor;
    private DayOfWeek dayOfWeek;
    private Room room;

    public Course(LocalTime startTime, LocalTime endTime, String name,
                  String code, String professor, DayOfWeek dayOfWeek, Room room) {
        if (isValid(startTime,endTime,name,code,professor,dayOfWeek,room)){
            this.id = idCount++;
            this.startTime = startTime;
            this.endTime = endTime;
            this.name = name;
            this.code = code;
            this.professor = professor;
            this.dayOfWeek = dayOfWeek;
            this.room = room;
        }
    }

    private boolean isValid(LocalTime startTime, LocalTime endTime, String name,
                            String code, String professor, DayOfWeek dayOfWeek, Room room){
        if (startTime==null) return false;
        if (endTime==null || !endTime.isAfter(startTime)) return false;
        if (!isValidString(name)) return false;
        if (!isValidString(name)) return false;
        if (!isValidString(name)) return false;
        if (room==null) return false;
        return dayOfWeek!=null;

    }

    public int getWeeklyDurationInMinutes(){
        return (int) Duration.between(startTime,endTime).toMinutes();
    }

    public String getStateAsString(){
        return String.format("%d%s%s%s%s%s%s%s",id,name,code,dayOfWeek,startTime,endTime,professor,room);
    }


    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getId() {
        return id;
    }
}
