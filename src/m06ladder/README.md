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
    수정 - 
        구현 로직 중 실제 LadderList 를 직접 사용해야 하는 로직이 필요했음.
        이유는 사다리 위에 사람이 있는 가를 판별하는 로직을 같거나 옆에있는 사다리 개수를 카운트해서 분기 태우기 때문
        수정 로직은 실제 사다리들을 PointY 를 기준으로 오름차순으로 정렬 하면 실제 이동을 하기 위해 필요한 데이터가 이후에 나오기때문에
        로직에 이상이 없음
        그래서 Bridge 의 역할을 수행할 수 있게 됨
        Ladder 로 구현하고 Person 과 협력함
        - 문제
            Bridge 의 cross 부분 로직에서 필요한 것은 Point 의 비교하기위해 Location 또는 Ladder 로 받았어야 했는데
            파라미터 값을 Person 인터페이스로 받기위해서 equals 메서드를 추가해 Location 으로 캐스팅 하는 로직을 추가하게 됨
            이 것이 불필요 한것인지 ( 굳이 인터페이스 파라미터를 사용하지 않아도 확장성에는 영향이 없다 )
            아니면 확장성이 좋게? 할지는 모르지만 필요한지 를 정확하게 분별하기 어려움
            ---------------------- 해결 할 것 ---------------------- 
#### 테스트코드
