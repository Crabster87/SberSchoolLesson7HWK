package crabster.rudakov.sberschoollesson7hwk.secondActivity

import android.content.Context
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import crabster.rudakov.sberschoollesson7hwk.Converter
import crabster.rudakov.sberschoollesson7hwk.R
import crabster.rudakov.sberschoollesson7hwk.data.InputValues
import java.lang.NumberFormatException

class SecondHolder(itemView: View, private val context: Context) :
    RecyclerView.ViewHolder(itemView) {

    /**
     * Метод отображает названия и величины в соотвествующих полях и назначает слушателей
     * событий
     * */
    fun bind(inputValue: InputValues, adapter: SecondAdapter) {
        val unitName = itemView.findViewById<TextView>(R.id.value_name_tint)
        unitName.text = context.getString(inputValue.values.name)

        val unitValue = itemView.findViewById<EditText>(R.id.value_unit)
        unitValue.setText(inputValue.inputValue.toString())

        setFocusListener(unitValue, adapter)
        setTextWatcher(unitValue, adapter)
    }

    /**
     * Метод назначает полю с числовым значением слушаетель фокуса, который будет перемещает
     * элемент, на котором произошло фокусирование, в самое начало списка и уведомляет об
     * этом адаптер
     * */
    private fun setFocusListener(unitValue: EditText, adapter: SecondAdapter) {
        unitValue.setOnFocusChangeListener { _, _ ->
            val removedElement = adapter.inputValues[adapterPosition]
            adapter.inputValues.remove(removedElement)
            adapter.inputValues.add(0, removedElement)

            adapter.notifyItemMoved(adapterPosition, 0)
            unitValue.inputType = InputType.TYPE_NULL
        }
    }

    /**
     * Метод назначает полю с числовым значением слушаетель, который отслеживет изменения
     * текста, вводимого пользователем, после проверки строки на заполнение и соответсвие
     * формату парсит значение в Double, присваивает новое значение юниту и вызывает
     * конвертер, передавая ему уже измененный список. Далее DiffUtil проверяет списки и
     * уведомляет адаптер
     * */
    private fun setTextWatcher(unitValue: EditText, adapter: SecondAdapter) {
        unitValue.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val inputString = unitValue.text.toString()
                if (inputString.isNotEmpty()) {
                    val newInputValue: Double = try {
                        inputString.toDouble()
                    } catch (e: NumberFormatException) {
                        0.0
                    }

                    adapter.inputValues[adapterPosition].inputValue = newInputValue
                    val newInputValues: MutableList<InputValues> =
                        Converter().convert(adapter.inputValues)

                    val inputValuesDiffUtil =
                        InputValuesDiffUtil(adapter.inputValues, newInputValues)
                    val inputValuesDiffResult: DiffUtil.DiffResult =
                        DiffUtil.calculateDiff(inputValuesDiffUtil)
                    adapter.inputValues = newInputValues
                    inputValuesDiffResult.dispatchUpdatesTo(adapter)
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

}