package dev.julianm.water.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WaterDao {
    @Query("SELECT * FROM water")
    fun getAll(): Flow<List<Water>>

    @Insert
    suspend fun insertAll(vararg waters: Water)
}
