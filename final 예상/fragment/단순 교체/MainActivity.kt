import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragment_container : FrameLayout = findViewById(R.id.fragment_container)
        if (fragment_container != null){
            if(savedInstanceState != null)
                return
            //만약 null인 경우, 프래그먼트 A로 초기화 한다.
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, FragmentA())
                .addToBackStack(null)
                .commit()
        }

        var buttonA: Button = findViewById(R.id.buttonA)
        buttonA.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, FragmentA())
                addToBackStack(null)
                commit()
            }
        }

        var buttonB:Button = findViewById(R.id.buttonB)
        buttonB.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, FragmentB())
                addToBackStack(null)
                commit()
            }
        }

    }
}
