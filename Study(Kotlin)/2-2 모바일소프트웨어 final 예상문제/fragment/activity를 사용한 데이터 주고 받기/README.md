1. 상호작용할 두 fragment 생성.
2. 두 개의 container view 생성. (tools:layout = "@layout/..." 해야 미리보기로 보임)
3. 각 fragment 디자인
4. data를 보내는 fragment 코틀린 코드 작성
 
   ㄱ. 이벤트 리스너 인터페이스 상속받기
   
   ㄴ. main에서 호출할 함수 interface 작성하기
   
   ㄷ. onattach 메서드 구현하기
   
   ㄹ. oncreateView 안에서 이벤트 처리하기
   
   ㅁ. 추가 상황별 이벤트 처리하기(ex.toolbar)
   
5. data를 받는 fragment에서 변경하는 함수 작성.
6. main에서 아까 정의한 인터페이스 상속받아 구현하기
