#### 요구사항
    1. 지뢰들은 숨겨져 있다.
    2. 숨겨진 부분을 열었을 때 지뢰면 실패
    3. 성공하면 모든 지뢰가 숨겨지지 않은 부분을 찾을 때 까지 진행한다.
    4. 그럼 제목이 지뢰 안찾기 나 피하기 아닌가?
    5. 좀 편하게 하기위해 지뢰보드는 크기가 정사각형임
#### 고민
    1. Miner - 땅을 파는 행위 - void dig(MineBoard);
    2. MineBoard - 해당 포인트의 땅을 파는 행위 - void digPoint(Mine);
    3. Mine - 지뢰인지 아닌지 확인 하는 행위 -  void findBomb(); 
#### 테스트코드