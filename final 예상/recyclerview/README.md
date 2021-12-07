data 클래스 사용. 

ViewModel 적용.

26 binding 방식 개선.

클릭 이벤트 처리.

CardView 적용.

1. data class를 생성한다.
2. 의존성 라이브러리 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1'를 추가한다.
3. View model를 생성하고, ViewModel() 상속한다.
4. item 레이아웃(layout폴더에) 생성하고, 필요한 리소스(사진 등)을 추가한다.
5. View모델에 데이터를 추가한다.
6. Main에서 ViewModel을 연결해준다.
7. MyViewHolder와 MyAdapter를 구현해준다. 
8. 리스너가 필요할 경우, MyViewHolder에 인터페이스를 상속시킨다.
9. recyclerView에 어댑터를 연결해준다.
