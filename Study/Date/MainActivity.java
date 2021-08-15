import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
  
    private long mNow;
    private Date mDate;
    private SimpleDateFormat mFormat = new SimpleDateFormat("MM/dd"); //표현하고자 하는 날짜 형식 지정.
    private TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
      
        date = view.findViewById(R.id.date);
        date.setText(getTime());
    }
  
  //시스템으로부터 시간을 받아와 지정한 형식대로 날짜 데이터를 반환하는 메소드 직접 작성.
  private String getTime() { 
        mNow = System.currentTimeMillis();
        mDate= new Date(mNow);
        return mFormat.format(mDate);
    }
}
