package dev.julianm.water.ui.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.julianm.water.data.Water
import dev.julianm.water.data.WaterRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

sealed interface WaterTrackerUiState {
    object Loading : WaterTrackerUiState
    data class Success(val water: List<Water>, val mlTotal: Int) : WaterTrackerUiState
}

class WaterViewModel constructor(private val waterRepository: WaterRepository) : ViewModel() {
    val uiState = waterRepository.waterFlow.map {
        val mlTotal = it.sumOf { water -> water.ml }
        WaterTrackerUiState.Success(it, mlTotal)
    }.stateIn(
        scope = viewModelScope,
        initialValue = WaterTrackerUiState.Loading,
        started = SharingStarted.WhileSubscribed(5000)
    )

    fun drinkGlass() = viewModelScope.launch {
        waterRepository.insert(Water(ml = 250))
    }
}