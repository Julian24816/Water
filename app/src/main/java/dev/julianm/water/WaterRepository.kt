package dev.julianm.water

import java.time.Instant

class WaterRepository(private val localWaterSource: FallbackWaterSource) {

    val waterFlow = localWaterSource.waterFlow;

    suspend fun addWater(ml: Int, time: Instant) = localWaterSource.addWater(Water(1, ml, time))

    suspend fun removeWater(water: Water) = localWaterSource.removeWater(water)
}