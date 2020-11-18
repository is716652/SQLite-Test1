package is716652.me.sqlite_test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Btn_Main_CreateDB.setOnClickListener {
            val objDBHelper = DBHelper(this,"test.db",3)
            val h :Int=3
        }
    }
}