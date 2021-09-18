package crabster.rudakov.sberschoollesson7hwk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import crabster.rudakov.sberschoollesson7hwk.data.RecyclerViewObject

/**
 * Стартовая Activity, отображающая категории величин, доступных для конвертации
 * */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapterMainActivity = AdapterMainActivity(this)
        adapterMainActivity.values = RecyclerViewObject.dataList

        val recyclerView: RecyclerView = findViewById(R.id.list_values)
        recyclerView.adapter = adapterMainActivity
    }

}