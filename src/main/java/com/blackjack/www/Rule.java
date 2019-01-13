package com.blackjack.www;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Rule {
    private LinkedList<BlackJackUser> orderList;
    private CardDeck cardDeck;

    public Rule() {
        cardDeck = new CardDeck();
        orderList = new LinkedList<>();
    }

    public void setUserOrder(LinkedList<BlackJackUser> userList) {
        this.orderList = userList;
        Collections.shuffle(this.orderList);
    }

    /*
    - 세트가 끝날 때 어떤 User가 이겼는지 확인할 때 사용.

     */
    public BlackJackUser getWinner() {

        Iterator iter = orderList.iterator();
        int Max_result = 0;
        int allDie = 0;
        BlackJackUser winner = orderList.getFirst();
        BlackJackUser user = null;

        while(iter.hasNext()) {
            user = (BlackJackUser) iter.next();
            int result = user.getScore();

            System.out.println(user + "의 상태: " + user.getState() + " 점수: " + result);

            if(user.getState() == 2) {
                allDie++;
                continue;
            }

            if((user instanceof BlackJackDealer)? Max_result <= result : Max_result < result) {
                winner = user;
                Max_result = result;
            }
        }

        if(allDie == orderList.size())
            winner = null;

        return winner;
    }

    public void initSet(LinkedList<BlackJackUser> gameUserList) {
        cardDeck = new CardDeck();
        cardDeck.shuffle();
        setUserOrder(gameUserList);

        Iterator iter = orderList.iterator();
        BlackJackUser user = null;

        while(iter.hasNext()) {

            user = (BlackJackUser) iter.next();
            user.initSet(this.cardDeck);
        }
    }

    /*
    세트가 시작될 때 사용하는 메서드
     */
    public void startSet(LinkedList<BlackJackUser> gameUserList) {

        int allDieCnt;
        this.initSet(gameUserList);

        while(true) {

            allDieCnt = 0;      // 값 초기화;
            Iterator iter = orderList.iterator();
            BlackJackUser user = null;

            while(iter.hasNext()) {

                user = (BlackJackUser) iter.next();

                if(user.getState() >= 1) {
                    allDieCnt++;
                    continue;
                }
                viewCurrentSituation();
                user.myTurn();
            }

            if(allDieCnt == orderList.size()) {
                BlackJackUser winner = this.getWinner();
                if(winner == null) {
                    System.out.println("모두 죽었기 때문에 승자는 없습니다.");
                } else {
                    System.out.println("세트 승자 " + winner.toString());
                }

                System.out.println("세트 종료");
                break;
            }
        }
    }

    public void viewCurrentSituation(){
        Iterator iter = orderList.iterator();
        BlackJackUser user = null;

        while(iter.hasNext()) {
            user = (BlackJackUser) iter.next();

            user.viewOpenCard();
        }
    }
}
