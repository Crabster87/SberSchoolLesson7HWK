package crabster.rudakov.sberschoollesson7hwk.data

import crabster.rudakov.sberschoollesson7hwk.R

class RecyclerViewObject {

    companion object {
        val dataList: MutableList<Values> = mutableListOf(
            Values(
                R.string.length, mutableListOf(
                    Units(R.string.length_millimeter, 0.001),
                    Units(R.string.length_centimeter, 0.01),
                    Units(R.string.length_meter, 1.0),
                    Units(R.string.length_kilometer, 1000.0),
                    Units(R.string.length_inch, 0.0254),
                    Units(R.string.length_foot, 0.3048),
                    Units(R.string.length_yard, 0.9144),
                    Units(R.string.length_mile, 1609.344),
                    Units(R.string.length_nautical_mile, 1852.0)
                )
            ),
            Values(
                R.string.area, mutableListOf(
                    Units(R.string.area_square_millimeter, 0.000001),
                    Units(R.string.area_square_centimeter, 0.0001),
                    Units(R.string.area_square_kilometer, 1000000.0),
                    Units(R.string.area_square_meter, 1.0),
                    Units(R.string.area_square_inch, 0.00065),
                    Units(R.string.area_square_foot, 0.0929),
                    Units(R.string.area_acre, 4046.85642),
                    Units(R.string.area_hectare, 10000.0)
                )
            ),
            Values(
                R.string.mass, mutableListOf(
                    Units(R.string.mass_pound, 0.45359),
                    Units(R.string.mass_ounce, 0.02835),
                    Units(R.string.mass_kilogram, 1.0),
                    Units(R.string.mass_gram, 0.001),
                    Units(R.string.mass_ton, 1000.0),
                    Units(R.string.mass_hundredweight, 100.0),
                    Units(R.string.mass_milligram, 0.000001),
                )
            )
        )
    }

}