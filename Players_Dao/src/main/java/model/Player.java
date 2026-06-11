package model;

import java.util.Objects;

public class Player {
    private String name;
    private final int number;
    private String position;
    private boolean isFielded;

    public Player(String name, int number, String position) {
        isValidData(name, number, position);
        this.name = name;
        this.number = number;
        this.position = position;
    }



    public Player(String name, int number, String position,boolean isFielded) {
        isValidData(name, number, position);
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded= isFielded;
    }

    private void isValidData(String name, int number, String position) {
        if (name.isBlank()) throw new IllegalArgumentException("name must be not blank");
        if (position.isBlank()) throw new IllegalArgumentException("position must be not blank");
        Objects.requireNonNull(name,"Name must be not null");
        Objects.requireNonNull(number,"Base location must be not null");
        Objects.requireNonNull(position,"position must be not null");
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }

    public boolean isFielded() {
        return isFielded;
    }

    public void setFielded() {
        isFielded=!isFielded;
    }
    public void setFielded(boolean fielded) {
        isFielded=fielded;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return number == player.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return """
                %s | %d | %s | %s
                """.formatted(name,number,position,isFielded);
    }
}
