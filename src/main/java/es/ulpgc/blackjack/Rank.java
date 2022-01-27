package es.ulpgc.blackjack;

public enum Rank {
    Ace,King,Queen,Jack,_10,_9, _8, _7, _6, _5, _4, _3, _2;
    public final String symbol;
    Rank(){
        this.symbol = this.name().charAt(0) == '_' ? this.name().substring(1) : this.name().substring(0,1);
    }

}
