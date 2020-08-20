package nihk.clampeditemtouchhelper

import androidx.recyclerview.widget.RecyclerView

interface GestureCallbacks {
    fun onStartDrag(viewHolder: RecyclerView.ViewHolder)
    fun onItemMoved(fromPosition: Int, toPosition: Int): Boolean
}