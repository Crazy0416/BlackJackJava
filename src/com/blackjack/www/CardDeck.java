package com.blackjack.www;

import java.util.*;

public class CardDeck {

    private LinkedList<Card> deckList;

    public CardDeck() {
        deckList = new LinkedList<Card>();
        Hashtable<Integer, String> patternTable = new Hashtable<>();
        patternTable.put(0, "Diamond");
        patternTable.put(1, "Spade");
        patternTable.put(2, "Heart");
        patternTable.put(3, "Club");

        for(int patternIdx = 0; patternIdx < 4; patternIdx++) {
            for(int num = 1; num <= 13; num++) {
                Card card = new Card(patternTable.get(patternIdx), num);
                deckList.add(card);
            }
        }
    }

    public Card drawCard() {
        Card card = deckList.pop();
        return card;
    }

    public void shuffle() {
        Collections.shuffle(deckList);
    }

    // TODO: toString 메서드 완료하기.
    @Override
    public String toString() {
        String str = this + " CardList: ";
        Iterator iter = deckList.iterator();

        while(iter.hasNext()) {
            Card card = (Card) iter.next();
            str += card.toString();
        }

        return str;
    }
}
