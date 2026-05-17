import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class Enrollment {
    private int id;
    private LocalDateTime enrollmentTime;
    private boolean concluded;
    private Student student;
    private static int ids=1;

    private Course[] courses;
    private int numCourse;

    public Enrollment(Student student) {
        if (student==null) return;
        this.id = ids++;
        this.enrollmentTime = LocalDateTime.now();
        this.concluded = false;
        this.student = student;
        this.courses = new Course[100];
        this.numCourse=0;
    }

    public boolean enroll(Course course){
        int total=this.getTotalHours();
        int index=verifyCourses(course);
        if (index>=0) return false;
        if (this.concluded) return false;
        if (!verifyTimeCourses(course)) return false;
        if (total+ Duration.between(course.getStartTime(),course.getEndTime()).toHours() >22) return false;
        courses[numCourse++]=course;
        return true;
    }

    public void remove(Course course){

        if (this.concluded) return;
        int index=verifyCourses(course);
        if (index<0) return;
        courses[index]=courses[numCourse-1];
        courses[numCourse-1]=null;
        numCourse--;


    }

    public void conclude(){
        if (this.concluded) return;
        this.concluded=!this.concluded;
        this.enrollmentTime=LocalDateTime.now();
    }



    private boolean verifyTimeCourses(Course course){
        for (int i = 0; i < numCourse; i++) {
            if (courses[i].getStartTime().equals(course.getStartTime()) && courses[i].getDayOfWeek()==course.getDayOfWeek()) return false;
            if (courses[i].getEndTime().equals(course.getEndTime()) && courses[i].getDayOfWeek()==course.getDayOfWeek()) return false;

        }
        return true;
    }

    private int verifyCourses(Course course){
        for (int i = 0; i < numCourse; i++) {
            if (courses[i].getId()==course.getId()) return i;

        }
        return -1;
    }

    public int getTotalHours(){
        int hours=0;
        for (int i = 0; i < numCourse; i++) {
            hours+= Duration.between(courses[i].getStartTime(),courses[i].getEndTime()).toHours();

        }
        return hours;

    }

    public String getStateAsString(){
        if (this==null) return "Invalid enrollment!";
        StringBuilder builder= new StringBuilder("Courses:\n");
        for (int i = 0; i < numCourse; i++) {
            builder.append(courses[i].getStateAsString());

        }
        if (!this.concluded) builder.append("Enrollment not concluded!");
        return builder.toString();
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

    public int getNumCourse(){
        return numCourse;
    }

}
