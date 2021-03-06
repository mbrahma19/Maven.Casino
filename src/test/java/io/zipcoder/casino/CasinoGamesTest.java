package io.zipcoder.casino;

import io.zipcoder.casino.Games.BlackJack;
import io.zipcoder.casino.Games.Craps;
import io.zipcoder.casino.Games.GoFish;
import io.zipcoder.casino.Games.HiLo;
import io.zipcoder.casino.Models.GuestAccount;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CasinoGamesTest{

    @Test
    public void selectAndRunGameTest1() {
        // Given
        CasinoGames testCasinoGames = getNewCasinoGames();
        String input = "no\n";
        ByteArrayInputStream bytArrInpStr = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream bytArrOutStr= new ByteArrayOutputStream();

        Casino testCasino = getCasinoWithBufferedInputAndOutput(bytArrInpStr, bytArrOutStr);
        String expectedOutput = "Welcome to the Casino Game Floor!\n" +
                "Would you like to play one of the games? (yes or no):\n" +
                "Thank you for visiting the Casino Game Floor!\n";

        // When
        testCasinoGames.selectAndRunGame();
        String actualOutput = bytArrOutStr.toString();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void selectAndRunGameTest2() {
        // Given
        CasinoGames testCasinoGames = getNewCasinoGames();
        String input = "yes\nCraps\nno\nno\nno\n";
        ByteArrayInputStream bytArrInpStr = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream bytArrOutStr= new ByteArrayOutputStream();

        Casino testCasino = getCasinoWithBufferedInputAndOutput(bytArrInpStr, bytArrOutStr);
        String expectedOutput = "Welcome to the Casino Game Floor!\n" +
                "Would you like to play one of the games? (yes or no):\n" +
                "[BLACKJACK, CRAPS, GOFISH, HILO, SLOTS]\n" +
                "\u001B[31m /$$      /$$           /$$                                                     /$$                       /$$     /$$                \n" +
                "| $$  /$ | $$          | $$                                                    | $$                      | $$    | $$                \n" +
                "| $$ /$$$| $$  /$$$$$$ | $$  /$$$$$$$  /$$$$$$  /$$$$$$/$$$$   /$$$$$$        /$$$$$$    /$$$$$$        /$$$$$$  | $$$$$$$   /$$$$$$ \n" +
                "| $$/$$ $$ $$ /$$__  $$| $$ /$$_____/ /$$__  $$| $$_  $$_  $$ /$$__  $$      |_  $$_/   /$$__  $$      |_  $$_/  | $$__  $$ /$$__  $$\n" +
                "| $$$$_  $$$$| $$$$$$$$| $$| $$      | $$  \\ $$| $$ \\ $$ \\ $$| $$$$$$$$        | $$    | $$  \\ $$        | $$    | $$  \\ $$| $$$$$$$$\n" +
                "| $$$/ \\  $$$| $$_____/| $$| $$      | $$  | $$| $$ | $$ | $$| $$_____/        | $$ /$$| $$  | $$        | $$ /$$| $$  | $$| $$_____/\n" +
                "| $$/   \\  $$|  $$$$$$$| $$|  $$$$$$$|  $$$$$$/| $$ | $$ | $$|  $$$$$$$        |  $$$$/|  $$$$$$/        |  $$$$/| $$  | $$|  $$$$$$$\n" +
                "|__/     \\__/ \\_______/|__/ \\_______/ \\______/ |__/ |__/ |__/ \\_______/         \\___/   \\______/          \\___/  |__/  |__/ \\_______/\n" +
                "                                                                                                                                     \n" +
                "                                                                                                                                     \n" +
                "                                                                                                                                     \n" +
                "              /$$$$$$                                               /$$$$$$$$        /$$       /$$           /$$                     \n" +
                "             /$$__  $$                                             |__  $$__/       | $$      | $$          | $$                     \n" +
                "            | $$  \\__/  /$$$$$$  /$$$$$$   /$$$$$$   /$$$$$$$         | $$  /$$$$$$ | $$$$$$$ | $$  /$$$$$$ | $$                     \n" +
                "            | $$       /$$__  $$|____  $$ /$$__  $$ /$$_____/         | $$ |____  $$| $$__  $$| $$ /$$__  $$| $$                     \n" +
                "            | $$      | $$  \\__/ /$$$$$$$| $$  \\ $$|  $$$$$$          | $$  /$$$$$$$| $$  \\ $$| $$| $$$$$$$$|__/                     \n" +
                "            | $$    $$| $$      /$$__  $$| $$  | $$ \\____  $$         | $$ /$$__  $$| $$  | $$| $$| $$_____/                         \n" +
                "            |  $$$$$$/| $$     |  $$$$$$$| $$$$$$$/ /$$$$$$$/         | $$|  $$$$$$$| $$$$$$$/| $$|  $$$$$$$ /$$                     \n" +
                "             \\______/ |__/      \\_______/| $$____/ |_______/          |__/ \\_______/|_______/ |__/ \\_______/|__/                     \n" +
                "                                         | $$                                                                                        \n" +
                "                                         | $$                                                                                        \n" +
                "                                         |__/                                                                                        \u001B[0m\n" +
                "\n" +
                "The minimum bet is $5.\n" +
                "Would you like to read the instructions? (yes or no):\n" +
                "Would you like to start playing Craps? (yes or no):\n" +
                "\n" +
                "We hope you enjoyed your visit to the Craps table!\n" +
                "Welcome back to the Casino Game Floor!\n" +
                "Would you like to play one of the games? (yes or no):\n" +
                "Thank you for visiting the Casino Game Floor!\n";

        // When
        testCasinoGames.selectAndRunGame();
        String actualOutput = bytArrOutStr.toString();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void getUserChoiceToContinuePlayingTest1() {
        // Given
        CasinoGames testCasinoGames = getNewCasinoGames();
        String validChoice = "yes\n";
        String input = validChoice;
        ByteArrayInputStream bytArrInpStr = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream bytArrOutStr= new ByteArrayOutputStream();

        Casino testCasino = getCasinoWithBufferedInputAndOutput(bytArrInpStr, bytArrOutStr);
        boolean expectedResult = true;

        // When
        boolean actualResult = testCasinoGames.getUserChoiceToContinuePlaying();

        // Then
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getUserChoiceToContinuePlayingTest2() {
        // Given
        CasinoGames testCasinoGames = getNewCasinoGames();
        String validChoice = "no\n";
        String input = validChoice;
        ByteArrayInputStream bytArrInpStr = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream bytArrOutStr= new ByteArrayOutputStream();

        Casino testCasino = getCasinoWithBufferedInputAndOutput(bytArrInpStr, bytArrOutStr);
        boolean expectedResult = false;

        // When
        boolean actualResult = testCasinoGames.getUserChoiceToContinuePlaying();

        // Then
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getUserChoiceToContinuePlayingTest3() {
        // Given
        CasinoGames testCasinoGames = getNewCasinoGames();
        String invalidChoice1 = ";lkj\n";
        String invalidChoice2 = "asdf\n";
        String validChoice = "no\n";
        String input = invalidChoice1 + invalidChoice2 + validChoice;
        ByteArrayInputStream bytArrInpStr = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream bytArrOutStr= new ByteArrayOutputStream();

        Casino testCasino = getCasinoWithBufferedInputAndOutput(bytArrInpStr, bytArrOutStr);

        boolean expectedResult = false;
        String expectedOutput = "Would you like to play one of the games? (yes or no):\n" +
                "Sorry, I couldn't understand you. Please enter 'yes' or 'no':\n" +
                "Sorry, I couldn't understand you. Please enter 'yes' or 'no':\n";

        // When
        boolean actualResult = testCasinoGames.getUserChoiceToContinuePlaying();
        String actualOutput = bytArrOutStr.toString();


        // Then
        Assert.assertEquals(expectedResult, actualResult);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    private Casino getCasinoWithBufferedInputAndOutput(ByteArrayInputStream bytArrInpStr, ByteArrayOutputStream bytArrOutStr) {
        return new Casino(bytArrInpStr, new PrintStream(bytArrOutStr));
    }
    
    private CasinoGames getNewCasinoGames(){
        return new CasinoGames(new Guest("", new GuestAccount("", 1, 100.0)));
    }
}