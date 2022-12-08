package com.dusinski;

import com.dusinski.solutions.day1.CalorieCounting;
import com.dusinski.solutions.day2.RockPaperScissors;
import com.dusinski.solutions.day3.RucksackReorganization;
import com.dusinski.solutions.day4.CampCleanup;
import com.dusinski.solutions.day5.SupplyStack;
import com.dusinski.solutions.day6.TuningTrouble;
import com.dusinski.solutions.day7.NoSpaceLeftOnDevice;
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

    public void testD5_SupplyStack() {
        assertEquals("CMZ", SupplyStack.getTopStacksAfterRearrangementPart1("day5_test.txt"));
        assertEquals("QPJPLMNNR", SupplyStack.getTopStacksAfterRearrangementPart1("day5.txt"));
        assertEquals("MCD", SupplyStack.getTopStacksAfterRearrangementPart2("day5_test.txt"));
        assertEquals("BQDNWJPVJ", SupplyStack.getTopStacksAfterRearrangementPart2("day5.txt"));
    }

    public void testD4_CampCleanup() {
        assertEquals(2, CampCleanup.getFullyContainedAssignmentPairSumPart1("day4_test.txt"));
        assertEquals(466, CampCleanup.getFullyContainedAssignmentPairSumPart1("day4.txt"));
        assertEquals(4, CampCleanup.getFullyContainedAssignmentPairSumPart2("day4_test.txt"));
        assertEquals(865, CampCleanup.getFullyContainedAssignmentPairSumPart2("day4.txt"));
    }

    public void testD6_TuningTrouble() {
        assertEquals(11, TuningTrouble.getNumberOfProcessedCharactersPart1("day6_test.txt"));
        assertEquals(1361, TuningTrouble.getNumberOfProcessedCharactersPart1("day6.txt"));
        assertEquals(26, TuningTrouble.getNumberOfProcessedCharactersPart2("day6_test.txt"));
        assertEquals(3263, TuningTrouble.getNumberOfProcessedCharactersPart2("day6.txt"));
    }

    public void testD7_NoSpaceLeftOnDevice() {
        assertEquals(95437, NoSpaceLeftOnDevice.getTotalSizeToRemovePart1("day7_test.txt"));
        assertEquals(1306611, NoSpaceLeftOnDevice.getTotalSizeToRemovePart1("day7.txt"));
        assertEquals(24933642, NoSpaceLeftOnDevice.getSmallestDirToBeDeletedPart2("day7_test.txt"));
        assertEquals(13210366, NoSpaceLeftOnDevice.getSmallestDirToBeDeletedPart2("day7.txt"));

    }


}
