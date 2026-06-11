package dto;

public record PlayerDTO(String name, int number, String postion, boolean isFIelded) {
    @Override
    public String name() {
        return name;
    }

    @Override
    public int number() {
        return number;
    }

    @Override
    public String postion() {
        return postion;
    }

    @Override
    public boolean isFIelded() {
        return isFIelded;
    }
}
