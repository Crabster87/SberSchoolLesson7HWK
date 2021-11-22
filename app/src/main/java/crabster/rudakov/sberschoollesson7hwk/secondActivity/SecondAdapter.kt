package crabster.rudakov.sberschoollesson7hwk.secondActivity

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import crabster.rudakov.sberschoollesson7hwk.R
import crabster.rudakov.sberschoollesson7hwk.data.InputValues

/**
 * Adapter RecyclerView вторичной Activity
 * */
class SecondAdapter(private val context: Context) :
    ListAdapter<InputValues, SecondHolder>(InputValuesDiffUtilNew) {

    lateinit var inputValues: MutableList<InputValues>

    /**
     * Метод устанавливает соответствующий Layout
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_second_main_item,
            parent,
            false
        )
        return SecondHolder(view, context)
    }

    /**
     * Метод привязывает данные к соответсвующему холдэру
     * */
    override fun onBindViewHolder(holder: SecondHolder, position: Int) {
        val inputValue = inputValues[position]
        holder.bind(inputValue, this)
    }

}