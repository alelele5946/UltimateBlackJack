package es.ulpgc.blackjack;

public class Card {
    public final Rank rank;
    public final Suit suit;


    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public boolean isNumber(){
        String symbol = rank.symbol;
        return isNumber(symbol);
    }
    private boolean isNumber(String symbol) {
        for (char c : symbol.toCharArray()){
            if(c < '0' || c > '9') return false;
        }
        return true;
    }
}
