import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Student chad=new Student("SC0000532","Chad", LocalDate.of(2020,10,12));
        Student gool=new Student("SC3000152","Gool",LocalDate.of(2025,8,10));
        Enrollment enrollment=new Enrollment(chad);
        Enrollment enrollment1=new Enrollment(gool);
        System.out.println(chad.getStateAsString());
        System.out.println(chad.getAdmissionDate());
        Course course1=new Course(LocalTime.of(17,10),LocalTime.of(20,10),"123","123","123", DayOfWeek.MONDAY, Course.Room.C104);
        Course course2=new Course(LocalTime.of(21,10),LocalTime.of(23,10),"123","123","123", DayOfWeek.MONDAY, Course.Room.C104);
        Course course3= new Course(LocalTime.of(17,10),LocalTime.of(19,10),"123","123","123", DayOfWeek.THURSDAY, Course.Room.C104);
        Course course4= new Course(LocalTime.of(17,10),LocalTime.of(19,10),"123","123","123", DayOfWeek.WEDNESDAY, Course.Room.C104);
//        enrollment.enroll(course1);
        enrollment.enroll(course2);
        enrollment.remove(course2);
        enrollment.enroll(course3);

        enrollment1.enroll(course1);
        enrollment1.enroll(course2);
        enrollment1.enroll(course3);

        enrollment.enroll(course4);
        enrollment.conclude();



        System.out.println(enrollment.getStateAsString());
        System.out.println(chad.getSemester());
        System.out.println(enrollment.getTotalHours());


        System.out.println(enrollment1.getStateAsString());


        System.out.println(gool.getStateAsString());
        System.out.println(gool.getSemester());





    }
}

/*Student chad=new Student("SC0000532","Chad", LocalDate.of(2020,10,12));
        Student gool=new Student("SC3000152","Gool",LocalDate.of(2025,8,10));
        Enrollment enrollment=new Enrollment(1,chad);
        Enrollment enrollment1=new Enrollment(2,gool);
        System.out.println(chad.getStateAsString());
        System.out.println(chad.getAdmissionDate());
        Course course1=new Course(enrollment.getNumCourse(), LocalTime.of(17,10),LocalTime.of(20,10),"123","123","123", DayOfWeek.MONDAY, Course.Room.C104);
        Course course2=new Course(1, LocalTime.of(21,10),LocalTime.of(23,10),"123","123","123", DayOfWeek.MONDAY, Course.Room.C104);
        Course course3= new Course(2, LocalTime.of(17,10),LocalTime.of(19,10),"123","123","123", DayOfWeek.THURSDAY, Course.Room.C104);
        enrollment.enroll(course1);
        System.out.println(enrollment.getNumCourse());
        enrollment.enroll(course2);
        enrollment.enroll(course3);
        enrollment.remove(course2);
        enrollment1.enroll(course1);
        enrollment1.enroll(course2);
        enrollment1.enroll(course3);
        enrollment.conclude();


        System.out.println(enrollment.getStateAsString());
        System.out.println(chad.getSemester());
        System.out.println(enrollment.getTotalHours());

        System.out.println(enrollment.getStateAsString());
        System.out.println(enrollment.getNumCourse());
        System.out.println(enrollment1.getStateAsString());
        System.out.println(gool.getStateAsString());
        System.out.println(gool.getSemester());*/
