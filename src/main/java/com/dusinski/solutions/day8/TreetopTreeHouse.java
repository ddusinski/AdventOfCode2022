package com.dusinski.solutions.day8;

import com.dusinski.utils.utils;

import java.util.Arrays;

public class TreetopTreeHouse {

    public static int getHowManyTreesAreVisiblePart1VER2(String inputName) {
        int[][] forest = utils.loadNumTwoDimArray(inputName);
        int visibleSum = 0;
        boolean[][] visible = new boolean[forest.length][forest[0].length];

        getVisibleTreesCountHorizontal(forest, visible);
        getVisibleTreesCountVertical(forest, visible);

        for (boolean[] booleans : visible) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) visibleSum++;
            }
        }
        return visibleSum;
    }

    public static int getHowManyTreeWithBestViewPart2(String inputName) {
        int[][] forest = utils.loadNumTwoDimArray(inputName);
        int visibleSum = 0;

        int[][] visibleLeft = new int[forest.length][forest[0].length];
        int[][] visibleRight = new int[forest.length][forest[0].length];
        int[][] visibleTop = new int[forest.length][forest[0].length];
        int[][] visibleDown = new int[forest.length][forest[0].length];

        getHorizontalLeftView(forest, visibleLeft);
        getHorizontalRightView(forest, visibleRight);
        getVerticalTopView(forest, visibleTop);
        getVerticalDownView(forest, visibleDown);
        System.out.println("visibleLeft");
        for (int[] ints : visibleLeft) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("visibleRight");
        for (int[] ints : visibleRight) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("visibleTop");
        for (int[] ints : visibleTop) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("visibleDown");
        for (int[] ints : visibleDown) {
            System.out.println(Arrays.toString(ints));
        }


        for (int i = 0; i < visibleLeft.length; i++) {
            for (int j = 0; j < visibleLeft[0].length; j++) {
                visibleSum = Math.max(visibleSum, visibleLeft[i][j] * visibleRight[i][j] * visibleTop[i][j] * visibleDown[i][j]);
            }
        }

        return visibleSum;
    }

    private static void getVisibleTreesCountHorizontal(int[][] f, boolean[][] v) {
        for (int i = 0; i < f.length; i++) {
            int[] tempRow = Arrays.copyOf(f[i], f[i].length);  //forward
            v[i][0] = true;
            for (int j = 1; j < tempRow.length; j++) {
                if (tempRow[j - 1] >= tempRow[j]) {
                    tempRow[j] = tempRow[j - 1];
                } else if (tempRow[j - 1] < tempRow[j]) v[i][j] = true;
            }

            tempRow = Arrays.copyOf(f[i], f[i].length);  //backward
            v[i][tempRow.length - 1] = true;
            for (int j = tempRow.length - 1; j > 1; j--) {
                if (tempRow[j - 1] <= tempRow[j]) {
                    tempRow[j - 1] = tempRow[j];
                } else if (tempRow[j - 1] > tempRow[j]) v[i][j - 1] = true;
            }
        }
    }

    private static void getHorizontalLeftView(int[][] f, int[][] v) {
        for (int i = 0; i < f.length; i++) {
            int[] tempRow = Arrays.copyOf(f[i], f[i].length);  //forward
            v[i][0] = 1;
            for (int j = 1; j < tempRow.length; j++) {
                if (tempRow[j - 1] >= tempRow[j]) {
                    tempRow[j] = tempRow[j - 1];
                    v[i][j] = 1;
                } else if (tempRow[j - 1] < tempRow[j]) v[i][j] = v[i][j - 1] + 1;
            }
        }
    }

    private static void getHorizontalRightView(int[][] f, int[][] v) {
        for (int i = 0; i < f.length; i++) {
            int[] tempRow = Arrays.copyOf(f[i], f[i].length);  //backward
            v[i][tempRow.length - 1] = 1;
            for (int j = tempRow.length - 1; j > 1; j--) {
                if (tempRow[j - 1] <= tempRow[j]) {
                    tempRow[j - 1] = tempRow[j];
                    v[i][j - 1] = 1;
                } else if (tempRow[j - 1] > tempRow[j]) v[i][j - 1] = v[i][j] + 1;
            }
        }
    }


    private static void getVisibleTreesCountVertical(int[][] f, boolean[][] v) {
        for (int col = 0; col < f.length; col++) {
            int[] tempRow = new int[f.length];
            for (int k = 0; k < f[col].length; k++) {
                tempRow[k] = f[k][col];
            }
            int[] tempRowBackward = Arrays.copyOf(tempRow, tempRow.length);

            v[0][col] = true;           //forward
            for (int j = 1; j < tempRow.length; j++) {
                if (tempRow[j - 1] >= tempRow[j]) {
                    tempRow[j] = tempRow[j - 1];
                } else if (tempRow[j - 1] < tempRow[j]) v[j][col] = true;
            }

            v[tempRowBackward.length - 1][col] = true;      //backward
            for (int j = tempRowBackward.length - 1; j > 1; j--) {
                if (tempRowBackward[j - 1] <= tempRowBackward[j]) {
                    tempRowBackward[j - 1] = tempRowBackward[j];
                } else if (tempRowBackward[j - 1] > tempRowBackward[j]) v[j - 1][col] = true;
            }
        }
    }


    private static void getVerticalTopView(int[][] f, int[][] v) {
        for (int col = 0; col < f.length; col++) {
            int[] tempRow = new int[f.length];
            for (int k = 0; k < f[col].length; k++) {
                tempRow[k] = f[k][col];
            }

            v[0][col] = 1;           //forward
            for (int j = 1; j < tempRow.length; j++) {
                if (tempRow[j - 1] >= tempRow[j]) {
                    tempRow[j] = tempRow[j - 1];
                    v[j][col] = 1;
                } else if (tempRow[j - 1] < tempRow[j]) v[j][col] = v[j - 1][col] + 1;
            }
        }
    }

    private static void getVerticalDownView(int[][] f, int[][] v) {
        for (int col = 0; col < f.length; col++) {
            int[] tempRowBackward = new int[f.length];
            for (int k = 0; k < f[col].length; k++) {
                tempRowBackward[k] = f[k][col];
            }

            v[tempRowBackward.length - 1][col] = 1;      //backward
            for (int j = tempRowBackward.length - 1; j > 1; j--) {
                if (tempRowBackward[j - 1] <= tempRowBackward[j]) {
                    tempRowBackward[j - 1] = tempRowBackward[j];
                    tempRowBackward[j - 1] = 1;
                } else if (tempRowBackward[j - 1] > tempRowBackward[j]) v[j - 1][col] = v[j][col] + 1;
            }
        }
    }

}
