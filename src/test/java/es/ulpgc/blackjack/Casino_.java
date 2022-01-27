package es.ulpgc.blackjack;

import org.junit.Test;

import static es.ulpgc.blackjack.Rank.*;
import static es.ulpgc.blackjack.Suit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Casino_ {
    @Test
    public void evaluate_croupier_method_case_1_should_return_21() {
        Casino casino = new Casino();
        Hand croupier = new Hand();

        croupier.add(new Card(_9, Hearts)).add(new Card(_7, Clubs));

        Hand deck = new Hand();
        deck.add(new Card(_5, Clubs)).add(new Card(_4, Spades))
                .add(new Card(King, Diamonds))
                .add(new Card(_2, Hearts));
        assertThat(casino.evaluateCroupier(croupier, deck)).isEqualTo(21);


    }

    @Test
    public void evaluate_croupier_method_case_2_should_return_19() {
        Casino casino = new Casino();
        Hand croupier = new Hand();

        croupier.add(new Card(_5, Hearts)).add(new Card(_10, Clubs));

        Hand deck = new Hand();
        deck.add(new Card(Ace, Clubs)).add(new Card(_3, Spades))
                .add(new Card(King, Diamonds))
                .add(new Card(_2, Hearts));
        assertThat(casino.evaluateCroupier(croupier, deck)).isEqualTo(19);


    }

    @Test
    public void evaluate_getWinner_method_case_1_one_player_should_generate_Player1() {
        Casino casino = new Casino();
        Hand croupier = new Hand();
        croupier.add(new Card(_9, Hearts)).add(new Card(_7, Clubs));

        Hand player1 = new Hand().add(new Card(Jack, Hearts)).add(new Card(Ace, Clubs));
        Hand player2 = new Hand().add(new Card(_10, Hearts)).add(new Card(_5, Clubs)).add(new Card(_6, Clubs));
        Hand player3 = new Hand().add(new Card(_3, Hearts)).add(new Card(_6, Hearts)).add(new Card(Ace, Clubs)).add(new Card(_3, Hearts)).add(new Card(Ace, Clubs)).add(new Card(King, Clubs));

        Hand deck = new Hand().add(new Card(_5, Clubs)).add(new Card(_4, Spades))
                .add(new Card(King, Diamonds))
                .add(new Card(_2, Hearts));


        System.out.println(casino.getWinners(croupier,deck,player1,player2,player3));

    }

    @Test
    public void evaluate_getWinner_method_case_1_one_player_should_generate_Player33() {
        Casino casino = new Casino();
        Hand croupier = new Hand();
        croupier.add(new Card(_5, Hearts)).add(new Card(_10, Clubs));

        Hand player1 = new Hand().add(new Card(_10, Hearts)).add(new Card(King, Clubs));
        Hand player2 = new Hand().add(new Card(_10, Hearts)).add(new Card(_2, Clubs)).add(new Card(_6, Clubs));
        Hand player3 = new Hand().add(new Card(_8, Hearts)).add(new Card(_8, Hearts)).add(new Card(_5, Clubs));

        Hand deck = new Hand().add(new Card(Ace, Clubs)).add(new Card(_3, Spades))
                .add(new Card(King, Diamonds))
                .add(new Card(_2, Hearts));


        System.out.println(casino.getWinners(croupier,deck,player1,player2,player3));

    }



    @Test
    public void is_Black_Jack_True() {
        Casino casino = new Casino();
        Hand player1 = new Hand();
        player1.add(new Card(Jack, Hearts)).add(new Card(Ace, Clubs));
        assertThat(casino.isBlackJack(player1)).isEqualTo(true);


    }

    @Test
    public void is_Black_Jack_False() {
        Casino casino = new Casino();
        Hand player = new Hand();

        player.add(new Card(_9, Hearts)).add(new Card(Ace, Clubs));
        assertThat(casino.isBlackJack(player)).isEqualTo(false);


    }

    @Test
    public void is_Black_Jack_False2() {
        Casino casino = new Casino();
        Hand player = new Hand();

        player.add(new Card(_9, Hearts)).add(new Card(_2, Clubs));
        assertThat(casino.isBlackJack(player)).isEqualTo(false);


    }

    @Test
    public void player_wins() {
        Casino casino = new Casino();
        Hand player1 = new Hand();
        player1.add(new Card(_10, Hearts)).add(new Card(_5, Clubs))
                .add(new Card(_6, Clubs));
        Hand croupier = new Hand();

        croupier.add(new Card(_9, Hearts)).add(new Card(_7, Clubs));
        Hand deck = new Hand();
        deck.add(new Card(_5, Clubs)).add(new Card(_4, Spades))
                .add(new Card(King, Diamonds))
                .add(new Card(_2, Hearts));
        assertThat(casino.wins(croupier, deck, player1)).isEqualTo(false);

    }
}
