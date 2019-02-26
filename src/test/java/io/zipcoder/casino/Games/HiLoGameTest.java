package io.zipcoder.casino.Games;

import io.zipcoder.casino.Casino;
import io.zipcoder.casino.Games.HiLo;
import io.zipcoder.casino.Guest;
import io.zipcoder.casino.Models.Card;
import io.zipcoder.casino.Models.CardDeck;
import io.zipcoder.casino.Models.GuestAccount;
import io.zipcoder.casino.Players.HiLowPlayer;
import io.zipcoder.casino.Players.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class HiLoGameTest {

    @Before
    public void setUp(){
        HiLo hiloGame = new HiLo(new Guest("Marlys", new GuestAccount("Marlys", 1, 1000.0)));
    }



    @Test
    public void playFullGameTest1() {
        // Given
        String input = "10\nl\nno\n";
        ByteArrayInputStream bytArrInpStr = new ByteArrayInputStream(input.getBytes());
        Casino testCasino = new Casino(bytArrInpStr, System.out);
        Double startingBalance = 1000.0;
        Guest testGuest = new Guest("", new GuestAccount("", 0, startingBalance));
        HiLo testHiLo = new HiLo(testGuest, new CardDeck()); // This deck has not been shuffled

        Double expectedFinalBalance = 1002.5;

        // When
        testHiLo.playFullGame();
        Double actualFinalBalance = testGuest.getAccountBalance();

        // Then
        Assert.assertEquals(expectedFinalBalance, actualFinalBalance);
    }

    @Test
    public void playFullGameTest2() {
        // Given
        String input = "0\n10\nh\nno\n";
        ByteArrayInputStream bytArrInpStr = new ByteArrayInputStream(input.getBytes());
        Casino testCasino = new Casino(bytArrInpStr, System.out);
        Double startingBalance = 1000.0;
        Guest testGuest = new Guest("", new GuestAccount("", 0, startingBalance));
        HiLo testHiLo = new HiLo(testGuest, new CardDeck()); // This deck has not been shuffled

        Double expectedFinalBalance = 990.0;

        // When
        testHiLo.playFullGame();
        Double actualFinalBalance = testGuest.getAccountBalance();

        // Then
        Assert.assertEquals(expectedFinalBalance, actualFinalBalance);
    }

    @Test
    public void dealTest(){
        //Given
        HiLo hiloGame = new HiLo(new Guest("Marlys", new GuestAccount("Marlys", 1, 1000.0)));


        //When
        Card actual= hiloGame.deal();

        //Then

        Assert.assertNotNull(actual);

    }
    @Test
    public void dealSecondCardTest(){
        //Given
        HiLo hiloGame = new HiLo(new Guest("Marlys", new GuestAccount("Marlys", 1, 1000.0)));


        //When
        Card actual= hiloGame.dealSecondCard();

        //Then

        Assert.assertNotNull(actual);

    }


    @Test
    public void isLessTest(){
        //Given
        HiLo hiloGame = new HiLo(new Guest("Marlys", new GuestAccount("Marlys", 1, 1000.0)));
        Card firstCard = new Card(Card.Suit.HEARTS, Card.Rank.THREE);
        Card secondCard = new Card(Card.Suit.HEARTS, Card.Rank.EIGHT);

        //When
        Boolean actual = hiloGame.isLess(firstCard,secondCard);

        //Then
        Assert.assertFalse(actual);

    }

    @Test
    public void isMoreTest(){
        //Given
        HiLo hiloGame = new HiLo(new Guest("Marlys", new GuestAccount("Marlys", 1, 1000.0)));
        Card firstCard = new Card(Card.Suit.HEARTS, Card.Rank.THREE);
        Card secondCard = new Card(Card.Suit.HEARTS,Card.Rank.JACK);

        //When
        Boolean actual = hiloGame.isMore(firstCard,secondCard);

        //Then
        Assert.assertTrue(actual);

    }


    @Test
    public void checkPlayersBalanceTest(){
        //Given
        Double expected = 20.00;
        GuestAccount guestAccount = new GuestAccount(null,null,expected);
        Guest guest = new Guest(null,guestAccount);
        HiLowPlayer hiLowPlayer = new HiLowPlayer(guest);
        HiLo hiloGame = new HiLo(guest);

        //When
        Double actual = hiloGame.checkPlayersBalance(hiLowPlayer);


        //Then
        Assert.assertEquals(expected,actual);


    }
    @Test
    public void enoughMoneyForBetTest(){
        //Given
        Double expected = 20.00;
        GuestAccount guestAccount = new GuestAccount(null,null,expected);
        Guest guest = new Guest(null,guestAccount);
        Player player = new Player(guest);
        HiLo hiloGame = new HiLo(guest);


        //When
        Boolean actual = hiloGame.enoughMoneyForBet(30.0,player);

        //Then
        Assert.assertFalse(actual);
    }
    @Test
    public void receiveBetFromPlayerTest(){
        //Given
        Casino testCasino = new Casino(System.in, System.out);
        GuestAccount guestAccount = new GuestAccount(null,null,20.0);
        Guest guest = new Guest(null,guestAccount);
        HiLo hiloGame = new HiLo(guest);
        Player player = new Player(guest);
        Double expected = 5.00;

        //When
        Double balance = hiloGame.checkPlayersBalance(player);
        hiloGame.receiveBetFromPlayer(15.00);
        Double actual = hiloGame.checkPlayersBalance(player);

        //Then
        Assert.assertEquals(expected,actual);

    }
//    @Test
//    public void giveWinningsToPlayerTest() {
//        //Given
//        Casino testCasino = new Casino(System.in, System.out);
//        GuestAccount guestAccount = new GuestAccount(null, null, 20.0);
//        Guest guest = new Guest(null, guestAccount);
//        HiLo hiloGame = new HiLo(guest);
//        Player player = new Player(guest);
//        Double expected = 21.25;
//        Double bet = 5.00;
//
//
//        //When
//
//        hiloGame.giveWinningsToPlayer(5.00);
//        Double actual = hiloGame.checkPlayersBalance(player);
//
//        //Then
//        Assert.assertEquals(expected, actual);
//
//
//    }



    public void winningTest() {
        //Given
        Casino testCasino = new Casino(System.in, System.out);
        GuestAccount guestAccount = new GuestAccount(null,null,20.0);
        Guest guest = new Guest(null,guestAccount);
        HiLo hiloGame = new HiLo(guest);
        Player player = new Player(guest);
        Card firstCard = new Card(Card.Suit.HEARTS, Card.Rank.THREE);
        Card secondCard = new Card(Card.Suit.HEARTS,Card.Rank.JACK);


        //When
        hiloGame.winning();



        //Then
    }




}
