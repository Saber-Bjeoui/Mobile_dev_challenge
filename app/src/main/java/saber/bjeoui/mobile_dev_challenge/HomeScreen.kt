package saber.bjeoui.mobile_dev_challenge

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.time.LocalDateTime


class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        println("hello world")

        val currentDateText: TextView = findViewById(R.id.current_date_text)

        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val formatter = SimpleDateFormat("MMM dd ','yyyy")
        val parsedDate: String = formatter.format(parser.parse(LocalDateTime.now().toString()))
        currentDateText.text = parsedDate

    }
}