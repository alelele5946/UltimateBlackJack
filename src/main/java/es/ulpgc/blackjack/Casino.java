package es.ulpgc.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Casino {
    public String getWinners(Hand croupier, Hand deck, Hand... players) {

        List<String> winningPlayers = new ArrayList<>();

        for(int i = 0; i<players.length; i++)
        {
            if(this.wins(croupier,deck, players[i]))
            {
                winningPlayers.add("Player"+(i+1));
            }
        }

        return "getWinners(...)-----> [" + String.join(",",winningPlayers)  + "]";
    }

    public int evaluateCroupier(Hand croupier, Hand deck) {
        while(croupier.value() < 17 && deck.length() > 0){
            croupier.add(deck.addFirst());
        }
        return croupier.value();
    }

    public boolean isBlackJack(Hand hand) {
     return hand.length() == 2 && hand.Ace() && hand.value() == 21;
    }

    public boolean wins(Hand croupier, Hand deck, Hand player1) {
        this.evaluateCroupier(croupier,deck);
        return !this.isBlackJack(croupier) && ( (player1.value() <= 21 && player1.value() > croupier.value()) || this.isBlackJack(player1));
    }
}
