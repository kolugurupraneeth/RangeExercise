package com;

import java.util.ArrayList;
import java.util.List;
public class Range{

        private static final List<String> outputRange = new ArrayList<>();

        public static void main(String[] args) {

            List<String> inputRanges = new ArrayList<>();

            inputRanges.add("94133,94133");
            inputRanges.add("94200,94299");
            inputRanges.add("94600,94699");

            for (String inputRange : inputRanges) {
                compareRange(inputRange);
            }

            System.out.println(outputRange.toString());

        }

        public static void compareRange(String range) {

            boolean addValueToOutputRange = false;

            if (outputRange.size() == 0) {
                outputRange.add(range);
            } else {

                String[] splitString = range.split(",");

                int minRange = Integer.parseInt(splitString[0]);
                int maxRange = Integer.parseInt(splitString[1]);

                for (int i = 0; i < outputRange.size(); i++) {
                    String[] splitoutString = outputRange.get(i).split(",");
                    int minoutRange = Integer.parseInt(splitoutString[0]);
                    int maxoutRange = Integer.parseInt(splitoutString[1]);

                    if (minRange > minoutRange && maxRange < maxoutRange) {
                        addValueToOutputRange = false;
                        break;
                    }

                    if (minRange > minoutRange && maxRange >= maxoutRange && minRange < maxoutRange) {
                        String newvalue = minoutRange + "," + maxRange;
                        outputRange.set(i, newvalue);
                        addValueToOutputRange = false;
                        break;
                    }

                    if (minRange <= minoutRange && maxRange < maxoutRange && maxRange > minoutRange) {
                        String newvalue = minRange + "," + maxoutRange;
                        outputRange.set(i, newvalue);
                        addValueToOutputRange = false;
                        break;
                    }

                    // condition where input range is less than all the ranges in the output

                    if (minRange <= minoutRange && minRange <= maxoutRange && maxRange <= minoutRange
                            && maxRange <= maxoutRange) {
                        addValueToOutputRange = true;
                    }

                    // condition where input range is more than all the ranges in the output

                    if (minRange >= minoutRange && minRange >= maxoutRange && maxRange >= minoutRange
                            && maxRange >= maxoutRange) {
                        addValueToOutputRange = true;
                    }
                }

                if (addValueToOutputRange) {
                    outputRange.add(minRange + "," + maxRange);
                }
            }
        }
}

