package crabster.rudakov.sberschoollesson7hwk.secondActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import crabster.rudakov.sberschoollesson7hwk.R
import crabster.rudakov.sberschoollesson7hwk.data.InputValues
import crabster.rudakov.sberschoollesson7hwk.data.Values


/**
 * Вторичная Activity, отображающая список величин, доступных для конвертации
 * */
class SecondActivity : AppCompatActivity() {

    private lateinit var values: Values

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_main)

        val recyclerView: RecyclerView = findViewById(R.id.list_units)

        values = intent.getParcelableExtra(getString(R.string.second_activity_intent_flag))!!
        val adapterSecondActivity = SecondAdapter(this)

        adapterSecondActivity.submitList(makeDisplayList())
        adapterSecondActivity.inputValues = makeDisplayList()
        recyclerView.adapter = adapterSecondActivity
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    /**
     * Метод создаёт список с названиями и их исходными значениями величин для
     * последующего отображения на экране
     * */
    private fun makeDisplayList(): MutableList<InputValues> {
        val inputValues: MutableList<InputValues> = mutableListOf()
        for (i in values.units.indices) {
            inputValues.add(InputValues(values.units[i], 0.0))
        }
        return inputValues
    }

    companion object {

        /**
         * Метод создаёт интент, который будет использован для вызова текущей
         * активности из MainActivity
         * */
        fun createIntent(context: Context, value: Values): Intent {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra(context.getString(R.string.second_activity_intent_flag), value)
            return intent
        }

    }

}
