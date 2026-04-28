package ifsp.br;

import java.time.LocalDate;
import java.time.Period;

public class Student {
    private String id;
    private String name;
    private LocalDate admissionDate;

    public Student(String id, String name, LocalDate admissionDate) {
        if (isValid(id,name,admissionDate)){
            this.id = id;
            this.name = name;
            this.admissionDate = admissionDate;
        }
    }

    private boolean isValid(String id, String name, LocalDate admissionDate){
        if (isValidString(name)) return false;
        if (admissionDate==null) return false;
        return isValid(id);


    }

    private static boolean isValid(String id) {
        if (id ==null || id.length() !=9) return false;
        String idUpperCase = id.toUpperCase();
        if (!idUpperCase.startsWith("SC")) return false;
        if (!(idUpperCase.endsWith("X")) ||
                Character.isDigit(idUpperCase.charAt(8))) return false;
        final String substring = idUpperCase.substring(2,8);
        for (char c : substring.toCharArray() ) {
            if (!Character.isDigit(c)) return false;

        }
        return true;
    }


    public String getStateAsString(){
        return String.format("%s|%s|%s"
                ,id,name,admissionDate);
    }

    public int getSemester(){
        return (int) Period.between(admissionDate,LocalDate.now()).toTotalMonths()+1;
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
