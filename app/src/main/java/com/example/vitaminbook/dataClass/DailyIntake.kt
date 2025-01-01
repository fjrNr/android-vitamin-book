package com.example.vitaminbook.dataClass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DailyIntake(
    val people: String? = "",
    val value: Double? = 0.0,
): Parcelable
