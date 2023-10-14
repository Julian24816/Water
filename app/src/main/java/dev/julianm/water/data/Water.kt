package dev.julianm.water.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Water(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    val ml: Int,
    val time: Long = System.currentTimeMillis(),
)