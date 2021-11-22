package crabster.rudakov.sberschoollesson7hwk

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import crabster.rudakov.sberschoollesson7hwk.data.Values
import crabster.rudakov.sberschoollesson7hwk.secondActivity.SecondActivity

/**
 * Holder RecyclerView стартовой Activity, в котором каждому item назначается
 * слушатель клика для старта Activity со списком значений
 * */
class MainHolder(itemView: View, private val context: Context) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(value: Values) {
        val valueName = itemView.findViewById<TextView>(R.id.value_name)
        valueName.text = context.getString(value.name)

        valueName.setOnClickListener {
            context.startActivity(SecondActivity.createIntent(context, value))
        }
    }

}