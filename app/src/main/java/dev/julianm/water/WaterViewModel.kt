package dev.julianm.water

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.ZoneId

sealed interface WaterUiState {
    object Loading : WaterUiState
    data class Success(val water: List<Water>, val mlToday: Int) : WaterUiState
}

class WaterViewModel constructor(private val waterRepository: WaterRepository) : ViewModel() {
    val uiState = waterRepository.waterFlow.map {
        val today =
            Instant.now().atZone(ZoneId.systemDefault()).withHour(0).withMinute(0).withSecond(0)
                .withNano(0).toInstant()
        val mlToday = it.filter { water -> water.time >= today }.sumOf { water -> water.ml }
        WaterUiState.Success(it, mlToday)
    }.stateIn(
        scope = viewModelScope,
        initialValue = WaterUiState.Loading,
        started = SharingStarted.WhileSubscribed(5000)
    )

    fun drinkGlass() = viewModelScope.launch {
        waterRepository.addWater(250, Instant.now())
    }
}