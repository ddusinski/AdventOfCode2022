package com.dusinski.solutions.day4;

import com.dusinski.utils.utils;

import java.util.List;

public class CampCleanup {

    public static int getFullyContainedAssignmentPairSumPart1(String inputName) {
        List<String> pairs = utils.loadStringList(inputName);

        int containedSum = 0;

        for (String pair : pairs) {
            String[] pairStringArray = pair.split(",");
            int lStart = Integer.parseInt(pairStringArray[0].split("-")[0]);
            int lEnd = Integer.parseInt(pairStringArray[0].split("-")[1]);
            int rStart = Integer.parseInt(pairStringArray[1].split("-")[0]);
            int rEnd = Integer.parseInt(pairStringArray[1].split("-")[1]);

            if (isContaining(lStart, lEnd, rStart, rEnd)) containedSum++;
        }
        return containedSum;
    }

    public static int getFullyContainedAssignmentPairSumPart2(String inputName) {
        List<String> pairs = utils.loadStringList(inputName);

        int overlappedSum = 0;

        for (String pair : pairs) {
            String[] pairStringArray = pair.split(",");
            int lStart = Integer.parseInt(pairStringArray[0].split("-")[0]);
            int lEnd = Integer.parseInt(pairStringArray[0].split("-")[1]);
            int rStart = Integer.parseInt(pairStringArray[1].split("-")[0]);
            int rEnd = Integer.parseInt(pairStringArray[1].split("-")[1]);

            if (isOverlapping(lStart, lEnd, rStart, rEnd)) overlappedSum++;
        }
        return overlappedSum;
    }

    private static boolean isContaining(int a, int b, int c, int d) {
        return (a <= c && b >= d) || (c <= a && d >= b);
    }

    private static boolean isOverlapping(int a, int b, int c, int d) {
        return (a <= c && b >= c) || (c <= b && b <= d) || (a >= c && a <= d) || (a <= d && d <= b) || isContaining(a, b, c, d);
    }
}
