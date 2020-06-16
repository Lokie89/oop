### 객체지향 코드 연습
    각 미션에 해당하는 내용은 패키지 안에 명시되어있음. (최대한 국룰을 따랐음)
    
    실행 방법
        1. 요구사항을 분석
        2. 고민
        3. 테스트 코드 작성
        4. 코딩
        5. 요구사항 지켰는지 확인 ( 반복 )
        6. 코딩 룰을 지켰는지 확인 ( 반복 )
        7. 리팩토링 ( 반복 )
        8. 누구나 알아볼 수 있는지 확인 ( 반복 )
        
    코딩 룰
        규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.
        규칙 2: else 예약어를 쓰지 않는다.
        규칙 3: 모든 원시값과 문자열을 포장한다.
        규칙 4: 한 줄에 점을 하나만 찍는다.
        규칙 5: 줄여쓰지 않는다(축약 금지).
        규칙 6: 모든 엔티티를 작게 유지한다.
        규칙 7: 2개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
        규칙 8: 일급 콜렉션을 쓴다.
        규칙 9: 게터/세터/프로퍼티를 쓰지 않는다.
    
    문제
        01. baseball
        02. racing car
        03. lotto
        04. string carculator
        05. blackjack
        06. ladder
        07. find mine
        08. chess
        09. httpserver
        10. framework
        11. racing game

설계 원칙        
1. 클래스 우선이 아닌, 객체의 속성과 행위가 우선이다.
    <ul>클래스는 객체를 추상화하는 도구일 뿐이다.</ul>
    
2. 데이터가 아닌 메세지(행위)를 중심으로 객체를 설계해라.
    <ul>객체는 혼자 있을 수 없다. 다른 객체와의 협력 안에서만 존재할 수 있다.</ul>
    <ul>메세지를 중심으로, 해당 메세지가 어떤 객체를 필요로 하는지를 생각하자.</ul>
    
3. 하나하나 지시하지 말고 요청해라.
    <ul>예를들어, 판사가 증인에게 1) 목격했던 장면을 떠올리고, 2) 떠오르는 시간을 순서대로 구성하고, 3) 말로 간결하게 표현해라 라고 요청하지 않는다. 그냥 "증언하라" 라고 요청한다.</ul>
    <ul>마찬가지로 객체의 설계단계에서도 책임이 있는 객체에 요청만 하도록 설계한다.</ul>
    
4. 하나의 메소드는 하나의 일만 해야한다.

5. 처음부터 완벽한 설계는 없다.
    <ul>설계를 코드로 구현해가는 과정에서 수정이 필요하다면 설계를 수정한다.</ul>
    
객체지향의 사실과 오해
추가
1. 객체가 어떤 행동을 하느냐에 따라 객체의 타입을 결정
2. 객체 내부의 상태는 어떻게 표현해도 상관없음.
방법 : 모든 행동을 클래스로 만들고, 그 이후 같은 객체 ( 같은 행동을 하는 ) 클래스를 추상화 시킨 인터페이스로 묶기
///

3. 첫번째는 객체간의 협력을 토대로 책임 설계
4. 이후 객체가 필요한 행위 정의
5. 행위에 필요한 필드 정의