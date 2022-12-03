package com.dusinski.solutions.day3;

import com.dusinski.utils.utils;

import java.util.List;

public class RucksackReorganization {
    public static int getSumOfPrioritiesPart1(String inputName) {
        List<String> rucksackContentList = utils.loadStringList(inputName);
        int prioritySum = 0;
        for (String contentList : rucksackContentList) {
            char duplicated = new Rucksack(contentList).getDuplicateItem();
            prioritySum += getPriority(duplicated);
        }
        return prioritySum;
    }

    public static int getSumOfPrioritiesPart2(String inputName) {
        List<String> rucksackContentList = utils.loadStringList(inputName);
        int prioritySum = 0;
        for (int i = 0; i < rucksackContentList.size() / 3; i++) {
            boolean[] listA = new Rucksack(rucksackContentList.get(i * 3)).getFullRucksack();
            boolean[] listB = new Rucksack(rucksackContentList.get(i * 3 + 1)).getFullRucksack();
            boolean[] listC = new Rucksack(rucksackContentList.get(i * 3 + 2)).getFullRucksack();
            char duplicated = getCommonBatchChar(listA, listB, listC);
            prioritySum += getPriority(duplicated);
        }
        return prioritySum;
    }


    private static int getPriority(char c) {
        if (Character.isUpperCase(c)) {
            return c - 'A' + 27;
        } else return c - 'a' + 1;
    }

    private static char getCommonBatchChar(boolean[] a, boolean[] b, boolean[] c) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] && a[i] == b[i] && a[i] == c[i]) {
                return (char) (i + 'A');
            }
        }
        return ' ';
    }

    private static class Rucksack {
        private final boolean[] leftCompartment;
        private final boolean[] rightCompartment;

        private final boolean[] fullRucksack;

        private Rucksack(String itemList) {
            String left = getLeft(itemList);
            String right = getRight(itemList);
            this.leftCompartment = strInstrToArray(left);
            this.rightCompartment = strInstrToArray(right);
            this.fullRucksack = strInstrToArray(left + right);
        }

        private String getLeft(String s) {
            int length = s.length();
            return s.substring(0, length / 2);
        }

        private String getRight(String s) {
            int length = s.length();
            return s.substring(length / 2, length);
        }

        private boolean[] strInstrToArray(String input) {
            boolean[] result = new boolean[58];
            for (char c : input.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    result[c - 'A'] = true;
                } else result[c - 'A'] = true;
            }
            return result;
        }

        private char getDuplicateItem() {
            for (int i = 0; i < this.leftCompartment.length; i++) {
                if (this.leftCompartment[i] && this.leftCompartment[i] == this.rightCompartment[i]) {
                    return (char) (i + 'A');
                }
            }
            return ' ';
        }

        public boolean[] getFullRucksack() {
            return fullRucksack;
        }
    }
}
