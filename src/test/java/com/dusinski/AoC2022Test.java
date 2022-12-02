package com.dusinski;

import com.dusinski.solutions.day1.CalorieCounting;
import com.dusinski.solutions.day2.RockPaperScissors;
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
}
