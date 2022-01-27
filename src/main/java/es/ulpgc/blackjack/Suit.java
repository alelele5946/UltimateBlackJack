package es.ulpgc.blackjack;

public enum Suit {
    Diamonds ("♦"), Clubs ("♣"), Hearts ("♥") , Spades ("♠");

    public final String symbol;
    Suit(String symbol) {
        this.symbol = symbol;
    }
}
