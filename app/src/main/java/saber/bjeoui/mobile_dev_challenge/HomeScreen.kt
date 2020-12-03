package saber.bjeoui.mobile_dev_challenge

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.time.LocalDateTime


class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        println("hello world")

        // I think here at this point in a fully functional app we need to go and fetch data from server
        // So I created some dummy data to work with

        //devices
        val smartTv = Device("SmartTV")
        val airCond = Device("Air conditioner")
        val thermostatController = Device("Thermostat")
        val connectedBulb = Device("Smart Bulb")
        val ipCamera = Device("IP Camera")
        val smartSpeaker = Device("Smart Speaker")

        //rooms
        val bathroom = Room("bathroom", listOf(connectedBulb, smartSpeaker))
        val livingRoom = Room("Living Room", listOf(smartSpeaker, smartTv, airCond, thermostatController, connectedBulb, ipCamera))
        val mediaRoom = Room("Media Room", listOf(smartSpeaker, smartTv, connectedBulb, airCond))
        val bedRoom = Room("BedRoom", listOf(smartSpeaker, smartTv, thermostatController, ipCamera))

        val roomsList = listOf(livingRoom, bathroom, mediaRoom, bedRoom)

        val currentDateText: TextView = findViewById(R.id.textView_current_date)

        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val formatter = SimpleDateFormat("MMM dd ','yyyy")
        val parsedDate: String = formatter.format(parser.parse(LocalDateTime.now().toString()))
        currentDateText.text = parsedDate

        var username: String = intent.getStringExtra("username")

        val welcomeUserText: TextView = findViewById(R.id.textView_welcome_user)
        welcomeUserText.text = "Welcome, $username"

    }
}