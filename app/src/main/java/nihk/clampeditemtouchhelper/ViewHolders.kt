package nihk.clampeditemtouchhelper

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.header_item.view.*
import kotlinx.android.synthetic.main.list_item.view.*

class HeaderItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: Item) {
        itemView.title.text = item.text
        if (item.group == Group.RED) {
            itemView.setBackgroundColor(Color.RED)
        } else {
            itemView.setBackgroundColor(Color.BLUE)
        }
    }
}

class ListItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var itemInternal: Item? = null
    val item get() = itemInternal!!

    @SuppressLint("ClickableViewAccessibility")
    fun bind(item: Item, gestureCallbacks: GestureCallbacks) {
        itemInternal = item
        itemView.name.text = item.text

        itemView.drag.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                gestureCallbacks.onStartDrag(this)
            }
            false
        }
    }
}