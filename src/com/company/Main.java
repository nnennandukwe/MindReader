package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create storage for number of guesses user will have accumulated
        int numOfGuesses = 0;

        // Utilize Scanner to read user input
        Scanner read = new Scanner(System.in);

        // Set up random number generator to store as computer's random number
        // "Between  1 and 1000" = (1, 1000) => 1 exclusive and 1000 exclusive
        int computerNumber = 2 + (int)(Math.random() * (1000 - 2));

        // Initiate program with introduction and instructions on how to play the game
        System.out.println(">>> WELCOME TO MIND-READER.");
        System.out.println(">>> I am thinking of a number between 1 and 1000...");
        System.out.println(">>> Take a WILD guess: ");

        // Check that user input is an integer and no other type
        // Store user number input in
        String userNumber = read.next();
        try {
            int parsedNumber = Integer.parseInt(userNumber);
            while (parsedNumber != computerNumber) {

                // guesses guess in total guesses variable
                numOfGuesses += 1;

                // If user input is above computer number, inform user.
                if (parsedNumber > computerNumber)
                    System.out.println(">>> *** HINT *** Your number is too high. Try again: ");
                else {
                    System.out.println(">>> *** HINT *** Your number is too low. Try again, please: ");
                }

                parsedNumber = read.nextInt();

            }

            // Count the last winning guess
            numOfGuesses += 1;

            // Handle case of correct number guess from user input
            System.out.println(">>> CONGRATULATIONS! YOU READ MY MIND!");
            System.out.println(">>> THE MAGIC NUMBER WAS: " + parsedNumber);
            System.out.println("You guessed a total of " + numOfGuesses + " times!");

        // Handle exceptions for data types of user's input.
        } catch (InputMismatchException e) {
            System.out.println("You can only enter in integers. Sorry.");
        } catch (NumberFormatException e) {
            System.out.println("You cannot use non-integer values to guess.");
        }

        read.close();
    }
}
