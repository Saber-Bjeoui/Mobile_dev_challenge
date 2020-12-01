package saber.bjeoui.mobile_dev_challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonOne = findViewById<Button>(R.id.btn1)


        buttonOne.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            val editTextInput = findViewById<EditText>(R.id.editText_username)
            val user = User(editTextInput.text.toString())

            intent.putExtra("username", user.name)
            startActivity(intent);
        }
    }
}