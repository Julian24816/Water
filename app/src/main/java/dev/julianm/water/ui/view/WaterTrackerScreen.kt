package dev.julianm.water.ui.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun WaterTrackerScreen(viewModel: WaterViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    WaterTrackerScreen(uiState, viewModel::drinkGlass)
}

@Composable
private fun WaterTrackerScreen(
    uiState: WaterTrackerUiState,
    onDrinkGlass: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (uiState) {
            WaterTrackerUiState.Loading -> Text(text = "Loading")
            is WaterTrackerUiState.Success -> WaterInfoRow(
                uiState.mlTotal,
                onDrinkGlass = onDrinkGlass
            )
        }
    }
}