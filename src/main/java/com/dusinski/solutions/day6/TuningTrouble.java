package com.dusinski.solutions.day6;

import com.dusinski.utils.utils;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class TuningTrouble {

    public static int getNumberOfProcessedCharactersPart1(String inputName) {
        String signalString = utils.loadStringLine(inputName);
        ArrayDeque<Character> charWin = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) {
            charWin.add(signalString.toCharArray()[i]);
        }

        if (notContainsDuplicates(charWin)) return 4;

        for (int i = 4; i < signalString.toCharArray().length; i++) {
            Character currentMarker = signalString.toCharArray()[i];
            charWin.pollFirst();
            charWin.add(currentMarker);
            if (notContainsDuplicates(charWin)) return i + 1;
        }
        return -1;
    }

    public static int getNumberOfProcessedCharactersPart2(String inputName) {
        String signalString = utils.loadStringLine(inputName);
        ArrayDeque<Character> charWin = new ArrayDeque<>();
        for (int i = 0; i < 14; i++) {
            charWin.add(signalString.toCharArray()[i]);
        }

        if (notContainsDuplicates(charWin)) return 15;

        for (int i = 14; i < signalString.toCharArray().length; i++) {
            Character currentMarker = signalString.toCharArray()[i];
            charWin.pollFirst();
            charWin.add(currentMarker);
            if (notContainsDuplicates(charWin)) return i + 1;
        }
        return -1;
    }

    private static boolean notContainsDuplicates(Queue<Character> queue) {
        Set<Character> tempSet = new HashSet<>(queue);
        return (tempSet.size() == queue.size());
    }
}
