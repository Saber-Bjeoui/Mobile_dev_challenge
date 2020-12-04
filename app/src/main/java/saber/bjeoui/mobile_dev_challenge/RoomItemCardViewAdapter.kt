package saber.bjeoui.mobile_dev_challenge

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RoomItemCardViewAdapter(private val roomsList: List<RoomItemCardView>) :
    RecyclerView.Adapter<RoomItemCardViewAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RoomItemCardViewAdapter.ItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_room_item, parent, false)

        return ItemViewHolder(view)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val currentItemData = roomsList[position]
        holder.roomNameTextView.text = currentItemData.roomName
        holder.nbrOfDevicesTextView.text = currentItemData.nbrOfDevices.toString() + " Devices"
        //holder.roomItemImageView.setImageResource(currentItemData.imageResource)
        holder.roomItemImageView.setBackgroundResource(currentItemData.imageResource)

    }

    override fun getItemCount(): Int = roomsList.size


    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val roomNameTextView: TextView = view.findViewById(R.id.textView_room_desc)
        val nbrOfDevicesTextView: TextView = view.findViewById(R.id.textView_nbr_of_devices)
        val roomItemImageView: ImageView = view.findViewById(R.id.imageView_room_image)
    }
}