package dev.julianm.water.data

import androidx.annotation.WorkerThread

class WaterRepository(private val waterDao: WaterDao) {

    val waterFlow = waterDao.getAll()

    @WorkerThread
    suspend fun insert(water: Water) {
        waterDao.insertAll(water)
    }
}