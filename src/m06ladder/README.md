#### 요구사항
    사다리 게임은 가로선을 높이, 세로줄 번호( 가로 ) 형태로 나타낼 수 있음
    사다리를 만나면 오른쪽으로 이동함
    마지막에 도착하면 세로줄 번호 ( 가로 ) 숫자를 출력
#### 고민
    1. 협력
        Bridge -> Person ( 건너! )
        Person -> Point ( 변경해! );
    2. 책임
        Bridge - 
        
    실패 -
        Bridge - Ladder ( extends Location )
        Person - LadderGamer ( extends Location )
        구조에서 Ladder 와 LadderGamer 의 필드값을 비교하는 로직이 필요한데 
        로직을 실행하는 클래스는 LadderList 여야 하고 ( List<Ladder> 필드가 필요함 )
        비교하는 로직 이후 수행해야 할 로직은 ( cross() ) Bridge 에 있음
        
#### 테스트코드
