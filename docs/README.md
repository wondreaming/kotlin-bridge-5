## 📋 기능 구현 목록

### 🙋 입력

- [X] 다리의 길이
    - [X] 빈값
    - [X] IntOrNull
    - [X] 3~20사이

- [X] 위 아래 선택
    - [X] 빈값
    - [X] U, D

- [X] 다시 시도 여부 선택
    - [X] 빈값
    - [X] R, Q


### 🖥 출력

- [X] 서비스 시작 문구 : "다리 건너기 게임을 시작합니다."
- [X] 다리의 길이 입력 : "다리의 길이를 입력해주세요."
- [X] 위, 아래 선택 : "이동할 칸을 선택해주세요. (위: U, 아래: D)"
- [X] 게임 다시 시도 여부 : "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
- [ ] 게임 종료 문구
    ```
  최종 게임 결과
  [ O |   |   ]
  [   | O | O ]
  
  게임 성공 여부: 성공
  총 시도한 횟수: 2
  ```
### 🌈 로직

1. 다리의 길이 입력
2. Random이 0이면, 아래 칸 1 -> 위칸
- 매 라운드마다 이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D를 입력한다.
- 이동한 칸을 건널 수 있다면 O로 표시한다. 건널 수 없다면 X로 표시한다.
- - 다리를 끝까지 건너면 게임이 종료된다.
- 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다.
  - 재시작해도 처음에 만든 다리로 재사용한다.