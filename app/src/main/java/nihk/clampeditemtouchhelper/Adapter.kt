package nihk.clampeditemtouchhelper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class Adapter(
    items: List<Item>,
    private val gestureCallbacks: GestureCallbacks
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: MutableList<Item> = items.toMutableList()

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is HeaderItem) {
            R.layout.header_item
        } else {
            R.layout.list_item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolderCreator: (View) -> RecyclerView.ViewHolder = if (viewType == R.layout.header_item) {
            ::HeaderItemViewHolder
        } else {
            ::ListItemViewHolder
        }
        return LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)
            .let(viewHolderCreator)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (item is ListItem) {
            (holder as ListItemViewHolder).bind(item, gestureCallbacks)
        } else {
            (holder as HeaderItemViewHolder).bind(item)
        }
    }

    fun onItemMoved(fromPosition: Int, toPosition: Int): Boolean {
        // This is what does the neat drag swapping animation.
        // Source: https://medium.com/@ipaulpro/drag-and-swipe-with-recyclerview-b9456d2b1aaf
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(items, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(items, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
        return true
    }
}