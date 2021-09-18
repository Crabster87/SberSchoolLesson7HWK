package crabster.rudakov.sberschoollesson7hwk

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import crabster.rudakov.sberschoollesson7hwk.data.RecyclerViewObject
import crabster.rudakov.sberschoollesson7hwk.data.Values

/**
 * Adapter RecyclerView стартовой Activity
 * */
class AdapterMainActivity(private val context: Context) : RecyclerView.Adapter<HolderMainActivity>() {

    var values: List<Values> = RecyclerViewObject.dataList

    /**
     * Метод устанавливает соответствующий Layout
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderMainActivity {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_main_item,
            parent,
            false
        )
        return HolderMainActivity(view, context)
    }

    /**
     * Метод привязывает данные к соответсвующему холдэру
     * */
    override fun onBindViewHolder(holder: HolderMainActivity, position: Int) {
        val value = values[position]
        holder.bind(value)
    }

    /**
     * Метод возвращает размер списка
     * */
    override fun getItemCount(): Int {
        return values.size
    }

}