package com.blackjack.www;

import java.util.Iterator;
import java.util.Scanner;

public class BlackJackPlayer extends BlackJackUser{

    public BlackJackPlayer(String name, String uid) {
        super(name, uid);
    }

    public void showMyCardList() {
        Iterator iter = this.cardList.iterator();

        System.out.println("보유한 카드 리스트:");
        while(iter.hasNext()) {
            Card card = (Card) iter.next();
            System.out.println(" || Card : "  + card.getNUMBER() + " || ");
        }
    }

    @Override
    public void myTurn() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(this.toString() + ": 내 턴에 실행할 동작을 선택하세요.");
        System.out.println("1. 카드 드로우");
        System.out.println("2. 스톱");
        System.out.println("3. 다이");
        showMyCardList();
        System.out.println("현재 내 점수: " + this.getScore());
        int choice = 0;

        try{
            choice = Integer.parseInt(scanner.nextLine());
            while(choice <= 0 || choice >= 4) {
                System.out.println("다시 입력해주세요.");
                choice = Integer.parseInt(scanner.nextLine());
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();

        }

        switch(choice) {
            case 1:
                this.drawCard();
                if(this.getScore() > 21) {
                    System.out.println(this + ": 21을 초과하여 죽었습니다.");
                    this.setState(2);
                }
                break;
            case 2:
                System.out.println(this + ": 게임을 스톱합니다.");
                this.setState(1);
                break;
            case 3:
                System.out.println(this + ": 다이를 선택합니다.");
                this.setState(2);
                break;
        }
    }
}
