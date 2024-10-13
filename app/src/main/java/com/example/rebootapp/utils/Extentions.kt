package com.example.rebootapp.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O) // TODO Add 24-25 api support
fun String.isToday(): Boolean = this == LocalDate.now().localDateToString()

@RequiresApi(Build.VERSION_CODES.O) // TODO Add 24-25 api support
fun LocalDate.localDateToString(): String = this.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"))