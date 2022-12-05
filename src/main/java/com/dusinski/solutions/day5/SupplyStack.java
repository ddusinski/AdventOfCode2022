package com.dusinski.solutions.day5;

import com.dusinski.utils.utils;

import java.util.*;

public class SupplyStack {
    public static String getTopStacksAfterRearrangementPart1(String inputName) {
        List<String> rearrangementProcedure = utils.loadStringList(inputName);
        int lineCounter = getLineBreaker(rearrangementProcedure); //line counter
        int stackCount = rearrangementProcedure.get(lineCounter - 1).replace(" ", "").length();
        ShipWithStacks ship = fillTheShip(stackCount, lineCounter, rearrangementProcedure);

        for (int instrID = lineCounter + 1; instrID < rearrangementProcedure.size(); instrID++) { //looping instructions
            int[] param = getInstrArray(rearrangementProcedure.get(instrID));
            ship.moveCratesPart1(param[0], param[1], param[2]);
        }
        return ship.getTheMessage();
    }

    public static String getTopStacksAfterRearrangementPart2(String inputName) {
        List<String> rearrangementProcedure = utils.loadStringList(inputName);
        int lineCounter = getLineBreaker(rearrangementProcedure); //line counter
        int stackCount = rearrangementProcedure.get(lineCounter - 1).replace(" ", "").length();
        ShipWithStacks ship = fillTheShip(stackCount, lineCounter, rearrangementProcedure);

        for (int instrID = lineCounter + 1; instrID < rearrangementProcedure.size(); instrID++) { //looping instructions
            int[] param = getInstrArray(rearrangementProcedure.get(instrID));
            ship.moveCratesPart2(param[0], param[1], param[2]);
        }
        return ship.getTheMessage();
    }

    private static ShipWithStacks fillTheShip(int stackCount, int lineCounter, List<String> procedureList) {
        ShipWithStacks ship = new ShipWithStacks(stackCount);
        for (int instrID = 0; instrID < lineCounter - 1; instrID++) { // filling initial stacks
            for (int stackNr = 1; stackNr <= stackCount; stackNr++) {
                char currentCrate = getCratesForNStack(procedureList.get(instrID), stackNr);
                if (currentCrate != '+') ship.fillStack(stackNr, currentCrate);
            }
        }
        return ship;
    }

    private static char getCratesForNStack(String instr, int stackNumber) {
        int charPos = 1 + (stackNumber - 1) * 4;
        char result = ' ';
        if (instr.length() > charPos) {
            result = instr.charAt(charPos);
        }
        if (result != ' ') {
            return result;
        } else return '+';
    }

    private static int[] getInstrArray(String s) {
        s = s.replaceAll("[^\\d]", " ").trim().replaceAll(" + ", " ");
        int[] result = new int[3];
        result[0] = Integer.parseInt(s.split(" ")[0]);
        result[1] = Integer.parseInt(s.split(" ")[1]);
        result[2] = Integer.parseInt(s.split(" ")[2]);
        return result;
    }

    private static int getLineBreaker(List<String> input) {
        Iterator<String> procedureIterator = input.listIterator();
        int lineCounter = 0;
        while (!procedureIterator.next().equals("")) {
            lineCounter++; //this line is empty string and end of stack initial status
        }
        return lineCounter;
    }

    private static class ShipWithStacks {
        final private List<Vector<Character>> shipStackList = new ArrayList<>();

        private ShipWithStacks(int n) {
            for (int i = 0; i < n; i++) shipStackList.add(new Stack<>());
        }

        private void fillStack(int stackNr, char crates) {
            shipStackList.get(stackNr - 1).add(0, crates);
        }


        private void moveCratesPart1(int numberOfCrates, int startStack, int endStack) {
            for (int i = 0; i < numberOfCrates; i++) {
                char tempChar = this.shipStackList.get(startStack - 1).lastElement();
                this.shipStackList.get(startStack - 1).remove(this.shipStackList.get(startStack - 1).size() - 1);
                this.shipStackList.get(endStack - 1).add(tempChar);
            }
        }

        private void moveCratesPart2(int numberOfCrates, int startStack, int endStack) {
            Vector<Character> tempVector = new Vector<>();
            for (int i = 0; i < numberOfCrates; i++) {
                tempVector.add(0, this.shipStackList.get(startStack - 1).lastElement());
                this.shipStackList.get(startStack - 1).remove(this.shipStackList.get(startStack - 1).size() - 1);
            }
            this.shipStackList.get(endStack - 1).addAll(tempVector);
            tempVector.clear();
        }

        private String getTheMessage() {
            StringBuilder message = new StringBuilder();
            for (Vector<Character> stack : this.shipStackList) {
                message.append(stack.lastElement());
            }
            return message.toString();
        }

        @Override
        public String toString() {
            return "ShipWithStacks{" + "shipStackList=" + shipStackList + '}';
        }
    }
}
