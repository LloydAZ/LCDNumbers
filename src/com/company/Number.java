package com.company;

import java.util.ArrayList;

public class Number {
    // Numbers will be four characters wide by seven characters tall
    //
    //  --        --   --        --   --   --   --   --
    // |  |    |    |    | |  | |    |       | |  | |  |
    // |  |    |    |    | |  | |    |       | |  | |  |
    //            --   --   --   --   --        --   --
    // |  |    | |       |    |    | |  |    | |  |    |
    // |  |    | |       |    |    | |  |    | |  |    |
    //  --        --   --        --   --        --   --
    //
    // Formatted numbers will have a single space between each one.

    //region Constants

    // Constants for the segments in the numbers
    private final String BLANK = "    ";
    private final String TWO_DASH = " -- ";
    private final String TWO_PIPE = "|  |";
    private final String PIPE_LEFT = "|   ";
    private final String PIPE_RIGHT = "   |";

    //endregion

    //region Collections

    // Contains a collection of string arrays representing the nine digits.
    private ArrayList<String[]> numbers;

    //endregion

    //region Constructors

    // Default Constructor
    public Number() {
        numbers = new ArrayList<>();
        createNumbers();
    }

    //endregion

    // region Public Methods

    // Public method to display the number in an LCD format.
    public void DisplayLCDNumber(int number) {
        String[] display = GetLCDNumber(number);

        for (String str : display) {
            System.out.println(str);
        }
    }

    //endregion

    //region Private Methods

    // Get the string array equivalent of the number.
    private String[] GetLCDNumber(int number) {
        // Convert the number into an array of characters.
        char[] charArray = Integer.toString(number).toCharArray();

        // Create an arraylist of string arrays to hold the string arrays
        // that we will get back for each number in the character array.
        ArrayList<String[]> tempNum = new ArrayList<>();

        // Create the array that will be returned and set the default for
        // each string in it to an empty string.
        String[] lcdNumber = new String[] { "", "", "", "", "", "", "" };

        // Get each number in the array and store it in an array list of string arrays.
        for (char c : charArray) {
            tempNum.add(GetNumber(c));
        }

        // Loop through each array in the tempNum collection.
        for (int i = 0; i < tempNum.size(); i++) {
            // Loop through each string in the selected array.
            for (int j = 0; j < 7; j++) {
                // Build a new array of strings that will have all of the numbers
                // formatted correctly next to each other.
                lcdNumber[j] += (tempNum.get(i)[j] + " ");
            }
        }

        return lcdNumber;
    }

    // Get an individual number from the arraylist as a string array.
    private String[] GetNumber(char charNum) {
        int number = Integer.parseInt(Character.toString(charNum));

        if ((number >= 0) && (number <= 9)) {
            return numbers.get(number);
        }

        return null;
    }

    // Create each of the nine digits as a string array.
    private void createNumbers() {
        // 0
        String[] number = new String[] {TWO_DASH, TWO_PIPE, TWO_PIPE, BLANK, TWO_PIPE, TWO_PIPE, TWO_DASH};
        numbers.add(number);

        // 1
        number = new String[] {BLANK, PIPE_RIGHT, PIPE_RIGHT, BLANK, PIPE_RIGHT, PIPE_RIGHT, BLANK};
        numbers.add(number);

        // 2
        number = new String[] {TWO_DASH, PIPE_RIGHT, PIPE_RIGHT, TWO_DASH, PIPE_LEFT, PIPE_LEFT, TWO_DASH};
        numbers.add(number);

        // 3
        number = new String[] {TWO_DASH, PIPE_RIGHT, PIPE_RIGHT, TWO_DASH, PIPE_RIGHT, PIPE_RIGHT, TWO_DASH};
        numbers.add(number);

        // 4
        number = new String[] {BLANK, TWO_PIPE, TWO_PIPE, TWO_DASH, PIPE_RIGHT, PIPE_RIGHT, BLANK};
        numbers.add(number);

        // 5
        number = new String[] {TWO_DASH, PIPE_LEFT, PIPE_LEFT, TWO_DASH, PIPE_RIGHT, PIPE_RIGHT, TWO_DASH};
        numbers.add(number);

        // 6
        number = new String[] {TWO_DASH, PIPE_LEFT, PIPE_LEFT, TWO_DASH, TWO_PIPE, TWO_PIPE, TWO_DASH};
        numbers.add(number);

        // 7
        number = new String[] {TWO_DASH, PIPE_RIGHT, PIPE_RIGHT, BLANK, PIPE_RIGHT, PIPE_RIGHT, BLANK};
        numbers.add(number);

        // 8
        number = new String[] {TWO_DASH, TWO_PIPE, TWO_PIPE, TWO_DASH, TWO_PIPE, TWO_PIPE, TWO_DASH};
        numbers.add(number);

        // 9
        number = new String[] {TWO_DASH, TWO_PIPE, TWO_PIPE, TWO_DASH, PIPE_RIGHT, PIPE_RIGHT, TWO_DASH};
        numbers.add(number);
    }

    //endregion
}