package es.ulpgc.blackjack;

import org.junit.Test;

import static es.ulpgc.blackjack.Rank.*;
import static es.ulpgc.blackjack.Suit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Hand_ {
    @Test
    public void value_should_be_5_when_cards_are_2d_3c() {

        Hand hand = new Hand();
        hand.add(new Card(_2, Diamonds)).add(new Card(_3, Clubs));
        assertThat(hand.value()).isEqualTo(5);
    }

    @Test
    public void value_should_be_10_when_cards_are_6s_4h() {

        Hand hand = new Hand();
        hand.add(new Card(_6, Spades)).add(new Card(_4, Hearts));
        assertThat(hand.value()).isEqualTo(10);

    }

    @Test
    public void value_should_be_13_when_cards_are_Qd_3h() {

        Hand hand = new Hand();
        hand.add(new Card(Queen, Diamonds)).add(new Card(_3, Hearts));
        assertThat(hand.value()).isEqualTo(13);

    }

    @Test
    public void value_should_be_21_when_cards_are_Ad_10h() {

        Hand hand = new Hand();
        hand.add(new Card(Ace, Diamonds)).add(new Card(_10, Hearts));
        assertThat(hand.value()).isEqualTo(21);

    }

    @Test
    public void value_should_be_13_when_cards_are_Ad_Ah_Ah() {

        Hand hand = new Hand();
        hand.add(new Card(Ace, Diamonds)).add(new Card(Ace, Hearts)).add(new Card(Ace, Hearts));
        assertThat(hand.value()).isEqualTo(13);

    }
}