# KT DS JAVA 교육
KT DS 웹 융합 어플리케이션 개발자 양성과정 JAVA 학습 - Team2

## Cafe Menu Management System
### v1.0.0
<a href="https://naver.com"><img src="https://img.shields.io/badge/1st Proejct-000000?style=flat-square&logo=Github&logoColor=white"/></a>
<a href="https://naver.com"><img src="https://img.shields.io/badge/view ReadMe-000000?style=flat-square&logo=ReadMe&logoColor=white"/></a>
#### 주요 기능
  - 등록
  - 수정
  - 삭제
  - 조회(1개)
  - 조회(종류별)
  - 조회(전체)

#### 추가 예정 기능
  - 동일 아이템 중복 등록 방지
  - 메뉴 입력 과정에서 잘못된 타입의 입력 방지
  - 각 메뉴 별 가격 추가 및 옵션(샷 추가, 휘핑추가, ... etc) 추가 기능
  - 각 메뉴 별 수량 추가
  - 각 메뉴 재고 없을 시 품절 상태 기능
  - Customer를 통한 판매 기능
    + 메뉴 조회 ( 재고 없을 시, 품절 표시)
    + 장바구니 담기 (대량 구매)
    + 바로 구매 (1개 구매시)
    + 결제
    + 주문 번호 출력
    + 영수증 출력
    
  - DB 학습 후 DB 연동
    + 각 아이템 수량을 DB와 연동
    + 관리자 계정 DB연동
    + 사용자 계정 DB연동
    
  - FrontEnd 학습 후 직접 웹 화면에 출력
    + 홈페이지
    + 회원가입
      * 아이디, 비밀번호, 유효성 검사
      * DB에 저장
    + 로그인
      * DB와 비교하여 올바른 아이디 비밀번호인지
    + 관리자 계정
      * 사용자 계정 기능 + 관리자 메뉴
    + 사용자 계정
      * 금액을 충전하는 방식으로 본인의 지갑을 통한 구매
    + 주문 페이지
      * 각 카테고리 별 분류
      * 각 아이템 별 이미지, 이름, 가격, 수량설정 버튼, 구매 버튼, 장바구니 추가 버튼
    + 장바구니 페이지
      * 각 아이템 별 이미지, 이름, 가격, 수량조정 버튼, 총 금액, 구매 버튼, 취소 버튼
    + 결제 페이지
      * 본인의 지갑 금액을 불러와 결제
    + 결제 후 주문번호 및 영수증 출력
