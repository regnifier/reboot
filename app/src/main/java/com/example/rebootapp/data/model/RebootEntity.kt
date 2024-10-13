package com.example.rebootapp.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class RebootEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val date: String = "",
    val count: Int = 0
) : Parcelable