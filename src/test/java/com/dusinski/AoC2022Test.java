package com.dusinski;

import com.dusinski.solutions.day1.CalorieCounting;
import junit.framework.TestCase;

/**
 * Unit test for simple AoC 2022.
 */
public class AoC2022Test extends TestCase {

    public void testApp() {
        assertEquals(69501, CalorieCounting.getMostTotalCalories());
        assertEquals(202346, CalorieCounting.getTopThreeTotalCalories());
    }
}
