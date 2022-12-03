package com.dusinski;

import com.dusinski.solutions.day1.CalorieCounting;
import com.dusinski.solutions.day2.RockPaperScissors;
import com.dusinski.solutions.day3.RucksackReorganization;
import junit.framework.TestCase;

/**
 * Unit test for simple AoC 2022.
 */
public class AoC2022Test extends TestCase {

    public void testD1_CalorieCounting() {
        assertEquals(69501, CalorieCounting.getMostTotalCalories());
        assertEquals(202346, CalorieCounting.getTopThreeTotalCalories());
    }

    public void testD2_RockPaperScissors() {
        assertEquals(15, RockPaperScissors.getTotalStoreOfRPSPart1("day2_test.txt"));
        assertEquals(15523, RockPaperScissors.getTotalStoreOfRPSPart1("day2.txt"));
        assertEquals(12, RockPaperScissors.getTotalStoreOfRPSPart2("day2_test.txt"));
        assertEquals(15702, RockPaperScissors.getTotalStoreOfRPSPart2("day2.txt"));
    }

    public void testD3_RucksackReorganization() {
        assertEquals(157, RucksackReorganization.getSumOfPrioritiesPart1("day3_test.txt"));
        assertEquals(7863, RucksackReorganization.getSumOfPrioritiesPart1("day3.txt"));
        assertEquals(70, RucksackReorganization.getSumOfPrioritiesPart2("day3_test.txt"));
        assertEquals(2488, RucksackReorganization.getSumOfPrioritiesPart2("day3.txt"));
    }
}
