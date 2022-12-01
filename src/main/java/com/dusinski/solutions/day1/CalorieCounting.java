package com.dusinski.solutions.day1;

import com.dusinski.utils.utils;

import java.util.List;

public class CalorieCounting {

    public static int getMostTotalCalories() {
        List<String> caloriesList = utils.loadStringList("day1.txt");
        int maxCaloriesSum = 0;
        int tempCaloriesSum = 0;
        for (String calorie : caloriesList) {
            if (calorie.equals("")) {
                if (tempCaloriesSum > maxCaloriesSum) maxCaloriesSum = tempCaloriesSum;
                tempCaloriesSum = 0;
            } else {
                tempCaloriesSum += Integer.parseInt(calorie);
            }
        }
        return maxCaloriesSum;
    }

    public static int getTopThreeTotalCalories() {
        List<String> caloriesList = utils.loadStringList("day1.txt");
        int tempCaloriesSum = 0;
        TopThreeCalorie topThreeCalories = new TopThreeCalorie();
        for (String calorie : caloriesList) {
            if (calorie.equals("")) {
                topThreeCalories.addCalorie(tempCaloriesSum);
                tempCaloriesSum = 0;
            } else {
                tempCaloriesSum += Integer.parseInt(calorie);
            }
        }
        return topThreeCalories.returnTotalThree();
    }

    static private class TopThreeCalorie {
        static int firstCalorie, secondCalorie, thirdCalorie = 0;

        private void addCalorie(int calorie) {
            if (calorie > firstCalorie) {
                thirdCalorie = secondCalorie;
                secondCalorie = firstCalorie;
                firstCalorie = calorie;
            } else if (calorie > secondCalorie) {
                thirdCalorie = secondCalorie;
                secondCalorie = calorie;
            } else if (calorie > thirdCalorie) {
                thirdCalorie = calorie;
            }
        }

        private int returnTotalThree() {
            return firstCalorie + secondCalorie + thirdCalorie;
        }
    }
}
