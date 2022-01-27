package es.ulpgc.blackjack;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class Hand {
    public List<Card> cards = new ArrayList<>();


    public Hand add(Card card) {
        cards.add(card);
        return this;
    }


    public int value() {
        return minimize(cards.stream().mapToInt(this::value).sum());
    }

    private int minimize(int sum) {
        return sum - min(currentAces() , neededAces(sum))*10;
    }

    private int neededAces(int sum) {
        return  max( 0 , (sum / 11 -1));
    }

    private int currentAces() {
        return (int) cards.stream().filter(c -> c.rank == Rank.Ace).count();
    }

    private int value(Card card) {
        return card.isNumber() ? valueOf(card) : card.rank == Rank.Ace ? 11 : 10;
    }



    private int valueOf(Card card) {
        return parseInt(card.rank.symbol);
    }


    public Card addFirst() {
        return cards.remove(0);
    }

    public int length() {
        return cards.size();
    }

    public boolean Ace() {
        return currentAces() > 0;
    }
}
