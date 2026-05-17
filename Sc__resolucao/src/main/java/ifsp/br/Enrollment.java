package ifsp.br;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Enrollment {
    private static int idCount;
    private int id;
    private LocalDateTime enrollmentTime;
    private boolean concluded;

    private Student student;
    private final Course[] courses=new Course[100];
    private int coursesCount=0;
    private int minutesInClasses;

    public Enrollment(Student student) {
        if (student==null || student.getId()==null){
            concluded=true;
            return;
        }
        this.id=idCount++;
        this.student=student;
    }

    public boolean enroll(Course course){
        if (course==null) return false;
        if (concluded) return false;
        if (minutesInClasses+course.getWeeklyDurationInMinutes()>=22*60) return false;
        for (int i = 0; i < coursesCount; i++) {

            if (collidesAmong(course, i));

        }

        courses[coursesCount++]=course;
        minutesInClasses+=course.getWeeklyDurationInMinutes();
        return true;
    }

    public void remove(Course course){
        if (concluded) return;
        for (int i = 0; i < coursesCount; i++) {
            if (courses[i].getId()==course.getId()){
                courses[i]=courses[coursesCount-1];
                courses[coursesCount-1]=null;
                coursesCount--;
            }

        }
    }






    private boolean collidesAmong(Course course, int i) {
        return course.getStartTime().isBefore(courses[i].getEndTime()) && !course.getEndTime().isBefore(courses[i].getStartTime());
    }


    public void conclude(){
        concluded=true;
        enrollmentTime=LocalDateTime.now();
    }

    public String getStateAsString(){
        if (!concluded) return "Enrollment not concluded!";
        if (student==null) return "Invalid enrollment";
        StringBuilder sb= new StringBuilder();
        final DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        for (int i = 0; i < coursesCount; i++) {
            sb.append(courses[i].getStateAsString()).append("\n");

        }
        return String.format("""
                %s
                %s
                %s
                """, student.getStateAsString(),formatter.format(enrollmentTime),sb.toString());
    }


    public int getId() {
        return id;
    }

    public LocalDateTime getEnrollmentTime() {
        return enrollmentTime;
    }

    public boolean isConcluded() {
        return concluded;
    }

    public Student getStudent() {
        return student;
    }

    public Course[] getCourses() {
        return courses;
    }
}
