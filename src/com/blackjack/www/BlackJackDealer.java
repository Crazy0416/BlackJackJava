package com.blackjack.www;

public class BlackJackDealer extends BlackJackUser{

    public BlackJackDealer(String name, String uid) {
        super(name, uid);
    }

    @Override
    public void myTurn() {
        System.out.println(this.toString() + ": 딜러 턴에 실행할 동작을 선택 중입니다.");
        if(this.getScore() <= 16) {
            this.drawCard();
            System.out.println(this.toString() + ": 딜러는 카드를 드로우 했습니다.");
            if(this.getScore() > 21) {
                System.out.println(this + ": 21을 초과하여 죽었습니다.");
                this.setState(2);
            }
        } else if(this.getScore() <= 21) {
            System.out.println(this.toString() + ": 딜러는 스톱했습니다.");
            this.setState(1);
        }
    }
}
