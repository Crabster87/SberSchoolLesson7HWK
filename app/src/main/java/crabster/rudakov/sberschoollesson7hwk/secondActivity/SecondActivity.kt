package crabster.rudakov.sberschoollesson7hwk.secondActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import crabster.rudakov.sberschoollesson7hwk.data.InputValues
import crabster.rudakov.sberschoollesson7hwk.data.Values

import crabster.rudakov.sberschoollesson7hwk.R

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
        val adapterSecondActivity = AdapterSecondActivity(this)

        makeDisplayList()
        adapterSecondActivity.inputValues = makeDisplayList()
        recyclerView.adapter = adapterSecondActivity
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

}
