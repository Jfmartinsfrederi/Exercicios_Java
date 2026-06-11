package player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Player implements Comparable<Player> {
    private String userName;
    private List<Integer> gameScores;

    public Player(String userName) {
        this.userName = userName;
        this.gameScores = new ArrayList<>();
    }

    public void addScore(int score) {
        gameScores.add(score);
    }


    public int compareTo(Player out) {
        List<Integer> pGameScores =
                new ArrayList<>(gameScores);
        List<Integer> outGameScores =
                new ArrayList<>(out.getGameScores());

        pGameScores.sort(Collections.reverseOrder());
        outGameScores.sort(Collections.reverseOrder());

        int min =
                Math.min(pGameScores.size(),
                        outGameScores.size());

        for (int i = 0; i < min; i++) {

            int result =
                    Integer.compare(
                            pGameScores.get(i),
                            outGameScores.get(i));

            if (result != 0) {
                return result;
            }
        }

        return userName.compareTo(out.userName);

    }

    public String getUserName() {
        return userName;
    }

    public List<Integer> getGameScores() {
        return Collections.unmodifiableList(gameScores);
    }


    @Override
    public String toString() {
        Collections.reverse(gameScores);
        return "Username=%s | MaxScore=%d".formatted(userName, Collections.max(gameScores));
    }


}

