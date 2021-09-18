package crabster.rudakov.sberschoollesson7hwk

import crabster.rudakov.sberschoollesson7hwk.data.InputValues
import java.math.RoundingMode

/**
 * Класс, реализующий логику конвертации величин из одной в другую с помощью
 * переводного коэффициента к стандартной единице измерения системы СИ
 * */
class Converter {

    fun convert(inputValues: MutableList<InputValues>): MutableList<InputValues> {
        val primaryValues = inputValues.toMutableList()
        val afterFocusValue: InputValues = primaryValues.removeFirst()
        for (i in primaryValues.indices) {
            primaryValues[i] = primaryValues[i].copy(
                inputValue = (afterFocusValue.inputValue *
                        afterFocusValue.values.ratioToStandard *
                        primaryValues[i].values.ratioFromStandard).toBigDecimal()
                            .setScale(4, RoundingMode.UP).toDouble()
            )
        }
        primaryValues.sortBy { it.inputValue }
        primaryValues.add(0, afterFocusValue)
        return primaryValues
    }

}