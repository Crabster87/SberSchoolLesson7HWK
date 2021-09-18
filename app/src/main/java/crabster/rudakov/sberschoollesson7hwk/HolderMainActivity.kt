package crabster.rudakov.sberschoollesson7hwk

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import crabster.rudakov.sberschoollesson7hwk.data.Values
import crabster.rudakov.sberschoollesson7hwk.secondActivity.SecondActivity

/**
 * Holder RecyclerView стартовой Activity, в котором каждому item назначается
 * слушатель клика для старта Activity со списком значений
 * */
class HolderMainActivity(itemView: View, private val context: Context) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(value: Values) {
        val valueName = itemView.findViewById<TextView>(R.id.value_name)
        valueName.text = context.getString(value.name)

        valueName.setOnClickListener {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra(context.getString(R.string.second_activity_intent_flag), value)
            context.startActivity(intent)
        }
    }

}