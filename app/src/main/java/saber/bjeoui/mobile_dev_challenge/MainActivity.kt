package saber.bjeoui.mobile_dev_challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("hello world")

        val buttonOne = findViewById<Button>(R.id.btn1)
        buttonOne.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent);
        }
    }
}