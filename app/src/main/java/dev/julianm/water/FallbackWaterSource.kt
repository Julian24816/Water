package dev.julianm.water

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FallbackWaterSource {
    // TODO("actually save sth")
    val waterFlow: Flow<List<Water>> = flow {
        emit(listOf(Water(1, 500), Water(2, 250)))
        emit(listOf(Water(1, 500), Water(2, 250)))
        emit(listOf(Water(1, 500), Water(2, 250)))
        emit(listOf(Water(1, 500), Water(2, 250)))
        emit(listOf(Water(1, 500), Water(2, 250)))
        emit(listOf(Water(1, 500), Water(2, 250)))
    }

    suspend fun addWater(water: Water) {
        // TODO
    }

    suspend fun removeWater(water: Water) {
        // TODO
    }
}