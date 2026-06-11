package dto;

public record TeamDTO(String name, String baseLocation,
                      String coachName, int idCaptain) {
    @Override
    public String name() {
        return name;
    }

    @Override
    public String baseLocation() {
        return baseLocation;
    }

    @Override
    public String coachName() {
        return coachName;
    }

    @Override
    public int idCaptain() {
        return idCaptain;
    }
}
