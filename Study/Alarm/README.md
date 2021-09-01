# Alarm 동작방법

- *AlarmManager* 를 이용해 알람기능 실행
- *AlarmManager* 에게 호출할 *Receiver*와 실행할 시간을 설정함
- *Receiver*는 이를 받아서 *Service*를 호출함
- *Service*에 원하는 동작을 구현하면 됨


DatePickerDialog와 TimePicker를 이용한 알람 설정

Service에서 (알람 종료를 위한)알람창 호출
