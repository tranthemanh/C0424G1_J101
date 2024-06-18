package com.codegym;

public class TennisGame {

    private static final String[] SCORE_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};
    private static final String[] SCORE_SUFFIXES = {"-All", "-Advantage player1", "-Advantage player2", "-Win for player1", "-Win for player2"};

    public static String getScore(String player1Name, String player2Name, int scorePlayer1, int scorePlayer2) {
        if (scorePlayer1 == scorePlayer2) {
            return getEqualScore(scorePlayer1);
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            return getGameResult(scorePlayer1, scorePlayer2);
        } else {
            return getScoreInGame(scorePlayer1, scorePlayer2);
        }
    }

    private static String getEqualScore(int score) {
        if (score < 0 || score > 3) {
            return "Deuce";
        } else {
            return SCORE_NAMES[score] + "-All";
        }
    }

    private static String getGameResult(int scorePlayer1, int scorePlayer2) {
        int scoreDiff = scorePlayer1 - scorePlayer2;
        if (Math.abs(scoreDiff) >= 2) {
            return (scoreDiff > 0 ? "Win for player1" : "Win for player2");
        } else {
            return (scoreDiff > 0 ? "Advantage player1" : "Advantage player2");
        }
    }

    private static String getScoreInGame(int scorePlayer1, int scorePlayer2) {
        return SCORE_NAMES[scorePlayer1] + "-" + SCORE_NAMES[scorePlayer2];
    }
}