package crabster.rudakov.sberschoollesson7hwk

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
     * Метод сравнивает каждый объект по величине его значения(введённая
     * пользователем цифра), чтобы в принципе определить, разные ли это объекты
     * */
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldInputValue: InputValues = oldInputValues[oldItemPosition]
        val newInputValue: InputValues = newInputValues[newItemPosition]
        return oldInputValue.inputValue == newInputValue.inputValue
    }

    /**
     * Метод сравнивает каждый объект уже по всем полям, чтобы определить,
     * поменялось ли что-то из того, что отображается на экране
     * */
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldInputValue: InputValues = oldInputValues[oldItemPosition]
        val newInputValue: InputValues = newInputValues[newItemPosition]
        return oldInputValue.values == newInputValue.values &&
                oldInputValue.inputValue == newInputValue.inputValue
    }

}