package com.dusinski.solutions.day2;

import com.dusinski.utils.utils;

import java.util.List;

public class RockPaperScissors {

    public static int getTotalStoreOfRPSPart1(String inputName) {
        List<String> strategyGuide = utils.loadStringList(inputName);
        int totalDuelResult = 0;
        for (String s : strategyGuide) {
            totalDuelResult += new RPSDuel(s.charAt(0), s.charAt(2)).getTotalResultPart1();
        }
        return totalDuelResult;
    }

    public static int getTotalStoreOfRPSPart2(String inputName) {
        List<String> strategyGuide = utils.loadStringList(inputName);
        int totalDuelResult = 0;
        for (String s : strategyGuide) {
            totalDuelResult += new RPSDuel(s.charAt(0), s.charAt(2)).getTotalResultPart2();
        }
        return totalDuelResult;
    }

    private static class RPSDuel {
        private final char opponentSel;
        private final char yourSel;

        public RPSDuel(char opponent, char you) {
            opponentSel = opponent;
            yourSel = you;
        }

        private int getYourSelectionPointsPart1() {
            switch (this.yourSel) {
                case 'X':  //Rock
                    return 1;
                case 'Y': //Paper
                    return 2;
                case 'Z': //Scissors
                    return 3;
                default:
                    return 0;
            }
        }

        private int getYourSelectionPointsPart2() {
            switch (this.yourSel) {
                case 'X':  // need to lose
                    return getLostObjectPoints();
                case 'Y': // need to draw
                    return getDrawObjectPoints();
                case 'Z': // need to win
                    return getWinObjectPoints();
                default:
                    return 0;
            }
        }

        private int getLostObjectPoints() {
            switch (this.opponentSel) {
                case 'A':  // need to lose. Opp has Rock. I take Scissors = 3
                    return 3;
                case 'B': // need to lose. Opp has Paper. I take Rock = 1
                    return 1;
                case 'C': // need to lose. Opp has Scissors. I take Paper = 2
                    return 2;
                default:
                    return 0;
            }
        }

        private int getDrawObjectPoints() {
            switch (this.opponentSel) {
                case 'A':  // need to draw. Opp has Rock.  I take Rock = 1
                    return 1;
                case 'B': // need to draw. Opp has Paper. I take Paper = 2
                    return 2;
                case 'C': // need to draw. Opp has Scissors. I take Scissors = 3
                    return 3;
                default:
                    return 0;
            }
        }

        private int getWinObjectPoints() {
            switch (this.opponentSel) {
                case 'A':  // need to win. Opp has Rock. I take Paper = 2
                    return 2;
                case 'B': // need to win. Opp has Paper. I take Scissors = 3
                    return 3;
                case 'C': // need to win. Opp has Scissors. I take Rock = 1
                    return 1;
                default:
                    return 0;
            }
        }

        private int getYourDuelResultPart1() {
            if ((this.yourSel == 'X' && this.opponentSel == 'A') || (this.yourSel == 'Y' && this.opponentSel == 'B') || (this.yourSel == 'Z' && this.opponentSel == 'C')) {
                return 3;
            }
            if ((this.yourSel == 'X' && this.opponentSel == 'C') || (this.yourSel == 'Y' && this.opponentSel == 'A') || (this.yourSel == 'Z' && this.opponentSel == 'B')) {
                return 6;
            }
            return 0;
        }

        private int getYourDuelResultPart2() {
            switch (this.yourSel) {
                case 'X':  // need to lose
                    return 0;
                case 'Y': // need to draw
                    return 3;
                case 'Z': // need to win
                    return 6;
                default:
                    return 0;
            }
        }

        public int getTotalResultPart1() {
            return getYourSelectionPointsPart1() + getYourDuelResultPart1();
        }

        public int getTotalResultPart2() {
            return getYourSelectionPointsPart2() + getYourDuelResultPart2();
        }

        @Override
        public String toString() {
            return "RPSDuel{" + "OpponentSel=" + opponentSel + ", YourSel=" + yourSel + '}';
        }
    }
}
