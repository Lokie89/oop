#### 요구사항
    (1) 임의의 중복되지 않은 3개의 숫자 생성 (0~9까지의 난수)
    (2) 사용자의 입력숫자 3개에 대해서 숫자와 위치를 체크하여 결과 반환
        (숫자만 일치 : Ball / 숫자와 위치 둘다일치 : Strike)
    (3) 스트라이크가 3개이면 우승으로 판정 
    (4) 게임의 시도횟수가 10번 초과하면 실패(게임오버) 판정
        
#### 고민
##### 주요 객체
* 야구게임
* 야구게임 문제
* 야구게임의 숫자
* 랜덤숫자 생성기
* 규칙
* 게이머
##### 주요 객체의 속성과 역할
* 야구게임
    - 야구게임 문제를 가지고 있다.
    - 10번 시도하면 게임은 끝이난다.
* 야구게임 문제
    - 야구게임의 숫자를 가지고있다.
* 야구게임의 숫자
    - 0 ~ 9까지의 숫자이다.
* 랜덤숫자 생성기
    - 임의의 숫자를 생성한다.
* 규칙
    - 결과를 알려준다.
* 플레이어
    - 서로 다른 숫자 3개를 입력한다.
    
            
#### 테스트코드