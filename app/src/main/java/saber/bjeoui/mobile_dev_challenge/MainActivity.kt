package saber.bjeoui.mobile_dev_challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnContinue = findViewById<Button>(R.id.button_continue)


        btnContinue.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            val editTextInput = findViewById<EditText>(R.id.editText_username)

            if (editTextInput.text.toString() == "") {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val user = User(editTextInput.text.toString())
                intent.putExtra("username", user.name)
                startActivity(intent);
                editTextInput.setText("")
            }
        }
    }
}