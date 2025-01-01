package com.example.vitaminbook.dataClass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Vitamin(
    var name: String? = "",
    var thumbnailUrl: String? = "",
    var synonym: String? = "",
    var overall: String? = "",
    var usageDescription: String? = "",
    var photoCardUrl: String? = "",
    var deficiencyDescription: String? = "",
    var foodsDescription: String? = "",
    var unit: String? = "",
    var referenceUrl: String? = ""
): Parcelable