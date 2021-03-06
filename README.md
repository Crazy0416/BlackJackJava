# BlackJack

생 자바 코드로 블랙잭 만들어 보기

## 의존성
- java 1.8 버전

## 설치 및 실행
- wget https://github.com/Crazy0416/BlackJackJava/releases/download/1.0/BlackJackGame.jar
- java -jar BlackJackGame.jar

## 블랙잭 룰

- 딜러와 게이머 단 2명만 존재한다.
- 카드는 조커를 제외한 52장이다. (즉, 카드는 다이아몬드,하트,스페이드,클럽 무늬를 가진 A,2~10,K,Q,J 으로 이루어져있다.)
- 2~10은 숫자 그대로 점수를, K/Q/J는 10점으로, A는 1로 계산한다. (기존 규칙은 A는 1과 11 둘다 가능하지만 여기선 1만 허용하도록 스펙아웃)
- 딜러와 게이머는 순차적으로 카드를 하나씩 뽑아 각자 2개의 카드를 소지한다.
- 게이머는 얼마든지 카드를 추가로 뽑을 수 있다.
- 딜러는 2카드의 합계 점수가 16점 이하이면 반드시 1장을 추가로 뽑고, 17점 이상이면 추가할 수 없다.
- 양쪽다 추가 뽑기 없이, 카드를 오픈하면 딜러와 게이머 중 소유한 카드의 합이 21에 가장 가까운 쪽이 승리한다.
- 딜러와 유저가 동점이라면 딜러가 이기도록 한다.
- 단 21을 초과하면 초과한 쪽이 진다.


## 클래스간 관계
![클래스 관계도](https://raw.githubusercontent.com/Crazy0416/BlackJackJava/master/resources/BlackJack.png)


## 사용되는 클래스

- 카드 덱(CardDeck)
- 카드(Card)
- 규칙(Rule)
- 딜러(BlackJackDealer)
- 게이머(BlackJackPlayer)
- 게임방(Room)



## 블랙잭 메서드 정리

[블랙잭 메서드 정리 md](https://github.com/Crazy0416/BlackJackJava/blob/master/resources/%EB%B8%94%EB%9E%99%EC%9E%AD%20%EB%A9%94%EC%84%9C%EB%93%9C%20%EC%A0%95%EB%A6%AC.md)

