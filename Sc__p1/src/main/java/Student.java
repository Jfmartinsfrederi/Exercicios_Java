import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Student {
    private String id;
    private String name;
    private LocalDate admissionDate;


    public Student(String id, String name, LocalDate admissionDate) {
        if (!isValidId(id)) return;
        this.id=id;

        this.name = name;
        this.admissionDate = admissionDate;
    }

    public String getStateAsString(){
        return String.format("%s|%s|Admission date=%s",this.getId(),this.getName(),this.getAdmissionDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

    }

    public long getSemester(){

        return Period.between(this.getAdmissionDate(),LocalDate.now()).toTotalMonths()/6;


    }




    private boolean isValidId(String id){
        if (id.charAt(0)!='S') return false;
        if (id.charAt(1)!='C') return false;
        int i;
        for ( i = 2; i < 6; i++) {
            if (!Character.isDigit(id.charAt(i))) return false;
        }
        return id.charAt(i + 1) == 'X' || Character.isDigit(id.charAt(i + 1));

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }
}
