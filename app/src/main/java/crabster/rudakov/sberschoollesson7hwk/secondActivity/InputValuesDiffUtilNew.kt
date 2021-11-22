package crabster.rudakov.sberschoollesson7hwk.secondActivity

import androidx.recyclerview.widget.DiffUtil
import crabster.rudakov.sberschoollesson7hwk.data.InputValues

object InputValuesDiffUtilNew : DiffUtil.ItemCallback<InputValues>() {

    /**
     * Метод определяет, являются ли newItem и oldItem одним и тем же
     * элементом
     * */
    override fun areContentsTheSame(oldItem: InputValues, newItem: InputValues): Boolean {
        return oldItem == newItem
    }

    /**
     * Метод определяет, изменились ли значения newItem и oldItem
     * */
    override fun areItemsTheSame(oldItem: InputValues, newItem: InputValues): Boolean {
        return oldItem.inputValue == newItem.inputValue
    }

}