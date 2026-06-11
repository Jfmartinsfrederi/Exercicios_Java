package exception;

public class LimitPlayersTeamReached extends RuntimeException {
    public LimitPlayersTeamReached(String message) {
        super(message);
    }
}
