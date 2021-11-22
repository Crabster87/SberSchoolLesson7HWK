package crabster.rudakov.sberschoollesson7hwk.secondActivity

import androidx.recyclerview.widget.DiffUtil
import crabster.rudakov.sberschoollesson7hwk.data.InputValues

/**
 * Специальный класс, сравнивающий списки
 * */
class InputValuesDiffUtil(
    private val oldInputValues: List<InputValues>,
    private val newInputValues: List<InputValues>) : DiffUtil.Callback() {

    /**
     * Метод возвращает размер старого списка
     * */
    override fun getOldListSize(): Int {
        return oldInputValues.size
    }

    /**
     * Метод возвращает размер обновленного варианта списка
     * */
    override fun getNewListSize(): Int {
        return newInputValues.size
    }

    /**
     * Метод определяет, изменились ли значения newItem и oldItem
     * */
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldInputValue: InputValues = oldInputValues[oldItemPosition]
        val newInputValue: InputValues = newInputValues[newItemPosition]
        return oldInputValue.inputValue == newInputValue.inputValue
    }

    /**
     * Метод определяет, являются ли newItem и oldItem одним и тем же
     * элементом
     * */
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldInputValue: InputValues = oldInputValues[oldItemPosition]
        val newInputValue: InputValues = newInputValues[newItemPosition]
        return oldInputValue == newInputValue
    }

}