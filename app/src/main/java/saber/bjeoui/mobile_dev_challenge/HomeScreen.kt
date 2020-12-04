package saber.bjeoui.mobile_dev_challenge

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.ArrayList


class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

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
        val roomsList = listOf(
            Room("Bathroom", listOf(connectedBulb, smartSpeaker), R.drawable.bathroom),
            Room(
                "Living room",
                listOf(
                    smartSpeaker,
                    smartTv,
                    airCond,
                    thermostatController,
                    connectedBulb,
                    ipCamera
                ),
                R.drawable.livingroom
            ),
            Room(
                "Media room",
                listOf(smartSpeaker, smartTv, connectedBulb, airCond),
                R.drawable.mediaroom
            ),
            Room(
                "Bedroom",
                listOf(smartSpeaker, smartTv, thermostatController, ipCamera),
                R.drawable.bedroom
            ),
            Room(
                "Bedroom",
                listOf(smartSpeaker, smartTv, thermostatController, ipCamera),
                R.drawable.bedroom
            ),
            Room(
                "Bedroom",
                listOf(smartSpeaker, smartTv, thermostatController, ipCamera),
                R.drawable.bedroom
            )

        )

        //Creating list of cardViews representing the list of rooms
        val cadrViewList = roomsList.map {
            RoomItemCardView(it.backGroungImage, it.name, it.devices.count())
        }


        val recyclerViewRooms: RecyclerView = findViewById(R.id.recyclerView_list_of_rooms)

        recyclerViewRooms.adapter = RoomItemCardViewAdapter(cadrViewList)
        recyclerViewRooms.layoutManager = LinearLayoutManager(this)


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