package org.example.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private String userName;
    private final List<Integer> gameScores;

    public Player(String userName) {
        this.userName = userName;
        this.gameScores = new ArrayList<>();
    }

    public void addScore(int score) {
        gameScores.add(score);
    }

    public int compateTo(Player out) {
        List<Integer> gamesScoreRival = out.getGameScores();
        int maior = 0;
        for (int i = 0; i < gameScores.size(); i++) {
            if (gamesScoreRival.get(i + 1) == null) break;
            if (gamesScoreRival.get(i) > gameScores.get(i)) {
                maior = gamesScoreRival.get(i);
                return maior;
            } else if (gameScores.get(i) > gamesScoreRival.get(i)) {
                maior = gameScores.get(i);
                return maior;
            }


        }
        String userNameRival = out.getUserName();
        for (int i = 0; i < userName.length(); i++) {
            if (userNameRival.length() < i) return getMaxScore();
            if (userNameRival.charAt(i) > userName.charAt(i)) return getMaxScore();
            else if (userName.charAt(i) > userNameRival.charAt(i)) {
                return out.getMaxScore();

            }


        }
        return getMaxScore();
    }

    public String getUserName() {
        return userName;
    }

    public List<Integer> getGameScores() {
        return Collections.unmodifiableList(gameScores);
    }

    public int getMaxScore() {
        int maior = 0;
        for (Integer gameScore : gameScores) {
            if (gameScore > maior) maior = gameScore;

        }
        return maior;
    }

    @Override
    public String toString() {
        return """
                Usename=%s |
                Max Score=%d
                """.formatted(userName, getMaxScore());
    }
}
