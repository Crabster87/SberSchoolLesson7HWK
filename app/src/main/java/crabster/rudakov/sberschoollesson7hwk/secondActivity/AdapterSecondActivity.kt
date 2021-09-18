package crabster.rudakov.sberschoollesson7hwk.secondActivity

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import crabster.rudakov.sberschoollesson7hwk.R
import crabster.rudakov.sberschoollesson7hwk.data.InputValues

/**
 * Adapter RecyclerView вторичной Activity
 * */
class AdapterSecondActivity(private val context: Context) : RecyclerView.Adapter<HolderSecondActivity>() {

    lateinit var inputValues: MutableList<InputValues>

    /**
     * Метод устанавливает соответствующий Layout
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderSecondActivity {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_second_main_item,
            parent,
            false
        )
        return HolderSecondActivity(view, context)
    }

    /**
     * Метод привязывает данные к соответсвующему холдэру
     * */
    override fun onBindViewHolder(holder: HolderSecondActivity, position: Int) {
        val inputValue = inputValues[position]
        holder.bind(inputValue, this)
    }

    /**
     * Метод возвращает размер списка
     * */
    override fun getItemCount(): Int {
        return inputValues.size
    }

}