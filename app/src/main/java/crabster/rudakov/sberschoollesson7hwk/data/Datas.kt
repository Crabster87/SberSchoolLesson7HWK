package crabster.rudakov.sberschoollesson7hwk.data

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

/**
 * Класс, хранящий характеристики групп величин
 * */
@Parcelize
data class Values(val name: Int, val units: MutableList<Units>) : Parcelable

/**
 * Класс, хранящий характеристики самих величин
 * */
@Parcelize
data class Units(val name: Int, val ratioToStandard: Double) : Parcelable {
    @IgnoredOnParcel
    val ratioFromStandard: Double = 1.0 / ratioToStandard
}

/**
 * Класс, связывающий величины и введённые пользователем данные
 * */
data class InputValues(val values: Units, var inputValue: Double)