package com.blackjack.www;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class BlackJackUser extends User implements SetManager{

    protected LinkedList<Card> cardList;
    protected int state;
    protected CardDeck roomCardDeck;

    public BlackJackUser(String name, String uid) {
        super(name, uid);
        state = 0;
        cardList = new LinkedList<>();
    }

    public void drawCard() {
        Card card = roomCardDeck.drawCard();
        cardList.add(card);
    }

    public int getScore() {
        int result = 0;
        Iterator iter = cardList.iterator();
        Card card = null;

        while(iter.hasNext()) {
            card = (Card) iter.next();
            int score = card.getNUMBER();
            if(score > 10)
                score = 10;
            result += score;
        }

        return result;
    }

    public Iterator getFirstOpenCardIter() {
        if(cardList.size() < 2) {
            return null;
        }

        Iterator iter = cardList.iterator();
        iter.next();
        return iter;
    }

    // TODO: myTurn 메서드 완료하기
    public abstract void myTurn();

    public void viewOpenCard() {
        Iterator iter = this.getFirstOpenCardIter();
        Card card;
        System.out.print(this.uid + "의 오픈된 카드: ");
        System.out.print("XXXX XX || ");

        while(iter.hasNext()) {
            card = (Card) iter.next();
            System.out.print(card.getPATTERN() + " " + card.getNUMBER() + " || ");
        }
        System.out.print("\n");
    }

    public LinkedList<Card> getCardList() {
        return cardList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public CardDeck getRoomCardDeck() {
        return roomCardDeck;
    }

    public void setRoomCardDeck(CardDeck roomCardDeck) {
        this.roomCardDeck = roomCardDeck;
    }

    @Override
    public String toString() {
        return "BlackJackUser=> uid: " + this.uid + " || name: " + this.name;
    }

    @Override
    public void initSet(CardDeck cardDeck) {
        this.cardList.clear();
        this.state = 0;
        this.roomCardDeck = cardDeck;
        this.drawCard();
        this.drawCard();
    }
}
