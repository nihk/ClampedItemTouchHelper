package nihk.clampeditemtouchhelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GestureCallbacks {

    private val adapter = Adapter(sampleItems, this)
    private val itemTouchHelper = ItemTouchHelper(ItemTouchHelperCallback(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemTouchHelper.attachToRecyclerView(recyclerView)
        recyclerView.adapter = adapter
    }

    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        itemTouchHelper.startDrag(viewHolder)
    }

    override fun onItemMoved(fromPosition: Int, toPosition: Int): Boolean {
        return adapter.onItemMoved(fromPosition, toPosition)
    }
}