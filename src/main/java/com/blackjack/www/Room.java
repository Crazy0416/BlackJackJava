package com.blackjack.www;

import java.util.LinkedList;

public class Room {
    private LinkedList<BlackJackUser> userList;
    private BlackJackDealer dealer;
    private Rule rule;

    public Room() {
        userList = new LinkedList<>();
        dealer = new BlackJackDealer("dealer", "dealer");
        rule = new Rule();
    }

    public void addUser(BlackJackUser user) {
        userList.add(user);
    }

    public void gameStart() {
        BlackJackPlayer user = new BlackJackPlayer("testName", "testUid");
        this.addUser(user);
        this.addUser(dealer);
        rule.startSet(userList);
    }
}
