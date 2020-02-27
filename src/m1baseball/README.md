#### 요구사항
    (1) 임의의 중복되지 않은 3개의 숫자 생성 (0~9까지의 난수)
    (2) 사용자의 입력숫자 3개에 대해서 숫자와 위치를 체크하여 결과 반환
        (숫자만 일치 : Ball / 숫자와 위치 둘다일치 : Strike)
    (3) 스트라이크가 3개이면 우승으로 판정 
    (4) 게임의 시도횟수가 10번 초과하면 실패(게임오버) 판정
    ++ 추가
        - 문제를 사람이 내기 가능
        게임 종료 후 입력했던 RECORD 알려줌
        여러 사람이 함께 컴퓨터의 문제 맞추기 가능
        
#### 고민
    기능별 나누기
        1. BaseBallGame - a. NumberList(문제), b. Judge(판단), c. Response(응답하는) 기능이 있는 게임
            a-1 RandomNumberGenerator
            b-1 Rule
        2. Member - a. NumberList(대답 or 문제), b. Pitch(전달), c. Response(응답받는), d. Record(기록)
            a-1 NumberList
            d-1 NumberList
#### 테스트코드